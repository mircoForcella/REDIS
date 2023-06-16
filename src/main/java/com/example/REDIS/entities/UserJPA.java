package com.example.REDIS.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class UserJPA extends User {
	public UserJPA(Long id, String name, String surname) {
		super(id, name, surname);
	}
	
	public UserJPA() {
	}
	
}
