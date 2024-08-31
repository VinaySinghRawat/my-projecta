package com.example.demo.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.JournalEntry;
import com.example.demo.entity.User;
import com.example.demo.repository.JournalEntryRepository;

import lombok.extern.slf4j.Slf4j;

@Service
public class JournalEntryService  {
@Autowired
private JournalEntryRepository journalEntryRepository;

@Autowired
private UserService userService;


@Transactional
public void saveEntry(JournalEntry journalEntry,String userName) {
	try{User user=userService.findByUserName(userName);
		journalEntry.setDate(LocalDateTime.now());
		JournalEntry saved=journalEntryRepository.save(journalEntry);
	user.getJournalEntries().add(saved);
	userService.saveUser(user);}
	catch(Exception e) {
		
		throw new RuntimeException("An error occured while saving the entry ",e);
	}
}
public void saveEntry(JournalEntry journalEntry) {
	
	journalEntryRepository.save(journalEntry);
}

public List<JournalEntry> getAll(){
	return journalEntryRepository.findAll();
	}

public Optional<JournalEntry> findById(ObjectId id) {
	return journalEntryRepository.findById(id);
}

@Transactional
public boolean deleteById(ObjectId id, String userName) {
	boolean removed=false;
	try{User user=userService.findByUserName(userName);
	removed=user.getJournalEntries().removeIf(x-> x.getId().equals(id));
	
	if(removed) {
		userService.saveUser(user);
		journalEntryRepository.deleteById(id);
	}}
	catch(Exception e) {
		System.out.println(e);
		throw new RuntimeException("Anerror occured while select deleting the entry ",e);
	}
	return removed;
}
//public List<JournalEntry> findByUserName(String userName){
//	
//}
}


//controller--.service-->repository