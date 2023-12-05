package com.example.DiplomRestApi.service.impl;

import com.example.DiplomRestApi.dto.passport.PassportCreateDTO;
import com.example.DiplomRestApi.dto.passport.PassportFullDTO;
import com.example.DiplomRestApi.dto.passport.PassportUpdateDTO;
import com.example.DiplomRestApi.entity.PassportEntity;
import com.example.DiplomRestApi.entity.StudentEntity;
import com.example.DiplomRestApi.mapper.PassportMapper;
import com.example.DiplomRestApi.repository.PassportRepository;
import com.example.DiplomRestApi.repository.StudentRepository;
import com.example.DiplomRestApi.service.PassportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PassportServiceImpl implements PassportService {
    private PassportRepository passportRepository;
    private StudentRepository studentRepository;
    private PassportMapper passportMapper;

    @Autowired
    public PassportServiceImpl(PassportRepository passportRepository, StudentRepository studentRepository, PassportMapper passportMapper) {
        this.passportRepository = passportRepository;
        this.studentRepository = studentRepository;
        this.passportMapper = passportMapper;
    }

    @Override
    public List<PassportFullDTO> findAll() {
        return passportMapper.mapPassportListToDtos(passportRepository.findAll());
    }

    @Override
    public List<PassportFullDTO> findAllByStudent(Long studentId){
        Optional<StudentEntity> findedStudent = studentRepository.findById(studentId);

        //TODO
        if (findedStudent.isEmpty()){
            return null;
        }

        return passportMapper.mapPassportListToDtos(passportRepository.findAllByStudent(findedStudent.get()));
    }

    @Override
    public PassportFullDTO create(PassportCreateDTO passportToSaveDto){
        Optional<StudentEntity> student = studentRepository.findById(passportToSaveDto.getStudentId());

        //TODO
        if (student.isEmpty()){
            return null;
        }

        PassportEntity passport = passportMapper.mapToEntity(passportToSaveDto, student.get());

        PassportEntity savedPassport = passportRepository.save(passport);

        return passportMapper.mapToDto(savedPassport);
    }

    @Override
    public PassportFullDTO update(PassportUpdateDTO passportToUpdateDto) {
        Optional<PassportEntity> passport = passportRepository.findById(passportToUpdateDto.getId());

        //TODO
        if (passport.isEmpty()){
            return null;
        }

        PassportEntity passportToSave = passport.get();
        passportToSave.setNumber(passportToUpdateDto.getNumber());
        passportToSave.setSeries(passportToUpdateDto.getSeries());
        passportToSave.setImageURL(passportToUpdateDto.getImageURL());

        return passportMapper.mapToDto(passportRepository.save(passportToSave));
    }

    @Override
    public void deleteById(Long id){
        passportRepository.deleteById(id);
    }
}
