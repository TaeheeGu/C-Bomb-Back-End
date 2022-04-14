package com.fireprohibition.CBomb.domain;

import java.time.LocalDateTime;

import javax.persistence.MappedSuperclass;

import lombok.Getter;

@MappedSuperclass
@Getter
public abstract class BaseEntity {
	private LocalDateTime createDate;
	private LocalDateTime lastModify;
}
