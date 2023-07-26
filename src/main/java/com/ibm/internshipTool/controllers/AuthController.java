package com.ibm.internshipTool.controllers;


import com.ibm.internshipTool.models.UserProfile;
import com.ibm.internshipTool.responses.UserProfileResponse;
import com.ibm.internshipTool.services.UserProfileService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class AuthController {

    private final UserProfileService userProfileService;

    @Autowired
    public AuthController(UserProfileService userProfileService) {
        this.userProfileService = userProfileService;
    }

    @PostMapping("/login")
    public ResponseEntity<UserProfileResponse> login(@RequestParam String email) {
        // Check if the user exists based on the provided email
        UserProfile userProfile = userProfileService.getUserProfileByEmail(email);

        if (userProfile != null) {
            // User exists, return the user profile or any relevant information
            UserProfileResponse userProfileResponse = convertToUserProfileResponse(userProfile);
            return ResponseEntity.ok(userProfileResponse);
        } else {
            // User does not exist, return an appropriate response (e.g., 404 Not Found)
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(HttpSession session) {
        // Invalidate the session to perform logout
        session.invalidate();
        return ResponseEntity.ok("Logout successful");
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
