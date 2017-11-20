package com.company.shop.dao;

import com.company.shop.model.dto.UserDto;

import java.util.List;

public interface UserDao {

    void create(UserDto userDto);

    UserDto findByUsername(String username);

    List<UserDto> findAll();

}
