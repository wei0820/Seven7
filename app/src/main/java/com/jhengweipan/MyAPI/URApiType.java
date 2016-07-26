package com.jhengweipan.MyAPI;

/**
 * Created by redjack on 15/9/22.
 *
 * This class simulate enum class.
 *
 * Just for convenient to storage request type and method name.
 *
 * You can declare static member as type:
 *
 * static RequestType DOWNLOAD = new RequestType(0, "Download");
 *
 * So that you can compare type
 *
 */
public abstract class URApiType {

    public int type = 0;
    public String method = "";

    public URApiType(int type, String method) {
        this.type = type;
        this.method = method;
    }
}
