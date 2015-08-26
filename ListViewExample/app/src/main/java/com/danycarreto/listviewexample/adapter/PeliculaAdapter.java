package com.danycarreto.listviewexample.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.danycarreto.listviewexample.R;
import com.danycarreto.listviewexample.model.Pelicula;

import java.util.ArrayList;

/**
 * Created by DanyCarreto on 25/08/15.
 */
public class PeliculaAdapter extends BaseAdapter {
    private ArrayList<Pelicula> peliculas;
    private Activity activity;

    public PeliculaAdapter(Activity activity,ArrayList<Pelicula> peliculas) {
        this.activity = activity;
        this.peliculas = peliculas;
    }

    @Override
    public int getCount() {
        return peliculas.size();
    }

    @Override
    public Object getItem(int position) {
        return peliculas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public static class ViewHolder{
        TextView textViewTitulo;
        TextView textViewDirector;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder = new ViewHolder();
        LayoutInflater layoutInflater = activity.getLayoutInflater();
        final Pelicula pelicula = peliculas.get(position);
        convertView = layoutInflater.inflate(R.layout.list_view_pelicula,parent,false);

        viewHolder.textViewTitulo = (TextView) convertView.findViewById(R.id.textViewTitulo);
        viewHolder.textViewDirector = (TextView) convertView.findViewById(R.id.textViewDirector);

        viewHolder.textViewTitulo.setText(pelicula.getTitulo());
        viewHolder.textViewDirector.setText(pelicula.getDirector());

        return convertView;
    }
}
