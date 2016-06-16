package in.co.go_bio.learn;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.CountDownTimer;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.io.IOException;
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
    final static int NORMAL = 5;
    int state;
    int playstate;
    final static int PLAYING = 0;
    final static int PAUSED = 1;
    final static int STOPPED = 2;
    int i;
    CountDownTimer c1;
    CountDownLatch latch;
    long millisRemaining;
    AnimatorSet zoomInAnimator;
    AnimatorSet zoomOutAnimator;
    ViewPropertyAnimator fadeOutAnimator, fadeInAnimator, fadeInAnimator1, fadeOutAnimator1;
    //Context c;
    public letstry(final tab2 c){
        this.c = c;
        state = NORMAL;
        playstate = STOPPED;
        im = c.im;
        im2 = c.im2;
        int finalI;
        c.l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(playstate==STOPPED){
                    Thread t = new Thread() {
                        @Override
                        public void run() {
                            //some actions
                            for (i = 0; i <= 2; i++) {
                                state = ZOOMING_IN;
                                c.getActivity().runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        playstate = PLAYING;
                                        zoomIn(im, c.hotspots[i]);

                                    }
                                });
                                try {
                                    latch = new CountDownLatch(1);
                                    latch.await();
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }

                            }
                            c.getActivity().runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    try {
                                        c.h2.stopaudio();
                                        playstate = STOPPED;
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }

                                }
                            });

                        }
                    };
                    t.start();
                    c.im5.setImageResource(R.drawable.sun);
                    c.im5.setAlpha(0f);
                    c.im3.setImageResource(R.drawable.fertiliser);
                    crossfade(c.im3,c.im5);
                    c.h2.startaudio();
                    playstate = PLAYING;
                }else if (playstate == PLAYING){
                    c.rooty.pause();
                    if(state == ZOOMING_IN){
                        zoomInAnimator.pause();
                    }else if(state ==ZOOMING_OUT){
                        zoomOutAnimator.pause();
                    }else if(state == WAITING){
                        c1.cancel();
                    }else if(state == CROSSFADING_IN) {
                        fadeInAnimator.cancel();
                    }else if( state == CROSSFADING_OUT){
                        fadeOutAnimator.cancel();
                    }
                    playstate = PAUSED;
                }else if (playstate == PAUSED){
                    c.rooty.start();
                    if(state == WAITING){
                        countDown(c.hotspots[i],millisRemaining);
                    }else if(state == ZOOMING_IN){
                        zoomInAnimator.resume();
                    }else if(state == ZOOMING_OUT){
                        zoomOutAnimator.resume();

                    }else if(state == CROSSFADING_IN) {
                        fadeInAnimator.start();
                    }else if( state == CROSSFADING_OUT){
                        fadeOutAnimator.start();
                    }


                    playstate = PLAYING;
                }

            }
        });
        //fadeout = ObjectAnimator.ofFloat(c.im3, "alpha",1f,0f);

        //oe = ObjectAnimator.ofInt(im2,"visibility",ImageView.GONE,ImageView.VISIBLE);
//        disappear = ObjectAnimator.ofInt(im,"visibility",ImageView.VISIBLE,ImageView.GONE);
        //oe.setDuration(2000);
//        disappear.setDuration(1);
        //fadein.setStartDelay(500);
        //fadeout.setDuration(1000);



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
        zoomInAnimator = new AnimatorSet();
        zoomInAnimator.play(zoominx).with(zoominy);//zoom in

        zoomInAnimator.addListener(new Animator.AnimatorListener() {
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
        zoomInAnimator.start();
    }

    public void countDown(final Hotspot h){
        c1 = new CountDownTimer(h.getDuration(), 1) {
            @Override
            public void onTick(long millisUntilFinished) {
                millisRemaining = millisUntilFinished;
            }

            @Override
            public void onFinish() {
                state = CROSSFADING_OUT;
                crossfade(im2,im, h);
            }
        };
        c1.start();

    }
    public void countDown(final Hotspot h, long bam){
        c1 = new CountDownTimer(bam, 1) {
            @Override
            public void onTick(long millisUntilFinished) {
                millisRemaining = millisUntilFinished;
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

        fadeOutAnimator = im.animate()
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
        fadeInAnimator = im2.animate()
                .alpha(1f)
                .setDuration(200)
                .setListener(null);  //fade in
    }

    public void crossfade(ImageView imageView, ImageView imageView2){

        final ImageView im = imageView , im2 = imageView2;
        im2.setAlpha(0.001f);
        im2.setVisibility(View.VISIBLE);
        //Toast.makeText(this.c.getContext(),"Crossfade",Toast.LENGTH_LONG).show();

        fadeOutAnimator1 = im.animate()
                .alpha(0f)
                .setDuration(1000)
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        im.setVisibility(View.INVISIBLE);
                        crossfade(im2,im);
                        //IF condition
                    }
                });   //fade out
        fadeInAnimator1 = im2.animate()
                .alpha(1f)
                .setDuration(1000)
                .setListener(null);  //fade in
    }

    public void zoomOut(ImageView im){

        zoomoutx = ObjectAnimator.ofFloat(im, "scaleX",3f,1f);
        zoomouty = ObjectAnimator.ofFloat(im, "scaleY",3f,1f);
        zoomoutx.setDuration(2000);
        zoomouty.setDuration(2000);
        zoomOutAnimator = new AnimatorSet();
        zoomOutAnimator.play(zoomoutx).with(zoomouty);
        zoomOutAnimator.addListener(new Animator.AnimatorListener() {
        @Override
        public void onAnimationStart(Animator animation) {

        }

        @Override
        public void onAnimationEnd(Animator animation) {
            state = NORMAL;
            latch.countDown();

        }

        @Override
        public void onAnimationCancel(Animator animation) {

        }

        @Override
        public void onAnimationRepeat(Animator animation) {

        }
        });
        zoomOutAnimator.start();

        }



}
