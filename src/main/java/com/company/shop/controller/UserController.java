package com.company.shop.controller;

import com.company.shop.dao.UserDao;
import com.company.shop.model.ResponseMessage;
import com.company.shop.model.dto.UserDto;
import com.company.shop.validation.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    private UserDao userDao;
    @Autowired
    private UserValidator userValidator;

    @RequestMapping(value = "/login")
    public String getLogin(@RequestParam(value = "error", required = false) String error,
                           @RequestParam(value = "logout", required = false) String logout,
                           Model model) {
        model.addAttribute("error", error != null);
        model.addAttribute("logout", logout != null);
        return "login";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String getRegistration() {
        return "registration";
    }

    @ResponseBody
    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ResponseMessage addUser(@RequestBody UserDto userDto) {
        String validateResult = userValidator.validate(userDto);
        if (validateResult != null) {
            return ResponseMessage.errorMessage(validateResult);
        } else
            userDao.create(userDto);
        return ResponseMessage.okMessage();
    }

}
