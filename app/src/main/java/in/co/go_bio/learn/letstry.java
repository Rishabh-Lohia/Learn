package in.co.go_bio.learn;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.concurrent.CountDownLatch;

/**
 * Created by rishabh on 15/6/16.
 */
public class letstry {
   ImageView im, im2;
    tab2 c;
    ObjectAnimator zoominx, zoominy, fadein, fadeout, disappear, zoomoutx, zoomouty;
    LinearLayout l1;
    final static int ZOOMING_IN = 0;
    final static int CROSSFADING_IN = 1;
    final static int WAITING = 2;
    final static int CROSSFADING_OUT = 3;
    final static int ZOOMING_OUT = 4;
    final static int STOPPED = 5;
    int state;
    int i;

    CountDownLatch latch;

    //Context c;
    public letstry(final tab2 c){
        this.c = c;
        state = STOPPED;
        im = c.im;
        im2 = c.im2;
        int finalI;
        c.l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread t = new Thread(){
                    @Override
                    public void run() {
                        //some actions
                        for(i=0; i<=2; i++){
                            state = ZOOMING_IN;
                          //  zoomIn(im,c.hotspots[finalI]);
                            c.getActivity().runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    zoomIn(im,c.hotspots[i]);

                                }
                            });
                            try {
                                latch = new CountDownLatch(1);
                                latch.await();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                        }

                    }
                };
                t.start();

            }
        });
        fadeout = ObjectAnimator.ofFloat(im, "alpha",1f,0f);
        fadein = ObjectAnimator.ofFloat(im2,"alpha",0f,1f);
        //oe = ObjectAnimator.ofInt(im2,"visibility",ImageView.GONE,ImageView.VISIBLE);
        disappear = ObjectAnimator.ofInt(im,"visibility",ImageView.VISIBLE,ImageView.GONE);
        //oe.setDuration(2000);
        disappear.setDuration(1);
        fadein.setDuration(500);
        fadein.setStartDelay(500);
        fadeout.setDuration(1000);



    }

    public void zoomIn(ImageView imageView, Hotspot hotspot) {
        final Hotspot h = hotspot;
        imageView.setPivotX(imageView.getWidth()*h.getX());
        imageView.setPivotY(imageView.getHeight()*h.getY());
        Toast.makeText(this.c.getContext(),"x pivot "+Float.toString(im.getPivotX()),Toast.LENGTH_LONG).show();
        zoominx = ObjectAnimator.ofFloat(im, "scaleX",1f,3f);
        zoominy = ObjectAnimator.ofFloat(im, "scaleY",1f,3f);
        zoominx.setDuration(1000);
        zoominy.setDuration(1000);
        AnimatorSet a = new AnimatorSet();
        a.play(zoominx).with(zoominy);//zoom in

        a.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                if(h.getImage_uri()!=-1) {
                    state = CROSSFADING_IN;
                    im2.setImageResource(h.getImage_uri());
                    crossfade(im, im2, h);
                }
                else {
                    state = WAITING;
                    countDown(h);
                }
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        a.start();
    }

    public void countDown(final Hotspot h){
        CountDownTimer c1 = new CountDownTimer(h.getDuration(), 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                state = CROSSFADING_OUT;
                crossfade(im2,im, h);
            }
        };
        c1.start();

    }

    public void crossfade(final ImageView im, final ImageView im2, final Hotspot h){

        im2.setAlpha(0.001f);
        im2.setVisibility(View.VISIBLE);
        //Toast.makeText(this.c.getContext(),"Crossfade",Toast.LENGTH_LONG).show();

        im.animate()
                .alpha(0f)
                .setDuration(200)
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        im.setVisibility(View.GONE);
                        //IF condition
                        if(state == CROSSFADING_IN ){
                            state = WAITING;
                            countDown(h);
                        }else if(state == CROSSFADING_OUT){
                            state = ZOOMING_OUT;
                            zoomOut(im2);
                        }
                    }
                });   //fade out
        im2.animate()
                .alpha(1f)
                .setDuration(200)
                .setListener(null);  //fade in
    }

    public void zoomOut(ImageView im){

        zoomoutx = ObjectAnimator.ofFloat(im, "scaleX",3f,1f);
        zoomouty = ObjectAnimator.ofFloat(im, "scaleY",3f,1f);
        zoomoutx.setDuration(2000);
        zoomouty.setDuration(2000);
        AnimatorSet a2 = new AnimatorSet();
        a2.play(zoomoutx).with(zoomouty);
        a2.addListener(new Animator.AnimatorListener() {
        @Override
        public void onAnimationStart(Animator animation) {

        }

        @Override
        public void onAnimationEnd(Animator animation) {
            state = STOPPED;
            latch.countDown();

        }

        @Override
        public void onAnimationCancel(Animator animation) {

        }

        @Override
        public void onAnimationRepeat(Animator animation) {

        }
        });
        a2.start();

        }



}
