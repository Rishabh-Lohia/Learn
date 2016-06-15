package in.co.go_bio.learn;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by rishabh on 15/6/16.
 */
public class letstry {
   ImageView im, im2;
    tab2 c;
    ObjectAnimator zoominx, zoominy, fadein, fadeout, oe, disappear;
    LinearLayout l1;
    //Context c;
    public letstry(tab2 c){
        this.c = c;
        im = (ImageView)this.c.v.findViewById(R.id.im);
        im.setPivotX(.5f);
        im.setPivotY(.5f);
        im2 = (ImageView)this.c.v.findViewById(R.id.im2);
        zoominx = ObjectAnimator.ofFloat(im, "scaleX",1f,3f);
        zoominy = ObjectAnimator.ofFloat(im, "scaleY",1f,3f);
        zoominx.setDuration(2000);
        zoominy.setDuration(2000);
        im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bleh();
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
        im2.setAlpha(0f);
        im2.setVisibility(View.VISIBLE);


    }

    public void bleh() {
        AnimatorSet a = new AnimatorSet();
        a.play(zoominx).with(zoominy);//zoom in

        a.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                im2.setAlpha(0.001f);

                im.animate()
                        .alpha(0f)
                        .setDuration(200)
                        .setListener(new AnimatorListenerAdapter() {
                            @Override
                            public void onAnimationEnd(Animator animation) {
                                im.setVisibility(View.GONE);
                            }
                        });
                im2.animate()
                        .alpha(1f)
                        .setDuration(200)
                        .setListener(null);

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

}
