package com.jhengweipan.MyAPI;

/**
 * Created by redjack on 15/9/15.
 */
public interface RequestResponseListener {

    /**
     * Will call after sent request.
     */
    public void requesting(RequestSetting setting);

    /**
     * Will call when request complete.
     */
    public void requestComplete(RequestSetting setting, String result);

    /**
     * Will call when request failed, like timeout or connection failed.
     */
    public void requestFault(RequestSetting setting);

    /**
     * Will call when all request event is finished, this method will execute at main thread.
     * You could do something need to rest at here.
     */
    public void requestDone(RequestSetting setting);

}