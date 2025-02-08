package com.codingshuttle.vinay.prod_ready_features.prod_ready_features.entities;

import java.time.LocalDateTime;

import org.hibernate.envers.Audited;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.codingshuttle.vinay.prod_ready_features.prod_ready_features.DTO.PostDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreRemove;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "posts")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Audited
public class PostEntity extends AuditableEntity{
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;


private String title;
private String description;
@PrePersist
void beforeSave() {

}

@PreUpdate
void beforeUpdate() {

}

@PreRemove
void beforeDelete() {

}



}
