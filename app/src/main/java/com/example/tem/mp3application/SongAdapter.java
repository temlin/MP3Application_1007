package com.example.tem.mp3application;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class SongAdapter extends BaseAdapter{
    LayoutInflater inflater;
    private List<Song> songs;

    public SongAdapter(Context c, List<Song>song){
        inflater=(LayoutInflater)c.getSystemService(c.LAYOUT_INFLATER_SERVICE);
        this.songs=song;
    }
   public int getCount(){
       return songs.size();
   }
    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Song song=(Song)getItem(i);
        view=inflater.inflate(R.layout.itemlist,null);
        TextView title=(TextView) view.findViewById(R.id.title);
        title.setText(song.getTitle());
        TextView album=(TextView)view.findViewById(R.id.album);
        album.setText(song.getAlbum());
        return view;
    }

}
