package in.co.go_bio.learn;


import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ViewAnimator;
import java.io.IOException;


public class LearnMainActivity extends FragmentActivity
{/*
int c;
    ImageView iview;
    ImageView img;
    ImageView grimg;
    Animation zoom_in, zoom_out,fadein, fadeout;
    MediaPlayer rooty;
    ViewAnimator viewAnimator;
    Thread t;
    ZoomInListener zoomInListener;
    ZoomOutListener zoomOutListener;
    AudioHandler h2;
    Hotspot[] hotspots;
    Growth[] growings;
    int animStat=0;
    int numOfHotspots,numOfgrows;
    int currentHotspot,currentGrow;
    ImageHandler imageHandler;
    int wrongclick = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_learn);
        imageHandler = new ImageHandler(this.get);
        iview = (ImageView) findViewById(R.id.imageView);
        img = (ImageView) findViewById(R.id.imageView3);
        grimg = (ImageView) findViewById(R.id.imageView2);
        fadein = AnimationUtils.loadAnimation(this, android.R.anim.fade_in);
        fadeout = AnimationUtils.loadAnimation(this, android.R.anim.fade_out);
        zoomInListener = new ZoomInListener(this);
        zoomOutListener = new ZoomOutListener(this);
        h2 = new AudioHandler(this);
        t = new Thread(h2);
        t.start();
        numOfHotspots = 5;
        currentHotspot = 0;
        numOfgrows = 2;
        currentGrow=0;
        *//*TODO: Get hotspots from server along with the image uri*//*
        hotspots = new Hotspot[numOfHotspots];
        hotspots[0] = new Hotspot(0.5f,0.5f,2000,R.drawable.root);
        hotspots[1] = new Hotspot(0.9f,0.9f,2000,R.drawable.leaf);
        hotspots[2] = new Hotspot(0.1f,0.1f,2000);
        hotspots[3] = new Hotspot(0.3f,0.6f,2000,R.drawable.leaf);
        hotspots[4] = new Hotspot(0.2f,0.4f,2000,R.drawable.root);
        growings = new  Growth[numOfgrows];
        growings[0]= new Growth(2000,R.drawable.root);
        //growings[1]= new Growth(2000,R.drawable.plant);
        growings[1]= new Growth(2000,R.drawable.leaf);

        *//*This hotspot's x and y coordinates will be fetched from server.*//*

        viewAnimator = (ViewAnimator)findViewById(R.id.viewAnimator);
        viewAnimator.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                ViewAnimator v2 = (ViewAnimator)v;
                currentGrow=0;
                currentHotspot=0;

                if(animStat == 0) {
                    h2.startaudio();
                    wrongclick = 0;
                    animStat = 1;
                    imageHandler.zoomIn(iview, hotspots[currentHotspot]);
                }

                else{
                    wrongclick = 1;
                    try{
                        h2.stopaudio();
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                    currentHotspot = 0;
                    animStat=0;
                    v2.getCurrentView().getAnimation().cancel();
                    v2.getCurrentView().getAnimation().reset();
                    v2.setDisplayedChild(0);
                }
            }
        });
    }

    @Override
    protected void onStop (){
        super.onStop();
        rooty.release();
        rooty = null;

    }
*/
}
