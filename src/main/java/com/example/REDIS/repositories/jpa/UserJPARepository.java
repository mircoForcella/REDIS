package com.example.REDIS.repositories.jpa;

import com.example.REDIS.entities.UserJPA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserJPARepository extends JpaRepository<UserJPA, Long> {
}
