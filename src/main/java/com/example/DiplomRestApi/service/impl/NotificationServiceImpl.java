package com.example.DiplomRestApi.service.impl;

import com.example.DiplomRestApi.dto.fluorography.FluorographyFullDto;
import com.example.DiplomRestApi.dto.passport.PassportFullDto;
import com.example.DiplomRestApi.service.FluorographyService;
import com.example.DiplomRestApi.service.NotificationService;
import com.example.DiplomRestApi.service.PassportService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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
        PassportFullDto passport = passportService.findByStudent(studentId);
        FluorographyFullDto fluorography = fluorographyService.findByStudent(studentId);

        List<String> notifications = new ArrayList<>();

        if (passport != null) {
            LocalDateTime convertedPassportDate = LocalDateTime.of(passport.getIssueDate().toLocalDate(), LocalTime.now());
            if (checkIfDateExpired(convertedPassportDate, 6)){
                notifications.add("Требуется обновить паспорт");
            }
        } else {
            notifications.add("Требуется добавить паспорт");
        }

        if (fluorography != null) {
            LocalDateTime convertedFluDate = LocalDateTime.of(fluorography.getCreateDate().toLocalDate(), LocalTime.now());
            if (checkIfDateExpired(convertedFluDate, 1)){
                notifications.add("Требуется обновить флюорографию");
            }
        } else {
            notifications.add("Требуется добавить флюорографию");
        }

        return notifications;
    }

    private boolean checkIfDateExpired(LocalDateTime sourceDate, int years){
        return sourceDate.plusYears(years).isBefore(LocalDateTime.now());
    }
}
