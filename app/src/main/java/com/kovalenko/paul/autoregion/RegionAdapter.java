package com.kovalenko.paul.autoregion;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Pashulya on 17.05.2016.
 */
public class RegionAdapter extends BaseAdapter {
    Context ctx;
    LayoutInflater layoutInflater;
    String[] regs;
    int[] imgRegs;

    RegionAdapter(Context context, String[] regions, int[] imgRegions){
        ctx = context;
        regs = regions;
        imgRegs = imgRegions;
        layoutInflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return regs.length;
    }

    @Override
    public Object getItem(int position) {
        return regs[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null)
            view = layoutInflater.inflate(R.layout.item, parent, false);

        String reg = regs[position];
        int imgreg = imgRegs[position];

        ((TextView) view.findViewById(R.id.textView1)).setText(reg);
        ((ImageView) view.findViewById(R.id.ivImage)).setImageResource(imgreg);
        return view;
    }
}
