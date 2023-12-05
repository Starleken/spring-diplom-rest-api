package com.example.DiplomRestApi.mapper;

import com.example.DiplomRestApi.dto.passport.PassportCreateDTO;
import com.example.DiplomRestApi.dto.passport.PassportFullDTO;
import com.example.DiplomRestApi.dto.passport.PassportUpdateDTO;
import com.example.DiplomRestApi.entity.PassportEntity;
import com.example.DiplomRestApi.entity.StudentEntity;
import com.example.DiplomRestApi.repository.StudentRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PassportMapper {
    public List<PassportFullDTO> mapPassportListToDtos(List<PassportEntity> passports){
        List<PassportFullDTO> passportFullDTOList = new ArrayList<>();

        for (PassportEntity passport : passports){
            PassportFullDTO dto = new PassportFullDTO();
            dto.setId(passport.getId());
            dto.setStudent(passport.getStudent());
            dto.setSeries(passport.getSeries());
            dto.setNumber(passport.getNumber());

            passportFullDTOList.add(dto);
        }

        return passportFullDTOList;
    }

    public PassportEntity mapToEntity(PassportCreateDTO createDto, StudentEntity student){
        PassportEntity passportEntity = new PassportEntity();

        passportEntity.setImageURL(createDto.getImageURL());
        passportEntity.setStudent(student);
        passportEntity.setNumber(createDto.getNumber());
        passportEntity.setSeries(createDto.getSeries());

        return passportEntity;
    }

    public PassportEntity mapToEntity(PassportUpdateDTO updateDTO){
        PassportEntity passportEntity = new PassportEntity();

        passportEntity.setImageURL(updateDTO.getImageURL());
        passportEntity.setNumber(updateDTO.getNumber());
        passportEntity.setSeries(updateDTO.getSeries());
        updateDTO.setId(updateDTO.getId());

        return passportEntity;
    }

    public PassportFullDTO mapToDto(PassportEntity passport){
        PassportFullDTO dto = new PassportFullDTO();

        dto.setNumber(passport.getNumber());
        dto.setImageURL(passport.getImageURL());
        dto.setId(passport.getId());
        dto.setSeries(passport.getSeries());
        dto.setStudent(passport.getStudent());

        return dto;
    }
}
