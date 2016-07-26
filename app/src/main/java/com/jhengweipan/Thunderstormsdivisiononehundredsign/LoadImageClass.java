package com.jhengweipan.Thunderstormsdivisiononehundredsign;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class LoadImageClass {

	public static void loadImage(final String path,
			final ImageView imageView,final Context context){

		new Thread(){

			@Override
			public void run() {

				try {
					URL imageUrl = new URL(path);
					HttpURLConnection httpCon = 
							(HttpURLConnection) imageUrl.openConnection();
					InputStream imageStr =  httpCon.getInputStream();
					final Bitmap bitmap =  BitmapFactory.decodeStream(imageStr);

					((Activity)context).runOnUiThread(new Runnable() {

						@Override
						public void run() {
							// TODO Auto-generated method stub
							imageView.setImageBitmap(bitmap);
						}
					});


				} catch (MalformedURLException e) {
				
				} catch (IOException e) {
					// TODO Auto-generated catch block
				
				}



			}

		
		}.start();
		}
}