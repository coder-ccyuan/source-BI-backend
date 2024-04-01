package com.cpy.BI.model.dto;

import lombok.Data;

/**
 * @Author:成希德
 */
@Data
public class UserRegisterRequest {
    private String userAccount;
    private String userPassword;
    private String checkPassword;
}
