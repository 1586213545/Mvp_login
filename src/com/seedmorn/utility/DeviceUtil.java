package com.seedmorn.utility;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

public class DeviceUtil {
	public static String getDeviceID(Context context) {
		String result = "";

		TelephonyManager TelephonyMgr = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
		try {
			result = TelephonyMgr.getDeviceId();
		} catch (Exception e) {

		}
		return result;

	}

	public static String getMacAddress(Context context) {
		String result = "";
		if (TextUtils.isEmpty(result)) {
			WifiManager wm = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
			result = wm.getConnectionInfo().getMacAddress();
		}
		return result;

	}

	public static String getBluetoothAddress(Context context) {
		String result = "";
		if (TextUtils.isEmpty(result)) {
			BluetoothAdapter m_BluetoothAdapter = null; // Local Bluetooth
														// adapter
			m_BluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
			result = m_BluetoothAdapter.getAddress();
		}

		return result;

	}
}
