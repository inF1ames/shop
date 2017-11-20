package com.company.shop.controller;

import com.company.shop.dao.ItemDao;
import com.company.shop.dao.OrderDao;
import com.company.shop.dao.UserDao;
import com.company.shop.dao.entity.Item;
import com.company.shop.model.CartParser;
import com.company.shop.model.ResponseMessage;
import com.company.shop.model.dto.ItemDto;
import com.company.shop.model.dto.OrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
public class ShopController {

    @Autowired
    private OrderDao orderDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private ItemDao itemDao;
    @Autowired
    private CartParser cartParser;


    @ResponseBody
    @RequestMapping(value = "/submitOrder", method = RequestMethod.POST, consumes = "application/json")
    public ResponseMessage submitOrder(Principal principal, @RequestBody(required = false) String cart) {
        if (cart != null) {
            List<Item> items = cartParser.parse(cart);
            OrderDto orderDto = new OrderDto();
            orderDto.setUser(userDao.findByUsername(principal.getName()));
            orderDto.setItems(items);
            orderDao.create(orderDto);
            return ResponseMessage.okMessage();
        } else {
            return ResponseMessage.errorMessage("Ваша корзина пустая, пожалуйста добавьте товар и попробуйте снова! :)");
        }
    }

    @RequestMapping(value = "/getItems", method = RequestMethod.GET)
    public @ResponseBody
    List<ItemDto> getItemsList() {
        return itemDao.findAll();
    }

}
