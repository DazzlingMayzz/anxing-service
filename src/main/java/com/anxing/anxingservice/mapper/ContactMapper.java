package com.anxing.anxingservice.mapper;

import com.anxing.anxingservice.model.Contact;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ContactMapper {
    List<Contact> getAll();
    List<Contact> getContactByUser_id(String user_id);
    int insert(Contact contact);

    int delete(Contact contact);
}
