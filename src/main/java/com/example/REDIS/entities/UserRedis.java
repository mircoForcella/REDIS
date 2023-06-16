package com.example.REDIS.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
@RedisHash(value = "user", timeToLive = 60)
public class UserRedis extends User implements Serializable {
	
	
	
	public UserRedis(Long id, String name, String surname) {
		super(id, name, surname);
	}
	public UserRedis() {
	}
}
