package com.forever.smarthair;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment implements View.OnClickListener {

    private Button b1, b2;


    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main, container, false);
        b1= (Button) view.findViewById(R.id.btngirl);
        b1.setOnClickListener(this);
        b2= (Button) view.findViewById(R.id.btnboy);
        b2.setOnClickListener(this);
        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        Intent intent;
        switch (id) {
            case R.id.btngirl:
                intent = FaceTypeListActivity.newIntent(getContext(), "girl");
                break;
            case R.id.btnboy:
                intent = FaceTypeListActivity.newIntent(getContext(), "boy");
                break;
            default:
                intent = null;
        }
        startActivity(intent);
    }
}
