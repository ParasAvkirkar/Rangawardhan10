package activity;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.util.LruCache;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.ToxicBakery.viewpager.transforms.ZoomOutSlideTransformer;
import com.example.akashj.rangawardhan10.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by paras on 26/11/2015.
 */

public class NewGalleryFragment extends Activity implements ViewPager.OnPageChangeListener{

    private ViewPager viewPager;
    private GalleryAdapter galleryAdapter;
    private HorizontalScrollView sv;
    private LruCache<String , Bitmap> mMemCache;
    private static List<Bitmap> bitmapList;
    private GalleryFilmStripAdapter galleryFilmStripAdapter;
    private Gallery gallery;

    private int[] imageIds = {R.drawable.g1,R.drawable.g2,R.drawable.g3,R.drawable.g4,R.drawable.g5,R.drawable.g6,
            R.drawable.g7,R.drawable.g8,R.drawable.g9,R.drawable.g10,R.drawable.g11,R.drawable.g12,
            R.drawable.g13,R.drawable.g14,R.drawable.g15
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bitmapList = new ArrayList<>();

        setContentView(R.layout.new_gallery_fragment);

        viewPager = (ViewPager) findViewById(R.id.gallery_pager);
        galleryAdapter = new GalleryAdapter();
        viewPager.setAdapter(galleryAdapter);
        viewPager.setPageTransformer(false, new ZoomOutSlideTransformer());
        //viewPager.setPageTransformer(false, new GalleryTransformer());
        viewPager.setOnPageChangeListener(NewGalleryFragment.this);
        gallery = (Gallery) findViewById(R.id.filmstrip);
        galleryFilmStripAdapter = new GalleryFilmStripAdapter(this);
        gallery.setAdapter(galleryFilmStripAdapter);
        gallery.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                viewPager.setCurrentItem(position);
            }
        });
        ViewGroup.LayoutParams lp = gallery.getLayoutParams();
        lp.width = (int)(getWindowManager().getDefaultDisplay().getWidth());
        lp.height = (int)(getWindowManager().getDefaultDisplay().getHeight()*0.25f);
        gallery.setLayoutParams(lp);
        gallery.setSpacing(5);
        gallery.setSelection(1);
        /*sv = (HorizontalScrollView)findViewById(R.id.filmstrip);

        for (int i = 0; i < imageIds.length; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setId(i);

            int size=(int)(((WindowManager)getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getHeight()*0.2f);
            imageView.setImageBitmap(utilsol.decodeSampledBitmapFromResource(getResources(), imageIds[i], size, size));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(size,size);
            params.leftMargin = 5;
            params.rightMargin = 5;
            if(i==imageIds.length-1)params.rightMargin=30;
            params.gravity = Gravity.CENTER;
            imageView.setLayoutParams(params);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);

            imageView.setSelected(i == 0);
            final int position = i;
            imageView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    viewPager.setCurrentItem(position);
                    setSelected(position);
                }
            });
            ((LinearLayout) findViewById(R.id.thumbnail)).addView(imageView);
        }*/

        viewPager.setCurrentItem(getIntent().getIntExtra("position", 0));

        final int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);
        final int cacheSize = maxMemory / 8;
        mMemCache = new LruCache<String, Bitmap>(cacheSize) {
            @Override
            protected int sizeOf(String key, Bitmap bitmap) {
                return bitmap.getByteCount() / 1024;
            }
        };

    }

    private void setSelected(final int position) {
        sv.findViewById(position).setSelected(true);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        //setSelected(position);
        gallery.setSelection(position);

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        /*for (Bitmap bm:bitmapList
                ) {
            if(bm != null)
                bm.recycle();
        }*/
    }

    public void addBitmapToMemoryCache(String key, Bitmap bitmap) {
        if (getBitmapFromMemCache(key) == null) {
            mMemCache.put(key, bitmap);
        }
    }

    public Bitmap getBitmapFromMemCache(String key) {
        return mMemCache.get(key);
    }

    private class GalleryAdapter extends PagerAdapter {

        public BitmapWorkerTask task;

        public GalleryAdapter() {
/*            for (int i = 0; i < imageIds.length; i++) {
                bitmapList.add(null);
            }*/
        }

        @Override
        public int getCount() {
            return imageIds.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ImageView imageView = new ImageView(NewGalleryFragment.this);
            imageView.setId(position);
            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            params.addRule(RelativeLayout.CENTER_HORIZONTAL);
            params.addRule(RelativeLayout.CENTER_VERTICAL);
            imageView.setLayoutParams(params);
//imageView.setBackgroundResource(R.drawable.drop_shadow_layer);
            Picasso.with(NewGalleryFragment.this).load(imageIds[position]).into(imageView);
            container.addView(imageView);
            return imageView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }

    class BitmapWorkerTask extends AsyncTask<Object, Void, Bitmap> {

        ImageView imageView;
        public BitmapWorkerTask() {
        }

        @Override
        protected Bitmap doInBackground(Object... params) {
            this.imageView = (ImageView)params[0] ;
            Bitmap bitmap = utilsol.decodeSampledBitmapFromResource(getResources(), ((Integer)params[1]).intValue(),
                    ((Integer)params[2]).intValue(), ((Integer)params[3]).intValue());
            addBitmapToMemoryCache(String.valueOf(params[1]), bitmap);
            bitmapList.add(bitmap);
            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            imageView.setImageBitmap(bitmap);
        }
    }



    /**
     * Page Transformation Animation taken from Google Example
     */
    private class GalleryTransformer implements ViewPager.PageTransformer {

        private static final float MIN_SCALE = 0.85f;
        private static final float MIN_ALPHA = 0.5f;

        public void transformPage(View view, float position) {
            int pageWidth = view.getWidth();
            int pageHeight = view.getHeight();

            if (position < -1) { // [-Infinity,-1)
                // This page is way off-screen to the left.
                view.setAlpha(0);

            } else if (position <= 1) { // [-1,1]
                // Modify the default slide transition to shrink the page as well
                float scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position));
                float vertMargin = pageHeight * (1 - scaleFactor) / 2;
                float horzMargin = pageWidth * (1 - scaleFactor) / 2;
                if (position < 0) {
                    view.setTranslationX(horzMargin - vertMargin / 2);
                } else {
                    view.setTranslationX(-horzMargin + vertMargin / 2);
                }

                // Scale the page down (between MIN_SCALE and 1)
                view.setScaleX(scaleFactor);
                view.setScaleY(scaleFactor);

                // Fade the page relative to its size.
                view.setAlpha(MIN_ALPHA +
                        (scaleFactor - MIN_SCALE) /
                                (1 - MIN_SCALE) * (1 - MIN_ALPHA));

            } else { // (1,+Infinity]
                // This page is way off-screen to the right.
                view.setAlpha(0);
            }
        }
    }

    public class GalleryFilmStripAdapter extends BaseAdapter {
        private Context context;
        public GalleryFilmStripAdapter(Context c)
        {
            context = c;
        }

        public int getCount() {
            return imageIds.length;
        }
        public Object getItem(int position) {
            return position;
        }
        public long getItemId(int position) {
            return position;
        }
        public View getView(int position, View convertView, ViewGroup parent) {
            Holder h = null;
            if(convertView == null){
                convertView = getLayoutInflater().inflate(R.layout.gallery_film_layout, null);
                h = new Holder();
                h.img = (ImageView) convertView.findViewById(R.id.galleryFilmImage);
                convertView.setTag(h);
//                convertView.setTag(position, h);
            }
            else
                h = (Holder) convertView.getTag();
            //    h = (Holder)convertView.getTag(position);

            ViewGroup.LayoutParams lp = h.img.getLayoutParams();
            lp.width = (int)(getWindowManager().getDefaultDisplay().getWidth()*0.4);
            lp.height = (int)(getWindowManager().getDefaultDisplay().getHeight()*0.24);;
            h.img.setScaleType(ImageView.ScaleType.FIT_XY);
            //h.img.setLayoutParams(lp);
            //imageView.setImageResource(imageIDs[position]);
            /*h.img.setImageBitmap(utilsol.decodeSampledBitmapFromResource(NewGalleryFragment.this.getResources(), imageIds[position]
                , lp.width, lp.height));*/
            Picasso.with(context).load(imageIds[position]).resize(lp.width, lp.height).into(h.img);
            return convertView;
        }
        class Holder{
            ImageView img;
        }

    }

}


