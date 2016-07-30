package com.seedmorn.activity;

import com.seedmorn.bean.User;

public interface IUserLoginView {
	public void showDialog();
	public void hideDialog();
	public void showToast(String text);
	public User getUser();
	void clearUser();
	void toMainActivity();
}
