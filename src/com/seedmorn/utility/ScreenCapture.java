package com.seedmorn.utility;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Environment;
import android.view.View;
/**
 * 截屏
 * 
 * */
public class ScreenCapture {
	/**
	 *  指定区域截屏
	 * @param Activity activity,int x,int y,int width,int height
	 * @return filePath 文件路径
	 * */
	public static String  getBitmap(Activity activity,int x,int y,int width,int height){
		View view = activity.getWindow().getDecorView();
		view.setDrawingCacheEnabled(true);
		view.buildDrawingCache();
		Bitmap bitmap = view.getDrawingCache();
		bitmap = Bitmap.createBitmap(bitmap, x, y, width, height);
		String filePath = null;
		try {
			// 获取内置SD卡路�?
			   String sdCardPath = Environment.getExternalStorageDirectory().getPath();
			// 图片文件路径
			filePath= sdCardPath +"/Helo"+ "/onscreen"+getCurrentTime()+".jpg";
			
			File file = new File(filePath);
			FileOutputStream os = new FileOutputStream(file);
			bitmap.compress(Bitmap.CompressFormat.JPEG, 100, os);
			os.flush();
			os.close();
		} catch (Exception e) {
		}
		view.setDrawingCacheEnabled(false);
		return filePath;
	}
	/**
	 *获取当前时间
	 * @return
	 */
	private static  String getCurrentTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		return sdf.format(new java.util.Date());
	}
}
