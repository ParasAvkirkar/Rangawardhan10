package activity;

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.akashj.rangawardhan10.R;
import com.squareup.picasso.Picasso;

/**
 * Created by Rohit on 23/11/2015.
 */
public class RWallImageAdapter extends PagerAdapter{


    private Activity _activity;
    //private ArrayList<String> _imagePaths;
    private int[] images;
    private LayoutInflater inflater;

    // constructor
    public RWallImageAdapter(Activity activity,
                                  int[] images) {
        this._activity = activity;
        this.images=images;
    }

    @Override
    public int getCount() {
        return this.images.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((LinearLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imgDisplay;

        inflater = (LayoutInflater) _activity
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View viewLayout = inflater.inflate(R.layout.layout_rwall_image, container,
                false);

        imgDisplay = (ImageView) viewLayout.findViewById(R.id.rwall_image);
        //imgDisplay.setImageResource(images[position]);
        ViewGroup.LayoutParams lp = imgDisplay.getLayoutParams();
        lp.width = lp.MATCH_PARENT;
        lp.height = lp.MATCH_PARENT;
/*
        imgDisplay.setImageBitmap(utilsol.decodeSampledBitmapFromResource(_activity.getResources(),
                images[position], lp.width, lp.height));
*/
        Picasso.with(_activity).load(images[position]).into(imgDisplay);
        imgDisplay.setLayoutParams(lp);
        ((ViewPager) container).addView(viewLayout);
       /* ViewGroup.LayoutParams lp = imgDisplay.getLayoutParams();
        lp.height = (int)(_activity.getWindowManager().getDefaultDisplay().getHeight()*0.5);
        imgDisplay.setLayoutParams(lp);*/
        return viewLayout;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView((LinearLayout) object);

    }


}
