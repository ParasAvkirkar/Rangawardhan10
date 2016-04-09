package activity;

import android.app.Activity;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.view.ViewPager;

import com.ToxicBakery.viewpager.transforms.FlipVerticalTransformer;
import com.example.akashj.rangawardhan10.R;


public class RWallPagerActivity extends Activity {


    private ViewPager viewPager;
    private RWallImageAdapter pagerAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.fragment_test);
        viewPager = (ViewPager)findViewById(R.id.pagerRWall);
        TypedArray array = getResources().obtainTypedArray(R.array.rwall_images_array);
        int imageId[] = new int[array.length()];
        for (int i = 0; i < imageId.length; i++) {
            imageId[i] = array.getResourceId(i, -1);
        }

        pagerAdapter = new RWallImageAdapter(this, imageId);
        viewPager.setAdapter(pagerAdapter);
        viewPager.setPageTransformer(true, new FlipVerticalTransformer());
    }

}
