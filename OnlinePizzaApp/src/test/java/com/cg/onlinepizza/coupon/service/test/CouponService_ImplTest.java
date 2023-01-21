package com.cg.onlinepizza.coupon.service.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cg.onlinepizza.coupon.dao.CouponRepository;
import com.cg.onlinepizza.coupon.entity.Coupon;
import com.cg.onlinepizza.coupon.exception.CouponIdNotFoundException;
import com.cg.onlinepizza.coupon.exception.InvalidCouponOperationException;
import com.cg.onlinepizza.coupon.service.CouponService_Impl;

@ExtendWith(MockitoExtension.class)
public class CouponService_ImplTest {

	@Mock
	private CouponRepository repo;

	@InjectMocks
	private CouponService_Impl service;

	private List<Coupon> list;
	private Coupon cp=null;
	
	public CouponService_ImplTest() {
		service = new CouponService_Impl();
		list = new ArrayList<>();
	}
	@BeforeEach
	private void initEach() {
		cp=new Coupon();
		cp.setCouponId(cp.getCouponId());
		cp.setCouponName(cp.getCouponName());
		cp.setCouponType(cp.getCouponType());
		cp.setCouponDesciption(cp.getCouponDesciption());
		cp.setCouponPizzaId(cp.getCouponPizzaId());
		
		list.add(cp);
	}

	@Test
	void addCouponTest() {
		Mockito.when(service.addCoupans(cp)).thenReturn(cp);
		assertEquals(service.addCoupans(cp), cp);
		verify(repo, Mockito.times(1)).save(cp);
	}

	@Test
	void viewCouponsTest() {
		Mockito.when(service.viewCoupons()).thenReturn(list);
		assertEquals(service.viewCoupons(), list);
	}

	@Test
	void editCouponTest() throws InvalidCouponOperationException {
		try {
			Mockito.when(service.editCoupans(cp, cp.getCouponId())).thenReturn(cp);
			assertEquals(service.editCoupans(cp, cp.getCouponId()), cp);
		} catch (InvalidCouponOperationException e) {
			e.printStackTrace();
			System.out.println("Invalid Coupon operation, Couldn't edit coupon ");
		}

}
	
	@Test
	void deleteCouponTest() {
		boolean isDelete;
		try {
			isDelete =service.deleteCoupans(cp.getCouponId());
			assertFalse(isDelete);
		} catch (CouponIdNotFoundException e) {
			e.printStackTrace();
			System.out.println("Can't able to delete Coupon");
		}

	}
}
