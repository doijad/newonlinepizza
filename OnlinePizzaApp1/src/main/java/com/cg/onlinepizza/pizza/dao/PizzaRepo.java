package com.cg.onlinepizza.pizza.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.onlinepizza.pizza.entity.Pizza;
import com.cg.onlinepizza.pizza.exception.InvalidMinCostException;

@Repository
public interface PizzaRepo extends JpaRepository<Pizza, Integer>{

	@Query("Select p from Pizza p where p.pizzaCost between :minCost and :maxCost")
	public List<Pizza> viewPizzaList(@Param("minCost")double minCost, @Param("maxCost")double maxCost);
}
