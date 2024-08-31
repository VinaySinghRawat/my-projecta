package com.example.demo.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.entity.JournalEntry;

public interface JournalEntryRepository extends MongoRepository<JournalEntry,ObjectId> {

}
