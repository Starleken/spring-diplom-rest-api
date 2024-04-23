package com.example.DiplomRestApi.service.impl;

import com.example.DiplomRestApi.dto.activity.ActivityCreateDto;
import com.example.DiplomRestApi.dto.activity.ActivityFullDto;
import com.example.DiplomRestApi.dto.activity.ActivityUpdateDto;
import com.example.DiplomRestApi.entity.*;
import com.example.DiplomRestApi.exception.EntityNotFoundException;
import com.example.DiplomRestApi.mapper.ActivityMapper;
import com.example.DiplomRestApi.repository.*;
import com.example.DiplomRestApi.service.ActivityService;
import com.example.DiplomRestApi.service.ImageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class ActivityServiceImpl implements ActivityService {
    private final ActivityRepository activityRepository;
    private final ActivityLevelRepository activityLevelRepository;
    private final ActivityTypeRepository activityTypeRepository;
    private final StudentRepository studentRepository;

    private final ImageService imageService;

    private final ActivityMapper activityMapper;

    @Override
    public List<ActivityFullDto> findAll(){
        List<ActivityEntity> entities = activityRepository.findAll();

        List<ActivityFullDto> dtos = entities.stream()
                .map(activityMapper::mapToDto)
                .collect(Collectors.toList());

        return dtos;
    }

    @Override
    public ActivityFullDto save(ActivityCreateDto createDto) {
        ActivityEntity activity = activityMapper.mapToEntity(createDto);
//        String imagePath = imageService.saveImage(createDto.getImage());
//        activity.setImageURL(imagePath);

        Optional<StudentEntity> findedStudent = studentRepository.findById(createDto.getStudentId());
        if (findedStudent.isEmpty()){
            //TODO
            return null;
        }
        activity.setStudent(findedStudent.get());

        Optional<ActivityLevelEntity> findedLevel = activityLevelRepository.findById(createDto.getActivityLevelId());
        if (findedLevel.isEmpty()){
            //TODO
            return null;
        }
        activity.setActivityLevel(findedLevel.get());

        Optional<ActivityTypeEntity> findedType = activityTypeRepository.findById(createDto.getActivityTypeId());
        if (findedType.isEmpty()){
            //TODO
            return null;
        }
        activity.setActivityType(findedType.get());

        ActivityEntity savedActivity = activityRepository.save(activity);

        return activityMapper.mapToDto(savedActivity);
    }

    @Override
    public ActivityFullDto update(ActivityUpdateDto updateDto){
        Optional<ActivityEntity> activityToChange = activityRepository.findById(updateDto.getId());

        //TODO
        if (activityToChange.isEmpty()){
            return null;
        }

        ActivityEntity activityToUpdate = activityToChange.get();

        Optional<ActivityTypeEntity> findedType = activityTypeRepository.findById(updateDto.getActivityTypeId());
        Optional<ActivityLevelEntity> findedLevel = activityLevelRepository.findById(updateDto.getActivityLevelId());

        if (findedLevel.isEmpty() || findedType.isEmpty()){
            //TODO
            return null;
        }

        activityToUpdate.setActivityLevel(findedLevel.get());
        activityToUpdate.setActivityType(findedType.get());
        activityToUpdate.setName(updateDto.getName());
        activityToUpdate.setDate(updateDto.getDate());
        activityToUpdate.setPlace(updateDto.getPlace());
        activityToUpdate.setEventPlace(updateDto.getEventPlace());

        if (updateDto.getImage() != null){
            imageService.deleteImage(activityToUpdate.getImageURL());
            String imagePath = imageService.saveImage(updateDto.getImage());
            activityToUpdate.setImageURL(imagePath);
        }

        ActivityEntity updated = activityRepository.save(activityToUpdate);
        return activityMapper.mapToDto(updated);
    }

    @Override
    public List<ActivityFullDto> findActivitiesByStudent(long studentId) {
        Optional<StudentEntity> findedStudent = studentRepository.findById(studentId);

        //TODO
        if (findedStudent.isEmpty()){
            return null;
        }

        List<ActivityEntity> entities = activityRepository.
                findActivitiesByStudent(findedStudent.get());

        List<ActivityFullDto> dtos = entities.stream()
                .map(activityMapper::mapToDto)
                .collect(Collectors.toList());

        return dtos;
    }

    @Override
    public void deleteById(Long id) {
        Optional<ActivityEntity> activity = activityRepository.findById(id);

        if (activity.isEmpty()){
            throw new EntityNotFoundException("Activity is not found");
        }

        imageService.deleteImage(activity.get().getImageURL());
        activityRepository.deleteById(id);
    }
}
