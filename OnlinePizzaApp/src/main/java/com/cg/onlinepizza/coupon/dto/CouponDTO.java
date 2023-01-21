package com.cg.onlinepizza.coupon.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CouponDTO {

	@NotEmpty
	private int couponId;
	@NotNull
	private String couponNam;
	private String couponType;
	private String couponDesciption;

	@NotEmpty
	private int couponPizzaId;

	public CouponDTO(@NotNull int couponId, @NotNull String couponNam, String couponType, String couponDesciption,
			@NotEmpty int couponPizzaId) {
		super();
		this.couponId = couponId;
		this.couponNam = couponNam;
		this.couponType = couponType;
		this.couponDesciption = couponDesciption;
		this.couponPizzaId = couponPizzaId;
	}

	public int getCouponId() {
		return couponId;
	}

	public void setCouponId(int couponId) {
		this.couponId = couponId;
	}

	public String getCouponNam() {
		return couponNam;
	}

	public void setCouponNam(String couponNam) {
		this.couponNam = couponNam;
	}

	public String getCouponType() {
		return couponType;
	}

	public void setCouponType(String couponType) {
		this.couponType = couponType;
	}

	public String getCouponDesciption() {
		return couponDesciption;
	}

	public void setCouponDesciption(String couponDesciption) {
		this.couponDesciption = couponDesciption;
	}

	public int getCouponPizzaId() {
		return couponPizzaId;
	}

	public void setCouponPizzaId(int couponPizzaId) {
		this.couponPizzaId = couponPizzaId;
	}



}
