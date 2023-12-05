package com.example.DiplomRestApi.service.impl;

import com.example.DiplomRestApi.entity.ActivityEntity;
import com.example.DiplomRestApi.entity.UserEntity;
import com.example.DiplomRestApi.repository.ActivityRepository;
import com.example.DiplomRestApi.repository.UserRepository;
import com.example.DiplomRestApi.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActivityServiceImpl implements ActivityService {
    private ActivityRepository activityRepository;
    private UserRepository userRepository;

    @Autowired
    public ActivityServiceImpl(ActivityRepository activityRepository, UserRepository userRepository) {
        this.activityRepository = activityRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<ActivityEntity> findAll(){
        return activityRepository.findAll();
    }

    @Override
    public ActivityEntity save(ActivityEntity activityEntity) {
        return activityRepository.save(activityEntity);
    }

    @Override
    public ActivityEntity update(ActivityEntity activityEntity){
        Optional<ActivityEntity> activityToChange = activityRepository.findById(activityEntity.getId());

        //TODO
        if (activityToChange.isEmpty()){
            return null;
        }

        ActivityEntity activityEntityToSave = activityToChange.get();

        activityEntityToSave.setDate(activityEntity.getDate());
        activityEntityToSave.setActivityType(activityEntity.getActivityType());
        activityEntityToSave.setActivityLevel(activityEntity.getActivityLevel());
        activityEntityToSave.setName(activityEntity.getName());
        activityEntityToSave.setPlace(activityEntity.getPlace());
        activityEntityToSave.setImageURL(activityEntity.getImageURL());

        return activityRepository.save(activityEntityToSave);
    }

    @Override
    public List<ActivityEntity> findActivitiesByUser(long userId) {
        Optional<UserEntity> findedUser = userRepository.findById(userId);

        //TODO
        if (findedUser.isEmpty()){
            return null;
        }

        return activityRepository.findActivitiesByUser(findedUser.get());
    }


}
