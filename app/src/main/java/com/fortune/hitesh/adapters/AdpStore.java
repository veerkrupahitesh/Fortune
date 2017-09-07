package com.fortune.hitesh.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.fortune.hitesh.R;

import java.util.List;

/**
 * Created by ABC on 9/7/2017.
 */

public class AdpStore extends BaseAdapter {

    private List<String> storeNameList;
    private Context context;

    AdpStore(Context context,List<String> storeNameList){
        this.context=context;
        this.storeNameList=storeNameList;
    }

    @Override
    public int getCount() {
        return storeNameList.size();
    }

    @Override
    public Object getItem(int position) {
        return storeNameList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {



        return null;

    }

    public class ViewHolder{
        private TextView txvSelectStore;
        ViewHolder(View view){
            txvSelectStore=(TextView)view.findViewById(R.id.txtStoreName);
        }
    }
}
