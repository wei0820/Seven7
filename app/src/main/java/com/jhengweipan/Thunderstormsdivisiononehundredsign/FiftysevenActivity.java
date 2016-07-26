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

public class FiftysevenActivity extends Activity {
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
		text1.setText("第五七籤");
		text2.setText("【 中平。己庚】");
		text4.setText("事端百出慮雖長");
		text5.setText("莫聽人言自主張");
		text6.setText("一著仙機君記取");
		text7.setText("紛紛鬧裏更思量");
		text8.setText("(一)爛柯觀棋");
		text9.setText("");
		
		
	}
	private void showString(){
		speakString = "事端百出慮雖長莫聽人言自主張一著仙機君記取紛紛鬧裏更思量"; //郎誦文字
		photoStr = "http://www.chance.org.tw/%E7%B1%A4%E8%A9%A9%E9%9B%86/%E9%9B%B7%E9%9B%A8%E5%B8%AB%E4%B8%80%E7%99%BE%E7%B1%A4/%E9%9B%B7%E9%9B%A8%E5%B8%AB%E3%84%A7%E7%99%BE%E7%B1%A4%E6%8E%83%E6%8F%8F%E6%AA%94/%E9%9B%B7%E9%9B%A8%E5%B8%AB%E3%84%A7%E7%99%BE%E7%B1%A4%20-%20057%E7%B1%A4.jpg" ;//圖
		
		str1="訟急解。病早禳。信即至。財如常。 孕生男。禱神康。凡百事。自主張。";//聖意		
		str2="";//聖意一
		str3="";//聖意二
		str4="";//東坡解
		str5="事務多端。紛紜不已。三思後行。悉歸條理。莫信人言。當自揣己。攙先一著。何事不濟。";//東坡解一
		str6="事務多端。紛紜不已。三思後行。悉歸條理。莫信人言。當自揣己。擠先一著。何事不濟。";//東坡解二
		str7="";//碧仙註
		str8="是非誰不怕將來。只要胸中自主義。 先自關防嬴地立。若遲一步便成災。 ";//碧仙註一
		str9="是非誰不帶將來。只要心中自主裁。先著堪從嬴地立。若遲一步便成災。"; //碧仙註二
		str10="此籤只宜退步。不可求勝。莫信人言。當自理會。攙先一著。何憂不濟。婚不成。財如常。訟宜和。病蚤禳（蚤與早相通）。信即至。孕可慮。禱神康。防人侵害也。";//解曰
		str11="陳凱提兵伐寇。人言紛紛。神與之言曰。一著仙機。君速圖之。俾無竄匿。既而密遣。顧巖等。抵郡即平之。故有一著仙機君記取之說。凡事事紛紛。若失機關。枉費心力。必不濟也。名利未遂。謀事如常。仙或作先。";//釋義
		str12="一人結訟。久而未解。占得此籤。後竟賴一友人。時與怨家奕棋。居間勸息。正著仙機句之驗也。又晉江吳生。一胞姪出天花。十分危險。多方調治。莫何。迨占得此籤後。始憶及家藏痘疹奇書。依法自治。不數劑而愈。此二三句之驗。";//占驗
		str13="(一)爛柯觀棋\n晉。王質。採樵信步入深山。見兩童子在石上對奕。質置斧旁觀。童子與質。一物形如棗核。食之不饑。至局終謂質曰。此非人間。仙家片刻。凡世百年。爾合急歸。質回頭見柯己爛。匆惶而歸至家。景物全非。人莫之識。爛柯山今在浙省衢州府。";//故事	
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