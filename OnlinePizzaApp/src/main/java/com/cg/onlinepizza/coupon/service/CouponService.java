package com.cg.onlinepizza.coupon.service;

import java.util.List;

import com.cg.onlinepizza.coupon.entity.Coupon;
import com.cg.onlinepizza.coupon.exception.CouponIdNotFoundException;
import com.cg.onlinepizza.coupon.exception.InvalidCouponOperationException;

public interface CouponService {
	
	Coupon addCoupans(Coupon coupon);

	Coupon editCoupans(Coupon coupon,int couponId) throws InvalidCouponOperationException;

	boolean deleteCoupans(int couponId) throws CouponIdNotFoundException;

	List<Coupon> viewCoupons();
}
