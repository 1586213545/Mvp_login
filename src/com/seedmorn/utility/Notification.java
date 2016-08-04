package com.seedmorn.utility;

import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.seedmorn.w33.R;

/**
 * 在通知栏显示通知
 * @author 
 *
 */
public class Notification {
	private final static String TAG = Notification.class.getSimpleName();
	
	public Notification() {
		super();
	}

	/**
	 * 在通知栏显示通知
	 * @param context 上下文
	 * @param Ticker  推送提示
	 * @param Title   通知标题
	 * @param message 通知信息
	 * @param count   通知个数
	 * @param id      通知ID
	 * @param cls     跳转类
	 */
	public static void notification(Context context, String Ticker, String Title, String message, int count, int id,  Class<Activity> cls) {
		Log.i(TAG, "Received a Notification  Received a Notification   Received a Notification   Received a Notification");
		NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
		PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, new Intent(context, cls), Intent.FLAG_ACTIVITY_NEW_TASK );
		android.app.Notification notify = new android.app.Notification.Builder(context)
				.setSmallIcon(R.drawable.ic_launcher)
				.setTicker(Ticker)
				.setContentTitle(Title)
				.setContentText(message)
				.setContentIntent(pendingIntent)
				.setNumber(count)
				.build();
		notify.icon = R.drawable.ic_launcher;
		notify.flags |= android.app.Notification.FLAG_AUTO_CANCEL;
		manager.notify(id, notify);
	}
}
