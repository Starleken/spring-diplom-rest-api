package com.example.DiplomRestApi.core.utils.entity;

import com.example.DiplomRestApi.entity.RoleEntity;
import com.example.DiplomRestApi.entity.UserEntity;

public abstract class UserEntityUtils {

    public static UserEntity generateUser() {
        var user = new UserEntity();

        return user;
    }
}
