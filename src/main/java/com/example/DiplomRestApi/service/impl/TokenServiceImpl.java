package com.example.DiplomRestApi.service.impl;

import com.example.DiplomRestApi.dto.token.RefreshTokenResponseDto;
import com.example.DiplomRestApi.entity.TokenEntity;
import com.example.DiplomRestApi.entity.TokenEntityStatus;
import com.example.DiplomRestApi.entity.UserEntity;
import com.example.DiplomRestApi.exception.EntityNotFoundException;
import com.example.DiplomRestApi.exception.TokenIsUsedException;
import com.example.DiplomRestApi.repository.TokenRepository;
import com.example.DiplomRestApi.repository.UserRepository;
import com.example.DiplomRestApi.service.TokenService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.crypto.SecretKey;
import java.util.Date;

import static com.example.DiplomRestApi.utils.TimeUtils.getCurrentTimeFromUTC;
import static com.example.DiplomRestApi.utils.TimeUtils.getExpiredDateFromUTC;

@Service
@Slf4j
public class TokenServiceImpl implements TokenService {

    private final TokenRepository tokenRepository;
    private final UserRepository userRepository;

    private final SecretKey secretAccessKey;
    private final SecretKey secretRefreshKey;

    private final long accessTime;
    private final long refreshTime;

    public TokenServiceImpl(@Autowired TokenRepository tokenRepository,
                            @Autowired UserRepository userRepository,
                            @Value("${jwt.access.secretKey}") String secretAccessKey,
                            @Value("${jwt.refresh.secretKey}") String secretRefreshKey,
                            @Value("${jwt.access.ttlMinutes}") long accessTime,
                            @Value("${jwt.refresh.ttlMinutes}") long refreshTime) {
        this.tokenRepository = tokenRepository;
        this.userRepository = userRepository;
        this.secretAccessKey = Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretAccessKey));
        this.secretRefreshKey = Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretRefreshKey));
        this.accessTime = accessTime;
        this.refreshTime = refreshTime;
    }

    @Override
    @Transactional
    public String generateAccessToken(long userId) {
        Date expirationTime = getExpiredDateFromUTC(accessTime);

        var foundUser = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        return generateToken(foundUser, secretAccessKey, expirationTime);
    }

    @Override
    @Transactional
    public String generateRefreshToken(long userId) {
        Date expirationTime = getExpiredDateFromUTC(refreshTime);

        var foundUser = userRepository.findById(userId).orElseThrow(
                () -> new EntityNotFoundException("User not found"));

        var refresh = generateToken(foundUser, secretRefreshKey, expirationTime);

        var tokenEntity = new TokenEntity();
        tokenEntity.setToken(refresh);
        tokenEntity.setUser(foundUser);
        tokenEntity.setStatus(TokenEntityStatus.ISSUED);
        tokenEntity.setCreatedAt(getCurrentTimeFromUTC());
        tokenRepository.save(tokenEntity);

        return refresh;
    }

    private String generateToken(UserEntity user, SecretKey key, Date expirationTime) {
        var foundUser = userRepository.findById(user.getId())
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        return Jwts.builder()
                .setSubject(foundUser.getLogin())
                .setExpiration(expirationTime)
                .signWith(key)
                .compact();
    }

    @Override
    public void validateAccessToken(String token) {
        validateToken(secretAccessKey, token);
    }

    @Override
    @Transactional(noRollbackFor = TokenIsUsedException.class)
    public void validateRefreshToken(String token) {
        validateToken(secretRefreshKey, token);

        var foundToken = tokenRepository.findByToken(token)
                .orElseThrow(() -> new EntityNotFoundException("Token not found"));

        var foundUser = userRepository.findByLogin(foundToken.getUser().getLogin())
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        if (foundToken.getStatus() == TokenEntityStatus.USED) {
            var tokens = tokenRepository.findAllByUser(foundUser);
            tokens.forEach(x -> x.setStatus(TokenEntityStatus.WITHDRAWN));

            tokenRepository.saveAll(tokens);
            throw new TokenIsUsedException("Token is used");
        }

        if(foundToken.getStatus() == TokenEntityStatus.WITHDRAWN) {
            throw new IllegalStateException("Token is withdrawn");
        }
    }

    private void validateToken(SecretKey key, String token) {
        Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token);
    }


    @Override
    @Transactional(noRollbackFor = TokenIsUsedException.class)
    public RefreshTokenResponseDto refresh(String token) {
        var entity = tokenRepository.findByToken(token)
                .orElseThrow(() -> new EntityNotFoundException("Token not found"));

        validateRefreshToken(entity.getToken());
        entity.setStatus(TokenEntityStatus.USED);
        tokenRepository.save(entity);

        return RefreshTokenResponseDto.builder()
                .accessToken(generateAccessToken(entity.getUser().getId()))
                .refreshToken(generateRefreshToken(entity.getUser().getId()))
                .build();
    }

    @Override
    public Claims getAccessClaims(String token) {
        return Jwts.parserBuilder().setSigningKey(secretAccessKey)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
