package com.example.homenet.pojo;

import lombok.Data;

@Data
public class UserInfo {

    private String id;
    private String name;
    private String password;
    private String role;
    private int roleCode;
}
