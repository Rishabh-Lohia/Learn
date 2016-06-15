package in.co.go_bio.learn;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.view.menu.ActionMenuItemView;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ActionMenuView;
import android.widget.GridLayout;
import android.widget.GridLayout.LayoutParams;
//import android.view.ViewGroup.LayoutParams;

//import com.google.android.gms.appindexing.Action;
//import com.google.android.gms.appindexing.AppIndex;
//import com.google.android.gms.common.api.GoogleApiClient;

//import android.support.v7.internal.view.menu.MenuBuilder;


public class MainActivity extends ActionBarActivity {

    // Declaring Your View and Variables
//jhnbjnmu
    Toolbar toolbar;
    Toolbar toolbar1;

    ViewPager pager;
    ViewPagerAdapter adapter;
    SlidingTabLayout tabs;
    CharSequence Titles[] = {"LEARN", "BIOshop", "DIFM"};
    int Numboftabs = 3;

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    // private GoogleApiClient client;
 /*   @Override
    public boolean onCreateOptionsMenu (Menu menu){
        if (toolbar1 == null) {
            EnhancedMenuInflater.inflate(getMenuInflater(), menu, false);
        }
        return super.onCreateOptionsMenu(menu);
    }*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Creating The Toolbar and setting it as the Toolbar for the activity

        toolbar = (Toolbar) findViewById(R.id.tool_bar);
      //  toolbar1 = (Toolbar) findViewById(R.id.lower_tool_bar);
        // toolbar2 = (Toolbar) findViewById(R.id.lower_tool_bar2);
        // toolbar3 = (Toolbar) findViewById(R.id.lower_tool_bar3);
        //toolbar4 = (Toolbar) findViewById(R.id.lower_tool_bar4);
        //toolbar5 = (Toolbar) findViewById(R.id.lower_tool_bar5);
        // toolbar6 = (Toolbar) findViewById(R.id.lower_tool_bar1);
        //toolbar1 = (Toolbar) findViewById(R.id.lower_tool_bar1);


       // toolbar1.inflateMenu(R.menu.lower_menu_main);
        // toolbar1.setContentInsetsAbsolute(10, 10);

        //toolbar.setContentInsetsAbsolute(10, 10);
        //toolbar.setBackgroundDrawable(new ColorDrawable("#FFFF"));

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.logo);
       // tabTitleView.setTextColor(getResources().getColorStateList(R.color.selector));

        //getActionBar().setIcon(R.drawable.logo);


        // Creating The ViewPagerAdapter and Passing Fragment Manager, Titles fot the Tabs and Number Of Tabs.
        adapter = new ViewPagerAdapter(getSupportFragmentManager(), Titles, Numboftabs);

        // Assigning ViewPager View and setting the adapter
        pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(adapter);

        // Assiging the Sliding Tab Layout View
        tabs = (SlidingTabLayout) findViewById(R.id.tabs);
        tabs.setDistributeEvenly(true); // To make the Tabs Fixed set this true, This makes the tabs Space Evenly in Available width

        // Setting Custom Color for the Scroll bar indicator of the Tab View
        tabs.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
            @Override
            public int getIndicatorColor(int position) {
                return getResources().getColor(R.color.tabsScrollColor);

                //SlidingTabLayout slidingTabLayout = (SlidingTabLayout) findViewById(R.id.tabs);

            }
        });
        // tabs.setCustomTabView(R.layout.custom_tab, 0);
        tabs.setViewPager(pager);


       /* if (toolbar1 != null) {
            EnhancedMenuInflater.inflate(getMenuInflater(), toolbar.getMenu(), true);
            toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    return onOptionsItemSelected(item);
                }
            });
        }*/
    }


            // Setting the ViewPager For the SlidingTabsLayout
//

            // ATTENTION: This was auto-generated to implement the App Indexing API.
            // See https://g.co/AppIndexing/AndroidStudio for more information.
            //client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        // getMenuInflater().inflate(R.menu.lower_menu_main, menu);

        return true;
    }

   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        if (toolbar1 == null) {
            EnhancedMenuInflater.inflate(getMenuInflater(), menu, false);
        }
        return super.onCreateOptionsMenu(menu);
    }*/

// somewhere after views have been set.


  /*  @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }


        return super.onOptionsItemSelected(item);
    }*/


// somewhere after views have been set.    }
            /**
             * This method will take however many items you have in your
             * menu/menu_main.xml and distribute them across your devices screen
             * evenly using a Toolbar. Enjoy!!
             */
 /*   public void setupEvenlyDistributedToolbar() {
        // Use Display metrics to get Screen Dimensions
        Display display = getWindowManager().getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);

        // Toolbar
        // toolbar = (Toolbar) findViewById(R.id.navigationToolbar);
        // Inflate your menu
        // mToolbar.inflateMenu(R.menu.menu_bottom);

        // Add 10 spacing on either side of the toolbar
        toolbar1.setContentInsetsAbsolute(10, 10);

        // Get the ChildCount of your Toolbar, this should only be 1
        int childCount = toolbar1.getChildCount();
        // Get the Screen Width in pixels
        int screenWidth = metrics.widthPixels;

        // Create the Toolbar Params based on the screenWidth
        Toolbar.LayoutParams toolbarParams = new Toolbar.LayoutParams(screenWidth, LayoutParams.WRAP_CONTENT);

        // Loop through the child Items
        for (int i = 0; i < childCount; i++) {
            // Get the item at the current index
            View childView = toolbar1.getChildAt(i);
            // If its a ViewGroup
            if (childView instanceof ViewGroup) {
                // Set its layout params
                childView.setLayoutParams(toolbarParams);
                // Get the child count of this view group, and compute the item widths based on this count & screen size
                int innerChildCount = ((ViewGroup) childView).getChildCount();
                int itemWidth = (screenWidth / innerChildCount);
                // Create layout params for the ActionMenuView
                ActionMenuView.LayoutParams params = new ActionMenuView.LayoutParams(itemWidth, LayoutParams.WRAP_CONTENT);
                // Loop through the children
                for (int j = 0; j < innerChildCount; j++) {
                    View grandChild = ((ViewGroup) childView).getChildAt(j);
                    if (grandChild instanceof ActionMenuItemView) {
                        // set the layout parameters on each View
                        grandChild.setLayoutParams(params);
                    }
                }
            }
        }
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.android.wf11/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.android.wf11/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }*/

            /**
             * This method will take however many items you have in your
             * menu/menu_main.xml and distribute them across your devices screen
             * evenly using a Toolbar. Enjoy!!
             */


    }