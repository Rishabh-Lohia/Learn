package in.co.go_bio.learn;

import android.os.CountDownTimer;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.ViewAnimator;

/**
 * Created by rishabh on 8/6/16.
 */
public class ImageHandler {
    tab3 m;
    CountDownTimer c1;
    public ImageHandler(tab3 m){
        this.m=m;
    }

    public void replaceImage(){
        m.viewAnimator = (ViewAnimator)m.getActivity().findViewById(R.id.lrn_scr3_a);
        m.viewAnimator.setInAnimation(m.fadein);
        m.viewAnimator.setOutAnimation(m.fadeout);
        m.viewAnimator.showNext();
    }

    public void restoreImage(){
        m.viewAnimator.showPrevious();
    }

    public void change_secondary(ImageView x) {
        int image_uri=m.hotspots[m.currentHotspot].getImage_uri();
        if(m.animStat==1) {
            x.setImageResource(image_uri);

        }

    }

    public void change_grow(ImageView x) {
        int image_uri=m.growings[m.currentGrow].getImg_uri();
        if(m.animStat==4) {
            x.setImageResource(image_uri);

        }

    }

    public void zoomIn(ImageView v, Hotspot h){
        m.zoom_in = new ScaleAnimation(1f,4f,1f,4f,Animation.RELATIVE_TO_SELF,h.getX(),Animation.RELATIVE_TO_SELF,h.getY());
        m.zoom_in.setDuration(1000);
        m.zoom_in.setInterpolator(new LinearInterpolator());
        m.zoom_in.setAnimationListener(m.zoomInListener);
        v.clearAnimation();
        v.setAnimation(m.zoom_in);
        v.startAnimation(m.zoom_in);
    }

    public void zoomOut(ImageView v, Hotspot h){
        m.zoom_out = new ScaleAnimation(4f,1f,4f,1f,Animation.RELATIVE_TO_SELF,h.getX(),Animation.RELATIVE_TO_SELF,h.getY());
        m.zoom_out.setDuration(1000);
        m.zoom_out.setInterpolator(new LinearInterpolator());
        m.zoom_out.setAnimationListener(m.zoomOutListener);
        v.startAnimation(m.zoom_out);
    }

   /* public void growtrans()
    {
        int i,time=0;
        *//*for(i=0;i<m.numOfgrows;i++){
            time+=m.growings[i].getDuration();
        }*//*
        time = m.growings[m.currentGrow].getDuration();
        change_grow(m.img);
        if(m.currentGrow==0) {
            m.viewAnimator.showNext();

        }
        c1 = new CountDownTimer(time,1){
            @Override
            public void onFinish(){
                m.imageHandler.replaceImage();
                m.animStat=4;
            }
            @Override
            public void onTick(long in){

            }
        };
        if(m.animStat==4 && m.currentGrow<m.numOfgrows) {
            c1.start();
            if(m.growings[m.currentGrow].getImg_uri()==R.raw.boo3){
                change_grow(m.grimg);
            }
            m.currentGrow++;
            restoreImage();
            growtrans();
        }
        if(m.currentGrow>=m.numOfgrows)
        {
            m.animStat = 0;
        }
    }*/
}
