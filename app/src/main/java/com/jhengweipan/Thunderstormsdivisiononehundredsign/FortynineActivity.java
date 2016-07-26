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

public class FortynineActivity extends Activity {
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
		text1.setText("第四九籤");
		text2.setText("【 下下。戊壬】");
		text4.setText("彼此居家只一山");
		text5.setText("如何似隔鬼門關");
		text6.setText("日月如梭人易老");
		text7.setText("許多勞碌不如閒");
		text8.setText("(一)張子房遁跡");
		text9.setText("");
		
		
	}
	private void showString(){
		speakString = "彼此居家只一山如何似隔鬼門關日月如梭人易老許多勞碌不如閒"; //郎誦文字
		photoStr = "http://www.chance.org.tw/%E7%B1%A4%E8%A9%A9%E9%9B%86/%E9%9B%B7%E9%9B%A8%E5%B8%AB%E4%B8%80%E7%99%BE%E7%B1%A4/%E9%9B%B7%E9%9B%A8%E5%B8%AB%E3%84%A7%E7%99%BE%E7%B1%A4%E6%8E%83%E6%8F%8F%E6%AA%94/%E9%9B%B7%E9%9B%A8%E5%B8%AB%E3%84%A7%E7%99%BE%E7%B1%A4%20-%20049%E7%B1%A4.jpg" ;//圖
		
		str1="名利阻。且休問。訟宜和。病有願。 婚姻遲。行人遠。欲獲吉。且安分。";//聖意		
		str2="";//聖意一
		str3="";//聖意二
		str4="";//東坡解
		str5="安閑易處。出門有阻。時迍易過。枉自勞苦。 且宜守舊。隨分而處。運未亨通。不宜進取。";//東坡解一
		str6="安閑易去處。出門有阻。時迍易過。枉自勞苦。 且宜守舊。隨分而處。運未亨通。不宜進取。";//東坡解二
		str7="";//碧仙註
		str8="寄跡相親心不親。如何要作契深人。 謀為動作皆無定。只恐虛名不得在。";//碧仙註一
		str9="形跡如親實不親。相看只作鏡中人。謀為動作皆無定。只恐虛名不得真。"; //碧仙註二
		str10="此籤事有阻滯。且隨緣分。切莫貪求。訟宜和。病有祟。名利阻。問婚不和。家宅有難。陰人有災。凡事防凶人中途侵害也。";//解曰
		str11="彼此家居內外。一般也。兩山成出。只有一山似隔鬼門關。有阻礙不得出也。日月如梭。易催人老。勞碌無成。不如閒坐也。名利皆迍。隨時修為。俟其自通。方可進取。婚姻不成。家宅主陰人謀害。行人至途中侵損。切宜謹防。占者凡事守舊。為上策。";//釋義
		str12="一人居住省城。欲往外驟生理。占此。人以籤不吉。止之不聽。離家只四十里。在外終日忙碌。無人可安。三年不得回。竟卒於外首。二住之驗也。又光緒(年)間。桐郡。鄭姓有子。染病延醫。許氏服藥未效。有人薦一何姓老醫。其父遲疑莫決。占此乃信。必託與高年者。竟不數日而愈。益恍然於。如何似人易老許不如。此九字。儼若為斯人作焉。";//占驗
		str13="張子房遁跡\n漢。張良。字子房。韓人。其先五世相韓。秦滅韓。良散家財遁跡。欲為韓報仇。乃使力士懷鐵錐。擊始皇於博浪沙上。誤中副車。始皇大索天下。十月不獲。後左(佐)漢定天下。功成謝絕人事。托名與赤松子遊。";//故事	
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