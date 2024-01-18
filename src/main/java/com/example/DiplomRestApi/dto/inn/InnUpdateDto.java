package com.example.DiplomRestApi.dto.inn;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class InnUpdateDto {

    private long id;
    private String number;
    private MultipartFile image;
}
