package net.javatatiana.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javatatiana.springboot.model.User;


public interface UserRepository extends JpaRepository<User, Long>{

}
