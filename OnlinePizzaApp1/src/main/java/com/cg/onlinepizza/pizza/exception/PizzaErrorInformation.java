package com.cg.onlinepizza.pizza.exception;

public class PizzaErrorInformation {

	private String url;
	private String msg;
	private String dateTime;
	
	public PizzaErrorInformation(String url, String msg, String dateTime) {
		super();
		this.url = url;
		this.msg = msg;
		this.dateTime = dateTime;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	
	
}
