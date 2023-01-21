package com.cg.onlinepizza.pizza.servicetest;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cg.onlinepizza.pizza.dao.PizzaRepo;
import com.cg.onlinepizza.pizza.entity.Pizza;
import com.cg.onlinepizza.pizza.exception.PizzaIdNotFoundException;
import com.cg.onlinepizza.pizza.service.PizzaServiceImpl;

@ExtendWith(MockitoExtension.class)
public class PizzaServiceTest {

	@Mock
	private PizzaRepo pizzaRepo;

	@InjectMocks
	private PizzaServiceImpl pizzaService;

	private Pizza pizza;

	private List<Pizza> pizzas;

	@BeforeEach
	void setUp() throws Exception {

		pizza = new Pizza();
		pizza.setPizzaId(pizza.getPizzaId());
		pizza.setPizzaType(pizza.getPizzaType());
		pizza.setPizzaName(pizza.getPizzaName());
		pizza.setPizzaDescription(pizza.getPizzaDescription());
		pizza.setPizzaCost(pizza.getPizzaCost());
		pizza.setPizzaCostAfterCoupan(pizza.getPizzaCost());

		pizzas = new ArrayList<>();
		pizzas.add(pizza);
	}

	@Test
	void testAddPizza() {
		when(pizzaService.addPizza(pizza)).thenReturn(pizza);
		assertEquals(pizza,pizzaService.addPizza(pizza));
	}

	@Test
	void testViewPizzaList() {
		when(pizzaService.viewPizzaList()).thenReturn(pizzas);
		assertEquals(pizzas,pizzaService.viewPizzaList());
	}

	@Test
	void testViewPizza() {
		try {
			when(pizzaRepo.findById(pizza.getPizzaId())).thenReturn(Optional.of(pizza)).then(i -> pizzaService.viewPizza(pizza.getPizzaId()));
			assertEquals(pizza, pizzaService.viewPizza(pizza.getPizzaId()));
		} catch (PizzaIdNotFoundException e) {
			fail("Exception not expected");
		}
	}

	@Test
	void testupdatePizza() {
		pizza.setPizzaName("panner");
		pizza.setPizzaType("big");
		try {
			when(pizzaRepo.findById(pizza.getPizzaId())).thenReturn(Optional.of(pizza));
			when(pizzaService.updatePizza(pizza.getPizzaId(), pizza)).thenReturn(pizza);
			assertEquals(pizza, pizzaService.updatePizza(pizza.getPizzaId(), pizza));
		} catch (PizzaIdNotFoundException e) {
			e.printStackTrace();
			fail("Exception not expected");
		}
	}

	@Test
	void testDeletePizza() {
		try {
			pizzas.remove(0);
			Mockito.when(pizzaRepo.findById(pizza.getPizzaId())).thenReturn(Optional.of(pizza)).thenAnswer(i -> pizzaService.deletePizza(pizza.getPizzaId()));
			assertEquals(pizza, pizzaService.deletePizza(pizza.getPizzaId()));
			assertEquals(pizzas, pizzaService.viewPizzaList());
	} 
			catch (PizzaIdNotFoundException  ex) {
			ex.getMessage();
			fail("caused exception");
		}
}
	
}
