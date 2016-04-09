package activity;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.alexvasilkov.foldablelayout.UnfoldableView;
import com.example.akashj.rangawardhan10.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dell on 11/24/2015.
 */
public class DeveloperNewFragment extends Fragment {


    public static final List<Friend> friends = new ArrayList<>();
    public static final List<String> friends2 = new ArrayList<>();
    private ImageView developerDetailImageView;
    private TextView developerNameTextView, developerEmailTextView, developerPhoneTextView;
    public static boolean isUnfolded;
    public static boolean isOnTopOfFragmentStack;
    static {
        friends.add(new Friend(R.drawable.akashdeveloper, "AKASH JANJAL",  "akashjanjal7@gmail.com", "+918390407634"));
        friends.add(new Friend(R.drawable.parasdeveloper, "PARAS AVKIRKAR", "parasavkirkar96@gmail.com", "+917506055572"));
        friends.add(new Friend(R.drawable.rohitdeveloper, "ROHIT PATIL",   "patilrohit1295@gmail.com", "+919405183330"));
        friends2.add("Akash");
        friends2.add("Paras");
        friends2.add("Rohit");

        listItemViews = new ArrayList<>();
        isUnfolded = false;
        isOnTopOfFragmentStack = false;
    }

    private ListView mListView;
    private View mListTouchInterceptor;
    private View mDetailsLayout;
    public static UnfoldableView mUnfoldableView;
    private static List<View> listItemViews;
    static Context mcontext;

