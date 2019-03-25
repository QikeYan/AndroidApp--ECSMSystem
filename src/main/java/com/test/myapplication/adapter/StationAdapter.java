package com.test.myapplication.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.test.myapplication.R;
import com.test.myapplication.bean.StationBean;

import java.util.List;

/**
 * Created by apple on 2017/3/7.
 */

public class StationAdapter extends RecyclerView.Adapter implements View.OnClickListener{
    private Context context;
    private List<StationBean> list;
    private OnClickItimListener onClickItimListener;

    public interface OnClickItimListener {
        void OnClickItim(View view, Object data);
    }

    public void setOnClickItimListener(OnClickItimListener onClickItimListener) {
        this.onClickItimListener = onClickItimListener;
    }

    private void init() {
        StationBean stationBean = new StationBean();
        stationBean.setNumber("A");
        stationBean.setName("Station   Consumption");
        StationBean stationBean1 = new StationBean();
        stationBean1.setNumber("B");
        stationBean1.setName("Station   Consumption");
        StationBean stationBean2 = new StationBean();
        stationBean2.setNumber("C");
        stationBean2.setName("Station   Consumption");
        StationBean stationBean3 = new StationBean();
        stationBean3.setNumber("D");
        stationBean3.setName("Station   Consumption");
        StationBean stationBean4 = new StationBean();
        stationBean4.setNumber("E");
        stationBean4.setName("Station   Consumption");
        StationBean stationBean5 = new StationBean();
        stationBean5.setNumber("F");
        stationBean5.setName("Station   Consumption");
//        StationBean stationBean6=new StationBean();
//        stationBean6.setNumber("G");
//        stationBean6.setName("Station Cousumption");
//        StationBean stationBean7=new StationBean();
//        stationBean7.setNumber("H");
//        stationBean7.setName("Station Cousumption");
//        StationBean stationBean8=new StationBean();
//        stationBean8.setNumber("I");
//        stationBean8.setName("Station Cousumption");
//        StationBean stationBean9=new StationBean();
//        stationBean9.setNumber("G");
//        stationBean9.setName("Station Cousumption");
//        StationBean stationBean10=new StationBean();
//        stationBean10.setNumber("K");
//        stationBean10.setName("Station Cousumption");
//        StationBean stationBean11=new StationBean();
//        stationBean11.setNumber("L");
//        stationBean11.setName("Station Cousumption");
//        StationBean stationBean12=new StationBean();
//        stationBean12.setNumber("M");
//        stationBean12.setName("Station Cousumption");
//        StationBean stationBean13=new StationBean();
//        stationBean13.setNumber("N");
//        stationBean13.setName("Station Cousumption");
//        StationBean stationBean14=new StationBean();
//        stationBean14.setNumber("O");
//        stationBean14.setName("Station Cousumption");
//        StationBean stationBean15=new StationBean();
//        stationBean15.setNumber("P");
//        stationBean15.setName("Station Cousumption");
        if (list != null) {
            list.add(stationBean);
            list.add(stationBean1);
            list.add(stationBean2);
            list.add(stationBean3);
            list.add(stationBean4);
            list.add(stationBean5);
//            list.add(stationBean6);
//            list.add(stationBean7);
//            list.add(stationBean8);
//            list.add(stationBean9);
//            list.add(stationBean10);
//            list.add(stationBean11);
//            list.add(stationBean12);
//            list.add(stationBean13);
//            list.add(stationBean14);
//            list.add(stationBean15);
        }
    }
//StationAdapter constructer ?????????????????????
    public StationAdapter(Context context, List<StationBean> list) {
        this.context = context;
        this.list = list;
        init();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.station_list_item, null);
        view.setOnClickListener(this);
        return new StationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        StationViewHolder stationViewHolder = (StationViewHolder) holder;
        holder.itemView.setTag(list.get(position));
        stationViewHolder.text_num.setText(list.get(position).getNumber());//assign value
//        stationViewHolder.text_num.setVisibility(View.VISIBLE);
//        stationViewHolder.text_num.setVisibility(View.INVISIBLE);
//        stationViewHolder.text_num.setVisibility(View.GONE);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    private class StationViewHolder extends RecyclerView.ViewHolder  {
        private TextView text_num;
        public StationViewHolder(View itemView) {
            super(itemView);
            text_num = (TextView) itemView.findViewById(R.id.text_num);
        }
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.rel_itme:
                if (onClickItimListener!=null){
                    this.onClickItimListener.OnClickItim(view,view.getTag());
                }
                break;
        }
    }
}
