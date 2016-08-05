package com.seedmorn.utility;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Environment;

public class FileUtil {
	/**
	 * 将Bitmap类型的图片保存到本地路径，并返回路径
	 * 
	 * @param context
	 * @param mType    资源类型，参照 MultimediaContentType 枚举，根据此类型，保存时可自动归类
	 * @param fileName 文件名称
	 * @param bitmap   图片
	 * @return
	 */
	public static String saveFile(Context context, String fileName, Bitmap bitmap) {
		return saveFile(context, null, fileName, bitmap);
	}

	public static String saveFile(Context context, String filePath, String fileName, Bitmap bitmap) {
		byte[] bytes = bitmapToBytes(bitmap);
		return saveFile(context, filePath, fileName, bytes);
	}

	private static byte[] bitmapToBytes(Bitmap bm) {
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		bm.compress(CompressFormat.PNG, 100, output);
		byte[] result = output.toByteArray();// 转换成功
		try {
			output.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static String saveFile(Context context, String filePath, String fileName, byte[] bytes) {
		String fileFullName = "";
		FileOutputStream fos = null;
		String dateFolder = new SimpleDateFormat("yyyyMMdd", Locale.CHINA).format(new Date());
		try {
			String suffix = ".PNG";
			if (filePath == null || filePath.trim().length() == 0) {
				filePath = Environment.getExternalStorageDirectory() + "/Android/data/" + context.getPackageName() + "/cache/" + dateFolder + "/";
			}
			File file = new File(filePath);
			if (!file.exists()) {
				file.mkdirs();
			}
			File fullFile = new File(filePath, fileName + suffix);
			fileFullName = fullFile.getPath();
			fos = new FileOutputStream(new File(filePath, fileName + suffix));
			fos.write(bytes);
		} catch (Exception e) {
			fileFullName = "";
		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					fileFullName = "";
					return null;
				}
			}
		}
		return fileFullName;
	}

	/**
	 * 读取文本数据
	 * 
	 * @param context  程序上下文
	 * @param fileName 文件名
	 * @return String  读取到的文本内容，失败返回null
	 */
	public static String readAssets(Context context, String fileName) {
		InputStream is = null;
		String content = null;
		try {
			is = context.getAssets().open(fileName);
			if (is != null) {
				byte[] buffer = new byte[1024];
				ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
				while (true) {
					int readLength = is.read(buffer);
					if (readLength == -1)
						break;
					arrayOutputStream.write(buffer, 0, readLength);
				}
				is.close();
				arrayOutputStream.close();
				content = new String(arrayOutputStream.toByteArray());

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			content = null;
		} finally {
			try {
				if (is != null)
					is.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
		return content;
	}
}
