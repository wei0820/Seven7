package com.jhengweipan.MyAPI;

import android.content.ContentValues;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;

/**
 * Created by redjack on 15/9/14.
 */
public abstract class RequestSetting {

    protected ContentValues params = new ContentValues();
    /// Request type.
    public int type;
    /// Http request method type.
    public HttpMethod httpMethod = HttpMethod.GET;
    /// Host for API.
    public String url;
    /// Anything.
    public Object userInfo;
    /// Request event listener.
    public RequestResponseListener listener;
    /// Second
    public int timeout = 30 * 1000;
    /// Set custom header.
    public ContentValues customHeaders = new ContentValues();


    /// Override if needs to change scheme.
    public RequestSetting addParam(String key, String value)
    {
        params.put(key, value);
        return this;
    }

    public RequestSetting addParam(String key, int value)
    {
        params.put(key, value);
        return this;
    }

    public RequestSetting addParam(String key, float value)
    {
        params.put(key, value);
        return this;
    }

    public RequestSetting addParams(ContentValues params)
    {
        this.params.putAll(params);
        return this;
    }

    public String getParamValue(String key)
    {
        return params.getAsString(key);
    }

    /**
     * @return If GET, return url with query parameter, if not, return url.
     */
    public String getFullUrl()
    {
        if (httpMethod == HttpMethod.GET) return getUrlWithQueryString();
        else                              return url;
    }

    /**
     * @return url with query parameter, if no parameter, return url.
     */
    public String getUrlWithQueryString()
    {
        if (params.size() == 0) return url;
        else                    return queryString(url + "?");
    }

    public boolean hasPostData()
    {
        return httpMethod != HttpMethod.GET && params.size() > 0;
    }

    /**
     * @return null if don't have.
     */
    public String getPostQueryString()
    {
        if      (httpMethod == HttpMethod.POST)       return postQueryString();
        else if (httpMethod == HttpMethod.POST_JSON)  return postQueryJsonString();
        else    return null;
    }

    public String postQueryString()
    {
        return queryString("");
    }

    public String postQueryJsonString()
    {
        JSONObject obj = new JSONObject();

        if (params.size() == 0) return obj.toString();

        try
        {
            for (String key : params.keySet())
            {
                obj.put(key, params.getAsString(key));
            }
        }
        catch (JSONException e) {
            e.printStackTrace();
        }

        return obj.toString();
    }

    public String queryString(String initialString)
    {
        ContentValues trimParams = adjustedParameter();

        if (trimParams == null)     trimParams = params;
        if (trimParams.size() == 0) return null;
        if (initialString == null)  initialString = "";

        StringBuilder sb = new StringBuilder(initialString);

        Iterator<String> i = trimParams.keySet().iterator();

        try
        {
            while (i.hasNext())
            {
                String key = i.next();
                sb.append(key)
                        .append("=")
                        .append(URLEncoder.encode(trimParams.getAsString(key), "UTF-8"));
                if (i.hasNext()) sb.append("&");
            }
        }
        catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return sb.toString();
    }



    /**
     *  This will be call before send request, form parameter at this method,
     *  You can add regular info needs to send at here.
     *
     *  If no, just return null or this.param.
     *
     *  @return   Formed parameter for request.
     */
    abstract protected ContentValues adjustedParameter();

    /**
     *  Will call when request method is POST_JSON.
     *
     * @return  Formed parameter in JSON.
     */
    abstract protected String postJsonString();

}
