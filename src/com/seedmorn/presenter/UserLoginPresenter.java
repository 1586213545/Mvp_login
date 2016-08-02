package com.seedmorn.presenter;

import android.os.Handler;

import com.seedmorn.model.biz.IUserBiz;
import com.seedmorn.model.biz.OnLoginListener;
import com.seedmorn.model.biz.UserBiz;
import com.seedmorn.view.in.IUserLoginView;

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

		OnLoginListener loginListener = new OnLoginListener() {

			public void loginSuccess() {
				mHandler.post(new Runnable() {
					public void run() {
						iUserLoginView.hideDialog();
						iUserLoginView.showToast("success");
						iUserLoginView.toMainActivity();
					}
				});
			}

			public void loginFailed() {
				mHandler.post(new Runnable() {
					public void run() {
						iUserLoginView.showToast("failed");
						iUserLoginView.hideDialog();
					}
				});

			}
		};
		
		iUserBiz.login(iUserLoginView.getUser(), loginListener);
	}

	public void clear() {
		iUserLoginView.clearUser();
	}

}
