package com.seedmorn.utility;

import java.lang.ref.WeakReference;

import android.content.Context;
import android.os.Handler;

/**
 * Handler�����ã��ڴ����
 * @author 
 *
 */
public class MyHandler extends Handler {
	WeakReference<Context> mWeakReference;
	public MyHandler(Context context) {
		mWeakReference = new WeakReference<Context>(context);
	}
}
