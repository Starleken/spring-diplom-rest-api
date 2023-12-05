package com.example.DiplomRestApi.service;

import com.example.DiplomRestApi.dto.passport.PassportCreateDTO;
import com.example.DiplomRestApi.dto.passport.PassportFullDTO;
import com.example.DiplomRestApi.dto.passport.PassportUpdateDTO;
import com.example.DiplomRestApi.entity.PassportEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PassportService{
    public List<PassportFullDTO> findAll();
    public List<PassportFullDTO> findAllByStudent(Long studentId);

    public PassportFullDTO create(PassportCreateDTO passportToSaveDto);

    public PassportFullDTO update(PassportUpdateDTO passportToUpdateDto);

    public void deleteById(Long id);
}
