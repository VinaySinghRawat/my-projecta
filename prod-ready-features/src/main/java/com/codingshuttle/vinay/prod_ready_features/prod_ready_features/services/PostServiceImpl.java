package com.codingshuttle.vinay.prod_ready_features.prod_ready_features.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.codingshuttle.vinay.prod_ready_features.prod_ready_features.DTO.PostDTO;
import com.codingshuttle.vinay.prod_ready_features.prod_ready_features.entities.PostEntity;
import com.codingshuttle.vinay.prod_ready_features.prod_ready_features.exceptions.ResourceNotFoundException;
import com.codingshuttle.vinay.prod_ready_features.prod_ready_features.repositories.PostRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService{

	private final PostRepository postRepository;
	private final ModelMapper modelMapper;
	@Override
	public List<PostDTO> getAllPosts() {
		// TODO Auto-generated method stub
		return postRepository.findAll().stream().map(postEntity->modelMapper.map(postEntity, PostDTO.class)).toList();
	}

	@Override
	public PostDTO createNewPost(PostDTO inputPostDTO) {
		// TODO Auto-generated method stub
			PostEntity postEntity =modelMapper.map(inputPostDTO, PostEntity.class);
	return	modelMapper.map(postRepository.save(postEntity),PostDTO.class);
			
	}

	@Override
	public PostDTO getPostById(Long postId) {
		// TODO Auto-generated method stub
		PostEntity postEntity=postRepository.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post Not Found with id "+postId));
		return modelMapper.map(postEntity,PostDTO.class);
		
	}

	@Override
	public PostDTO updatePost(PostDTO inputPost, Long postId) {
		// TODO Auto-generated method stub
		PostEntity olderPost=postRepository.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post is not available with id: "+postId));
		inputPost.setId(postId);
        modelMapper.map(inputPost, olderPost);
        PostEntity savedPostEntity = postRepository.save(olderPost);
        return modelMapper.map(savedPostEntity, PostDTO.class);
	}

}
