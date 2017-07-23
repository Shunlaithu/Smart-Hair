package com.forever.smarthair;

/**
 * Created by User on 7/16/2017.
 */

public class Facetype {
private int imageView;
    private String textView;

    public Facetype(){
    }
    public Facetype(int imageView,String textView) {
        this.imageView = imageView;
        this.textView = textView;
    }

    public int getImageView()
    {
        return imageView;
    }
    public void setImageView(int imageView)
    {
        this.imageView=imageView;
    }
    public  String getTextView()
    {
        return textView;
    }
    public  void setTextView(String textView)
    {
        this.textView=textView;
    }
}

