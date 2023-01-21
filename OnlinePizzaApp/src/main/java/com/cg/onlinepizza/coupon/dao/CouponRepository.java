package com.cg.onlinepizza.coupon.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.onlinepizza.coupon.entity.Coupon;

@Repository
public interface CouponRepository  extends JpaRepository<Coupon, Integer>{

	@Query("Select c from Coupon c where c.couponId=:couponId")
	public Coupon deleteCoupon(@Param("couponId") int couponId);
	
}
