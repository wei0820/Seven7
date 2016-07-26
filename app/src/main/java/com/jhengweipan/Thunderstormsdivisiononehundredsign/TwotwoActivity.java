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


public class TwotwoActivity extends Activity {
	private float    speechRate;
	private  TextToSpeech ts;
	private InterstitialAd interstitial;
	
	
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
		new AlertDialog.Builder(this)
		.setTitle("提醒您 ")
		.setMessage("以上張子房（張良）與韓蘄王（韓世忠）的故事都告訴我們，本籤寓意前進有禍，應求退出避禍之道，免遭人加害（例如故事中的漢高祖與秦檜）。『退守』是不夠的，籤意指的是『退出』、『逃避』、『遠離』之意")
		.setPositiveButton("確定", null)
		.show();
		
		
		ImageView imageview =(ImageView)findViewById(R.id.showphoto);




		ConnectivityManager conManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);//先取得此service

		NetworkInfo networInfo = conManager.getActiveNetworkInfo();       //在取得相關資訊

		if (networInfo == null || !networInfo.isAvailable()){ //判斷是否有網路
			imageview.setVisibility(View.GONE);
		}else{
			imageview.setVisibility(View.VISIBLE);
			LoadImageClass.loadImage("http://www.chance.org.tw/%E7%B1%A4%E8%A9%A9%E9%9B%86/%E9%9B%B7%E9%9B%A8%E5%B8%AB%E4%B8%80%E7%99%BE%E7%B1%A4/%E9%9B%B7%E9%9B%A8%E5%B8%AB%E3%84%A7%E7%99%BE%E7%B1%A4%E6%8E%83%E6%8F%8F%E6%AA%94/%E9%9B%B7%E9%9B%A8%E5%B8%AB%E3%84%A7%E7%99%BE%E7%B1%A4%20-%20002%E7%B1%A4.jpg", 
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
		return super.onCreateOptionsMenu(menu);
	}

	private void initlayout(){
		TextView text1 = (TextView)findViewById(R.id.textView1);
		TextView text2 = (TextView)findViewById(R.id.textView2);
//		TextView text3 = (TextView)findViewById(R.id.textView3);
		TextView text4 = (TextView)findViewById(R.id.textView4);
		TextView text5 = (TextView)findViewById(R.id.textView5);
		TextView text6 = (TextView)findViewById(R.id.textView6);
		TextView text7 = (TextView)findViewById(R.id.textView7);
		TextView text8 = (TextView)findViewById(R.id.textView8);
		TextView text9 = (TextView)findViewById(R.id.textView9);
		text1.setText("第二籤");
		text2.setText("【上吉。甲乙】");
		text4.setText("盈虛消息總天時");
		text5.setText("自此君當百事宜");
		text6.setText("若問前程歸縮地");
		text7.setText("須憑方寸好修為");
		text8.setText("(一)張子房遊赤松（張子房即張良）");
		text9.setText("(二)韓蘄王西湖騎驢");
		
		
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
							
							String str="盈虛消息總天時自此君當百事宜若問前程歸縮地須憑方寸好修為";
							//設定播放內容語系
							ts.setLanguage(Locale.CHINESE);
							Toast.makeText(getApplicationContext(), "開始朗誦", Toast.LENGTH_SHORT).show();		
							ts.speak(str, TextToSpeech.QUEUE_ADD, null);	
				}
			});
			
			break;
		case R.id.action_share:
			shareTo("",mykey.myShareString ,"Share to");
			
			break;
		case R.id.action_settings:
			break;
		}
		
		switch(item.getItemId()){
		case R.id.item0:
			builder.setTitle("聖意");
			builder.setMessage("訟宜和。病宜禱。功名有。遲莫躁。求財平。問婚好。若妄為。身莫保。");
			builder.setPositiveButton("確定", null);
			builder.show();
			break;
		case R.id.item1:
			builder.setTitle("聖意一");
			builder.setMessage("");
			builder.setPositiveButton("確定", null);
			builder.show();
			break;
		case R.id.item2:
			builder.setTitle("聖意二");
			builder.setMessage("");
			builder.setPositiveButton("確定", null);
			builder.show();
			break;
		case R.id.item03:
			builder.setTitle("東坡解");
			builder.setMessage("");
			builder.setPositiveButton("確定", null);
			builder.show();
			break;
		case R.id.item3:
			builder.setTitle("東坡解一");
			builder.setMessage("萬事乘除。隨時而處。否極泰來。事無齟齬。能保則吉。更當修為。切莫妄動。萬福來宜。");
			builder.setPositiveButton("確定", null);
			builder.show();
			break;
		case R.id.item301:
			builder.setTitle("東坡解二");
			builder.setMessage("萬事乘除。隨時而處。否極泰來。事無齟齬。收成結果。方寸修為。切莫妄動。萬福來宜。");
			builder.setPositiveButton("確定", null);
			builder.show();
			break;
		case R.id.item4:
			builder.setTitle("碧仙註");
			builder.setMessage("");
			builder.setPositiveButton("確定", null);
			builder.show();
			break;
		case R.id.item401:
			builder.setTitle("碧仙註一");
			builder.setMessage("禍福從天降。心仁萬事宜。若還無妄作。災散禍消除。");
			builder.setPositiveButton("確定", null);
			builder.show();
			break;
		case R.id.item402:
			builder.setTitle("碧仙註二");
			builder.setMessage("禍福從天降。存心萬事宜。若還無妄作。禍散福相隨。");
			builder.setPositiveButton("確定", null);
			builder.show();
			break;
		case R.id.item5:
			builder.setTitle("解曰");
			builder.setMessage("此籤謀望虛。查不宜速進。且須待時。方可成就。 婚則合。訟宜和。求財有。行人至。孕生女。病宜禱。 大概以正心修德為要。");
			builder.setPositiveButton("確定", null);
			builder.show();
			break;
		case R.id.item6:
			builder.setTitle("釋義");
			builder.setMessage("盈滿也。虛空也。消窮也。息渙也。四者皆用天命。 卜者當順受。不可妄為。 前程歸縮地。言目下功名。期望遠大。必藉修為。 乃得病。不可保。訟不可。終其曰。君當百事宜。 若蓋勉人修為。心地至於縮地。乃縮千里於目前。半步可至。 此壺公授費長房之術也。");
			builder.setPositiveButton("確定", null);
			builder.show();
			break;
		case R.id.item7:
			builder.setTitle("占驗");
			builder.setMessage("一少年患弱病。占此。殞歿。竟棄人間。應在前程歸縮地一句。又一人問行人。占此。不數日。其人兼程而至。亦縮地之應也。又一人問執業。占此。奔走四方。靡有生涯。後遇一選課者傳授心法。乃遁跡潯江。自開擇日館。研究趨吉避凶之術。頗精。上二句甚驗。");
			builder.setPositiveButton("確定", null);
			builder.show();
			break;
		case R.id.item8:
			builder.setTitle("故事");
			builder.setMessage("(一)張子房遊赤松（張子房即張良）\n子房名良。韓國公曰。博浪沙事後(指行弒秦始皇)匿下邳。遊覆上遇衣褐老夫。墮屨命取。良跪進之。老父曰。孺子可教。越五日授以太公兵法。謂後十三年。濟北穀城山下黃石即我也。後良佐(漢)高祖定天下。封留侯。因感鳥盡弓藏。謝病歸入白雲山。師事黃石。號赤松子。");
			builder.setPositiveButton("確定", null);
			builder.show();
			break;
		
		
		
		
		}
		return super.onOptionsItemSelected(item);
	}
	


}
