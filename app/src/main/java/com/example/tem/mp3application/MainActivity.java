package com.example.tem.mp3application;

import android.content.ContentResolver;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    private ListView musicList;
    private SeekBar seekBar;
    private Button btnPlay,btnStop,btnPrev,btnNext,txtTotal;
    private LinkedList<Song>songList;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }
    private void initView(){
        musicList=(ListView) findViewById(R.id.musicList);
        seekBar=(SeekBar)findViewById(R.id.seekBar);
        btnPlay=(Button) findViewById(R.id.playbtn);
        btnStop=(Button) findViewById(R.id.stopbtn);
        btnPrev=(Button) findViewById(R.id.prevbtn);
        btnNext=(Button) findViewById(R.id.nextbtn);
    }
    private void getMusics(){
        songList=new LinkedList<Song>();
        ContentResolver contentResolver=getContentResolver();
        Uri uri= MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        Cursor cursor=contentResolver.query(uri,null,null,null,null);
        if(cursor==null){
            Log.d("==>","inquery mistake");
        }else if(!cursor.moveToFirst()){
            Log.d("==>","without media file");
        }else{
            int titleColumn=cursor.getColumnIndex(MediaStore.Audio.Media.TITLE);
            int idColumn=cursor.getColumnIndex(MediaStore.Audio.Media._ID);
            int albumColumn=cursor.getColumnIndex(MediaStore.Audio.Media.ALBUM);
            do{
                long thisId=cursor.getLong(idColumn);
                String thisTitle=cursor.getString(titleColumn);
                String thisAlbum=cursor.getString(albumColumn);
                Log.d("=======>", "id: " + thisId + ", title: " + thisTitle);
                songList.add(new Song(thisId,thisTitle,thisAlbum));
            }while(cursor.moveToNext());
            SongAdapter adapter=new SongAdapter(MainActivity.this,songList);
            musicList.setAdapter(adapter);
            txtTotal.setText("Total"+songList.size()+"song");
        }
    }
}
