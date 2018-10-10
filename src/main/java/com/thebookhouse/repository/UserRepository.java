package com.thebookhouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thebookhouse.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
