package in.co.go_bio.learn;

import android.os.CountDownTimer;
import android.os.Handler;
import android.view.animation.Animation;


public class ZoomInListener implements  Animation.AnimationListener {

    tab3 m;
    CountDownTimer c1;
    public ZoomInListener(tab3 m){
        this.m=m;
    }
    Handler hand2;
    @Override
    public void onAnimationRepeat(Animation a){
    }
    @Override
    public void onAnimationStart(Animation a){
        /*m.animStat=1;
        if(!(m.hotspots[(m.currentHotspot)].getImage_uri()==R.raw.boo3)){
            m.imageHandler.change_secondary(m.img);}
        else {

        }*/
    }
    @Override
    public void onAnimationEnd(Animation a){
            m.imageHandler.replaceImage();
            m.animStat=2;
            c1 = new CountDownTimer(m.hotspots[m.currentHotspot].getDuration(),1){
                @Override
                public void onFinish(){
                    m.imageHandler.restoreImage();
                    m.animStat=3;
                    m.imageHandler.zoomOut(m.iview,m.hotspots[m.currentHotspot]);
                }
                @Override
                public void onTick(long in){
                }
            };
            c1.start();
    }
    
}