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
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.jhengweipan.Guandisignonehundred.R;

import java.util.Locale;

import myAppKey.mykey;

public class OneoneActivity extends Activity {
	private float    speechRate;
	private  TextToSpeech ts;
	private InterstitialAd interstitial;
	private String str1,str2,srt3,str4,str5,str6,str7,str8,str9,str10,str11,str12,str13;
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
		setContentView(R.layout.activity_oneone);

		getActionBar().setDisplayHomeAsUpEnabled(true);
		ImageView imageview =(ImageView)findViewById(R.id.showphoto);




		ConnectivityManager conManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);//先取得此service

		NetworkInfo networInfo = conManager.getActiveNetworkInfo();       //在取得相關資訊

		if (networInfo == null || !networInfo.isAvailable()){ //判斷是否有網路
			imageview.setVisibility(View.GONE);
		}else{
			imageview.setVisibility(View.VISIBLE);
			LoadImageClass.loadImage("http://www.chance.org.tw/%E7%B1%A4%E8%A9%A9%E9%9B%86/%E9%9B%B7%E9%9B%A8%E5%B8%AB%E4%B8%80%E7%99%BE%E7%B1%A4/%E9%9B%B7%E9%9B%A8%E5%B8%AB%E3%84%A7%E7%99%BE%E7%B1%A4%E6%8E%83%E6%8F%8F%E6%AA%94/%E9%9B%B7%E9%9B%A8%E5%B8%AB%E3%84%A7%E7%99%BE%E7%B1%A4%20-%20001%E7%B1%A4.jpg", 
					imageview,this);

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
			if(keyCode==KeyEvent.KEYCODE_BACK){
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

		return true;
	}


	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}

		switch(id){
		case android.R.id.home:
			NavUtils.navigateUpFromSameTask(this);
			return true;
		case R.id.action_read:
			ts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {

				@Override
				public void onInit(int status) {
					if(status==TextToSpeech.SUCCESS){
						Toast.makeText(getApplicationContext(), "語音設備設定完成", Toast.LENGTH_SHORT).show();	
					}else{		
					}
					//設定語音速度
					speechRate=0.3f;
					ts.setSpeechRate(speechRate);
					//設置播放內容

					String str="巍巍獨步向雲間玉殿千官第一班富貴榮華天付汝福如東海壽如山";
					//設定播放內容語系
					ts.setLanguage(Locale.CHINESE);
					Toast.makeText(getApplicationContext(), "開始朗誦", Toast.LENGTH_SHORT).show();		
					ts.speak(str, TextToSpeech.QUEUE_ADD, null);	
				}
			});

			break;
		case R.id.action_share:
			shareTo("", "關帝籤一百首速解!快點下載吧\n\n https://play.google.com/store/apps/details?id=com.jhengweipan.Thunderstormsdivisiononehundredsign","Share to");

			break;
		case R.id.action_settings:
			break;
		}

		switch(item.getItemId()){
		case R.id.item0:
			builder.setTitle("聖意");
			builder.setMessage("");
			builder.setPositiveButton("確定", null);
			builder.show();
			break;
		case R.id.item1:
			builder.setTitle("聖意一");
			builder.setMessage("功名遂。福祿全。訟得理。病即痊。桑麻熟。婚姻聯。孕生子。行人還。");
			builder.setPositiveButton("確定", null);
			builder.show();
			break;
		case R.id.item2:
			builder.setTitle("聖意二");
			builder.setMessage("功名遂。福祿全。訟得理。病即痊。桑麻熟。婚姻圓。孕生子。行人還。");
			builder.setPositiveButton("確定", null);
			builder.show();
			break;
		case R.id.item3:
			builder.setTitle("東坡解一");
			builder.setMessage("雲間獨步。拔萃超群。名登甲第。談笑功勳。終身光顯。皆天所相。祿厚壽高。意稱謀望。");
			builder.setPositiveButton("確定", null);
			builder.show();
			break;
		case R.id.item4:
			builder.setTitle("碧仙註");
			builder.setMessage("月裡攀丹桂。成名步玉畿。求謀皆稱意。萬事定無疑。");
			builder.setPositiveButton("確定", null);
			builder.show();
			break;
		case R.id.item5:
			builder.setTitle("解曰");
			builder.setMessage("此籤謀望通達。無不遂意。但各有所主。\n\n官員占茲。有超越之喜。士人有功名之望。庶人不吉。\n\n若謀望。求財者。有名無實。為語多空虛也。");
			builder.setPositiveButton("確定", null);
			builder.show();
			break;
		case R.id.item6:
			builder.setTitle("釋義");
			builder.setMessage("上兩句顯仕者之進身。出玉殿千官之上。壽山福海皆天所付。 不可易得。故不應占。\n\n得此者勢如騎虎。降得(虎)者吉降。不得者反被(虎)所傷。\n\n千官或作仙官。");
			builder.setPositiveButton("確定", null);
			builder.show();
			break;
		case R.id.item7:
			builder.setTitle("占驗");
			builder.setMessage("一士人問功名。占此。自謂非會。即狀久而始第。會試殿試兩科。通榜序齒。皆第一授官。山東由知縣。歷州府司道以至撫臺。皆不離山東。應在末句。");
			builder.setPositiveButton("確定", null);
			builder.show();
			break;
		case R.id.item8:
			builder.setTitle("故事");
			builder.setMessage("(一)漢高祖入關\n\n漢高祖。姓劉名邦。字季。沛人也。其時秦法苛暴。天下皆叛。楚人項羽起義。立懷王孫心。高祖率沛中子弟以從。諸侯兵皆西鄉。回功秦約。以先入關者王之。獨高祖先入秦關。除苛法與父老約法三章。秦民大悅。秦王子嬰。素車白馬。出軸道以降。\n\n\n(二)十八學士登瀛洲\n\n李世民于秦王府開設文學館。招攬儒士。立十八學士。後文學館昇格翰林院。又開科取仕。一片昇平景象。瀛洲指仙山(史記6-6-56)。登瀛洲即上仙山。十八學士登瀛洲。指山雞變鳳凰。");
			builder.setPositiveButton("確定", null);
			builder.show();
			break;

		}
		return true;
	}






}
