package com.ibm.internshipTool.controllers;

import com.ibm.internshipTool.responses.UserProfileResponse;
import com.ibm.internshipTool.services.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.ibm.internshipTool.requests.UserProfileRequest;

@RestController
@RequestMapping("/v1")
public class ProfileController {
    private final UserProfileService userProfileService;

    @Autowired
    public ProfileController(UserProfileService userProfileService) {
        this.userProfileService = userProfileService;
    }

    @GetMapping("/profile/{userId}")
    public ResponseEntity<UserProfileResponse> getUserProfile(@PathVariable Long userId) {
        // Fetch the user's profile using the service and the provided user ID
        UserProfileResponse userProfileResponse = userProfileService.getUserProfile(userId);

        if (userProfileResponse != null) {
            return ResponseEntity.ok(userProfileResponse);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/profile/{userId}")
    public ResponseEntity<UserProfileResponse> updateUserProfile(
            @PathVariable Long userId,
            @RequestBody UserProfileRequest request
    ) {
        // Update the user's profile using the service and the provided user ID
        UserProfileResponse userProfileResponse = userProfileService.updateUserProfile(userId, request);

        if (userProfileResponse != null) {
            return ResponseEntity.ok(userProfileResponse);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
