package com.forever.smarthair;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by User on 7/17/2017.
 */

public class RecyclerTouchListener implements RecyclerView.OnItemTouchListener{
    private GestureDetector gestureDetector;
    private ClickListener clickListener;
    public RecyclerTouchListener(Context context,final RecyclerView recyclerView,final ClickListener clickListener){
        this.clickListener=clickListener;
        gestureDetector=new GestureDetector(context,new GestureDetector.SimpleOnGestureListener(){
            public boolean onSingleTapUp(MotionEvent event){
                return true;
            }
            public void onLongPress(MotionEvent event){
                View child=recyclerView.findChildViewUnder(event.getX(), event.getY());
                if(child!=null && clickListener!=null){
                    clickListener.onLongClick(child,recyclerView.getChildPosition(child));
                }
            }
        });
    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        View child=rv.findChildViewUnder(e.getX(),e.getY());
        if(child!=null && clickListener!=null && gestureDetector.onTouchEvent( e)){
            clickListener.onClick(child,rv.getChildPosition(child));
        }
        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }
    public interface ClickListener{
        void onClick(View view,int position);
        void onLongClick(View view,int position);

        void startActivity(Intent intent);
    }
}
