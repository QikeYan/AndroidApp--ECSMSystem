package com.test.myapplication.dao;

import android.content.Context;

import com.test.myapplication.util.NetCallBack;
import com.test.myapplication.util.URLS;

import net.tsz.afinal.FinalHttp;
import net.tsz.afinal.http.AjaxCallBack;
import net.tsz.afinal.http.AjaxParams;

/**
 * Created by apple on 2017/3/29.
 */

public class LoginDao {
    public void sendUserinfo(Context context, String username,String password, final NetCallBack netCallBack){

        AjaxParams params = new AjaxParams();
        params.put("username", username);
        params.put("password",password);
        FinalHttp fh = new FinalHttp();
        fh.post(URLS.URL_LOGIN, params, new AjaxCallBack<Object>() {
            @Override
            public void onSuccess(Object o) {
                super.onSuccess(o);
                if (netCallBack!=null) {
                    netCallBack.onSuccess(o.toString());
                }
            }

            @Override
            public void onFailure(Throwable t, int errorNo, String strMsg) {
                super.onFailure(t, errorNo, strMsg);
                if (netCallBack!=null)
                    netCallBack.onFail(strMsg);
            }
        });

    }
}
