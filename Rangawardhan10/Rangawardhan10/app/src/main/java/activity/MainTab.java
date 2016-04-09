package activity;

/**
 * Created by akashj on 22/11/2015.
 */

import android.app.ActionBar;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.ToxicBakery.viewpager.transforms.AccordionTransformer;
import com.example.akashj.rangawardhan10.R;

import java.util.Arrays;
import java.util.List;


//this project developped by iheb ben salem@IBSSoft
public class MainTab extends FragmentActivity {

    ViewPager pager;
    PagerTabStrip tab_strp;
    ActionBar actionBar;
    private ImageView eventMainImageView;
    public static int descriptionIds[];

    public static List<String> names;
    public static List<String> phoneNo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_tab);
        Intent i = getIntent();
        int position = i.getIntExtra(getString(R.string.position), 0);
        String eventNames[] = getResources().getStringArray(R.array.event_names_array);

        eventMainImageView = (ImageView)findViewById(R.id.event_tab_image);

        TypedArray array = getResources().obtainTypedArray(R.array.event_image_array);
        
        
        //eventMainImageView.setBackground(getResources().getDrawable(array.getResourceId(position, -1)));
        ViewGroup.LayoutParams lp = eventMainImageView.getLayoutParams();
        lp.height = (int) (getWindowManager().getDefaultDisplay().getHeight()*0.33f);
        lp.width =  (int) (getWindowManager().getDefaultDisplay().getWidth());
        eventMainImageView.setImageBitmap(utilsol.decodeSampledBitmapFromResource(
                getResources(), array.getResourceId(position, -1),
                lp.width, lp.height));

        eventMainImageView.setLayoutParams(lp);

        
        
        TypedArray arrayDescription = getResources().obtainTypedArray(R.array.event_introduction);
        descriptionIds = new int[arrayDescription.length()];
        for(int index = 0; index < arrayDescription.length(); index++)
            descriptionIds[index] = arrayDescription.getResourceId(index, -1);

        TypedArray arrayNames = getResources().obtainTypedArray(R.array.eventhd_names_array);
        int id1 = arrayNames.getResourceId(position, -1);
        TypedArray arrayPhone = getResources().obtainTypedArray(R.array.eventhd_no_array);
        int id2 = arrayPhone.getResourceId(position, -1);
        names = Arrays.asList(getResources().getStringArray(id1));
        phoneNo = Arrays.asList(getResources().getStringArray(id2));

        actionBar=getActionBar();
        actionBar.setTitle(eventNames[position]);
        actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.action_bar_event));

        ma_pager_adapter mapager=new ma_pager_adapter(getSupportFragmentManager(), this, position);
        pager=(ViewPager)findViewById(R.id.pager);
        pager.setAdapter(mapager);
        pager.setPageTransformer(true, new AccordionTransformer());
        tab_strp=(PagerTabStrip)findViewById(R.id.tab_strip);
        tab_strp.setTextColor(Color.WHITE);
        //   tab_strp.setTextSize(14,14);
        // tab_strp.setTabIndicatorColor(Color.WHITE);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


}

