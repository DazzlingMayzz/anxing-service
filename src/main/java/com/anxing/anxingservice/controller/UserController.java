package com.anxing.anxingservice.controller;

import com.anxing.anxingservice.model.Contact;
import com.anxing.anxingservice.model.RespBean;
import com.anxing.anxingservice.model.User;
import com.anxing.anxingservice.service.ContactService;
import com.anxing.anxingservice.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    ContactService contactService;

    @GetMapping("")
    List<User> getAll() {
        return userService.getAllUser();
    }

    @PostMapping("")
    int insert(@Param("openid") String openid) {
        return userService.insert(openid);
    }

    @GetMapping("/{openid}")
    User getByOpenid(@PathVariable("openid") String openid) {
        List<User> l = userService.getByOpenid(openid);
        if (l.size() != 0) {
            return l.get(0);
        } else {
            return null;
        }
    }

    @PostMapping("/{openid}")
    RespBean addContact(@PathVariable("openid") String openid, @Param("name") String name, @Param("phoneNumber") Integer phoneNumber) {
        List<User> l = userService.getByOpenid(openid);
        if (l.size() == 0) {
            userService.insert(openid);
            l = userService.getByOpenid(openid);
        }
        Integer user_id = l.get(0).getId();
        Contact contact = new Contact();
        contact.setUser_id(user_id);
        contact.setName(name);
        contact.setPhoneNumber(phoneNumber);
        if (contactService.insert(contact) == 1) {
            return new RespBean("success", "成功！");
        } else {
            return new RespBean("error", "失败！");
        }
    }

    @DeleteMapping("/{openid}")
    RespBean deleteContact(@PathVariable("openid") String openid, @Param("name") String name, @Param("phoneNumber") Integer phoneNumber) {
        List<User> l = userService.getByOpenid(openid);
        if (l.size() == 0) {
            return new RespBean("error", "失败！");
        }
        Integer user_id = l.get(0).getId();
        Contact contact = new Contact();
        contact.setUser_id(user_id);
        contact.setName(name);
        contact.setPhoneNumber(phoneNumber);
        if (contactService.delete(contact) == 1) {
            return new RespBean("success", "成功！");
        } else {
            return new RespBean("error", "失败！");
        }
    }

}
