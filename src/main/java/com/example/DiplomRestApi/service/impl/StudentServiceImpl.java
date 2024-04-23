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
        List<StudentEntity> entities = studentRepository.findAll();

        List<StudentFullDto> dtos = entities.stream()
                .map(mapper::mapToDto)
                .collect(Collectors.toList());

        return dtos;
    }

    @Override
    public List<StudentActivityDto> findAllWithActivities() {
        List<StudentEntity> entities = studentRepository.findAll();

        List<StudentActivityDto> dtos = entities.stream()
                .map(mapper::mapToWithActivityDto)
                .collect(Collectors.toList());

        return dtos;
    }

    @Override
    public List<StudentActivityDto> findByGroupWithActivities(long groupId) {
        Optional<GroupEntity> findedGroup = groupRepository.findById(groupId);

        //TODO
        if (findedGroup.isEmpty()){
            return null;
        }

        List<StudentEntity> entities = studentRepository.findStudentsByGroup(findedGroup.get());

        List<StudentActivityDto> dtos = entities.stream()
                .map(mapper::mapToWithActivityDto)
                .collect(Collectors.toList());

        return dtos;
    }

    @Override
    public StudentFullDto findById(Long id) {
        Optional<StudentEntity> finded = studentRepository.findById(id);
        if (finded.isEmpty()){
            throw new EntityNotFoundException("Student is not found");
        }

        return mapper.mapToDto(finded.get());
    }

    public List<StudentFullDto> findStudentsByGroup(Long groupId){
        Optional<GroupEntity> findedGroup = groupRepository.findById(groupId);

        //TODO
        if (findedGroup.isEmpty()){
            return null;
        }

        List<StudentEntity> entities = studentRepository.findStudentsByGroup(findedGroup.get());

        List<StudentFullDto> dtos = entities.stream()
                .map(mapper::mapToDto)
                .collect(Collectors.toList());

        return dtos;
    }

    @Override
    public StudentFullDto findStudentByUser(Long userId) {
        Optional<UserEntity> findedUser = userRepository.findById(userId);

        //TODO
        if (findedUser.isEmpty()){
            return null;
        }

        StudentEntity findedStudent = studentRepository.
                findStudentByUser(findedUser.get());

        return mapper.mapToDto(findedStudent);
    }

    public StudentFullDto create(StudentCreateDto createDto){
        StudentEntity student = mapper.mapToEntity(createDto);

        Optional<RoleEntity> findedRole = roleRepository.findById(createDto.getUser().getRoleId());
        if (findedRole.isEmpty()){
            throw new EntityNotFoundException("Role is not found");
        }
        student.getUser().setRole(findedRole.get());

        Optional<GroupEntity> findedGroup = groupRepository.findById(createDto.getGroupId());
        if (findedGroup.isEmpty()){
            throw new EntityNotFoundException("Group is not found");
        }
        student.setGroup(findedGroup.get());

        Optional<EducationFormEntity> findedEducationForm = educationFormRepository.findById(
                createDto.getEducationFormId());
        if (findedEducationForm.isEmpty()){
            throw new EntityNotFoundException("Education form is not found");
        }
        student.setEducationForm(findedEducationForm.get());

        return mapper.mapToDto(studentRepository.save(student));
    }

    public StudentFullDto update(StudentUpdateDto updateDto){
        Optional<StudentEntity> studentEntity = studentRepository.findById(updateDto.getId());
        StudentEntity studentToUpdate = studentEntity.orElseThrow(() -> new EntityNotFoundException("Student is not found"));

        Optional<EducationFormEntity> findedEducationForm = educationFormRepository.findById(updateDto.getEducationFormId());
        if (findedEducationForm.isEmpty()){
            throw new EntityNotFoundException("Education form is not found");
        }
        studentToUpdate.setEducationForm(findedEducationForm.get());

        Optional<GroupEntity> findedGroup = groupRepository.findById(updateDto.getGroupId());
        if (findedGroup.isEmpty()){
            throw new EntityNotFoundException("Group is not found");
        }
        studentToUpdate.setGroup(findedGroup.get());

        Optional<RoleEntity> findedRole = roleRepository.findById(updateDto.getUser().getRoleId());
        if (findedRole.isEmpty()){
            throw new EntityNotFoundException("Role is not found");
        }
        studentToUpdate.getUser().setRole(findedRole.get());

        studentToUpdate.setRegistrationAddress(updateDto.getRegistrationAddress());
        studentToUpdate.setResidentialAddress(updateDto.getResidentialAddress());
        studentToUpdate.getUser().setLogin(updateDto.getUser().getLogin());
        studentToUpdate.getUser().setPassword(updateDto.getUser().getPassword());
        studentToUpdate.getUser().getPerson().setName(updateDto.getUser().getPerson().getName());
        studentToUpdate.getUser().getPerson().setPatronymic(updateDto.getUser().getPerson().getPatronymic());
        studentToUpdate.getUser().getPerson().setSurname(updateDto.getUser().getPerson().getSurname());
        studentToUpdate.setPhone(updateDto.getPhone());

        return mapper.mapToDto(studentRepository.save(studentToUpdate));
    }

    @Override
    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }
}
