package in.co.go_bio.learn;

import android.view.animation.Animation;

import java.io.IOException;

/**
 * Created by rishabh on 8/6/16.
 */
public class ZoomOutListener implements Animation.AnimationListener{
    private tab3 m;
    public ZoomOutListener(tab3 m){
        this.m = m;
    }
    @Override
    public void onAnimationStart(Animation animation) {}
    @Override
    public void onAnimationRepeat(Animation animation) {}
    @Override
    public void onAnimationEnd(Animation animation) {
        m.currentHotspot++;
        if(m.currentHotspot >= m.numOfHotspots) {
//            if (m.currentGrow == 0) {
//                m.animStat = 4;
//                //m.imageHandler.growtrans();
//            } else if(m.currentGrow >= m.numOfgrows){
                try {
                    m.h2.stopaudio();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                m.animStat = 0;
            //}
        }else{
            if(m.currentHotspot+1 < m.numOfHotspots)
            /*if (!(m.hotspots[m.currentHotspot+1].getImage_uri()==R.raw.boo3)){
                m.imageHandler.change_secondary(m.img);
            }*/
            m.imageHandler.zoomIn(m.iview,m.hotspots[m.currentHotspot]);
        }
    }

}