package com.seedmorn.model.biz;

import com.seedmorn.model.entity.User;

public class UserBiz implements IUserBiz {

	@Override
	public void login(final User user, final OnLoginListener onLoginListener) {
		// TODO Auto-generated method stub

		new Thread(new Runnable() {

			@Override
			public void run() {

				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				// TODO Auto-generated method stub
				if (user.getUsername().equals("hyw")
						&& user.getPassword().equals("123")) {
					onLoginListener.loginSuccess();
				} else {
					onLoginListener.loginFailed();
				}
			}
		}).start();

	}

}
