package com.test.myapplication.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.test.myapplication.R;
import com.test.myapplication.activity.OverViewActivity1;
import com.test.myapplication.bean.DetailsBean;

import java.util.List;

import static com.test.myapplication.R.id.chargingpileid;
import static com.test.myapplication.R.id.img_go;
import static com.test.myapplication.R.id.textbatterytype;
import static com.test.myapplication.R.id.textchargingtimes;
import static com.test.myapplication.R.id.textequipmentstate;
import static com.test.myapplication.R.id.textnoimalvotage;

/**
 * Created by apple on 2017/3/20.
 */

public class DetailsAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<DetailsBean> list;
    private String judge = "Usable";

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_station_details_item, null);
//             view.setOnClickListener((View.OnClickListener) this);
        return new DetailsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        DetailsViewHolder detailsViewHolder = (DetailsViewHolder) holder;
        holder.itemView.setTag(list.get(position));
        detailsViewHolder.Chargingpileid.setText(list.get(position).getEquipment_id());
        detailsViewHolder.Textbatterytype.setText(list.get(position).getBattery_type());
        detailsViewHolder.Textnoimalvotage.setText(list.get(position).getNomial_voltage());
        detailsViewHolder.Textequipmentstate.setText(list.get(position).getState());
        detailsViewHolder.Textchargingtimes.setText(list.get(position).getCharging_times());
        if (detailsViewHolder.Textequipmentstate.getText().equals(judge)) {
            detailsViewHolder.Img_go.setVisibility(View.VISIBLE);
            detailsViewHolder.Img_go.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(context, OverViewActivity1.class);
                    intent.putExtra("id",list.get(position).getEquipment_id());
                    context.startActivity(intent);
                }
            });
        } else {
            detailsViewHolder.Img_go.setVisibility(View.GONE);
        }
    }

    private class DetailsViewHolder extends RecyclerView.ViewHolder {
        private TextView Chargingpileid, Textbatterytype, Textnoimalvotage, Textequipmentstate, Textchargingtimes;
        private ImageView Img_go;

        public DetailsViewHolder(View itemView) {
            super(itemView);
            Chargingpileid = (TextView) itemView.findViewById(chargingpileid);
            Textbatterytype = (TextView) itemView.findViewById(textbatterytype);
            Textnoimalvotage = (TextView) itemView.findViewById(textnoimalvotage);
            Textequipmentstate = (TextView) itemView.findViewById(textequipmentstate);
            Textchargingtimes = (TextView) itemView.findViewById(textchargingtimes);
            Img_go = (ImageView) itemView.findViewById(img_go);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public DetailsAdapter(Context context, List<DetailsBean> list) {
        this.context = context;
        this.list = list;

    }
}
