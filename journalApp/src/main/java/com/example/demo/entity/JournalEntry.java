package com.example.demo.entity;

import java.sql.Date;
import java.time.LocalDateTime;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;


import lombok.Data;
import lombok.NoArgsConstructor;




@Document(collection="journal_entries")   //map as collection
@Data
@NoArgsConstructor
public class JournalEntry {
	@Id  //map as primary key
private ObjectId id;
private String title;
private String content;
private LocalDateTime date;




}
