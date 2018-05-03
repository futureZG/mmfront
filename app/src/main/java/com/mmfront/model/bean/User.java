package com.mmfront.model.bean;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by My on 2018/5/1.
 */
@Getter
@Setter
public class User {
    private String username;
    private String password;
    private Long phone;
    private int age;
    private int gender;
}
