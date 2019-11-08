package com.anxing.anxingservice.model;

import lombok.Data;

import java.util.List;

@Data
public class User {
    private Integer id;
    private String openid;

    private List<Contact> contacts;
}
