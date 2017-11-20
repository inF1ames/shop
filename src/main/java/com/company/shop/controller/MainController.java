package com.company.shop.controller;


import com.company.shop.dao.ItemDao;
import com.company.shop.dao.OrderDao;
import com.company.shop.dao.UserDao;
import com.company.shop.model.ContactInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;


@Controller
public class MainController {

    @Autowired
    private ItemDao itemDao;
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private ContactInformation contactInformation;

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String getMain() {
        return "main";
    }

    @RequestMapping(value = "/goods", method = RequestMethod.GET)
    public String getAllItems(Model model) {
        model.addAttribute("itemList", itemDao.findAll());
        return "goods";
    }

    @RequestMapping(value = "/history", method = RequestMethod.GET)
    public String getHistory(Principal principal, Model model) {
        model.addAttribute("orders", orderDao.findAllOrdersByUserId(
                userDao.findByUsername(principal.getName())
                        .getId()));
        return "history";
    }

    @RequestMapping(value = "/cart", method = RequestMethod.GET)
    public String getCart() {
        return "cart";
    }

    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public String about() {
        return "about";
    }

    @RequestMapping(value = "/contacts", method = RequestMethod.GET)
    public String getContacts(Model model) {
        model.addAttribute("contactInformation", contactInformation);
        return "contacts";
    }


}
