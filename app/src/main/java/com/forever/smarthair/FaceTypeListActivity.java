package com.forever.smarthair;

import android.content.Context;
import android.content.Intent;
import android.graphics.Movie;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class FaceTypeListActivity extends AppCompatActivity {
FaceTypeAdapter faceTypeAdapter;
    private RecyclerView rvFaceTypeList;
    private List<Facetype> facetypess = new ArrayList<>();

    int[] girl={R.drawable.gdiamond,R.drawable.gheart,R.drawable.glong,R.drawable.goval,R.drawable.gcircle,R.drawable.gsquare};

    public static Intent newIntent(Context context, String key) {
        Intent intent = new Intent(context, FaceTypeListActivity.class);
        intent.putExtra("key", key);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_face_type_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        rvFaceTypeList = (RecyclerView) findViewById(R.id.rv_face_type_list);
        faceTypeAdapter = new FaceTypeAdapter(facetypess);
              rvFaceTypeList.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        rvFaceTypeList.setLayoutManager(layoutManager);
        rvFaceTypeList.setItemAnimator(new DefaultItemAnimator());

        rvFaceTypeList.setAdapter(faceTypeAdapter);
        /*rvFaceTypeList.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(),rvFaceTypeList,new RecyclerTouchListener.ClickListener(){
            public void onClick(View view,int position){
                Facetype facetype=facetypess.get(position);
                switch (position)
                {
                    case 0:
                        Intent intent = new Intent(FaceTypeListActivity.this,Oblonggirl.class);
                        this.startActivity(intent);
                        break;

                    case 1:
                        Intent intent1 = new Intent(FaceTypeListActivity.this,Diamondgirl.class);
                        this.startActivity(intent1);
                        break;

                    case 2:
                        Intent intent2 = new Intent(FaceTypeListActivity.this,Heartgirl.class);
                        this.startActivity(intent2);
                        break;

                    case 3:
                        Intent intent3 = new Intent(FaceTypeListActivity.this,Ovalgirl.class);
                        this.startActivity(intent3);
                        break;

                    case 4:
                        Intent intent4 = new Intent(FaceTypeListActivity.this,Roundgirl.class);
                        this.startActivity(intent4);
                        break;

                    case 5:
                        Intent intent5 = new Intent(FaceTypeListActivity.this,Squaregirl.class);
                        this.startActivity(intent5);
                        break;


                }

            }
            public void onLongClick(View view,int position){

            }
        }));*/
        Facetypeaction();

    }
    //faceTypeAction
    private void Facetypeaction(){
        Facetype facetype=new Facetype(girl[0],"Oblong");
        facetypess.add(facetype);
        facetype=new Facetype(girl[1],"Diamond");
        facetypess.add(facetype);
        facetype=new Facetype(girl[2],"Heart");
        facetypess.add(facetype);
        facetype=new Facetype(girl[3],"Oval");
        facetypess.add(facetype);
        facetype=new Facetype(girl[4],"Round");
        facetypess.add(facetype);
        facetype=new Facetype(girl[5],"Square");
        facetypess.add(facetype);

        faceTypeAdapter.notifyDataSetChanged();
    }

}
