package com.coffeproject.Repositories;

import com.coffeproject.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findById(long id);

    User findByUsername(String username);

}
