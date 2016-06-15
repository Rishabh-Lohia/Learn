package in.co.go_bio.learn;

import android.view.View;
import android.widget.ViewAnimator;

import java.io.IOException;

/**
 * Created by rishabh on 15/6/16.
 */
public class something implements Runnable {
    tab3 t;
    public something(tab3 t){
        this.t = t;
    }
    public void run(){
        t.viewAnimator = (ViewAnimator)t.v.findViewById(R.id.lrn_scr3_a);

        t.viewAnimator.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                ViewAnimator v2 = (ViewAnimator)v;
                t.currentGrow=0;
                t.currentHotspot=0;

                if(t.animStat == 0) {
                    t.h2.startaudio();
                    t.wrongclick = 0;
                    t.animStat = 1;
                    t.imageHandler.zoomIn(t.iview, t.hotspots[t.currentHotspot]);
                }

                else{
                    t.wrongclick = 1;
                    try{
                        t.h2.stopaudio();
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                    t.currentHotspot = 0;
                    t.animStat=0;
                    v2.getCurrentView().getAnimation().cancel();
                    v2.getCurrentView().getAnimation().reset();
                    v2.setDisplayedChild(0);
                }
            }
        });
    }
}
