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

public class Page_96Activity extends Activity {
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
		text1.setText("第九六籤");
		text2.setText("【 上吉。癸己】");
		text4.setText("婚姻子媳莫嫌遲");
		text5.setText("但把精神仗佛持");
		text6.setText("四十年前須報應");
		text7.setText("功圓行滿有馨兒");
		text8.setText("(一)山濤見王衍");
		text9.setText("");
		
		
	}
	private void showString(){
		speakString = "婚姻子媳莫嫌遲但把精神仗佛持四十年前須報應功圓行滿有馨兒"; //郎誦文字
		photoStr = "http://www.chance.org.tw/%E7%B1%A4%E8%A9%A9%E9%9B%86/%E9%9B%B7%E9%9B%A8%E5%B8%AB%E4%B8%80%E7%99%BE%E7%B1%A4/%E9%9B%B7%E9%9B%A8%E5%B8%AB%E3%84%A7%E7%99%BE%E7%B1%A4%E6%8E%83%E6%8F%8F%E6%AA%94/%E9%9B%B7%E9%9B%A8%E5%B8%AB%E3%84%A7%E7%99%BE%E7%B1%A4%20-%20096%E7%B1%A4.jpg" ;//圖
		
		str1="";//聖意		
		str2="名利訟。遲方吉。病漸瘥。婚姻結。 終年後。得子息。問行人。未有日。";//聖意一
		str3="名利訟。遲方吉。病漸瘥。婚姻實。 終年後。得子息。問行人。未有日。";//聖意二
		str4="";//東坡解
		str5="謀望雖遲。終有所遇。福神相佑。扶持門戶。 終年運泰。事宜進取。凡事稱心。咸無憂慮。";//東坡解一
		str6="謀望雖遲。中有所遇。福神相佑。扶持門戶。 終年運泰。事宜進取。凡事稱心。咸無憂慮。";//東坡解二
		str7="";//碧仙註
		str8="莫言來速與來遲。自要功名兩夾持。 但看平生多少力。晚來忽報事皆宜。";//碧仙註一
		str9="莫言來速與來遲。天道分明且待時。 積德到頭終有報。成功何處不相宜。"; //碧仙註二
		str10="此籤求財發達。訟莫興。和為貴。婚先未得。後成。遠行信在。此月至。孕生男。保吉。墳宅穩。凡事稱心。咸無憂慮也。";//解曰
		str11="言人求子息者。主生寧馨兒。以至凡百謀。為初未遂意。終必遇平正心事。則天必相佑。名利遠大。得此籤者主有四字之應。病見凶。過卯巳月日無事。子息莫本作仔細非也。";//釋義
		str12="一人苦淫雨。入廟問晴占此。不知所解。及霽乃值滿日也。且馨字下有一日字。此其所以待滿而日出也。又(清)光緒九年。晉江郭生年四十。元旦到廟祈禱財氣科名。占得此。無所應。至冬間乃舉一子。其生辰與該生同日月。此三四句籤語之驗也。又惠安縣。有一武生。將應試占此後。縣榜取結第十名。府榜取結二十六名。迨宗師按臨則取第四名。至拜客諸酒完後。復生一子。亦三四兩句之應也。按四十年前之年與連字同音。";//占驗
		str13="(一)山濤見王衍\n晉。山濤。字巨源。河內懷人。器量不群。小與阮藉為竹林友。武帝朝為吏部尚書。薦拔人物。王衍少時。山濤見之曰。何物老嫗生此寧馨兒。然悟天下蒼生。首必此子也。衍字夷甫。晉陽人。神姿高徹。如瑤林瓊樹。官至司徒。後為石勒所害。";//故事	
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