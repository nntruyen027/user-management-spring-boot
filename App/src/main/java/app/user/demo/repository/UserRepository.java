package app.user.demo.repository;

import org.springframework.data.repository.CrudRepository;

import app.user.demo.entity.User;

public interface UserRepository extends CrudRepository<User, String> {
	
}
