package com.cg.onlinepizza.pizza.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlinepizza.pizza.dao.PizzaRepo;
import com.cg.onlinepizza.pizza.entity.Pizza;
import com.cg.onlinepizza.pizza.exception.InvalidMinCostException;
import com.cg.onlinepizza.pizza.exception.PizzaIdNotFoundException;

@Service
public class PizzaServiceImpl implements PizzaService{

	@Autowired
	private PizzaRepo pizzaRepo;
	
	@Override
	@Transactional
	public Pizza addPizza(Pizza pizza) {
		return pizzaRepo.save(pizza);
	}

	@Override
	public Pizza updatePizza(int pizzaId,Pizza pizza) throws PizzaIdNotFoundException{
		
		Pizza findPizza = viewPizza(pizzaId);
		findPizza.setPizzaName(pizza.getPizzaName());
		findPizza.setPizzaType(pizza.getPizzaType());
		findPizza.setPizzaDescription(pizza.getPizzaDescription());
		findPizza.setPizzaCost(pizza.getPizzaCost());
		findPizza.setPizzaCostAfterCoupan(pizza.getPizzaCostAfterCoupan());
		
		return pizzaRepo.save(findPizza);
	}

	@Override
	public Pizza deletePizza(int pizzaId) throws PizzaIdNotFoundException {
		Optional<Pizza> deletePizza=pizzaRepo.findById(pizzaId);
		Pizza dPizza = null;
		if(deletePizza.isPresent()) {
			dPizza = deletePizza.get();
			pizzaRepo.delete(dPizza);
		}
		else {
			throw new PizzaIdNotFoundException("Pizza Not Found with id "+pizzaId);
		}
		return dPizza;
	}

	@Override
	public Pizza viewPizza(int pizzaId) throws PizzaIdNotFoundException {
		
		Optional<Pizza> pizza=pizzaRepo.findById(pizzaId);
		if(pizza.isPresent())
			return pizza.get();
		else
			throw new PizzaIdNotFoundException("Pizza Not Found with id "+pizzaId);
	}

	@Override
	public List<Pizza> viewPizzaList() {
		
		return pizzaRepo.findAll();
	}

	@Override
	public List<Pizza> viewPizzaList(double minCost, double maxCost) throws InvalidMinCostException {
		if(minCost<0)
			throw new InvalidMinCostException("Invalid cost");
		return pizzaRepo.viewPizzaList(minCost, maxCost);
	}

}
