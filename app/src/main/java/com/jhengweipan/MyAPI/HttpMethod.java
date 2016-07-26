package com.jhengweipan.MyAPI;

import android.content.ContentValues;

/**
 * Created by redjack on 15/9/15.
 */
public enum HttpMethod {

    GET,
    POST,
    POST_JSON;

    public static String[] METHOD_NAME = new String[] {
            "GET",
            "POST",
            "POST"
    };

    public static String[][] METHON_HEADER_ACCEPT = {
            {"Accept", "text/plain"},
            {"Accept", "text/plain"},
            {"Accept", "application/json"},
    };

    public static String[][] METHOD_HEADER_CONTENT = {
            {"Content-type", "text/html"},
            {"Content-type", "application/x-www-form-urlencoded"},
            {"Content-type", "application/json"},
    };

    public String getMethodName() {
        return METHOD_NAME[this.ordinal()];
    }

    public ContentValues getHeaderValue()
    {
        String[] accept = METHON_HEADER_ACCEPT[this.ordinal()];
        String[] content = METHOD_HEADER_CONTENT[this.ordinal()];

        ContentValues header = new ContentValues();
        header.put(accept[0], accept[1]);
        header.put(content[0], content[1]);

        return header;
    }

    public String[] getMethodHeaderAccept() {
        return METHON_HEADER_ACCEPT[this.ordinal()];
    }

    public String[] getMethodHeaderContent() {
        return METHOD_HEADER_CONTENT[this.ordinal()];
    }
}
