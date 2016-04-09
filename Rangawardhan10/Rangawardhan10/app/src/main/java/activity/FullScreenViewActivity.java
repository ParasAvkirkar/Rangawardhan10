package activity;

/**
 * Created by akashj on 05/10/2015.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;

import com.example.akashj.rangawardhan10.R;


public class FullScreenViewActivity extends Activity{

   // private Utils utils;
    private FullScreenImageAdapter adapter;
    private ViewPager viewPager;
    /*final private int[] imageid={R.drawable.image1,R.drawable.image2,R.drawable.image1,R.drawable.image2,
            R.drawable.image1,R.drawable.image2,R.drawable.image1,R.drawable.image2,
            R.drawable.image1,R.drawable.image2,R.drawable.image1,R.drawable.image2,R.drawable.image1,
            R.drawable.image1,R.drawable.image2,R.drawable.image1,R.drawable.image2,R.drawable.image1,
            R.drawable.image1,R.drawable.image2,R.drawable.image1,R.drawable.image2,R.drawable.image1,
            R.drawable.image1,R.drawable.image2,R.drawable.image1,R.drawable.image2,R.drawable.image1,
            R.drawable.image1,R.drawable.image2,R.drawable.image1,R.drawable.image2,R.drawable.image1,
            R.drawable.image1,R.drawable.image2,R.drawable.image1,R.drawable.image2,R.drawable.image1,
            R.drawable.image1,R.drawable.image2,R.drawable.image1,R.drawable.image2,R.drawable.image1,
            R.drawable.image1,R.drawable.image2,R.drawable.image1,R.drawable.image2,R.drawable.image1,
            R.drawable.image1,R.drawable.image2,R.drawable.image1,R.drawable.image2,R.drawable.image1,
            R.drawable.image1,R.drawable.image2,R.drawable.image1,R.drawable.image2,R.drawable.image1};*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscreen_view);

        viewPager = (ViewPager) findViewById(R.id.pager);

       // utils = new Utils(getApplicationContext());

        Intent i = getIntent();
        int position = i.getIntExtra("position", 0);

        adapter = new FullScreenImageAdapter(FullScreenViewActivity.this,
                ListModel.getModelImage());

        viewPager.setAdapter(adapter);

        // displaying selected image first
        viewPager.setCurrentItem(position);
    }
}
