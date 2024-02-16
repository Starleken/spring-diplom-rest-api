package com.example.DiplomRestApi.service;

import java.util.List;

public interface NotificationService {

    List<String> getByStudentId(Long studentId);
}