    public DeveloperNewFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.developer_new_fragment, container, false);
        isOnTopOfFragmentStack = true;


        Toolbar toolbar;
        toolbar=(Toolbar)getActivity().findViewById(R.id.toolbar);
        TextView tv = (TextView) toolbar.findViewById(R.id.toolbar_title);
        tv.setText(R.string.nav_item_developers);
        tv.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),
                "fonts/LobsterTwo-Regular.otf"));
        //toolbar.setTitle(R.string.title_home);

        mListView = (ListView) rootView.findViewById(R.id.developer_list_view);
        mListView.setAdapter(new DeveloperListViewAdapter(getActivity(), R.layout.developer_item));

        mListTouchInterceptor = rootView.findViewById(R.id.touch_interceptor_view);
        mListTouchInterceptor.setClickable(false);

        mDetailsLayout = rootView.findViewById(R.id.details_layout);
        mDetailsLayout.setVisibility(View.INVISIBLE);
        developerDetailImageView = (ImageView)rootView.findViewById(R.id.details_image);
        developerNameTextView = (TextView) rootView.findViewById(R.id.developer_detail_name);
        developerEmailTextView = (TextView) rootView.findViewById(R.id.developer_detail_email);
        developerPhoneTextView = (TextView) rootView.findViewById(R.id.developer_detail_phone);

        ViewGroup.LayoutParams lp = developerDetailImageView.getLayoutParams();
        int size=(int)(((WindowManager)getActivity().getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getHeight()*0.5f);
        lp.height=size;
        lp.width=size;
        developerDetailImageView.setLayoutParams(lp);

        /*TextView myTextView=(TextView) rootView.findViewById(R.id.theDeveloper);
        Typeface typeFace=Typeface.createFromAsset(getActivity().getAssets(), "fonts/JosefinSlab-Bold.ttf");
        myTextView.setTypeface(typeFace);
        */
        mUnfoldableView = (UnfoldableView) rootView.findViewById(R.id.unfoldable_view);

        mUnfoldableView.setOnFoldingListener(new UnfoldableView.SimpleFoldingListener() {
            @Override
            public void onUnfolding(UnfoldableView unfoldableView) {
                mListTouchInterceptor.setClickable(true);
                //////Toast.makeText(getActivity(), "unfolding", ////Toast.LENGTH_LONG).show();
                mDetailsLayout.setVisibility(View.VISIBLE);
                mListView.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onUnfolded(UnfoldableView unfoldableView) {
                mListTouchInterceptor.setClickable(false);
                isUnfolded = true;
            }

            @Override
            public void onFoldingBack(UnfoldableView unfoldableView) {
                mListTouchInterceptor.setClickable(true);
            }

            @Override
            public void onFoldedBack(UnfoldableView unfoldableView) {
                mListTouchInterceptor.setClickable(false);
                mDetailsLayout.setVisibility(View.INVISIBLE);
                mListView.setVisibility(View.VISIBLE);
                isUnfolded = false;
            }
        });

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                developerDetailImageView.setImageResource(friends.get(i).getImageId());
                developerNameTextView.setText(friends.get(i).getName());
                developerEmailTextView.setText(friends.get(i).getEmailId());
                developerPhoneTextView.setText(friends.get(i).getPhoneNo());

                mUnfoldableView.unfold(listItemViews.get(i), mDetailsLayout);
            }
        });

        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {

        /*if (mUnfoldableView != null && (mUnfoldableView.isUnfolded() || mUnfoldableView.isUnfolding())) {
            mUnfoldableView.foldBack();
        } else {
            super.onDetach();
        }*/
        super.onDetach();
        isOnTopOfFragmentStack = false;
        //////Toast.makeText(getActivity(), "no longer developer", ////Toast.LENGTH_LONG).show();
    }

    @Override
    public void onResume() {
        super.onResume();
        // Set title
        Toolbar toolbar;
        toolbar=(Toolbar)getActivity().findViewById(R.id.toolbar);
        TextView tv = (TextView) toolbar.findViewById(R.id.toolbar_title);
        tv.setText(R.string.nav_item_developers);
        tv.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),
                "fonts/LobsterTwo-Regular.otf"));
        //toolbar.setTitle(R.string.title_home);
    }


    static class DeveloperListViewAdapter extends BaseAdapter{
        private Context context;
        private int layoutResId;


        DeveloperListViewAdapter(Context context, int layoutResId){
            this.context = context;
            this.layoutResId = layoutResId;
        }

        class ViewHolder{
            ImageView img;
            TextView theDeveloper;
            // LinearLayout ll;
        }

        @Override
        public int getCount() {
            return friends.size();
        }

        @Override
        public Object getItem(int position) {
            return friends.get(position);
        }


        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder = null;

            LayoutInflater mInflater = (LayoutInflater)
                    context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

            if (convertView == null) {
                convertView = mInflater.inflate(layoutResId, null);
                holder = new ViewHolder();
                holder.img = (ImageView)convertView.findViewById(R.id.firstdeveloper);
                holder.theDeveloper= (TextView) convertView.findViewById(R.id.theDeveloper);
                //holder.ll= (LinearLayout) convertView.findViewById(R.id.vjti);

                convertView.setTag(holder);
                listItemViews.add(holder.img);
            }
            else {
                holder = (ViewHolder) convertView.getTag();
            }

            holder.img.setImageBitmap(getRoundedShape(decodeFile(context, friends.get(position).getImageId()), 200));
            //holder.img.setImageResource(friends.get(position).getImageId());
            holder.img.setScaleType(ImageView.ScaleType.FIT_XY);
            holder.img.setAdjustViewBounds(true);
            int width=(int)(((WindowManager)context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getWidth());
            ViewGroup.LayoutParams lp = holder.img.getLayoutParams();
            lp.height = (int)(((WindowManager)context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getHeight()*0.20f);
            //lp.width = (int)(((WindowManager)context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getWidth());
            lp.width=lp.height;
            holder.img.setLayoutParams(lp);
            holder.theDeveloper.setWidth((int)(width/3));
            holder.theDeveloper.setText(friends2.get(position));

            // holder.img.setPadding((int)(width*0.03f),(int)(width*0.03f),(int)(width*0.03f),(int)(width*0.03f));
            //holder.ll.setPadding((int)(width*0.1f),(int)(width*0.1f),(int)(width*0.1f),(int)(width*0.1f));

            return convertView;
        }
        public static Bitmap decodeFile(Context context,int resId) {
            try {
// decode image size
                mcontext=context;
                BitmapFactory.Options o = new BitmapFactory.Options();
                o.inJustDecodeBounds = true;
                BitmapFactory.decodeResource(mcontext.getResources(), resId, o);
// Find the correct scale value. It should be the power of 2.
                final int REQUIRED_SIZE = 200;
                int width_tmp = o.outWidth, height_tmp = o.outHeight;
                int scale = 1;
                while (true)
                {
                    if (width_tmp / 2 < REQUIRED_SIZE
                            || height_tmp / 2 < REQUIRED_SIZE)
                        break;
                    width_tmp /= 2;
                    height_tmp /= 2;
                    scale++;
                }
// decode with inSampleSize
                BitmapFactory.Options o2 = new BitmapFactory.Options();
                o2.inSampleSize = scale;
                return BitmapFactory.decodeResource(mcontext.getResources(), resId, o2);
            } catch (Exception e) {
            }
            return null;
        }
    }
    public static Bitmap getRoundedShape(Bitmap scaleBitmapImage,int width) {
        // TODO Auto-generated method stub
        int targetWidth = width;
        int targetHeight = width;
        Bitmap targetBitmap = Bitmap.createBitmap(targetWidth,
                targetHeight,Bitmap.Config.ARGB_8888);

        Canvas canvas = new Canvas(targetBitmap);
        Path path = new Path();
        path.addCircle(((float) targetWidth - 1) / 2,
                ((float) targetHeight - 1) / 2,
                (Math.min(((float) targetWidth),
                        ((float) targetHeight)) / 2),
                Path.Direction.CCW);
        canvas.clipPath(path);
        Bitmap sourceBitmap = scaleBitmapImage;
        canvas.drawBitmap(sourceBitmap,
                new Rect(0, 0, sourceBitmap.getWidth(),
                        sourceBitmap.getHeight()),
                new Rect(0, 0, targetWidth,
                        targetHeight), null);
        return targetBitmap;
    }

}




