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

public class FiftyActivity extends Activity {
	private float    speechRate;
	private  TextToSpeech ts;
	private InterstitialAd interstitial;
	private String  photoStr,speakString,str1,str2,str3,str4,str5,str6,str7,str8,str9,str10,str11,str12,str13;
	
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
		
		ImageView imageview =(ImageView)findViewById(R.id.showphoto);




		ConnectivityManager conManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);//先取得此service

		NetworkInfo networInfo = conManager.getActiveNetworkInfo();       //在取得相關資訊

		if (networInfo == null || !networInfo.isAvailable()){ //判斷是否有網路
			imageview.setVisibility(View.GONE);
		}else{
			imageview.setVisibility(View.VISIBLE);
			LoadImageClass.loadImage(photoStr,
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
		text1.setText("第五十籤");
		text2.setText("【 上平(上吉)。戊癸】");
		text4.setText("人說今年勝去年");
		text5.setText("也須步步要週旋");
		text6.setText("一家和氣多生福");
		text7.setText("萋菲讒言莫聽偏");
		text8.setText("(一)蘇東波勸民");
		text9.setText("");
		
		
	}
	private void showString(){
		speakString = "人說今年勝去年也須步步要週旋一家和氣多生福萋菲讒言莫聽偏"; //郎誦文字
		photoStr = "http://www.chance.org.tw/%E7%B1%A4%E8%A9%A9%E9%9B%86/%E9%9B%B7%E9%9B%A8%E5%B8%AB%E4%B8%80%E7%99%BE%E7%B1%A4/%E9%9B%B7%E9%9B%A8%E5%B8%AB%E3%84%A7%E7%99%BE%E7%B1%A4%E6%8E%83%E6%8F%8F%E6%AA%94/%E9%9B%B7%E9%9B%A8%E5%B8%AB%E3%84%A7%E7%99%BE%E7%B1%A4%20-%20050%E7%B1%A4.jpg" ;//圖
		
		str1="";//聖意		
		str2="出入吉。財物多。孕可保。病即瘥。 婚必成。訟宜和。問行人。奏凱歌。";//聖意一
		str3="出入吉。財物多。孕可保。病即瘥。 婚易成。訟宜和。問行人。奏凱歌。";//聖意二
		str4="";//東坡解
		str5="謀望勝先。進取攸利。人事周密。禍消福至。勿信讒言。惶惑思慮。慎終如始。切莫猶豫。";//東坡解一
		str6="謀望勝前。卻宜進取。人事周旋。禍消福至。勿信讒言。惶惑思慮。慎終如始。切莫顛墜。";//東坡解二
		str7="";//碧仙註
		str8="此心有主何憂懼。須管今番勝舊番。 婦人言語君休聽。家道興衰在此間。";//碧仙註一
		str9="剝復亨迍遞往還。今番管許勝前番。 婦人言語君休聽。家道興衰在此間。"; //碧仙註二
		str10="此籤大吉。富貴榮華。門庭興旺。見喜添丁。但謀事要和合。莫信讒言。只宜保守。方得安樂。出入吉。財可求。婚可結。行人至。病得痊。訟宜和。百事亨泰也。";//解曰
		str11="功名未遂。若謀為他事。今春頗勝。如不能周旋。亦只是去年榜樣也。周旋謂進步。要慎審的。蓋作事須要周旋也。卜者。得之人事。能周旋。則一家之內。禍災消滅。和氣自生矣。莫聽偏者。戒人不可聽信讒言。以致惶惑也。";//釋義
		str12="一人惑妻言。欲與弟分家。占此感悟。依舊同居。後其弟遠商獲利數萬。與兄同享。數世安居。第三句驗甚。又鯉城。郭補卷與余總角交也。庚寅病重。其弟以年近五旬。且身體素弱。非溫補不宜。余薦種禾堂醫士。吳和。尚舍力。用清涼。闔家訝焉。占此服之。火候始見。竟以和藥奏功。亦第三句之驗也。竹坪又識。";//占驗
		str13="(一)蘇東波勸民\n宋。蘇軾。字子瞻。號東波居士。知杭州。歲饑。勸民平糶。發倉廩賑濟。又遣使四出治病。活者萬計。有逋(欠)稅不償。軾呼詢之。云以夏扇謀生。天寒難賣。非故負也。軾令取廿餘柄來。據案草書。及畫枯木竹石。其人持出。眾以千文爭買一扇不得。盡償所逋(欠)。";//故事	
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
							
							String str=speakString;
							//設定播放內容語系
							ts.setLanguage(Locale.CHINESE);
							Toast.makeText(getApplicationContext(), "開始朗誦", Toast.LENGTH_SHORT).show();		
							ts.speak(str, TextToSpeech.QUEUE_ADD, null);	
				}
			});
			
			break;
		case R.id.action_share:
			shareTo("", mykey.myShareString,"Share to");
			
			break;
		case R.id.action_settings:
			break;
		}
		
	

		switch(item.getItemId()){
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