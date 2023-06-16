package com.example.REDIS.repositories.redis;

import com.example.REDIS.entities.UserRedis;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("userRedisRepository")
public interface UserRedisRepository extends CrudRepository<UserRedis, Long> {
}
