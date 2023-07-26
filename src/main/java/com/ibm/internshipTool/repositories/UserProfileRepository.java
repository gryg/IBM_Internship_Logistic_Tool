package com.ibm.internshipTool.repositories;

import com.ibm.internshipTool.models.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {

    // Method to fetch the user's profile by user ID
    UserProfile getProfileById(Long id);
    UserProfile getUserProfileByEmail(String email);

}
