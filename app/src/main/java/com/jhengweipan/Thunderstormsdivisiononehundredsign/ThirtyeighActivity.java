package com.jhengweipan.Thunderstormsdivisiononehundredsign;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v4.app.NavUtils;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.jhengweipan.Guandisignonehundred.R;

import java.util.Locale;

import myAppKey.mykey;

public class ThirtyeighActivity extends Activity {
	private float speechRate;
	private TextToSpeech ts;
	private InterstitialAd interstitial;
	private String photoStr, speakString, str1, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13;

	private void shareTo(String subject, String body, String chooserTitle) {

		Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
		sharingIntent.setType("text/plain");
		sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, subject);
		sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, body);//分享這款app 網址

		startActivity(Intent.createChooser(sharingIntent, chooserTitle));
	}


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_twotwo);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		initlayout();
		showString();

		ImageView imageview = (ImageView) findViewById(R.id.showphoto);


		ConnectivityManager conManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);//先取得此service

		NetworkInfo networInfo = conManager.getActiveNetworkInfo();       //在取得相關資訊

		if (networInfo == null || !networInfo.isAvailable()) { //判斷是否有網路
			imageview.setVisibility(View.GONE);
		} else {
			imageview.setVisibility(View.VISIBLE);
			LoadImageClass.loadImage(photoStr,
					imageview, this);

		}
		AdView mAdView = (AdView) findViewById(R.id.adView);
		AdRequest adRequest = new AdRequest.Builder().build();
		mAdView.loadAd(adRequest);
		interstitial = new InterstitialAd(this);
		interstitial.setAdUnitId(mykey.ad);


		// Begin loading your interstitial.
		interstitial.loadAd(adRequest);
	}


	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			interstitial.show();
			this.finish();


			return true;
		}

		return super.onKeyDown(keyCode, event);
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.meun, menu);
		return super.onCreateOptionsMenu(menu);
	}

	private void initlayout() {
		TextView text1 = (TextView) findViewById(R.id.textView1);
		TextView text2 = (TextView) findViewById(R.id.textView2);
//		TextView text3 = (TextView)findViewById(R.id.textView3);
		TextView text4 = (TextView) findViewById(R.id.textView4);
		TextView text5 = (TextView) findViewById(R.id.textView5);
		TextView text6 = (TextView) findViewById(R.id.textView6);
		TextView text7 = (TextView) findViewById(R.id.textView7);
		TextView text8 = (TextView) findViewById(R.id.textView8);
		TextView text9 = (TextView) findViewById(R.id.textView9);
		text1.setText("第三八籤");
		text2.setText("【 下下。丁辛】");
		text4.setText("蛩吟唧唧守孤幃");
		text5.setText("千里懸懸望信歸");
		text6.setText("等得榮華公子到");
		text7.setText("秋冬括括雨靡靡");
		text8.setText("(一)孟姜女思夫");
		text9.setText("");


	}

	private void showString() {
		speakString = "蛩吟唧唧守孤幃千里懸懸望信歸等得榮華公子到秋冬括括雨靡靡"; //郎誦文字
		photoStr = "http://www.chance.org.tw/%E7%B1%A4%E8%A9%A9%E9%9B%86/%E9%9B%B7%E9%9B%A8%E5%B8%AB%E4%B8%80%E7%99%BE%E7%B1%A4/%E9%9B%B7%E9%9B%A8%E5%B8%AB%E3%84%A7%E7%99%BE%E7%B1%A4%E6%8E%83%E6%8F%8F%E6%AA%94/%E9%9B%B7%E9%9B%A8%E5%B8%AB%E3%84%A7%E7%99%BE%E7%B1%A4%20-%20038%E7%B1%A4.jpg";//圖

		str1 = "";//聖意
		str2 = "莫問財。休鬥訟。行未回。病亦重。婚無成。多怪夢。且禱神。勿妄動。";//聖意一
		str3 = "莫問財。休鬥訟。遠未回。病且重。婚無成。多怪夢。且禱神。勿妄動。";//聖意二
		str4 = "作事無聊。空自惆悵。蹤得好音。依然悽愴。 謀望不遂。心神徒喪。家道未安。禱神陰相。";//東坡解
		str5 = "";//東坡解一
		str6 = "";//東坡解二
		str7 = "不宜問事不宜行。九日常憂十日驚。 一段榮華如一夢。翻來覆去總無情。";//碧仙註
		str8 = "";//碧仙註一
		str9 = ""; //碧仙註二
		str10 = "此籤主有死亡之憂。哭泣之哀。訟休問。病有險。財莫求。婚難成。行人不至。謀事凶多吉少。秋冬占之大不吉。縱有虛喜。終是大憂。";//解曰
		str11 = "計出無聊。獨守孤幃。又聞秋聲唧唧。能不惆悵耶。千里懸懸者。目下謀為不遂。榮華公子到者。亦是虛名而無實事。雨靡靡者。言是非喪服之累。喜末完。憂纏之。占者大抵不吉。秋冬尤宜謹之。秋冬括括或作秋風括地。";//釋義
		str12 = "占功名必得。但恐憂繼之。然所應又有不同。有一生占此。入學抵家。遭妻之喪。又一生占此。中式。旋時則值淫雨連綿。";//占驗
		str13 = "(一)孟姜女思夫\n孟姜女。秦始皇時人。夫范杞郎。派作長城。久役不歸。故思之。";//故事
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		switch (id) {
			case android.R.id.home:
				NavUtils.navigateUpFromSameTask(this);
				return true;

			case R.id.action_read:
				ts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {

					@Override
					public void onInit(int status) {
						if (status == TextToSpeech.SUCCESS) {
							Toast.makeText(getApplicationContext(), "語音設備設定完成", Toast.LENGTH_SHORT).show();
						} else {
						}
						//設定語音速度
						speechRate = 0.3f;
						ts.setSpeechRate(speechRate);
						//設置播放內容

						String str = speakString;
						//設定播放內容語系
						ts.setLanguage(Locale.CHINESE);
						Toast.makeText(getApplicationContext(), "開始朗誦", Toast.LENGTH_SHORT).show();
						ts.speak(str, TextToSpeech.QUEUE_ADD, null);
					}
				});

				break;
			case R.id.action_share:
				shareTo("", mykey.myShareString, "Share to");

				break;
			case R.id.action_settings:
				break;
		}


		switch (item.getItemId()) {
			case R.id.item0:
				builder.setTitle("聖意");
				builder.setMessage(str1);
				builder.setPositiveButton("確定", null);
				builder.show();
				break;
			case R.id.item1:
				builder.setTitle("聖意一");
				builder.setMessage(str2);
				builder.setPositiveButton("確定", null);
				builder.show();
				break;
			case R.id.item2:
				builder.setTitle("聖意二");
				builder.setMessage(str3);
				builder.setPositiveButton("確定", null);
				builder.show();
				break;
			case R.id.item03:
				builder.setTitle("東坡解");
				builder.setMessage(str4);
				builder.setPositiveButton("確定", null);
				builder.show();
				break;
			case R.id.item3:
				builder.setTitle("東坡解一");
				builder.setMessage(str5);
				builder.setPositiveButton("確定", null);
				builder.show();
				break;
			case R.id.item301:
				builder.setTitle("東坡解二");
				builder.setMessage(str6);
				builder.setPositiveButton("確定", null);
				builder.show();
				break;
			case R.id.item4:
				builder.setTitle("碧仙註");
				builder.setMessage(str7);
				builder.setPositiveButton("確定", null);
				builder.show();
				break;
			case R.id.item401:
				builder.setTitle("碧仙註一");
				builder.setMessage(str8);
				builder.setPositiveButton("確定", null);
				builder.show();
				break;
			case R.id.item402:
				builder.setTitle("碧仙註二");
				builder.setMessage(str9);
				builder.setPositiveButton("確定", null);
				builder.show();
				break;
			case R.id.item5:
				builder.setTitle("解曰");
				builder.setMessage(str10);
				builder.setPositiveButton("確定", null);
				builder.show();
				break;
			case R.id.item6:
				builder.setTitle("釋義");
				builder.setMessage(str11);
				builder.setPositiveButton("確定", null);
				builder.show();
				break;
			case R.id.item7:
				builder.setTitle("占驗");
				builder.setMessage(str12);
				builder.setPositiveButton("確定", null);
				builder.show();
				break;
			case R.id.item8:
				builder.setTitle("故事");
				builder.setMessage(str13);
				builder.setPositiveButton("確定", null);
				builder.show();
				break;

		}
		return super.onOptionsItemSelected(item);
	}

}
