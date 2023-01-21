package com.cg.onlinepizza.pizza.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PizzaDTO {

	private int pizzaId;

	@NotEmpty
	private String pizzaType;

	@NotNull
	@Size(min = 5, message = "Pizza Name Must Be Correct")
	private String pizzaName;

	private String pizzaDescription;

	@NotEmpty
	private double pizzaCost;

	@NotEmpty
	private double pizzaCostAfterCoupan;

	public PizzaDTO() {
	}

	public PizzaDTO(int pizzaId, String pizzaType,String pizzaName, String pizzaDescription, double pizzaCost,
			double pizzaCostAfterCoupan) {
		super();
		this.pizzaId = pizzaId;
		this.pizzaType = pizzaType;
		this.pizzaName = pizzaName;
		this.pizzaDescription = pizzaDescription;
		this.pizzaCost = pizzaCost;
		this.pizzaCostAfterCoupan = pizzaCostAfterCoupan;
	}

	public int getPizzaId() {
		return pizzaId;
	}

	public void setPizzaId(int pizzaId) {
		this.pizzaId = pizzaId;
	}

	public String getPizzaType() {
		return pizzaType;
	}

	public void setPizzaType(String pizzaType) {
		this.pizzaType = pizzaType;
	}

	public String getPizzaName() {
		return pizzaName;
	}

	public void setPizzaName(String pizzaName) {
		this.pizzaName = pizzaName;
	}

	public String getPizzaDescription() {
		return pizzaDescription;
	}

	public void setPizzaDescription(String pizzaDescription) {
		this.pizzaDescription = pizzaDescription;
	}

	public double getPizzaCost() {
		return pizzaCost;
	}

	public void setPizzaCost(double pizzaCost) {
		this.pizzaCost = pizzaCost;
	}

	public double getPizzaCostAfterCoupan() {
		return pizzaCostAfterCoupan;
	}

	public void setPizzaCostAfterCoupan(double pizzaCostAfterCoupan) {
		this.pizzaCostAfterCoupan = pizzaCostAfterCoupan;
	}

}
