package com.example.DiplomRestApi.service.impl;

import com.example.DiplomRestApi.dto.student.StudentActivityDto;
import com.example.DiplomRestApi.dto.student.StudentCreateDto;
import com.example.DiplomRestApi.dto.student.StudentFullDto;
import com.example.DiplomRestApi.dto.student.StudentUpdateDto;
import com.example.DiplomRestApi.entity.*;
import com.example.DiplomRestApi.exception.EntityNotFoundException;
import com.example.DiplomRestApi.mapper.StudentMapper;
import com.example.DiplomRestApi.repository.*;
import com.example.DiplomRestApi.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final GroupRepository groupRepository;
    private final UserRepository userRepository;
    private final EducationFormRepository educationFormRepository;
    private final RoleRepository roleRepository;

    private final StudentMapper mapper;

    public List<StudentFullDto> findAll(){
        var entities = studentRepository.findAll();

        var dtos = entities.stream()
                .map(mapper::mapToDto)
                .collect(Collectors.toList());

        return dtos;
    }

    @Override
    public List<StudentActivityDto> findAllWithActivities() {
        var entities = studentRepository.findAll();

        var dtos = entities.stream()
                .map(mapper::mapToWithActivityDto)
                .collect(Collectors.toList());

        return dtos;
    }

    @Override
    public List<StudentActivityDto> findByGroupWithActivities(long groupId) {
        var foundGroup = groupRepository.findById(groupId)
                .orElseThrow(() -> new EntityNotFoundException("Group is not found"));

        var entities = studentRepository.findStudentsByGroup(foundGroup);

        var dtos = entities.stream()
                .map(mapper::mapToWithActivityDto)
                .collect(Collectors.toList());

        return dtos;
    }

    @Override
    public StudentFullDto findById(Long id) {
        var found = studentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Student is not found"));

        return mapper.mapToDto(found);
    }

    public List<StudentFullDto> findStudentsByGroup(Long groupId){
        var foundGroup = groupRepository.findById(groupId)
                .orElseThrow(() -> new EntityNotFoundException("Group is not found"));

        var entities = studentRepository.findStudentsByGroup(foundGroup);

        var dtos = entities.stream()
                .map(mapper::mapToDto)
                .collect(Collectors.toList());

        return dtos;
    }

    @Override
    public StudentFullDto findStudentByUser(Long userId) {
        var foundUser = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User is not found"));

        var foundStudent = studentRepository.findStudentByUser(foundUser);

        return mapper.mapToDto(foundStudent);
    }

    public StudentFullDto create(StudentCreateDto createDto){
        var student = mapper.mapToEntity(createDto);

        var foundRole = roleRepository.findById(createDto.getUser().getRoleId())
                .orElseThrow(() -> new EntityNotFoundException("Role is not found"));
        student.getUser().setRole(foundRole);

        var foundGroup = groupRepository.findById(createDto.getGroupId())
                        .orElseThrow(() -> new EntityNotFoundException("Group is not found"));
        student.setGroup(foundGroup);

        var foundEducationForm = educationFormRepository.findById(createDto.getEducationFormId())
                        .orElseThrow(() -> new EntityNotFoundException("Education form is not found"));
        student.setEducationForm(foundEducationForm);

        return mapper.mapToDto(studentRepository.save(student));
    }

    public StudentFullDto update(StudentUpdateDto updateDto){
        var foundStudent = studentRepository.findById(updateDto.getId())
                .orElseThrow(() -> new EntityNotFoundException("Student is not found"));

        var foundEducationForm = educationFormRepository.findById(updateDto.getEducationFormId())
                .orElseThrow(() -> new EntityNotFoundException("Education form is not found"));
        foundStudent.setEducationForm(foundEducationForm);

        var foundGroup = groupRepository.findById(updateDto.getGroupId())
                .orElseThrow(() -> new EntityNotFoundException("Group is not found"));
        foundStudent.setGroup(foundGroup);

        var foundRole = roleRepository.findById(updateDto.getUser().getRoleId())
                .orElseThrow(() -> new EntityNotFoundException("Role is not found"));
        foundStudent.getUser().setRole(foundRole);

        foundStudent.getUser().setLogin(updateDto.getUser().getLogin());
        foundStudent.getUser().setPassword(updateDto.getUser().getPassword());
        foundStudent.getUser().getPerson().setName(updateDto.getUser().getPerson().getName());
        foundStudent.getUser().getPerson().setPatronymic(updateDto.getUser().getPerson().getPatronymic());
        foundStudent.getUser().getPerson().setSurname(updateDto.getUser().getPerson().getSurname());
        foundStudent.setPhone(updateDto.getPhone());
        foundStudent.setRegistrationAddress(updateDto.getRegistrationAddress());
        foundStudent.setResidentialAddress(updateDto.getResidentialAddress());

        return mapper.mapToDto(studentRepository.save(foundStudent));
    }

    @Override
    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }
}
