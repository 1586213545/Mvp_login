package com.seedmorn.model.biz;

import com.seedmorn.model.entity.User;

public class UserBiz implements IUserBiz {

	public void login(final User user, final OnLoginListener onLoginListener) {

		new Thread(new Runnable() {
			public void run() {

				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				if (user.getUsername().equals("hyw") && user.getPassword().equals("123")) {
					onLoginListener.loginSuccess();
				} else {
					onLoginListener.loginFailed();
				}
			}
		}).start();

	}

}
