package com.test.myapplication.dao;

import android.content.Context;
import android.widget.Toast;

import com.test.myapplication.bean.DetailsBean;
import com.test.myapplication.util.NetCallBack;
import com.test.myapplication.util.URLS;

import net.tsz.afinal.FinalHttp;
import net.tsz.afinal.http.AjaxCallBack;
import net.tsz.afinal.http.AjaxParams;

/**
 * Created by apple on 2017/3/20.
 */

public class DetailsDao {
    public DetailsBean getDetails(Context context, String stationid, final NetCallBack netCallBack){
        DetailsBean detailsBean=new DetailsBean();
        AjaxParams params = new AjaxParams();
        params.put("stationid", stationid);
        Toast.makeText(context, "stationid++"+stationid,Toast.LENGTH_LONG).show();

        FinalHttp fh = new FinalHttp();
        fh.post(URLS.URL_DETAILSHOW, params, new AjaxCallBack<Object>() {
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
        return detailsBean;
    }
}
