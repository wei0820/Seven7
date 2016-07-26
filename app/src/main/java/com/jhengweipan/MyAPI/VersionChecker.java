package com.jhengweipan.MyAPI;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;

import com.jhengweipan.Guandisignonehundred.BuildConfig;

import java.util.regex.Matcher;
import java.util.regex.Pattern;



/**
 * Created by redjack on 15/11/6.
 */
public class VersionChecker implements RequestResponseListener {

    private Context context;
    private RequestHandler requestHandler;
    private DoneListener listener;

    String packageName;

    public VersionChecker(Context context)
    {
        this.context = context;
        requestHandler = new RequestHandler();
        packageName = context.getPackageName();
    }

    public void check(DoneListener listener)
    {
        if (context == null || listener == null) return;

        this.listener = listener;

        String host = "https://play.google.com/store/apps/details?id=%s";

        URApiSetting setting = new URApiSetting(String.format(host, packageName), HttpMethod.GET, 111111);

        requestHandler.sendRequest(setting, this);
    }

    public static void checkOnce(Context context, DoneListener listener)
    {
        VersionChecker checker = new VersionChecker(context);
        checker.check(listener);
    }

    public static Intent openMartketIntent()
    {
        return new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + BuildConfig.APPLICATION_ID));
    }

    public void compareVersion(String html)
    {
        if (html == null || listener == null) return;

        String onlineVersion = getVersionFromHtml(html);

        String appVersion = getAppVersion();

        if (onlineVersion == null || appVersion == null) return;

        if (isHeigherVersion(appVersion, onlineVersion)) listener.onHasNewVersion();
        else if (!isHeigherVersion(appVersion, onlineVersion)) listener.onLatestVersion();

    }

    public boolean isHeigherVersion(String oldVersion, String newVersion)
    {
        try {

            String[] olds = oldVersion.split("\\.");
            String[] news = newVersion.split("\\.");
            for (int i=0; i<olds.length; i++)
            {
                if (news.length <= i) break;

                int o = Integer.valueOf(olds[i]);
                int n = Integer.valueOf(news[i]);


                if (n > o) {
                    return true;
                }
                else if (n == o) {
                    continue;
                }else if(n < o) {
                    return false;
            }
            }

            if (news.length > olds.length) return true;
        }
        catch (NumberFormatException ex)
        {
            ex.printStackTrace();
        }
//        finally {
//
////            return false;
//        }
        return  false;
    }


    public String getAppVersion()
    {
        String appVersion = null;
        try {
            appVersion = context.getPackageManager().getPackageInfo(packageName, 0).versionName;
        }
        catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();

            listener.onError();
        }
        finally {
            return appVersion;
        }
    }

    public String getVersionFromHtml(String html)
    {
        Pattern p = Pattern.compile("\"softwareVersion\">\\s*([\\d.]*)\\s*</div>");
        Matcher m = p.matcher(html);

        if (m.find()) return m.group(1);
        else
        {
            listener.onError();
            return null;
        }
    }

    @Override
    public void requesting(RequestSetting setting) {

        if (listener != null) listener.onRequesting();
    }

    @Override
    public void requestComplete(RequestSetting setting, String result) {

        if (result == null || "".equals(result))
        {
            if (listener != null) listener.onError();
            return;
        }

        compareVersion(result);
    }

    @Override
    public void requestFault(RequestSetting setting) {

        if (listener != null) listener.onConnectionFailed();
    }

    @Override
    public void requestDone(RequestSetting setting) {

    }

    public interface DoneListener {
        public void onError();
        public void onRequesting();
        public void onHasNewVersion();
        public void onLatestVersion();
        public void onConnectionFailed();
    }

    public static class DoneAdapter implements DoneListener {

        @Override
        public void onError() {}

        @Override
        public void onRequesting() {}

        @Override
        public void onHasNewVersion() {
        }

        @Override
        public void onLatestVersion() {}

        @Override
        public void onConnectionFailed() {}
    }
}
