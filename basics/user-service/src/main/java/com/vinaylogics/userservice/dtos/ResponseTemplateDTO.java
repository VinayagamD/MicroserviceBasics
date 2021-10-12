package com.vinaylogics.userservice.dtos;

import com.vinaylogics.userservice.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateDTO {

    private User user;
    private Department department;
}
