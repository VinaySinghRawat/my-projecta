package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.Service.JournalEntryService;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@SpringBootTest
public class UserServiceTests {
	@Autowired
	private UserRepository userRepository;
    
	@Autowired
	private JournalEntryService journalEntryService;
	
	@ParameterizedTest
	@CsvSource({
		"ram",
		"syam",
		"vinay"
	})
	
	
	public void testFindByUserName(String name) {
		
 // User user=userRepository.findByUserName("vinay");
assertNotNull(userRepository.findByUserName(name),"failed for :"+name);
    	//	assertEquals(4,2+2);
		//assertTrue(!user.getJournalEntries().isEmpty());
    }
	
	@Disabled
	@ParameterizedTest
	@CsvSource({
		"1,1,2",
		"2,10,12",
		"3,3,9"
	})
	public void test(int a,int b,int expected) {
		assertEquals(expected,a+b);
	}
}
