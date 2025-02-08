package com.codingshuttle.vinay.prod_ready_features.prod_ready_features.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codingshuttle.vinay.prod_ready_features.prod_ready_features.entities.PostEntity;

@Repository
public interface PostRepository extends JpaRepository<PostEntity,Long> {

}
