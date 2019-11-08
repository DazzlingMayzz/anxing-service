package com.anxing.anxingservice.mapper;
import com.anxing.anxingservice.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    List<User> getAllUser();

    int insert(String openid);

    List<User> getByOpenid(String openid);

}
