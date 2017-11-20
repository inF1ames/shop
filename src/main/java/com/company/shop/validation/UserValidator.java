package com.company.shop.validation;

import com.company.shop.dao.UserDao;
import com.company.shop.model.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserValidator {

    @Autowired
    private UserDao userDao;

    public String validate(UserDto userDto) {
        if (userDao.findByUsername(userDto.getUsername()) != null) {
            return "Username already exists.";
        }
        return null;
    }

}
