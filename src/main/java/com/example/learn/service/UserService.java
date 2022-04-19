package com.example.learn.service;

import com.example.learn.entity.User;
import com.example.learn.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService
{
    private final UserRepository userRepository;

    public User save(User user)
    {
        return userRepository.save(user);
    }

    public User findById(Long id)
    {
        return userRepository.findById(id).orElseThrow();
    }
}
