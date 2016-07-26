package com.jhengweipan.MyAPI;

import android.content.ContentValues;

/**
 * Created by redjack on 15/9/22.
 */
public class URApiSetting extends RequestSetting {

    public static String KEY_DEVICE_ID = "device_id";
    public URApiType rType;

    public URApiSetting(String host, HttpMethod httpMethod, URApiType type) {

        this.url = host + type.method;
        this.httpMethod = httpMethod;
        this.type = type.type;
        this.rType = type;
    }

    public URApiSetting(String host, HttpMethod httpMethod, int type) {

        this.url = host;
        this.httpMethod = httpMethod;
        this.type = type;
    }

    @Override
    protected ContentValues adjustedParameter() {

        addParam(KEY_DEVICE_ID, URApiInfo.ANDROID_ID);
        return null;
    }

    @Override
    protected String postJsonString() {
        return null;
    }
}
