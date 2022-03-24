package com.choubapp.muslimapp;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

//import com.google.android.gms.ads.AdListener;
//import com.google.android.gms.ads.AdRequest;
//import com.google.android.gms.ads.AdView;

import java.util.ArrayList;

public class AdhanDikrActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    LinearLayout content;
//    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SharedPreferences prefs = getSharedPreferences(MainActivity.THEME_KEY,0);
        int thm=AboutUs.getCurrentTheme(prefs);
        AboutUs.setCurrentTheme(this, thm);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adhan_dikr);

        content=findViewById(R.id.contentlayout);
        //load AD
//        mAdView = findViewById(R.id.adVieww);
//        AdRequest adRequest = new AdRequest.Builder()
//                .build();
//        mAdView.loadAd(adRequest);
//        mAdView.setAdListener(new AdListener() {
//            @Override
//            public void onAdLoaded() {
//                // Code to be executed when an ad finishes loading.
//                Resources r = getResources();
//                int px = (int) TypedValue.applyDimension(
//                        TypedValue.COMPLEX_UNIT_DIP,
//                        50,
//                        r.getDisplayMetrics()
//                );
//                RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
//                        RelativeLayout.LayoutParams.WRAP_CONTENT,
//                        RelativeLayout.LayoutParams.WRAP_CONTENT
//                );
//                content.setLayoutParams(params);
//                params.setMargins(0, px, 0, px);
//            }
//        });

        ArrayList<Fadl> AdhanDikrList = new ArrayList<>();
        AdhanDikrList.add(new Fadl(getString(R.string.adhan1), getString(R.string.adhan1e)));
        AdhanDikrList.add(new Fadl(getString(R.string.adhan2), getString(R.string.adhan2e)));
        AdhanDikrList.add(new Fadl(getString(R.string.adhan3), getString(R.string.adhan3e)));
        AdhanDikrList.add(new Fadl(getString(R.string.adhan4), getString(R.string.adhan4e)));
        AdhanDikrList.add(new Fadl(getString(R.string.adhan5), getString(R.string.adhan5e)));
        AdhanDikrList.add(new Fadl(getString(R.string.adhan6), getString(R.string.adhan6e)));

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new FadlAdapter(AdhanDikrList);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }
}
