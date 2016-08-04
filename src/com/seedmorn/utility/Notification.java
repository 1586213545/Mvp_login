package com.seedmorn.utility;

import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.seedmorn.w33.R;

/**
 * ��֪ͨ����ʾ֪ͨ
 * @author 
 *
 */
public class Notification {
	private final static String TAG = Notification.class.getSimpleName();
	
	public Notification() {
		super();
	}

	/**
	 * ��֪ͨ����ʾ֪ͨ
	 * @param context ������
	 * @param Ticker  ������ʾ
	 * @param Title   ֪ͨ����
	 * @param message ֪ͨ��Ϣ
	 * @param count   ֪ͨ����
	 * @param id      ֪ͨID
	 * @param cls     ��ת��
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
