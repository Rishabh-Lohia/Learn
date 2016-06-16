package in.co.go_bio.learn;

/**
 * Created by sonal on 08-06-2016.
 */
import android.os.Bundle;
import android.support.annotation.Nullable;
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
    ImageView im, im2;
    Hotspot[] hotspots;
    int numOfHotspots;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v =inflater.inflate(R.layout.temporary,container,false);
        l = (LinearLayout)v.findViewById(R.id.iholdimage);
        im = (ImageView)v.findViewById(R.id.im);
        im2 = (ImageView)v.findViewById(R.id.im2);
        /* Hotspots and their number have to be fetched from the server.
        * */
        numOfHotspots = 3;
        hotspots = new Hotspot[numOfHotspots];
        hotspots[0] = new Hotspot(0.5f,0.9f,1000,R.drawable.root);
        hotspots[1] = new Hotspot(0.5f,0.1f,3000,R.drawable.leaf);
        hotspots[2] = new Hotspot(0.9f,0.5f,6000);

        l2 = new letstry(this);
        return v;
    }
}
