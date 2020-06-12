package com.thanhtrt.baitapvalidateformdangky.service;

import com.thanhtrt.baitapvalidateformdangky.model.User;
import com.thanhtrt.baitapvalidateformdangky.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepository;
    @Override
    public void save(User user) {
userRepository.save(user);
    }
}
