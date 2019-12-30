package com.user.function.service;


import com.user.function.entities.UserProfile;

public interface UserProfileService {
    UserProfile loadUserProfile(String userId);
}
