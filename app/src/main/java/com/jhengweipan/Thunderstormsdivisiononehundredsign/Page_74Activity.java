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

public class Page_74Activity extends Activity {
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
		text1.setText("第七四籤");
		text2.setText("【 上吉。辛丁】");
		text4.setText("崔巍崔魏復崔巍");
		text5.setText("履險如夷去復來");
		text6.setText("身似菩提心似鏡");
		text7.setText("長安一道放春回");
		text8.setText("(一)竇禹鈞折桂");
		text9.setText("");
		
		
	}
	private void showString(){
		speakString = "崔巍崔魏復崔巍履險如夷去復來身似菩提心似鏡長安一道放春回"; //郎誦文字
		photoStr = "http://www.chance.org.tw/%E7%B1%A4%E8%A9%A9%E9%9B%86/%E9%9B%B7%E9%9B%A8%E5%B8%AB%E4%B8%80%E7%99%BE%E7%B1%A4/%E9%9B%B7%E9%9B%A8%E5%B8%AB%E3%84%A7%E7%99%BE%E7%B1%A4%E6%8E%83%E6%8F%8F%E6%AA%94/%E9%9B%B7%E9%9B%A8%E5%B8%AB%E3%84%A7%E7%99%BE%E7%B1%A4%20-%20074%E7%B1%A4.jpg" ;//圖
		
		str1="";//聖意		
		str2="訟與病。險而平。名與利。連而亨。 婚先難。終必成。行人至。福自生。";//聖意一
		str3="訟與病。險而平。名與利。迍而亨。 婚先難。終必成。行人至。福自生。";//聖意二
		str4="";//東坡解
		str5="路途嵩險。心卻平夷。轉凶為吉。終免憂疑。 更宜守正。切莫改移。履道坦坦。何福不隨";//東坡解一
		str6="路途傾險。心卻平彝。轉凶為吉。終免憂疑。 更宜守正。切莫改移。履道坦坦。何福不隨。";//東坡解二
		str7="";//碧仙註
		str8="至再至三方見效。聿然機會可重逢。 此心無愧何憂事。謀盡終成不計功。";//碧仙註一
		str9="至再至三險已深。天公默鑒後凋心。從茲坦蕩長安道。出谷遷鶯到上林。"; //碧仙註二
		str10="此籤重有重險。心似平康。凡事先難後易。婚久方成。病險後安。訟凶。財可緩求。行人匆匆。萬物至春後。諸事轉凶成吉之象。";//解曰
		str11="唐。宣宗時。則諒荒酒。為邪魔委于深崖中。家人不知其處。默禱于神。有履險如夷之說。明蚤得從間道歸。凡占名利也。主三數之巧。春夏頗利。至秋大利。大抵人能平其心。正其身則吉福自臻矣。";//釋義
		str12="一人求婚。占此。娶妻至家。好著聰慧。應身似菩提一句。又一人鄉居。四面皆倭寇。急欲脫去。占此。夜從閒道得入郡城。應履險如夷一句。又(清)同治。甲子。福建鄉試。晉江一生。問名占此。迨到省後。忽值鄰省有警停考。回路又問沿途。劫掠大慘。正躊躇間。適有崔姓武官。邀他隨同。林提軍來泉。中途遇雨。延至十月初四日。乃到家。此占不特全詩多應。連題亦驗。";//占驗
		str13="竇禹鈞折桂（竇禹鈞即竇燕山）\n三字經云：「竇燕山，有義方，教五子，名俱揚」，即為此處所指之「竇氏」，竇公乃為五代後周時燕山人，救濟窮困之人，不遺餘力，而他原本命中無子，後因力行善事，日夜不怠，而改變了命運。竇公家中有一位僕人，偷了他二百千錢，寫了一張賣身契，掛在自己的幼女背上，將她送到竇家，說：「永賣此女，以償債務」，遂逃離家鄉，不再回來。竇公憐其苦情，反將契約焚燬，而撫養他的幼女。到了該女成年時，並為其選擇一位好人家將其嫁出。凡是親友中有喪不能葬者，出錢為他埋葬，有女不能嫁者，出錢為她嫁出。每年收入，除去生活必需費用之外，全部拿來作周濟他人之用。竇公又在住宅南端，建立一座書院，藏書數千冊，以優薪禮聘名師，教授四方清寒之士，由此而顯揚之人，不在少數。不久之後，連生五子，皆聰明英俊，後又夢見他的袓父告訴他：「你數年來所做的功德，很是浩大，上天都把它記下了，並延長你的壽命三紀（十二年為一紀），五子皆顯耀，你更當勉勵，不可懈怠！」而後，長子儀做了禮部尚書，次子儼做了禮部侍郎，三子侃做了右補闕，四子偁做了右諫議大夫，五子僖做了起居郎，所生八孫，亦皆顯貴。竇公的善行，讓他得到五位顯揚的孩子，就像被他折下五枝名貴的丹桂一般。（竇禹鈞生五子：儀、儼、侃、偁、僖等，相繼登科，馮瀛王贈禹鈞詩，有「靈椿一樹老，丹桂五枝芳」。時號「竇氏五龍」。本句來自詩詞典故網站）竇公享年八十有二，無病談笑而逝。";//故事	
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