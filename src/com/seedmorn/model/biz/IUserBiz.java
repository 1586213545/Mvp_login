package com.seedmorn.model.biz;

import com.seedmorn.model.entity.User;

public interface IUserBiz {
	void login(User user, OnLoginListener onLoginListener);
}
