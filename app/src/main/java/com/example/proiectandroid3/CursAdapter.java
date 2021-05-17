package com.example.proiectandroid3;

import android.content.Context;
import android.media.Image;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
public class CursAdapter extends BaseAdapter { List<Curs> list = new ArrayList<Curs>();
    private LayoutInflater li=null;
    private Context context;

    public CursAdapter(List<Curs> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return  list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        li=LayoutInflater.from(context);
        View v = li.inflate(R.layout.afisare_categorii,parent,false);
        Curs u = (Curs) getItem(position);

        TextView tvNume;
        tvNume=v.findViewById(R.id.nume_categorie);
        tvNume.setText(u.getNume_curs());

        ImageView img;
        img= v.findViewById(R.id.imagine_categorie);
        img.setImageResource(u.getImagine_curs());
        return v;
    }
}