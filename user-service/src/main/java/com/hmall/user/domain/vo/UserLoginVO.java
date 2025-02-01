package com.hmall.user.domain.vo;

import lombok.Data;

/**
 * @author unique
 */
@Data
public class UserLoginVO {
    private String token;
    private Long userId;
    private String username;
    private Integer balance;
}
