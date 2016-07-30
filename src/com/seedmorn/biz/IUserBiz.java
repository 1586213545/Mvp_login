package com.seedmorn.biz;

import com.seedmorn.bean.User;

public interface IUserBiz {
	void login(User user, OnLoginListener onLoginListener);
}
