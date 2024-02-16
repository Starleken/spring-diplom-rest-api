package com.example.DiplomRestApi.service.impl;

import com.example.DiplomRestApi.dto.fluorography.FluorographyFullDto;
import com.example.DiplomRestApi.dto.passport.PassportFullDto;
import com.example.DiplomRestApi.service.FluorographyService;
import com.example.DiplomRestApi.service.NotificationService;
import com.example.DiplomRestApi.service.PassportService;
import com.example.DiplomRestApi.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationServiceImpl implements NotificationService {

    private final PassportService passportService;
    private final FluorographyService fluorographyService;

    @Override
    public List<String> getByStudentId(Long studentId) {
        PassportFullDto passport = passportService.findAllByStudent(studentId).get(0);
        FluorographyFullDto fluorography = fluorographyService.findAllByStudent(studentId).get(0);

        List<String> notifications = new ArrayList<>();

        LocalDateTime convertedPassportDate = LocalDateTime.of(passport.getIssueDate().toLocalDate(), LocalTime.now());
        if (checkIfDateExpired(convertedPassportDate, 6)){
            notifications.add("Требуется обновить паспорт");
        }

        LocalDateTime convertedFluDate = LocalDateTime.of(fluorography.getCreateDate().toLocalDate(), LocalTime.now());
        if (checkIfDateExpired(convertedFluDate, 1)){
            notifications.add("Требуется обновить флюорографию");
        }

        return notifications;
    }

    private boolean checkIfDateExpired(LocalDateTime sourceDate, int years){
        return sourceDate.plusYears(6).isBefore(LocalDateTime.now());
    }
}
