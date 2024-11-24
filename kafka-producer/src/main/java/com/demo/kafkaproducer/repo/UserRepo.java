package com.demo.kafkaproducer.repo;

import com.demo.kafkaproducer.model.App_User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<App_User, Integer> {
}
