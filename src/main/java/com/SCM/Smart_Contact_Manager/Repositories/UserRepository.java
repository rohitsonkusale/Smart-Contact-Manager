package com.SCM.Smart_Contact_Manager.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SCM.Smart_Contact_Manager.Entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>{

    // extra method db relatedopertaion 
    // custom query method 
	
    // custom finder method 
	Optional<User> findByEmail(String email);
	Optional<User> findByEmailAndPassword(String email, String password);
}
