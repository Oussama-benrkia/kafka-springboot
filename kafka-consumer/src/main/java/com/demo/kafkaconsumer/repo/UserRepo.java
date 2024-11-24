package com.demo.kafkaconsumer.repo;

import com.demo.kafkaconsumer.model.App_User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<App_User, Integer> {
}
