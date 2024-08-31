package com.example.demo.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.entity.JournalEntry;
import com.example.demo.entity.User;

public interface UserRepository extends MongoRepository<User,ObjectId> {
 User findByUserName(String username);
 void deleteByUserName(String username);
}
