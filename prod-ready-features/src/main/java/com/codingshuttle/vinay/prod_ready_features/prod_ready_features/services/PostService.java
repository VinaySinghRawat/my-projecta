package com.codingshuttle.vinay.prod_ready_features.prod_ready_features.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingshuttle.vinay.prod_ready_features.prod_ready_features.DTO.PostDTO;
import com.codingshuttle.vinay.prod_ready_features.prod_ready_features.repositories.PostRepository;


public interface PostService {

	List<PostDTO> getAllPosts();
	PostDTO createNewPost(PostDTO inputPostDTO);
	PostDTO getPostById(Long postId);
	PostDTO updatePost(PostDTO inputPost, Long postId);
}
