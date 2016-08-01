package com.seedmorn.view.in;

import com.seedmorn.model.entity.User;

public interface IUserLoginView {
	public void showDialog();
	public void hideDialog();
	public void showToast(String text);
	public User getUser();
	void clearUser();
	void toMainActivity();
}
