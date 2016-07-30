package com.seedmorn.presenter;

import android.os.Handler;

import com.seedmorn.activity.IUserLoginView;
import com.seedmorn.biz.IUserBiz;
import com.seedmorn.biz.OnLoginListener;
import com.seedmorn.biz.UserBiz;

public class UserLoginPresenter {

	private IUserLoginView iUserLoginView;
	private IUserBiz iUserBiz;
	private Handler mHandler = new Handler();

	public UserLoginPresenter(IUserLoginView iUserLoginView) {
		this.iUserLoginView = iUserLoginView;
		iUserBiz = new UserBiz();

	}

	public void preLogin() {
		iUserLoginView.showDialog();
		iUserBiz.login(iUserLoginView.getUser(), new OnLoginListener() {

			@Override
			public void loginSuccess() {

				mHandler.post(new Runnable() {
					@Override
					public void run() {
						iUserLoginView.hideDialog();
						iUserLoginView.showToast("success");
						iUserLoginView.toMainActivity();
					}
				});
			}

			@Override
			public void loginFailed() {
				// TODO Auto-generated method stub
				mHandler.post(new Runnable() {
					@Override
					public void run() {
						iUserLoginView.showToast("failed");
						iUserLoginView.hideDialog();
					}
				});

			}
		});
	}

	public void clear() {
		iUserLoginView.clearUser();
	}

}
