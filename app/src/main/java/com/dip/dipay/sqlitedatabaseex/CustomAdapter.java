package com.dip.dipay.sqlitedatabaseex;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by webskitters on 4/7/18.
 */

public class CustomAdapter extends BaseAdapter {
    Context context;
    ArrayList<DataModel> data_models=new ArrayList<>();

    public CustomAdapter(Context context, ArrayList<DataModel> data_models) {
        this.context = context;
        this.data_models = data_models;
    }

    @Override
    public int getCount() {
        return data_models.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    private class ViewHolder {
        TextView txt_name,txt_add,txt_ph;
        TextView txt_id;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {  /*step 7*/
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        ViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.row_demo, null);
            holder = new ViewHolder();

            holder.txt_name=convertView.findViewById(R.id.txt_name);
            holder.txt_add=convertView.findViewById(R.id.txt_add);
            holder.txt_ph=convertView.findViewById(R.id.txt_ph);

            holder.txt_id=convertView.findViewById(R.id.txt_id);

            convertView.setTag(holder);
        }
        else{
            holder = (ViewHolder) convertView.getTag();
        }
        holder.txt_id.setText(String.valueOf(data_models.get(position).getId()));
        holder.txt_name.setText(data_models.get(position).getName());
        holder.txt_add.setText(data_models.get(position).getAdd());
        holder.txt_ph.setText(data_models.get(position).getPh());

        return convertView;
    }
}
