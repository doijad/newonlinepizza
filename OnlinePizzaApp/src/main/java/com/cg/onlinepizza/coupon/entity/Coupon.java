package com.cg.onlinepizza.coupon.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "coupon_table")
public class Coupon {

	@Id
	private int couponId;
	private String couponName;
	private String couponType;
	private String couponDesciption;
	private int couponPizzaId;

	public Coupon() {
	}

	public Coupon(int couponId, String couponName, String couponType, String couponDesciption, int couponPizzaId) {
		super();
		this.couponId = couponId;
		this.couponName = couponName;
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

	public String getCouponName() {
		return couponName;
	}

	public void setCouponName(String couponName) {
		this.couponName = couponName;
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

	@Override
	public String toString() {
		return "Coupon [couponId=" + couponId + ", couponName=" + couponName + ", couponType=" + couponType
				+ ", couponDesciption=" + couponDesciption + ", couponPizzaId=" + couponPizzaId + "]";
	}

}
