package activity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.akashj.rangawardhan10.R;
import com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton;
import com.oguzdev.circularfloatingactionmenu.library.FloatingActionMenu;
import com.oguzdev.circularfloatingactionmenu.library.SubActionButton;

import java.util.List;

import adapter.FragmentDrawer;

public class MainActivity extends ActionBarActivity implements FragmentDrawer.FragmentDrawerListener,View.OnClickListener {

    private static String TAG = MainActivity.class.getSimpleName();

    private Toolbar mToolbar;
    private FragmentDrawer drawerFragment;
    private static final String tag_fb="tag_fb";
    private static final String tag_web="tag_web";
    private static final String tag_twit="tag_twit";
    private static final String tag_insta="tag_insta";
    private static final String tag_fab="tag_fab";
    private FloatingActionMenu actionMenu;
    private FloatingActionButton actionButton;
    String title;
    public int k=0;
    private boolean exit;
    public static ActionBar actionBar;
    public static Toolbar toolbar;
    private Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(mToolbar);
        //toolbar = mToolbar;
        //actionBar = getSupportActionBar();

        mToolbar.setLogo(R.drawable.tool_icon);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        ImageView icon = new ImageView(this); // Create an icon
        icon.setImageResource(R.drawable.logo);
         actionButton = new FloatingActionButton.Builder(this).setContentView(icon)
                .build();

        ImageView fb = new ImageView(this);
        fb.setImageResource( R.drawable.facebook);
        ImageView web = new ImageView(this);
        web.setImageResource(R.drawable.web);
        ImageView twit = new ImageView(this);
        twit.setImageResource(R.drawable.twitter);
        ImageView insta = new ImageView(this);
        insta.setImageResource(R.drawable.instagram);
        SubActionButton.Builder itemBuilder = new SubActionButton.Builder(this);
        SubActionButton bfb = itemBuilder.setContentView(fb).build();
        SubActionButton bweb = itemBuilder.setContentView(web).build();
        SubActionButton btwit = itemBuilder.setContentView(twit).build();
        SubActionButton binsta = itemBuilder.setContentView(insta).build();

        /*FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(1500, 1500);
        itemBuilder.setLayoutParams(lp);

        //int ht=110,wd=110;
        ViewGroup.LayoutParams vlp;
        vlp = bfb.getLayoutParams();
        vlp.height = ht; vlp.width =wd;
        bfb.setLayoutParams(vlp);

        vlp = bweb.getLayoutParams();
        vlp.height = ht; vlp.width =wd;
        bweb.setLayoutParams(vlp);

        vlp = btwit.getLayoutParams();
        vlp.height = ht; vlp.width = wd;
        btwit.setLayoutParams(vlp);

        vlp = binsta.getLayoutParams();
        vlp.height = ht; vlp.width = wd;
        binsta.setLayoutParams(vlp);
*/
        bfb.setTag(tag_fb);
        bweb.setTag(tag_web);
        btwit.setTag(tag_twit);
        binsta.setTag(tag_insta);
         actionMenu = new FloatingActionMenu.Builder(this)
                .addSubActionView(bfb)
                .addSubActionView(bweb)
                .addSubActionView(btwit)
                .addSubActionView(binsta)
                .attachTo(actionButton)
                .build();
        bfb.setOnClickListener(this);
        btwit.setOnClickListener(this);
        bweb.setOnClickListener(this);
        binsta.setOnClickListener(this);

