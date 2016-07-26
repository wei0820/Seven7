package com.jhengweipan.MyAPI;


import android.content.ContentValues;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by redjack on 15/9/14.
 */
public class RequestHandler {

    private ExecutorService executorService = Executors.newCachedThreadPool();
    /**
     *  Run on mainThread.
     */
    Handler handler = new Handler(Looper.getMainLooper());

    /**
     * Send request with listener, will assign listen to setting.listener.
     */
    public void sendRequest(RequestSetting setting, RequestResponseListener listener) {

        setting.listener = listener;
        sendRequest(setting);
    }

    /**
     * Send request with setting.
     */
    public void sendRequest(final RequestSetting setting)
    {
        if (setting.listener != null)
        {
            handler.post(new Runnable() {
                @Override
                public void run() {
                    setting.listener.requesting(setting);
                }
            });
        }

        executorService.execute(new Runnable() {
            @Override
            public void run() {

                String url = setting.getFullUrl();
                String responseString = null;
                String query = setting.getPostQueryString();

                int responseCode = HttpURLConnection.HTTP_NOT_FOUND;

                Log.d("Request send", "\nSend \n=========\n Request " + setting.httpMethod.getMethodName() + " to :" + url + "\nParameter : \n" + query + "\n==========");

                HttpURLConnection conn = null;
                try
                {
                    conn = (HttpURLConnection) new URL(url).openConnection();

                    ContentValues headerValue = setting.customHeaders.size() != 0 ? setting.customHeaders : setting.httpMethod.getHeaderValue();

                    for (String key : headerValue.keySet())
                    {
                        conn.addRequestProperty(key, headerValue.getAsString(key));
                    }

                    if (query != null) conn.addRequestProperty("Content-Length", "" + query.getBytes().length);
                    conn.addRequestProperty("API-VER","1.1");
                    conn.setConnectTimeout(setting.timeout);
                    conn.setReadTimeout(setting.timeout);
                    conn.setRequestMethod(setting.httpMethod.getMethodName());
                    conn.setDoInput(true);
                    if (query != null) conn.setDoOutput(true);


                    conn.connect();

                    if (query != null)
                    {
                        DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
                        wr.write(query.getBytes());
                        wr.flush();
                        wr.close();
                    }

                    InputStream response = conn.getInputStream();

                    responseString = inputStreamToString(response);

                    responseCode = conn.getResponseCode();

                }
                catch (SocketTimeoutException e) {
                    e.printStackTrace();
                    Log.e("Request", url + " time out.");
                }
                catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
                finally
                {
                    Log.d("Request send", "\nSend \n=========\n Request " + setting.httpMethod.getMethodName() + " to :" + url + "\nParameter : \n" + query +
                            "\n\nResult : \n" + responseString + "\n==========");

                    requestFinished(responseCode < HttpURLConnection.HTTP_BAD_REQUEST && responseCode > 0, setting, responseString);

                    System.gc();
                }
            }
        });
    }


    public void requestFinished(final boolean isSuccess, final RequestSetting setting, final String responseString)
    {
        if (setting.listener == null) return;

        handler.post(new Runnable() {
            @Override
            public void run() {

//                setting.listener.requestComplete(setting, responseString);
                if (isSuccess) setting.listener.requestComplete(setting, responseString);
                else           setting.listener.requestFault(setting);

                setting.listener.requestDone(setting);
            }
        });
    }

    public void stopHandle()
    {
        executorService.shutdown();
    }

    public HttpURLConnection connectionFromSetting(RequestSetting setting, String fullUrl)
    {
        HttpURLConnection conn = null;

        try
        {
            URL url = new URL(fullUrl);
            conn = (HttpURLConnection) url.openConnection();

            ContentValues headerValue = setting.customHeaders.size() != 0 ? setting.customHeaders : setting.httpMethod.getHeaderValue();

            for (String key : headerValue.keySet())
            {
                conn.addRequestProperty(key, headerValue.getAsString(key));
            }

            conn.setConnectTimeout(setting.timeout);
            conn.setRequestMethod(setting.httpMethod.getMethodName());
            conn.setDoInput(true);

            if (setting.hasPostData()) conn.setDoOutput(true);

        }
        catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return conn;
    }

    public static String inputStreamToString(InputStream inputStream)
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder builder = new StringBuilder();
        String line;

        try
        {
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return builder.toString();
    }

}
