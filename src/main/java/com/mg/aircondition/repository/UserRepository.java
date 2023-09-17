package com.mg.aircondition.repository;

import com.mg.aircondition.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    public User findUserByPhoneNr(String phoneNumber);
}
