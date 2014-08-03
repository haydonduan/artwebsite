package com.art.style.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.art.style.domain.Style;

public interface StyleRepository extends JpaRepository<Style, Long> , StyleRepositoryCutstom{
	
	@Query("select s from Style s where type=100")
	public Style findColorByType();
}
