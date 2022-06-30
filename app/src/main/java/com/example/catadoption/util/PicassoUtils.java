package com.example.catadoption.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;



public final class PicassoUtils {

	private PicassoUtils() {

	}

	// 默认加载图片
	public static void loadImageView(String url, ImageView imageView) {
		Picasso.get().load(url).into(imageView);
	}

	// 默认加载图片能 指定大小
	public static void loadImageViewSize(ImageView imageView, String url, int width, int height) {
		Picasso.get().load(url).resize(width, height).centerCrop().into(imageView);
	}

	// 加载图片有 默认图片
	public static void loadImageViewHolder(String url, int loading, int errorImg, ImageView imageView) {
		Picasso.get().load(url).placeholder(loading).error(errorImg).into(imageView);
	}

	// 裁剪图片
	public static void loadImageViewCrop(String url, ImageView imageView) {
		Picasso.get().load(url).transform(new CropSquareTransformation()).into(imageView);
	}

	// 圆角图片
	public static void loadRoundImageView(String url, ImageView imageView, int radius) {
		Picasso.get().load(url).transform(new RoundTransform(radius)).into(imageView);
	}

	public static void loadRoundImageViewSize(ImageView imageView, String url, int width, int height, int radius) {
		Picasso.get().load(url).transform(new RoundTransform(radius)).resize(width, height).into(imageView);
	}

	public static void loadLocalRoundImageViewSize(Context context, int resourceId, ImageView imageView, int widthDp, int heightDp, int radiusDp) {
		int width = MetricUtil.Transition.dp2px(context, widthDp);
		int height = MetricUtil.Transition.dp2px(context, heightDp);
		int radius = MetricUtil.Transition.dp2px(context, radiusDp);
		Picasso.get().load(resourceId).transform(new RoundTransform(radius)).resize(width, height).into(imageView);
	}

	// 裁剪图片
	private static class CropSquareTransformation implements Transformation {
		
		@Override
		public Bitmap transform(Bitmap source) {
			int size = Math.min(source.getWidth(), source.getHeight());
			int x = (source.getWidth() - size) / 2;
			int y = (source.getHeight() - size) / 2;
			Bitmap result = Bitmap.createBitmap(source, x, y, size, size);
			if (result != source) {
				// 回收
				source.recycle();
			}
			return result;
		}
		
		@Override
		public String key() {
			return "square_picture";
		}
	}

	private static class RoundTransform implements Transformation {
		private final int radius;

		public RoundTransform(int radius) {
			this.radius = radius;
		}

		@Override
		public Bitmap transform(Bitmap source) {

			int widthLight = source.getWidth();
			int heightLight = source.getHeight();

			Bitmap output = Bitmap.createBitmap(source.getWidth(), source.getHeight(), Bitmap.Config.ARGB_8888);
			
			Canvas canvas = new Canvas(output);
			Paint paintColor = new Paint();
			paintColor.setFlags(Paint.ANTI_ALIAS_FLAG);
			
			RectF rectF = new RectF(new Rect(0, 0, widthLight, heightLight));
			
			canvas.drawRoundRect(rectF, radius, radius, paintColor);
			
			Paint paintImage = new Paint();
			paintImage.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP));
			canvas.drawBitmap(source, 0, 0, paintImage);
			source.recycle();
			
			return output;
		}
		
		@Override
		public String key() {
			return "round_picture";
		}
	}
}
