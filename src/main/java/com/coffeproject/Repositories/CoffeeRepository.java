package com.coffeproject.Repositories;

import com.coffeproject.Models.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoffeeRepository extends JpaRepository <Coffee, Long> {

    Coffee findById(long id);
}
