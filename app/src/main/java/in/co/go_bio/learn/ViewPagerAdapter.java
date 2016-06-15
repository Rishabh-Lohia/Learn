package in.co.go_bio.learn;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.content.ContextCompat;

/**
 * Created by sonal on 08-06-2016.
 */

import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentStatePagerAdapter;


//* Created by sonal on 04-06-2016.
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;


// * Created by hp1 on 21-01-2015.
//*/
public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    CharSequence Titles[]; // This will Store the Titles of the Tabs which are Going to be passed when ViewPagerAdapter is created
    int NumbOfTabs; // Store the number of tabs, this will also be passed when the ViewPagerAdapter is created

    private ContextCompat resources;

    // Build a Constructor and assign the passed Values to appropriate values in the class
    public ViewPagerAdapter(FragmentManager fm,CharSequence mTitles[], int mNumbOfTabsumb) {
        super(fm);

        this.Titles = mTitles;
        this.NumbOfTabs = mNumbOfTabsumb;

    }

    //This method return the fragment for the every position in the View Pager
    @Override
    public Fragment getItem(int position) {

        if(position == 0) // if the position is 0 we are returning the First tab
        {
            tab1 t1 = new tab1();
            return t1;
        }
        else
        if(position== 1)// As we are having 2 tabs if the position is now 0 it must be 1 so we are returning second tab
        {
            tab2 t2 = new tab2();
            return t2;
        }
        else
        {
            tab3 t3 = new tab3();
            return t3;
        }



    }

    // This method return the titles for the Tabs in the Tab Strip

    @Override
    public CharSequence getPageTitle(int position) {
        return Titles[position];
    }
  /* @Override
   public CharSequence getPageTitle(int position)
   {
       //Drawable image =  getResources().getDrawable(imageResId[position],0);
               //ResourcesCompat.getDrawable(getResources(), R.drawable.name, null);


      // ContextCompat.getDrawable(getApplicationContext(), R.drawable.icon);
       image.setBounds(0, 0, image.getIntrinsicWidth(), image.getIntrinsicHeight());
       SpannableString sb = new SpannableString(" ");
       ImageSpan imageSpan = new ImageSpan(image, ImageSpan.ALIGN_BOTTOM);
       sb.setSpan(imageSpan, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
       return sb;

   }*/
    // This method return the Number of tabs for the tabs Strip

    @Override
    public int getCount() {
        return NumbOfTabs;
    }

    public ContextCompat getResources() {
        return resources;
    }
}
