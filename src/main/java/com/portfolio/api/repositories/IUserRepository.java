package com.portfolio.api.repositories;

import com.portfolio.api.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Long> {

}
