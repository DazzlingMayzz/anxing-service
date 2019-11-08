package com.anxing.anxingservice.controller;

import com.anxing.anxingservice.model.Contact;
import com.anxing.anxingservice.model.User;
import com.anxing.anxingservice.service.ContactService;
import com.anxing.anxingservice.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    UserService userService;

    @Autowired
    ContactService contactService;

    @GetMapping("")
    List<Contact> get(@Param("user_id") String user_id) {
        if (user_id == null) {
            return contactService.getAll();
        } else {
            return contactService.getContactByUser_id(user_id);
        }
    }

}
