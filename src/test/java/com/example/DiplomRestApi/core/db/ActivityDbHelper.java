package com.example.DiplomRestApi.core.db;

import com.example.DiplomRestApi.repository.ActivityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ActivityDbHelper {

    private final ActivityRepository activityRepository;

    public void clear() {
        activityRepository.deleteAll();
    }
}
