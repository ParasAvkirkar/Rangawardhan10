package activity;

/**
 * Created by akashj on 05/10/2015.
 */

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.akashj.rangawardhan10.R;

public class FullScreenImageAdapter extends PagerAdapter {

    private Activity _activity;
    //private ArrayList<String> _imagePaths;
    private int[] images;
    private LayoutInflater inflater;

    // constructor
    public FullScreenImageAdapter(Activity activity,
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
        return view == ((RelativeLayout) object);
    }



    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imgDisplay;
        Button btnClose;

        inflater = (LayoutInflater) _activity
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View viewLayout = inflater.inflate(R.layout.layout_fullscreen_image, container,
                false);

        imgDisplay = (ImageView) viewLayout.findViewById(R.id.imgDisplay);
        btnClose = (Button) viewLayout.findViewById(R.id.btnClose);
        imgDisplay.setScaleType(ImageView.ScaleType.FIT_CENTER);
        ViewGroup.LayoutParams lp = imgDisplay.getLayoutParams();
        lp.height = lp.FILL_PARENT;
        lp.width = lp.FILL_PARENT;
        imgDisplay.setImageBitmap(utilsol.decodeSampledBitmapFromResource(_activity.getResources(),
                images[position], lp.width, lp.height));
        imgDisplay.setLayoutParams(lp);
       /* BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        Bitmap bitmap = BitmapFactory.decodeFile(_imagePaths.get(position), options);
        imgDisplay.setImageBitmap(bitmap);*/

        // imgDisplay.setImageResource(images[position]);

        // close button click event
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _activity.finish();
            }
        });

        ((ViewPager) container).addView(viewLayout);

        return viewLayout;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView((RelativeLayout) object);

    }


}
