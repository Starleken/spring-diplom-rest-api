package com.example.DiplomRestApi.service.impl;

import com.example.DiplomRestApi.dto.passport.PassportCreateDto;
import com.example.DiplomRestApi.dto.passport.PassportFullDto;
import com.example.DiplomRestApi.dto.passport.PassportUpdateDto;
import com.example.DiplomRestApi.entity.PassportEntity;
import com.example.DiplomRestApi.entity.StudentEntity;
import com.example.DiplomRestApi.exception.EntityNotFoundException;
import com.example.DiplomRestApi.mapper.PassportMapper;
import com.example.DiplomRestApi.repository.PassportRepository;
import com.example.DiplomRestApi.repository.StudentRepository;
import com.example.DiplomRestApi.service.ImageService;
import com.example.DiplomRestApi.service.PassportService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class PassportServiceImpl implements PassportService {
    private final PassportRepository passportRepository;
    private final StudentRepository studentRepository;

    private final ImageService imageService;

    private final PassportMapper passportMapper;

    @Override
    public List<PassportFullDto> findAll() {
        List<PassportEntity> entities = passportRepository.findAll();

        List<PassportFullDto> dtos = entities.stream()
                .map(passportMapper::mapToDto)
                .collect(Collectors.toList());

        return dtos;
    }

    @Override
    public List<PassportFullDto> findAllByStudent(Long studentId){
        Optional<StudentEntity> findedStudent = studentRepository.findById(studentId);

        //TODO
        if (findedStudent.isEmpty()){
            return null;
        }

        List<PassportEntity> entities = passportRepository.findAllByStudent(findedStudent.get());

        List<PassportFullDto> dtos = entities.stream()
                .map(passportMapper::mapToDto)
                .collect(Collectors.toList());

        return dtos;
    }

    @Override
    public PassportFullDto create(PassportCreateDto createDto){
        PassportEntity passport = passportMapper.mapToEntity(createDto);
        log.info(passport.getIssueDate().toString());

        Optional<StudentEntity> findedStudent = studentRepository.findById(createDto.getStudentId());

        if (findedStudent.isEmpty()){
            throw new EntityNotFoundException("Student is not found");
        }
        passport.setStudent(findedStudent.get());

        String imageUrl = imageService.saveImage(createDto.getImage());
        passport.setImageURL(imageUrl);

        PassportEntity saved = passportRepository.save(passport);
        return passportMapper.mapToDto(saved);
    }

    @Override
    public PassportFullDto update(PassportUpdateDto updateDto) {
        Optional<PassportEntity> findedPassport = passportRepository.findById(updateDto.getId());

        if (findedPassport.isEmpty()){
            throw new EntityNotFoundException("Passport is not found");
        }

        PassportEntity passportToUpdate = findedPassport.get();
        passportToUpdate.setNumber(updateDto.getNumber());
        passportToUpdate.setSeries(updateDto.getSeries());
        passportToUpdate.setIssueDate(updateDto.getIssueDate());
        passportToUpdate.setIssuingOrganization(updateDto.getIssuingOrganization());

        if (updateDto.getImage() != null){
            imageService.deleteImage(passportToUpdate.getImageURL());
            String imageUrl = imageService.saveImage(updateDto.getImage());
            passportToUpdate.setImageURL(imageUrl);
        }

        PassportEntity updated = passportRepository.save(passportToUpdate);
        return passportMapper.mapToDto(updated);
    }

    @Override
    public void deleteById(Long id){
        Optional<PassportEntity> passport = passportRepository.findById(id);

        if (passport.isEmpty()){
            throw new EntityNotFoundException("Passport is not found");
        }

        imageService.deleteImage(passport.get().getImageURL());
        passportRepository.deleteById(id);
    }
}
