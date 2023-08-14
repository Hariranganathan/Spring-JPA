package com.jdbc.demo.responce;

public class Response {

	private int responseCode;

	private String responsemsg;

	private Object jData;

	private String data;

	public int getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}

	public String getResponsemsg() {
		return responsemsg;
	}

	public void setResponsemsg(String responsemsg) {
		this.responsemsg = responsemsg;
	}

	public Object getjData() {
		return jData;
	}

	public void setjData(Object jData) {
		this.jData = jData;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

}
