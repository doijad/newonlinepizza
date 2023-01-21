package com.cg.onlinepizza.coupon.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlinepizza.coupon.dao.CouponRepository;
import com.cg.onlinepizza.coupon.entity.Coupon;
import com.cg.onlinepizza.coupon.exception.CouponIdNotFoundException;
import com.cg.onlinepizza.coupon.exception.InvalidCouponOperationException;

@Service
public class CouponService_Impl implements CouponService {
	
	@Autowired
	private CouponRepository cRepo;

	@Override
	@Transactional
	public Coupon addCoupans(Coupon coupon) {
		return cRepo.save(coupon);
	}

	@Override
	@Transactional
	public Coupon editCoupans(Coupon coupon,int couponId) throws InvalidCouponOperationException {
		Optional<Coupon> editCoupon=cRepo.findById(couponId);
		if (editCoupon.isPresent()) {
			return cRepo.save(coupon);
		} else {
			throw new InvalidCouponOperationException("Invalid Coupon");
		}
		
	}

//	@Override
//	@Transactional
//	public Coupon deleteCoupans(int couponId) throws CouponIdNotFoundException {
//		Optional<Coupon> cFind = cRepo.findById(couponId);
//		Coupon c=null;
//		if (cFind.isPresent()) {
//			c = cFind.get();
//			cRepo.delete(c);
//		} else {
//			throw new CouponIdNotFoundException("No coupon with this Id");
//		}
//		return c;
//
//	}
//	
	
	@Override
	@Transactional
	public boolean deleteCoupans(int couponId) throws CouponIdNotFoundException {
		
		Optional<Coupon> cFind = cRepo.findById(couponId);
		
		if (cFind.isPresent()) {
			cRepo.deleteById(couponId);
			return true;
		}
		return false;
	}

	@Override
	public List<Coupon> viewCoupons() {
		return cRepo.findAll();
	}
	


}
