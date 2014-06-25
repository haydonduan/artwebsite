package com.art.style.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.art.style.domain.Style;

public interface StyleRepository extends JpaRepository<Style, Long> , StyleRepositoryCutstom{
	
}
