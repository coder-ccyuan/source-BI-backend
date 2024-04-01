package com.cpy.BI.model.dto;

import lombok.Data;
import springfox.documentation.swagger.web.ApiResourceController;

/**
 * @Author:成希德
 */
@Data
public class UserLoginRequest {
    private String userAccount;
    private String userPassword;
}
