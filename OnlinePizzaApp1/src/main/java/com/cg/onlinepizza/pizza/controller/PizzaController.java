package com.cg.onlinepizza.pizza.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlinepizza.pizza.entity.Pizza;
import com.cg.onlinepizza.pizza.exception.InvalidMinCostException;
import com.cg.onlinepizza.pizza.exception.PizzaIdNotFoundException;
import com.cg.onlinepizza.pizza.service.PizzaService;

@RestController
public class PizzaController {
	
	@Autowired
	private PizzaService pizzaService;
	
	//http://localhost:4455/PizzaApp/swagger-ui/index.html#/pizza-controller/addUsingPOST
	@GetMapping("/pizzalist")
	public ResponseEntity<List<Pizza>> getAll(){
		return ResponseEntity.ok(pizzaService.viewPizzaList());
	}
	
	@GetMapping("/pizza/{pizzaId}")
	public ResponseEntity<Pizza> getById(@PathVariable("pizzaId") int pizzaId)throws PizzaIdNotFoundException{
		return ResponseEntity.ok(pizzaService.viewPizza(pizzaId));
	}
	
	@GetMapping("/betweencost/{minCost}/{maxCost}")
	public ResponseEntity<List<Pizza>> getByCost(@PathVariable("minCost") double minCost,@PathVariable("maxCost") double maxCost)throws InvalidMinCostException{
		return ResponseEntity.ok(pizzaService.viewPizzaList(minCost,maxCost));
	}
	
	@PostMapping("/pizzaadded")
	public ResponseEntity<Pizza> add(@RequestBody Pizza pizza){
		return ResponseEntity.accepted().body(pizzaService.addPizza(pizza));
	}
	
	@PutMapping("/updatedpizza/{pizzaId}")
	public ResponseEntity<Pizza> update(@RequestBody Pizza pizza,@PathVariable("pizzaId") int pizzaId)throws PizzaIdNotFoundException{
		return ResponseEntity.accepted().body(pizzaService.updatePizza(pizzaId, pizza));
	}
	
	@DeleteMapping("/deletepizza/{pizzaId}")
	public ResponseEntity<Pizza> delete(@PathVariable("pizzaId") int pizzaId)throws PizzaIdNotFoundException{
		return ResponseEntity.ok(pizzaService.deletePizza(pizzaId));
	}
	

}
