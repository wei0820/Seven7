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

public class ThirtyfiveActivity extends Activity {
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
		text1.setText("第三五籤");
		text2.setText("【 下下。丁戊】");
		text4.setText("一山如畫對清江");
		text5.setText("門裏團圓事事雙");
		text6.setText("誰料半途分折去");
		text7.setText("空幃無語對銀缸");
		text8.setText("(一)王昭君和番");
		text9.setText("");


	}

	private void showString() {
		speakString = "一山如畫對清江門裏團圓事事雙誰料半途分折去空幃無語對銀缸"; //郎誦文字
		photoStr = "http://www.chance.org.tw/%E7%B1%A4%E8%A9%A9%E9%9B%86/%E9%9B%B7%E9%9B%A8%E5%B8%AB%E4%B8%80%E7%99%BE%E7%B1%A4/%E9%9B%B7%E9%9B%A8%E5%B8%AB%E3%84%A7%E7%99%BE%E7%B1%A4%E6%8E%83%E6%8F%8F%E6%AA%94/%E9%9B%B7%E9%9B%A8%E5%B8%AB%E3%84%A7%E7%99%BE%E7%B1%A4%20-%20035%E7%B1%A4.jpg";//圖

		str1 = "訟終凶。宜謹防。病者險。主重喪。 行人阻。財有傷。婚不合。謹行藏。";//聖意
		str2 = "";//聖意一
		str3 = "";//聖意二
		str4 = "墳宅雖吉。命運未通。家門招禍。好事成空。 夫妻離散。骨肉西東。凡事不遂。有始無終。";//東坡解
		str5 = "";//東坡解一
		str6 = "";//東坡解二
		str7 = "";//碧仙註
		str8 = "始終未必不貪圖。到底須知力枉勞。設得十分奇巧計。卻防中路被風濤。";//碧仙註一
		str9 = "漫誇根蒂自堅牢。到底須知力枉勞。設得十分奇巧計。卻妨中路被風濤。"; //碧仙註二
		str10 = "此籤墳宅雖吉。命運未通。謀望到底成空。先吉後凶。有始無終。須防有死亡之患。訟必凶。病主險。求財必無。行人有阻也。";//解曰
		str11 = "一山對清江。言風水雖合吉。但命運未通故也。門裏團圓之事。半途分折。骨肉離散。名成而敗。利得而失。若人有見機之智。不待時之過中勢之極盛。先為趨避之計。則晚節末路可保無虞。占家宅。親病必危。問行人。有阻。凡事欠順。";//釋義
		str12 = "一人妻病。占此遂亡。應半途云云。一堪輿託人薦于富室。彼已有先至者。應門裏云云。兩人各為異論。與主家不合。皆不用而反(返)。應半途空幃云云。又一婦人。產後未滿月。母子得病。占此。不數日俱亡。應事事雙。并後兩句也。又一家兄弟兩人。將應試仝占此。後俱遊庠蓋。誰料半得隹字。途折去僅存道(道本作缺首，大五碼缺此部首字)。二者合成進字。故宜其入學也。";//占驗
		str13 = "(一)王昭君和番\n昭君姓王。名嬙。字告月。歸州人。漢元帝宮女。得罪畫工。為點崩夫痣。致不見幸。昭君以才貌雙全。自傷不見知會。匈奴求婚。乃自上書請行。臨去步入掖庭。顧影徘徊。君臣相顧失色。然不能失信於單于。故遣其和番。而斬畫工毛延壽等二百餘人。";//故事
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