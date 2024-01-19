package com.example.DiplomRestApi.dto.curator;

import com.example.DiplomRestApi.dto.group.GroupFullDto;
import com.example.DiplomRestApi.dto.user.UserFullDto;
import lombok.Data;

@Data
public class CuratorFullDto {

    private Long id;
    private UserFullDto user;
    private GroupFullDto group;
}