        drawerFragment = (FragmentDrawer)
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), mToolbar);
        drawerFragment.setDrawerListener(this);

        // display the first navigation drawer view on app launch
        displayView(0);
    }


    @Override
    public void onBackPressed() {
        //Fragment currentFragment=(Fragment) getSupportFragmentManager().findFragmentById(R.id.container_body);
        //if(currentFragment!=null&&currentFragment.getClass().equals(HomeFragment.class))

        if(DeveloperNewFragment.isOnTopOfFragmentStack && DeveloperNewFragment.isUnfolded){
        /*    fragment = new DeveloperNewFragment();
            title = getString(R.string.title_developer);
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container_body, fragment);
            fragmentTransaction.commit();
            getSupportActionBar().setTitle(title);*/
            if (DeveloperNewFragment.mUnfoldableView != null && (DeveloperNewFragment.mUnfoldableView.isUnfolded()
                    || DeveloperNewFragment.mUnfoldableView.isUnfolding())) {
                DeveloperNewFragment.mUnfoldableView.foldBack();
                Log.i("TAG","FOLDBACK");
                exit = false;
            }
            else if(exit){
                moveTaskToBack(true);
                Log.i("TAG","EXIT INNER");
                exit = false;
            } else {
                Toast.makeText(this, "Press again to exit",
                        Toast.LENGTH_SHORT).show();
                exit = true;
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        exit = false;
                    }
                }, 3 * 1000);
                Log.i("TAG","EXIT request INNER");
            }

        }
        else if (exit) {
            moveTaskToBack(true);
            Log.i("TAG","EXIT ");
        } else {
            Toast.makeText(this, "Press again to exit",
                    Toast.LENGTH_SHORT).show();
            exit = true;
            Log.i("TAG","EXIT request");
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    exit = false;
                }
            }, 3 * 1000);

        }

    }

  /*  @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        if(id == R.id.action_search){
            //Toast.makeText(getApplicationContext(), "Search action is selected!", //Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/

    @Override
    public void onDrawerItemSelected(View view, int position) {
         displayView(position); //RippleDrawable.createRipple(view, Color.GRAY);
    }
    private void displayView(int position) {
        Fragment originalFragment=(Fragment) getSupportFragmentManager().findFragmentById(R.id.container_body);
        fragment = null;
        title = getString(R.string.app_name);
        switch (position) {
            case 0:
                fragment = new HomeFragment();
                title = getString(R.string.title_home);
                break;
            case 1:fragment=new ThemeFragment();
                title=getString(R.string.title_theme);
                break;
            case 2:
                //fragment = new EventsFragment();
                fragment = new EventNewFragment();
                title = getString(R.string.title_events);
                break;

            case 3:
                fragment = new GalleryNewFragment();
                title = getString(R.string.title_gallery);
                break;
            case 4:
                fragment = new RWallFragment();
                title = getResources().getString(R.string.nav_item_rwall);
                break;
            case 5:
                fragment = new SponsorStickyFragment();
                title = getString(R.string.title_sponsors);
                break;
            case 6:
                fragment = new RangawardhanStickyCommitteeFragment();

                //fragment = new CommitteeFragment();
                title = getString(R.string.title_aboutus);
                break;

            case 7:
//                fragment = new DeveloperFragment();
                fragment = new DeveloperNewFragment();
                title = getString(R.string.title_developer);
                break;

            default:
                break;
        }

        if (fragment != null) {

            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container_body, fragment);
          // if(originalFragment==null||originalFragment.getClass()!=fragment.getClass())
           // fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
            // set the toolbar title
            ////Toast.makeText(this, title, //Toast.LENGTH_LONG).show();

            getSupportActionBar().setTitle(title);

            /*int titleId = getResources().getIdentifier("action_bar_title", "id", "android");
            TextView yourTextView = (TextView) findViewById(titleId);
            yourTextView.setTypeface(Typeface.createFromAsset(this.getAssets(),"fonts/LobsterTwo-Regular.otf"));*/

        }
    }


    @Override
    public void onClick(View v) {

        if(v.getTag().equals(tag_fb)){
            final String urlFb = "fb://page/"+"440649162625087";
            Intent intent9 = new Intent(Intent.ACTION_VIEW);
            intent9.setData(Uri.parse(urlFb));


            final PackageManager packageManager = getPackageManager();
            List<ResolveInfo> list =
                    packageManager.queryIntentActivities(intent9,
                            PackageManager.MATCH_DEFAULT_ONLY);
            if (list.size() == 0) {
                final String urlBrowser = "https://www.facebook.com/Rangawardhan";
                intent9.setData(Uri.parse(urlBrowser));
            }

            startActivity(intent9);
        }
        if(v.getTag().equals(tag_web)){
            Intent intent9 = new Intent(Intent.ACTION_VIEW);
            intent9.setData(Uri.parse("http://www.rangawardhan.org/"));
            startActivity(intent9);
        }
        if(v.getTag().equals(tag_twit)){

        }
        if(v.getTag().equals(tag_insta)){
            Intent intent9 = new Intent(Intent.ACTION_VIEW);
            intent9.setData(Uri.parse("https://instagram.com/rangawardhan/"));
            startActivity(intent9);
        }
    }

    public void onDrawerSlide(float slideOffset) {
        toggleTranslateFab(slideOffset);
    }

    private void toggleTranslateFab(float slideOffset) {
        if (actionMenu!=null){
            if(actionMenu.isOpen()){
                actionMenu.close(true);
            }
            actionButton.setTranslationX(slideOffset*200);
        }

    }
}