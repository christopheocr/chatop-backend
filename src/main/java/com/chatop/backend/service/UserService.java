package com.chatop.backend.service;


import com.chatop.backend.dto.UserInfoDto;
import com.chatop.backend.entity.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;

@Service
public class UserService {
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy/MM/dd");

    public User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !(authentication.getPrincipal() instanceof User)) {
            throw new IllegalStateException("Utilisateur non authentifié");
        }
        return (User) authentication.getPrincipal();
    }

    public UserInfoDto convertToUserInfoDto(User user) {
        if (user == null) {
            return null;
        }

        UserInfoDto userDto = new UserInfoDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        userDto.setCreatedAt(DATE_FORMAT.format(user.getCreatedAt()));
        userDto.setUpdatedAt(DATE_FORMAT.format(user.getUpdatedAt()));

        return userDto;
    }
}
