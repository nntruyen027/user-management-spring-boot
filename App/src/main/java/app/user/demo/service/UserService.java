package app.user.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import app.user.demo.entity.User;
import app.user.demo.repository.UserRepository;
import app.user.demo.request.UserRequest;

@Service
public interface UserService {
	Iterable<User> getUsers();
	void createUser(UserRequest userRequest);
	User updateUser(UserRequest userRequest);
	void deleteUser(String id);
}
