package com.Gowfy.Dao;

import com.Gowfy.model.ProfilePicture;

public interface ProfilePictureDao {
	void uploadProfilePicture(ProfilePicture profilePicture);
	ProfilePicture getProfilePicture(String email);
}
