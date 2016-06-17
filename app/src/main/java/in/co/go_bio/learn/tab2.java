package in.co.go_bio.learn;

/**
 * Created by sonal on 08-06-2016.
 */
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.percent.PercentRelativeLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by hp1 on 21-01-2015.
 */
public class tab2 extends Fragment {
    letstry l2;
    View v;
    LinearLayout l;
    ImageView im, im2, im3, im4, im5, im6;
    Hotspot[] hotspots;
    MediaPlayer rooty;
    AudioHandler h2;
    int[] icons;
    int noOfIcons;
    int curr_icon;
    int numOfHotspots;
    Thread t;
    PercentRelativeLayout pl;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v =inflater.inflate(R.layout.temporary,container,false);
        pl = (PercentRelativeLayout)v.findViewById(R.id.percent);
        l = (LinearLayout)v.findViewById(R.id.iholdimage);
        im = (ImageView)v.findViewById(R.id.im);
        im2 = (ImageView)v.findViewById(R.id.im2);
        im3 = (ImageView)v.findViewById(R.id.icon1);
        //im4 = (ImageView)v.findViewById(R.id.icon2);
        im5 = (ImageView)v.findViewById(R.id.icon3);
        //im6 = (ImageView)v.findViewById(R.id.icon4);
        h2 = new AudioHandler(this);
        curr_icon = 0;
        noOfIcons = 4;
        icons = new int[noOfIcons];
        icons[0] = R.drawable.sun;
        icons[1] = R.drawable.flower;
        icons[2] = R.drawable.fertiliser;
        icons[3] = R.drawable.water;
        t = new Thread(h2);
        t.start();
        /* Hotspots and their number have to be fetched from the server.
        * */
        numOfHotspots = 5;
        hotspots = new Hotspot[numOfHotspots];
        hotspots[0] = new Hotspot(0.5f,0.9f,5000,R.drawable.root);
        hotspots[1] = new Hotspot(0.5f,0.1f,5000,R.drawable.leaf);
        hotspots[2] = new Hotspot(0.9f,0.5f,5000);
        hotspots[3] = new Hotspot(0.1f, 0.1f, 5000, R.drawable.root);
        hotspots[4] = new Hotspot(0.1f, 0.7f, 5000);

        l2 = new letstry(this);
        return v;
    }
}
