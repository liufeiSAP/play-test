package com.user.login.service;


import com.user.login.entities.UserProfile;

public interface UserProfileService {
    UserProfile loadUserProfile(String userId);
}
