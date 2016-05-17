package com.kovalenko.paul.autoregion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    RegionAdapter regionAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] regions = {
                "Автономна республіка Крим", "Вінницька область", "Волинська область",
                "Дніпропетровська область", "Донецька область", "Житомирська область",
                "Закарпатська область", "Запорізька область", "Івано-Франківська область",
                "Київська область", "Кіровоградська область", "Луганська область",
                "Львівська область", "Миколаївська область", "Одеська область",
                "Полтавська область", "Рівненська область", "Сумська область",
                "Тернопільська область", "Харківська область", "Херсонська область",
                "Хмельницька область", "Черкаська область", "Чернігівська область",
                "Чернівецька область", "місто Київ", "місто Севастополь"
        };


        int[] regionsImageArray = new int[] {
                R.drawable.ak, R.drawable.ab, R.drawable.ac, R.drawable.ae, R.drawable.ah,
                R.drawable.am, R.drawable.ao, R.drawable.ap, R.drawable.at, R.drawable.ai,
                R.drawable.ba, R.drawable.bb, R.drawable.bc, R.drawable.be, R.drawable.bh,
                R.drawable.bi, R.drawable.bk, R.drawable.bm, R.drawable.bo, R.drawable.ax,
                R.drawable.bt, R.drawable.bx, R.drawable.ca, R.drawable.cb, R.drawable.ce,
                R.drawable.aa, R.drawable.ch
        };

        regionAdapter = new RegionAdapter(this, regions, regionsImageArray);

        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(regionAdapter);
//        listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
//                regions));
    }
}
