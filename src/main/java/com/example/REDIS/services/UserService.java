package com.example.REDIS.services;

import com.example.REDIS.entities.UserJPA;
import com.example.REDIS.entities.UserRedis;
import com.example.REDIS.repositories.jpa.UserJPARepository;
import com.example.REDIS.repositories.redis.UserRedisRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@org.springframework.stereotype.Service
public class UserService {
	@Autowired
	private UserJPARepository userJPARepository;
	@Autowired
	private UserRedisRepository userRedisRepository;
	public UserRedis convertData(UserJPA user){
		UserRedis userRedis = new UserRedis();
		BeanUtils.copyProperties(user, userRedis);
		return userRedis;
	}
	
	public UserJPA convertData(UserRedis user){
		UserJPA userJPA = new UserJPA();
		BeanUtils.copyProperties(user, userJPA);
		return userJPA;
	}
	
	public UserJPA createUser(UserJPA user){
		return userJPARepository.saveAndFlush(user);
	}
	public UserJPA readUser(Long id){
		Optional<UserRedis> userRedis = userRedisRepository.findById(id);
		if(userRedis.isPresent()){
			return convertData(userRedis.get());
		}else if (userJPARepository.existsById(id)){
			UserJPA userFromDB = userJPARepository.findById(id).get();
			userRedisRepository.save(convertData(userFromDB));
			return userFromDB;
		} else return null;
	}
	public UserJPA updateUser(UserJPA user){
		userRedisRepository.deleteById(user.getId());
		return userJPARepository.saveAndFlush(user);
	}
	public void deleteUser(Long id){
		userJPARepository.deleteById(id);
		userRedisRepository.deleteById(id);
	}
}
