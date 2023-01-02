package com.example.response;

public class DeleteResponse {
	private boolean success;
	private int id;

	public DeleteResponse(int id) {
		this.id = id;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}
}
