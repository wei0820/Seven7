package com.jhengweipan.Thunderstormsdivisiononehundredsign;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.adlocus.PushAd;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.jhengweipan.Guandisignonehundred.R;

import myAppKey.mykey;


public class ZeroActivity extends Activity {

    private Object[] activities = {
            "第一籤【大吉。甲甲】  	 巍巍獨步向雲間", OneoneActivity.class,
            "第二籤【上吉。甲乙】  	 盈虛消息總天時", TwotwoActivity.class,
            "第三籤【中吉。甲丙】  	 衣食自然生處有", ThreeActivity.class,
            "第四籤【下下。甲丁】	 去年百事可相宜", FourActivity.class,
            "第五籤【中平。甲戊】  	 子有三般不自由", FiveActivity.class,
            "第六籤【 下下。甲己】  	 何勞鼓瑟更吹笙", SixActivity.class,
            "第七籤【 大吉。甲庚】  	 仙風道骨本天生", SevenActivity.class,
            "第八籤【 上上。甲辛】 	 年來耕稼苦無收", EightActivity.class,
            "第九籤【大吉。甲壬】  	 望渠消息向長安", NineActivity.class,
            "第十籤【下下。甲癸】	 病患時時命蹇衰", TenActivity.class,
            "第十一籤【下下。乙甲】      今年好事一番新", ThirteenActivity.class,
            "第十二籤【 中平。乙乙】     營為期望在春前", TwelveActivity.class,
            "第十三籤【 中平。乙丙】 	  君今庚甲未亨通", ElevenActivity.class,
            "第十四籤【 下下。乙丁 】     一見佳人便喜歡", FourteenActivity.class,
            "第十五籤【 中平。乙戊】      兩家門戶各相當", FifteenActivity.class,
            "第十六籤【 下下。乙己】      官事悠悠難辨明", SixteenActivity.class,
            "第十七籤【 下下。乙庚】      田園價貫好商量", SeventeenActivity.class,
            "第十八籤【 中平。乙辛】      知君指擬是空華", EighteenActivity.class,
            "第十九籤【 上吉。乙壬】      嗟子從來未得時 ", NineteenActivity.class,
            "第二十籤【 下下。乙癸】      一生心事向誰論", TwentyActivity.class,
            "第二十一籤【下下。丙甲】    與君夙昔結成冤", TwentyoneActivity.class,
            "第二二籤【 上吉。丙乙】      碧玉池中開白蓮", TwentytwoActivity.class,
            "第二三籤【 下下。丙丙】     花開花謝在春風", TwentythreeActivity.class,
            "第二四籤【 中平(中吉)。丙丁】  一春萬事苦憂煎", TwentyfourActivity.class,
            "第二五籤【 中平。丙戊 】     寅午戍年多阻滯", TwentyfiveActivity.class,
            "第二六籤【 中吉。丙己】     年來豐歉皆天數", TwentysixActivity.class,
            "第二七籤【 下下(中平)。丙庚】  世間萬物各有主 ", TwentysevenActivity.class,
            "第二八籤【 上吉。丙辛】  公侯將相本無種", TwentyeightActivity.class,
            "第二九籤【 上上。丙壬】   祖宗積德幾多年", TwentynineActivity.class,
            "第三十籤【 中吉。丙癸】  奉公謹守莫欺心 ", ThirtyActivity.class,
            "第三一籤【 中吉。丁甲】  秋冬作事只尋常", ThirtyoneActivity.class,
            "第三二籤【 下下。丁乙】  勞心汨汨竟何歸", ThirtytwoActivity.class,
            "第三三籤【中平(中吉)。丁丙】 不分南北與西東", ThirtythreeActivity.class,
            "第三四籤【中平(中吉)。丁丁】  春夏纔過秋又冬", ThirtyfourActivity.class,
            "第三五籤【 下下。丁戊】  一山如畫對清江", ThirtyfiveActivity.class,
            "第三六籤【 上吉。丁己】  功名富貴自能為", ThirtysixActivity.class,
            "第三七籤【 中平(中吉)。丁庚】  焚香來告復何辭", ThirtysevenActivity.class,
            "第三八籤【 下下。丁辛】  蛩吟唧唧守孤幃", ThirtyeighActivity.class,
            "第三九籤【 下下(中下)。丁壬】  北山門外好安居", ThirtynineActivity.class,
            "第四十籤【 上吉 。丁癸 】  新來換得好規模", FortyActivity.class,
            "第四一籤【中吉(上吉)。戊甲】  自南自北自東西", FortyoneActivity.class,
            "第四二籤【中吉。戊乙】   我曾許汝事和諧", FortytwoActivity.class,
            "第四三籤【 中吉。戊丙】  一紙官書火急催", FortythreeActivity.class,
            "第四四籤【 中平(中吉)。戊丁】  汝是人中最吉人", FortyfourActivity.class,
            "第四五籤【 中平(中吉)。戊戊】  好將心地力耕耘", FortyfiveActivity.class,
            "第四六籤【中平。戊己 】  君是山中萬戶侯", FortysixActivity.class,
            "第四七籤【 下下(中平)。戊庚】  與君萬語復千言", FortysevenActivity.class,
            "第四八籤【中平(中吉)。戊辛】  登山涉水正天寒", FortyeightActivity.class,
            "第四九籤【 下下。戊壬】  彼此居家只一山", FortynineActivity.class,
            "第五十籤【 上平(上吉)。戊癸】  人說今年勝去年	", FiftyActivity.class,
            "第五一籤【 上吉。己甲】  君今百事且隨緣", FiftyoneActivity.class,
            "第五二籤【 上吉。己乙】  兀坐幽居歎寂寥", FiftytwoActivity.class,
            "第五三籤【 下下。己丙】  艱難險阻路蹊蹺", FiftythreeActivity.class,
            "第五四籤【 中平。己丁】  萬人叢裏逞英豪", FiftyfourActivity.class,
            "第五五籤【 中平。己戊】  勤耕力作莫蹉跎", FiftyfiveActivity.class,
            "第五六籤【 下下。己己】  心頭理曲強詞遮", FiftysixActivity.class,
            "第五七籤【 中平。己庚】  事端百出慮雖長", FiftysevenActivity.class,
            "第五八籤【 上吉。己辛】 蘇秦三寸足平生", FiftyeightActivity.class,
            "第五九籤【 中平。己壬 】 門衰戶冷苦伶仃 ", FiftynineActivity.class,
            "第六十籤【 上上。己癸】  羨君兄弟好名聲", SixtyActivity.class,
            "第六一籤【 中平(中吉)。庚甲】嘯聚山林兇惡儔", Page_61Activity.class,
            "第六二籤【中平(中吉)。庚乙】 百千人面虎狼心", Page_62Activity.class,
            "第六三籤【 中平(中吉)。庚丙】 曩時征北且圖南", Page_63Activity.class,
            "第六四籤【 上上。庚丁】 吉人相遇本和同", Page_64Activity.class,
            "第六五籤【 上上。庚戊】 朔風凜凜正窮冬", Page_65Activity.class,
            "第六六籤【 上上。庚己】 耕耘只可在鄉邦", Page_66Activity.class,
            "第六七籤【 中平。庚庚】 纔發君心天已知", Page_67Activity.class,
            "第六八籤【 中平(中吉)。庚辛】 南販珍珠北販鹽", Page_68Activity.class,
            "第六九籤【 下下(中平)。庚壬】  捨舟遵路總相宜", Page_69Activity.class,
            "第七十籤【 中平(中吉)。庚癸】  雷雨風雲各有司", Page_70Activity.class,
            "第七一籤【 中平(中吉)。辛甲】 喜鵲簷前報好音", Page_71Activity.class,
            "第七二籤【 下下(中平)。辛乙】 河渠傍路有高低", Page_72Activity.class,
            "第七三籤【下下。辛丙】  憶昔蘭房分半釵", Page_73Activity.class,
            "第七四籤【 上吉。辛丁】 崔巍崔魏復崔巍", Page_74Activity.class,
            "第七五籤【 中吉。辛戊】  生前結得好緣姻", Page_75Activity.class,
            "第七六籤【 中平。辛己】 三千法律八千文", Page_76Activity.class,
            "第七七籤【 下下(中下)。辛庚】  木有根荄水有源", Page_77Activity.class,
            "第七八籤【 下下。辛辛】 家道豐腴自飽溫 ", Page_78Activity.class,
            "第七九籤【 中平。辛壬】  乾亥來龍仔細看", Page_79Activity.class,
            "第八十籤【 中平。辛癸】 一朝無事忽遭官", Page_80Activity.class,
            "第八一籤【中平(中吉)。壬甲】 假君財物自當還", Page_81Activity.class,
            "第八二籤【 上吉。壬乙】 彼亦儔中一輩賢", Page_82Activity.class,
            "第八三籤【下下。壬丙】 隨分堂前赴粥饘", Page_83Activity.class,
            "第八四籤【 中平。壬丁】 君家事緒更紛然", Page_84Activity.class,
            "第八五籤【 中平。壬戊】  一春風雨正瀟瀟", Page_85Activity.class,
            "第八六籤【上上(上吉)。壬己】 一舟行貨好招邀", Page_86Activity.class,
            "第八七籤【 下下。壬庚】 陰裏詳看怪爾曹", Page_87Activity.class,
            "第八八籤【上吉。壬辛】  從前作事總徒勞", Page_88Activity.class,
            "第八九籤【 中平。壬壬】 樽前無事且高歌", Page_89Activity.class,
            "第九十籤【 中平。壬癸】  崆峒城裏事如麻", Page_90Activity.class,
            "第九一籤【 中平(中吉)。癸甲】 佛說淘沙始見金", Page_91Activity.class,
            "第九二籤【下下(下中)。癸乙】  今年禾穀不如前", Page_92Activity.class,
            "第九三籤【 中平。癸丙】 春來雨水太連綿", Page_93Activity.class,
            "第九四籤【 中平(中吉)。癸丁】 一般器用與人同", Page_94Activity.class,
            "第九五籤【 中平(中吉)。癸戊】 知君袖裏有驪珠", Page_95Activity.class,
            "第九六籤【 上吉。癸己】 婚姻子媳莫嫌遲", Page_96Activity.class,
            "第九七籤【 上上。癸庚】  五十功名心已灰", Page_97Activity.class,
            "第九八籤【 中平(中吉)。癸辛】 經營百出費精神", Page_98Activity.class,
            "第九九籤【 上上。癸壬】  貴人遭遇水雲鄉", Page_99Activity.class,
            "第一百籤【 上上。癸癸】 我本天仙雷雨師", Page_100Activity.class,


    };

    private void shareTo(String subject, String body, String chooserTitle) {

        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, subject);
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, body);//分享這款app 網址

        startActivity(Intent.createChooser(sharingIntent, chooserTitle));
    }

    private AdView adView;
    private InterstitialAd interstitial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zero);

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        CharSequence[] list = new CharSequence[activities.length / 2];
        for (int i = 0; i < list.length; i++) {

            list[i] = (String) activities[i * 2];

        }
        ArrayAdapter<CharSequence> a = new ArrayAdapter<CharSequence>(this, android.R.layout.simple_list_item_1, list);
        ListView listview = (ListView) findViewById(R.id.zerolistview);
        listview.setAdapter(a);


        listview.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(ZeroActivity.this, (Class<?>) activities[position * 2 + 1]);
                startActivity(intent);

            }
        });


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

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        switch (id) {
            case R.id.action_share:
                shareTo("", mykey.myShareString, "Share to");
                break;


        }

        return super.onOptionsItemSelected(item);
    }


}
