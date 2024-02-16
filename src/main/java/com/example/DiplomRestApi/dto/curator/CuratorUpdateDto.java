package com.example.DiplomRestApi.dto.curator;

import com.example.DiplomRestApi.dto.user.UserUpdateDto;
import lombok.Data;

@Data
public class CuratorUpdateDto {

    private Long id;
    private UserUpdateDto user;
    private long groupId;
}
