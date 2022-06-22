package com.codingdojo.bookclub.services;
import java.util.List;
import java.util.Optional;
import com.codingdojo.bookclub.repositories.UserRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.stereotype.Service;
import com.codingdojo.bookclub.models.User;
import com.codingdojo.bookclub.models.LoginUser;


@Service
public class UserService {
    
	@Autowired
	private UserRepository userRepository;
    
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    // Registration
    public User register(User newUser, BindingResult result) {
        if(userRepository.findByEmail(newUser.getEmail()).isPresent()) {
        	result.rejectValue("email", "Unique", "Email is already in use");	
        }
        if(!newUser.getPassword().equals(newUser.getConfirm())) {
        	result.rejectValue("confirm", "Matches", "Password and Confirm Password must match");
        }
        if(result.hasErrors()) {
        	return null;
        }
        
        String hashBrowns = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
        newUser.setPassword(hashBrowns);
        
        return userRepository.save(newUser);
    }
    
    public User login(LoginUser newLoginObject, BindingResult result) {
        Optional<User> optUser = userRepository.findByEmail(newLoginObject.getEmail());
        if(!optUser.isPresent()) {
        	result.rejectValue("email", "Unique", "Invalid Credentials");
        	return null;
        }
        User user = optUser.get();
        if(!BCrypt.checkpw(newLoginObject.getPassword(), user.getPassword())) {
        	result.rejectValue("password", "Matches", "Invalid Credentials");
        	return null;
        }
        
        return user;
    }
    // returns all the expenses
    public List<User> allUsers() {
        return userRepository.findAll();
    }
    // creates an expense
    public User createUser(User d) {
        return userRepository.save(d);
    }
    // Retrieves an expense
    public User findUser(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isPresent()) {
            return optionalUser.get();
        } else {
            return null;
        }
    }
    
    // Overloaded method to update expense with expense object
    public User updateUser(User e) {
        return userRepository.save(e);
    }
    // Deletes a book
    public void deleteUser(Long id) {
    	userRepository.deleteById(id);
    }
}

