package com.cg.onlinepizza.coupon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlinepizza.coupon.entity.Coupon;
import com.cg.onlinepizza.coupon.exception.CouponIdNotFoundException;
import com.cg.onlinepizza.coupon.exception.InvalidCouponOperationException;
import com.cg.onlinepizza.coupon.service.CouponService;

@RestController
public class CouponController {

	@Autowired
	private CouponService cService;

	@PostMapping(path = "/new")
	public ResponseEntity<Coupon> addCoupons(@RequestBody Coupon c1) {
		try {
			Coupon c = cService.addCoupans(c1);
			return new ResponseEntity<>(c, HttpStatus.CREATED);
		} catch (Exception ex) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

		}

	}

	@PutMapping("/edit/{id}")
	public ResponseEntity<Coupon> editCoupon(@PathVariable("id") int id, @RequestBody Coupon coupon) {
		try {

			return new ResponseEntity<>(cService.editCoupans(coupon, id), HttpStatus.ACCEPTED);

		} catch (InvalidCouponOperationException e) {

			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Coupon> deleteCoupon(@PathVariable("id") int id) {
		try {
			return new ResponseEntity(cService.deleteCoupans(id), HttpStatus.OK);
		} catch (CouponIdNotFoundException e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(path = "/coupon")
	public ResponseEntity<List<Coupon>> viewCoupons() {
		try {
			List<Coupon> cList = cService.viewCoupons();
			if (cList.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			} else {
				return new ResponseEntity<>(cList, HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
