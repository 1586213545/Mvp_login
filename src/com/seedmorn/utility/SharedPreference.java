package com.seedmorn.utility;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Base64;
import android.widget.ImageView;

/**
 * SharedPreference¥Ê»°∏®÷˙¿‡
 * @author 
 *
 */
public class SharedPreference {
	public static final String PREF_NAME = SharedPreference.class.getSimpleName();
	public static SharedPreferences sp;

	public static boolean getBoolean(Context context, String key, boolean defaultValue) {
		sp = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
		return sp.getBoolean(key, defaultValue);
	}

	public static void setBoolean(Context context, String key, boolean value) {
		sp = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
		sp.edit().putBoolean(key, value).commit();
	}

	public static String getString(Context context, String key, String defaultValue) {
		if(context != null){
			sp = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
		}else{
		}
		return sp.getString(key, defaultValue);
	}

	public static void setString(Context context, String key, String value) {
		sp = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
		sp.edit().putString(key, value).commit();
	}
	
	
	
	public static void removeAllSp(Context context) {
		sp = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
		sp.edit().clear().commit();
	}
}
