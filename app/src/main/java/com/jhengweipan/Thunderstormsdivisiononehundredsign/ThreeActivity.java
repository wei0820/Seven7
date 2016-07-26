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

public class ThreeActivity extends Activity {
	private float    speechRate;
	private  TextToSpeech ts;
	private InterstitialAd interstitial;
	private String str1,str2,str3,str4,str5,str6,str7,str8,str9,str10,str11,str12,str13;
	
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
//		new AlertDialog.Builder(this)
//		.setTitle("提醒您 ")
//		.setMessage("以上張子房（張良）與韓蘄王（韓世忠）的故事都告訴我們，本籤寓意前進有禍，應求退出避禍之道，免遭人加害（例如故事中的漢高祖與秦檜）。『退守』是不夠的，籤意指的是『退出』、『逃避』、『遠離』之意")
//		.setPositiveButton("確定", null)
//		.show();
		
		
		ImageView imageview =(ImageView)findViewById(R.id.showphoto);




		ConnectivityManager conManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);//先取得此service

		NetworkInfo networInfo = conManager.getActiveNetworkInfo();       //在取得相關資訊

		if (networInfo == null || !networInfo.isAvailable()){ //判斷是否有網路
			imageview.setVisibility(View.GONE);
		}else{
			imageview.setVisibility(View.VISIBLE);
			LoadImageClass.loadImage("http://www.chance.org.tw/%E7%B1%A4%E8%A9%A9%E9%9B%86/%E9%9B%B7%E9%9B%A8%E5%B8%AB%E4%B8%80%E7%99%BE%E7%B1%A4/%E9%9B%B7%E9%9B%A8%E5%B8%AB%E3%84%A7%E7%99%BE%E7%B1%A4%E6%8E%83%E6%8F%8F%E6%AA%94/%E9%9B%B7%E9%9B%A8%E5%B8%AB%E3%84%A7%E7%99%BE%E7%B1%A4%20-%20003%E7%B1%A4.jpg", 
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
		text1.setText("第三籤");
		text2.setText("【中吉。甲丙】");
		text4.setText("衣食自然生處有");
		text5.setText("勸君不用苦勞心");
		text6.setText("但能孝悌存忠信");
		text7.setText("福祿來成禍不侵");
		text8.setText("(一)賈誼遇漢文帝");
		text9.setText("(二)張公藝九世同居");
		
		
	}
	private void showString(){
		str1="";//聖意		
		str2="";//聖意一
		str3="";//聖意二
		str4="";//東坡解
		str5="";//東坡解一
		str6="";//東坡解二
		str7="";//碧仙註
		str8="";//碧仙註一
		str9=""; //碧仙註二
		str10="";//解曰
		str11="";//釋義
		str12="";//占驗
		str13="";//故事	
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
							
							String str="衣食自然生處有勸君不用苦勞心但能孝悌存忠信福祿來成禍不侵";
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
			builder.setMessage("");
			builder.setPositiveButton("確定", null);
			builder.show();
			break;
		case R.id.item1:
			builder.setTitle("聖意一");
			builder.setMessage("問名利。自有時。訟和吉。病瘥遲。求財平。婚未宜。宜謹守。免憂疑。");
			builder.setPositiveButton("確定", null);
			builder.show();
			break;
		case R.id.item2:
			builder.setTitle("聖意二");
			builder.setMessage("問名利。自有時。訟和吉。產尚遲。病可治。婚未宜。宜謹守。免憂疑。");
			builder.setPositiveButton("確定", null);
			builder.show();
			break;
		case R.id.item03:
			builder.setTitle("東坡解");
			builder.setMessage("富貴前定。何須強求。徒勞心力。反致傷憂。事親待人。動合循理。天必佑之。有泰無否。");
			builder.setPositiveButton("確定", null);
			builder.show();
			break;
		case R.id.item3:
			builder.setTitle("東坡解一");
			builder.setMessage("");
			builder.setPositiveButton("確定", null);
			builder.show();
			break;
		case R.id.item4:
			builder.setTitle("碧仙註");
			builder.setMessage("隨緣安分。直道而行。心中無愧。自然和平。");
			builder.setPositiveButton("確定", null);
			builder.show();
			break;
		case R.id.item5:
			builder.setTitle("解曰");
			builder.setMessage("此籤只宜守舊。不可貪求。但存中直。卻得兩平。\n\n謀事遲。求財阻。婚姻可。風水更。孕將生。宜早保。免憂驚。");
			builder.setPositiveButton("確定", null);
			builder.show();
			break;
		case R.id.item6:
			builder.setTitle("釋義");
			builder.setMessage("生處有者。戒人凡事依本分。不可貪得。\n\n處家孝悌。則內無怨。處人忠信。則外無怨。毒害消矣。\n\n交財未穩。婚姻主遲。是非口舌。主散為宜。\n\n修身待時。不可徒勞心力。成字或作時字。");
			builder.setPositiveButton("確定", null);
			builder.show();
			break;
		case R.id.item7:
			builder.setTitle("占驗");
			builder.setMessage("一生赴考遺才。占此得收錄。應在衣食自然生處有一句。蓋宗師正科舉之生處也。又(清朝)道光間。一人自恃有財。圖謀官爵。已損同知矣。一但忽欲指省浙江候補。故到廟占此。人勸其作富家翁。不聽。旋赴該省候委。百計營求。始有差事。因延緩多日尚未動身。大憲責其怠慢。截留改委。勞碌數年金盡。求裘敝(體)。歿於旅寓。不得回家。上二句之應也。");
			builder.setPositiveButton("確定", null);
			builder.show();
			break;
		case R.id.item8:
			builder.setTitle("故事");
			builder.setMessage("(一)賈誼遇漢文帝\n漢。賈誼。洛陽人。文帝時河南守。吳薦之石為博士。年二十餘。超遷歲中至大中大夫。請改正朔。興禮樂。上治安策。降灌等。毀之。出為長沙王太傅。誼既適去。渡湘水作賦。弔屈原。論者謂賈生。王佐才遇漢文明主。終不大用。卒悲傷而死。豈非天(意)乎。 （賈誼，西漢文學家、政論家，雖然上『治安策』主張削弱諸侯勢力有功，但因個人性格使然，連漢文帝這種明君也難以容納，終未得重用，是其一生的註解。本則故事解讀較難，請以『賈誼』於網路檢索，即可得白話易解之故事資料）\n(二)張公藝九世同居\n唐高宗問張公藝為何能九世同居（九代同堂未分家，計九百餘人）。當時已八十八歲的張公藝回答：“老夫自幼接受家訓，慈愛寬仁，無殊能，僅誠意待人，一‘忍’字而已。”隨即請紙筆，書寫了一百個“忍”字呈給皇上，並講述了“百忍”的具體內容：“父子不忍失慈孝，兄弟不忍外人欺，姑娌不忍鬧分居，婆媳不忍失孝心……”（本段絕大部分引用媒體資料）");
			builder.setPositiveButton("確定", null);
			builder.show();
			break;
		
		}
		return super.onOptionsItemSelected(item);
	}
	


}