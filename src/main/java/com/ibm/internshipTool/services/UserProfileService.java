package com.ibm.internshipTool.services;

import com.ibm.internshipTool.models.UserProfile;
import com.ibm.internshipTool.repositories.UserProfileRepository;
import com.ibm.internshipTool.requests.UserProfileRequest;
import com.ibm.internshipTool.responses.UserProfileResponse;
import org.springframework.stereotype.Service;

@Service
public class UserProfileService {

    private final UserProfileRepository userProfileRepository;

    public UserProfileService(UserProfileRepository userProfileRepository) {
        this.userProfileRepository = userProfileRepository;
    }
    public UserProfile getUserProfileByEmail(String email) {
        return userProfileRepository.getUserProfileByEmail(email);
    }
    public UserProfileResponse getUserProfile(Long userId) {
        UserProfile userProfile = userProfileRepository.getProfileById(userId);
        if (userProfile != null) {
            // Convert the UserProfile to UserProfileResponse
            return convertToUserProfileResponse(userProfile);
        } else {
            return null;
        }
    }

    public UserProfileResponse updateUserProfile(Long userId, UserProfileRequest request) {
        UserProfile userProfile = userProfileRepository.getProfileById(userId);
        if (userProfile != null) {
            // Update the userProfile based on the UserProfileRequest
            userProfile.setUsername(request.getUsername());
            userProfile.setEmail(request.getEmail());
            userProfile.setPhoto(request.getPhoto());

            // Save the updated profile
            userProfileRepository.save(userProfile);

            // Convert the updated UserProfile to UserProfileResponse
            return convertToUserProfileResponse(userProfile);
        } else {
            return null;
        }
    }

    private UserProfileResponse convertToUserProfileResponse(UserProfile userProfile) {
        // Convert the UserProfile to UserProfileResponse as per your defined structure
        UserProfileResponse userProfileResponse = new UserProfileResponse();
        userProfileResponse.setUsername(userProfile.getUsername());
        userProfileResponse.setEmail(userProfile.getEmail());
        userProfileResponse.setPhoto(userProfile.getPhoto());
        // Set other fields if needed
        return userProfileResponse;
    }
}
