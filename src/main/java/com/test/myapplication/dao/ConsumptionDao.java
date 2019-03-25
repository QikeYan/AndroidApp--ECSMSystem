package com.test.myapplication.dao;

import android.content.Context;

import com.test.myapplication.bean.ConsumptionBean;
import com.test.myapplication.util.NetCallBack;
import com.test.myapplication.util.URLS;

import net.tsz.afinal.FinalHttp;
import net.tsz.afinal.http.AjaxCallBack;
import net.tsz.afinal.http.AjaxParams;

/**
 * Created by apple on 2017/3/16.
 */

public class ConsumptionDao {

    public ConsumptionBean getConsumption(Context context, String id, final NetCallBack netCallBack){
        ConsumptionBean consumptionBean=new ConsumptionBean();
        AjaxParams params = new AjaxParams();
        params.put("id", id);
        FinalHttp fh = new FinalHttp();
        fh.post(URLS.URL_CONSHOW, params, new AjaxCallBack<Object>() {
            @Override
            public void onSuccess(Object o) {
                super.onSuccess(o);
                if (netCallBack!=null)
                    netCallBack.onSuccess(o.toString());
            }

            @Override
            public void onFailure(Throwable t, int errorNo, String strMsg) {
                super.onFailure(t, errorNo, strMsg);
                if (netCallBack!=null)
                    netCallBack.onFail(strMsg);
            }
        });
        return consumptionBean;
    }
}
