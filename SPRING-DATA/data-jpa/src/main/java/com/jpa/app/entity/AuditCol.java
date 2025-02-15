package com.jpa.app.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data @Embeddable
public class AuditCol {

	@Column
	private Integer createdBy;
	@Column @CreationTimestamp
	private LocalDateTime createdDate;
	@Column
	private Integer updatedBy;
	@Column @UpdateTimestamp
	private LocalDateTime updatedDate;
	
}
