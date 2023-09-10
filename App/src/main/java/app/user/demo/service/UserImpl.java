package app.user.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.user.demo.entity.User;
import app.user.demo.repository.UserRepository;
import app.user.demo.request.UserRequest;

@Component
public class UserImpl implements UserService {
	@Autowired
	private UserRepository userRepo;
	private List<User> users;

	@Override
	public Iterable<User> getUsers() {
		return userRepo.findAll();
	}

	@Override
	public void createUser(UserRequest userRequest) {
		User user = new User();
		user.setId(userRequest.getId());
		user.setFullname(userRequest.getFullName());
		user.setPhoneNumber(userRequest.getPhoneNumber());
		user.setAge(userRequest.getAge());
		
		userRepo.save(user);
		
	}

	@Override
	public User updateUser(UserRequest userRequest) {
		User user = userRepo.findById(userRequest.getId()).orElse(null);
		
		if(user == null)
			return null;
		
		user.setFullname(userRequest.getFullName());
		user.setAge(userRequest.getAge());
		user.setPhoneNumber(userRequest.getPhoneNumber());
		
		return userRepo.save(user);
	}

	@Override
	public void deleteUser(String id) {
		userRepo.deleteById(id);
		
	}
	
	
}
