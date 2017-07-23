package com.forever.smarthair;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 7/17/2017.
 */

public class BoyFaceShpeType extends AppCompatActivity {
    FaceTypeAdapter faceTypeAdapter;
    private RecyclerView rvFaceTypeList;
    private List<Facetype> facetypess = new ArrayList<>();

    int[] boy={R.drawable.ovalb,R.drawable.broung,R.drawable.diamondb,R.drawable.squareb,R.drawable.ovalb,R.drawable.ovalb,R.drawable.ovalb};

    public static Intent newIntent(Context context, String key) {
        Intent intent = new Intent(context, BoyFaceShpeType.class);
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
            public void onClick(View view, int position){
                Facetype facetype=facetypess.get(position);
               switch (facetype)
               {
                   case 0:
                     Intent intent = new Intent(BoyFaceShpeType.this,Oblonggirl.class);
                       this.startActivity(intent);
               }
            }



            public void onLongClick(View view,int position){




            }
        }));*/
        Facetypeaction();

    }
    private void Facetypeaction(){
        Facetype facetype=new Facetype(boy[0],"Oblong");
        facetypess.add(facetype);
        facetype=new Facetype(boy[1],"Diamond");
        facetypess.add(facetype);
        facetype=new Facetype(boy[2],"Heart");
        facetypess.add(facetype);
        facetype=new Facetype(boy[3],"Oval");
        facetypess.add(facetype);
        facetype=new Facetype(boy[4],"Pear");
        facetypess.add(facetype);
        facetype=new Facetype(boy[5],"Round");
        facetypess.add(facetype);
        facetype=new Facetype(boy[6],"Square");
        facetypess.add(facetype);
        facetype=new Facetype(boy[7],"Triangular");
        facetypess.add(facetype);

        faceTypeAdapter.notifyDataSetChanged();
    }

}

