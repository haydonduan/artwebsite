package com.art.production.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.art.production.domain.Production;

public interface ProductionRepository extends JpaRepository<Production, Long> , ProductionRepositoryCutstom{
	
}
