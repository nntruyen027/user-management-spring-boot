package app.user.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import app.user.demo.request.UserRequest;
import app.user.demo.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public ResponseEntity<?> getUsers() {
		return ResponseEntity.ok(userService.getUsers());
	}
	
	@PostMapping(value = "/", consumes = "application/x-www-form-urlencoded")
	public ResponseEntity<?> createUser(UserRequest userRequest) {
		userService.createUser(userRequest);
		return ResponseEntity.ok("Đã tạo thành công user:  " + userRequest.getFullName());
	}
	
	@PutMapping(value = "/{id}", consumes = "application/x-www-form-urlencoded")
	public ResponseEntity<?> updateUser(@PathVariable String id, UserRequest userRequest) {
		userService.updateUser(userRequest);
		return ResponseEntity.ok("Đã cập nhật thành công thông tin "  + userRequest.getFullName());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable String id) {
		userService.deleteUser(id);
		return ResponseEntity.ok("Đây là giao diện trang xóa user " + id);
	}
} 
