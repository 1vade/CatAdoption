package com.example.catadoption.util;

/*
 * Project Name: Match
 * Package Name: com.cooder.match.util.dimension
 * File Name:    MetricUtil
 * Creator:      ljw
 * Create Time:  2022/3/9 17:56
 * Introduce:    TODO
 */

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

public final class MetricUtil {

	private MetricUtil() {

	}

	public static final class Transition {
		public static int dp2px(Context context, float dp) {
			return (int) Math.ceil(dp * context.getResources().getDisplayMetrics().density);
		}
	}

	public static final class Phone {
		public static int getPhoneWidth(Context context) {
			final WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
			final DisplayMetrics metrics = new DisplayMetrics();
			windowManager.getDefaultDisplay().getMetrics(metrics);
			return metrics.widthPixels;
		}

		public static int getPhoneHeight(Context context) {
			final WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
			final DisplayMetrics metrics = new DisplayMetrics();
			windowManager.getDefaultDisplay().getMetrics(metrics);
			return metrics.heightPixels;
		}

		// 返回值是dp
		public static int getStatusBarHeight(Context context) {
			int height = -1;
			int resId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
			if (resId > 0) {
				height = context.getResources().getDimensionPixelSize(resId);
			}
			return height;
		}
	}
}