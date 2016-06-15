package in.co.go_bio.learn;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewAnimator;

/**
 * Created by rishabh on 15/6/16.
 */
public class letstry {
   ImageView im;
    tab2 c;
    ObjectAnimator oa, ob;
    //Context c;
    public letstry(tab2 c){
        this.c = c;
        im = (ImageView)this.c.v.findViewById(R.id.lrn_scr2_1_i);
        im.setPivotX(.5f);
        im.setPivotY(.1f);
        oa = ObjectAnimator.ofFloat(im, "scaleX",3f);
        ob = ObjectAnimator.ofFloat(im, "scaleY",3f);
        oa.setDuration(2000);
        ob.setDuration(2000);
        im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bleh();
            }
        });
    }

    public void bleh() {
        AnimatorSet a = new AnimatorSet();
        a.play(oa).with(ob);
        a.start();

    }

}
