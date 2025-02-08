package com.codingshuttle.vinay.prod_ready_features.prod_ready_features.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codingshuttle.vinay.prod_ready_features.prod_ready_features.DTO.PostDTO;
import com.codingshuttle.vinay.prod_ready_features.prod_ready_features.services.PostService;
import com.codingshuttle.vinay.prod_ready_features.prod_ready_features.services.PostServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/post")
public class PostController {
	
private final PostService postService;
@GetMapping
public List<PostDTO> getAllPosts(){
	return postService.getAllPosts();
}

@GetMapping("/{postId}")
public PostDTO getPostById(@PathVariable Long postId) {
	return postService.getPostById(postId);
}

@PostMapping
public PostDTO creatNewPost(@RequestBody PostDTO inputPost) {
	return postService.createNewPost(inputPost);
}
@PutMapping("/{postId}")
public PostDTO updatePost(@RequestBody PostDTO inputPost,@PathVariable Long postId) {
	return postService.updatePost(inputPost,postId);
}
}
