package in.co.go_bio.learn;

/**
 * Created by sonal on 08-06-2016.
 */
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ViewAnimator;

import java.io.IOException;

/**
 * Created by hp1 on 21-01-2015.
 */
public class tab3 extends Fragment {

    ImageView iview;
    ImageView img;
    ImageView grimg;
    Animation zoom_in, zoom_out,fadein, fadeout;
    MediaPlayer rooty;
    ViewAnimator viewAnimator;
    Thread t2, t;
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
    View v;


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v =inflater.inflate(R.layout.tab_3,container,false);
        imageHandler = new ImageHandler(this);
        iview = (ImageView) v.findViewById(R.id.imageView);
        img = (ImageView) v.findViewById(R.id.imageView3);
        grimg = (ImageView) v.findViewById(R.id.imageView2);
        fadein = AnimationUtils.loadAnimation(this.getContext(), android.R.anim.fade_in);
        fadeout = AnimationUtils.loadAnimation(this.getContext(), android.R.anim.fade_out);
        zoomInListener = new ZoomInListener(this);
        zoomOutListener = new ZoomOutListener(this);
        h2 = new AudioHandler(this);
        t = new Thread(h2);
        t.start();
        numOfHotspots = 5;
        currentHotspot = 0;
        numOfgrows = 0;
        currentGrow=0;
        /*TODO: Get hotspots from server along with the image uri*/
        hotspots = new Hotspot[numOfHotspots];
        hotspots[0] = new Hotspot(0.5f,0.5f,2000,R.drawable.root);
        hotspots[1] = new Hotspot(0.9f,0.9f,2000,R.drawable.leaf);
        hotspots[2] = new Hotspot(0.1f,0.1f,2000);
        hotspots[3] = new Hotspot(0.3f,0.6f,2000,R.drawable.leaf);
        hotspots[4] = new Hotspot(0.2f,0.4f,2000,R.drawable.root);
        //growings = new  Growth[numOfgrows];
        //growings[0]= new Growth(2000,R.drawable.root);
        //growings[1]= new Growth(2000,R.drawable.plant);
        //growings[1]= new Growth(2000,R.drawable.leaf);

        /*This hotspot's x and y coordinates will be fetched from server.*/
        something s = new something(this);
        t2 = new Thread(s);
        t2.start();
        return v;
    }
}
