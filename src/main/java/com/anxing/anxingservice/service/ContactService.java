package com.anxing.anxingservice.service;

import com.anxing.anxingservice.mapper.ContactMapper;
import com.anxing.anxingservice.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {

    @Autowired
    ContactMapper contactMapper;

    public List<Contact> getAll() {
        return contactMapper.getAll();
    }

    public List<Contact> getContactByUser_id(String user_id) {
        return contactMapper.getContactByUser_id(user_id);
    }

    public int insert(Contact contact) {
        return contactMapper.insert(contact);
    }

    public int delete(Contact contact) {
        return contactMapper.delete(contact);
    }
}
