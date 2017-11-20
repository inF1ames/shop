package com.company.shop.dao.impl;

import com.company.shop.converters.EntityDtoConverter;
import com.company.shop.dao.UserDao;
import com.company.shop.dao.entity.Role;
import com.company.shop.dao.entity.User;
import com.company.shop.model.dto.UserDto;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.company.shop.converters.EntityDtoConverter.convert;
import static java.util.stream.Collectors.toList;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void create(UserDto userDto) {
        userDto.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
        userDto.setRole(Role.ROLE_USER);
        sessionFactory.getCurrentSession().save(convert(userDto));
    }

    @Override
    public UserDto findByUsername(String username) {
        User user = (User) sessionFactory.getCurrentSession()
                .createQuery("select u from User u where u.username = :username")
                .setParameter("username", username)
                .uniqueResult();
        return convert(user);
    }

    @Override
    public List<UserDto> findAll() {
        List<User> users = sessionFactory.getCurrentSession()
                .createQuery("from User")
                .list();
        return users.stream().map(EntityDtoConverter::convert).collect(toList());
    }
}
