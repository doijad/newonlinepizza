package com.cg.onlinepizza.pizza.service;

import java.util.List;

import com.cg.onlinepizza.pizza.entity.Pizza;
import com.cg.onlinepizza.pizza.exception.InvalidMinCostException;
import com.cg.onlinepizza.pizza.exception.PizzaIdNotFoundException;


public interface PizzaService {

	public Pizza addPizza(Pizza pizza);

	public Pizza updatePizza(int pizzaId,Pizza pizza)throws PizzaIdNotFoundException;

	public Pizza deletePizza(int pizzaId) throws PizzaIdNotFoundException;

	public Pizza viewPizza(int pizzaId) throws PizzaIdNotFoundException;

	public List<Pizza> viewPizzaList();

	public List<Pizza> viewPizzaList(double minCost, double maxCost)throws InvalidMinCostException;
}
