package com.example.DiplomRestApi.dto.curator;

import com.example.DiplomRestApi.dto.user.UserCreateDto;
import com.example.DiplomRestApi.dto.user.UserFullDto;
import lombok.Data;

@Data
public class CuratorCreateDto {

    private UserCreateDto user;
    private Long groupId;
}
