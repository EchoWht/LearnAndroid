package com.cnwante.wantedrink.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.cnwante.wantedrink.R;
import com.cnwante.wantedrink.model.Drink;

import java.util.List;

/**
 * Created by Administrator on 2016/7/30 0030.
 */
public class DrinkListAdatper extends BaseAdapter {
    private Context context;
    private List<Drink> drinkList;

    public DrinkListAdatper(Context context,List<Drink> drinkList) {
        this.context=context;
        this.drinkList = drinkList;
    }

    @Override
    public int getCount() {
        return drinkList.size();
    }

    @Override
    public Drink getItem(int position) {
        return drinkList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.iteam,null);
            TextView drinkname = (TextView) convertView.findViewById(R.id.drinkname);
            TextView price= (TextView) convertView.findViewById(R.id.price);
            ImageView pic= (ImageView) convertView.findViewById(R.id.pic);
            Drink drink=drinkList.get(position);
            drinkname.setText(drink.getDrinkName());
            price.setText(drink.getPrice());
        }
        return null;
    }
}
