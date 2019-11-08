package com.anxing.anxingservice.model;

import lombok.Data;

@Data
public class Contact {
    private Integer id;
    private Integer user_id;
    private String name;
    private Integer phoneNumber;

//    private User user;
}
