package com.kovalenko.paul.autoregion;

import android.app.Activity;
import android.content.Context;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    DB db;
    RegionAdapter regionAdapter;

    //SIMPLE CURSOR

//    SimpleCursorAdapter scAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // открываем подключение к БД
        db = new DB(this);
        db.open();

        Cursor crs = db.getAllData();

//        List<String, Integer, Integer> RegionList = new ArrayList<>();
        final String[] regionNames = new String[crs.getCount()];
        final int[] regionImgLogo = new int[crs.getCount()];
        final int[] regionImgMap = new int[crs.getCount()];

        int i = 0;

        while (crs.moveToNext()){
            regionNames[i] = crs.getString(crs.getColumnIndex("region"));
            regionImgLogo[i] = crs.getInt(crs.getColumnIndex("imgReg"));
            regionImgMap[i] = crs.getInt(crs.getColumnIndex("imgMap"));
            i++;
        }

        //ARRAYS WITH FIELDS AND VIEWS

//        String[] from = new String[] { DB.COLUMN_REGION, DB.COLUMN_IMG_LOGO };
//        int[] to = new int[] { R.id.textView1, R.id.ivImage };

        //CURSOR LOADER SET ADAPTER

//        scAdapter = new SimpleCursorAdapter(this, R.layout.item, null, from, to, 0);
//        ListView listView = (ListView) findViewById(R.id.listView);
//        listView.setAdapter(scAdapter);


        //ARRAYS WITH NAMES OF REGIONS AND IMGS

//        final String[] regions = {
//                "Автономна республіка Крим", "Вінницька область", "Волинська область",
//                "Дніпропетровська область", "Донецька область", "Житомирська область",
//                "Закарпатська область", "Запорізька область", "Івано-Франківська область",
//                "Київська область", "Кіровоградська область", "Луганська область",
//                "Львівська область", "Миколаївська область", "Одеська область",
//                "Полтавська область", "Рівненська область", "Сумська область",
//                "Тернопільська область", "Харківська область", "Херсонська область",
//                "Хмельницька область", "Черкаська область", "Чернігівська область",
//                "Чернівецька область", "місто Київ", "місто Севастополь"
//        };
//
//
//        final int[] regionsImageArray = new int[] {
//                R.drawable.ak, R.drawable.ab, R.drawable.ac, R.drawable.ae, R.drawable.ah,
//                R.drawable.am, R.drawable.ao, R.drawable.ap, R.drawable.at, R.drawable.ai,
//                R.drawable.ba, R.drawable.bb, R.drawable.bc, R.drawable.be, R.drawable.bh,
//                R.drawable.bi, R.drawable.bk, R.drawable.bm, R.drawable.bo, R.drawable.ax,
//                R.drawable.bt, R.drawable.bx, R.drawable.ca, R.drawable.cb, R.drawable.ce,
//                R.drawable.aa, R.drawable.ch
//        };
//
//        final int[] regionsMapArray = new int[] {
//                R.drawable.crimea, R.drawable.vinnytsia, R.drawable.volyn,
//                R.drawable.dnipropetrovsk, R.drawable.donetsk, R.drawable.zhytomyr,
//                R.drawable.zakarpattia, R.drawable.zaporizhia, R.drawable.ivanofrankivsk,
//                R.drawable.kievska, R.drawable.kirovohrad, R.drawable.luhansk, R.drawable.lviv,
//                R.drawable.mykolaiv, R.drawable.odessa, R.drawable.poltava, R.drawable.rivne,
//                R.drawable.sumy, R.drawable.ternopil, R.drawable.kharkiv, R.drawable.kherson,
//                R.drawable.khmelnytskyi, R.drawable.cherkasy, R.drawable.chernihiv,
//                R.drawable.chernivtsi, R.drawable.kyiv, R.drawable.sevastopol
//        };

        //CUSTOM ADAPTER CALL

          regionAdapter = new RegionAdapter(this, regionNames, regionImgLogo);

        //SETTING ADAPTER ON LISTVIEW
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(regionAdapter);

        // создаем лоадер для чтения данных
//        getSupportLoaderManager().initLoader(0, null, this);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //CALLING REGION ACTIVITY
                Intent intent = new Intent(MainActivity.this, RegionMapActivity.class);
                intent.putExtra("regionName", regionNames[position]);
                intent.putExtra("regionMap", regionImgMap[position]);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });


    }

    //CURSOR LOADER ON DESTROY
//    protected void onDestroy() {
//        super.onDestroy();
//        // закрываем подключение при выходе
//        db.close();
//    }

}
