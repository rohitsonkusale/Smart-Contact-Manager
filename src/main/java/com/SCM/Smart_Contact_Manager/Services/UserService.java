package com.SCM.Smart_Contact_Manager.Services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.SCM.Smart_Contact_Manager.Entities.User;
import com.SCM.Smart_Contact_Manager.Repositories.UserRepository;
import com.SCM.Smart_Contact_Manager.helpers.AppConstants;
import com.SCM.Smart_Contact_Manager.helpers.ResourceNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public User saveUser(User user) {
//		user id: have to generate
		String userId = UUID.randomUUID().toString();
		user.setUserId(userId);
		//password encode
		// user.setPassword(userId);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		
		//set the user role
		user.setRoleList(List.of(AppConstants.ROLE_USER));
		
		logger.info(user.getProvider().toString());
		
		return userRepo.save(user);
	}

	public Optional<User> getUserById(String id) {
		return userRepo.findById(id);
	}

	public Optional<User> updateUser(User user) {
		User user2 = userRepo.findById(user.getUserId())
				.orElseThrow(() -> new ResourceNotFoundException("User Not Found"));
		// update karenge user2 ko user se
		user2.setname(user.getname());
		user2.setEmail(user.getEmail());
		user2.setPassword(user.getPassword());
		user2.setPhoneNumber(user.getPhoneNumber());
		user2.setAbout(user.getAbout());
		user2.setProfilePic(user.getProfilePic());
		user2.setEnabled(user.isEnabled());
		user2.setEmailVerified(user.isEmailVerified());
		user2.setPhoneVerified(user.isPhoneVerified());
		user2.setProvider(user.getProvider());
		user2.setProviderId(user.getProviderId());
		// save the user in data-base
		User save = userRepo.save(user2);
		return Optional.ofNullable(save);
	}

	public void deleteUser(String id) {
		User user2 = userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User Not Found"));
		userRepo.delete(user2);
	}

	public boolean isUserExist(String userId) {
		User user2 = userRepo.findById(userId).orElse(null);
		return user2 != null ? true : false;

	}

	public boolean isUserExistByEmail(String email) {
		User user = userRepo.findByEmail(email).orElse(null);
		return user != null ? true : false;
	}

	public List<User> getAllUsers() {
		return userRepo.findAll();
	}

	// add more methods here related user services

}
