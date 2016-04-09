package activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import com.example.akashj.rangawardhan10.R;
import com.twotoasters.jazzylistview.JazzyGridView;
import com.twotoasters.jazzylistview.JazzyHelper;

import java.util.HashMap;

public class GalleryNewFragment extends Fragment {
    private JazzyGridView mGrid;
    private HashMap<String, Integer> mEffectMap;
    private int mCurrentTransitionEffect = JazzyHelper.FLIP;
    private static final String KEY_TRANSITION_EFFECT = "transition_effect";
    private GridListAdapter gridListAdapter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_gallery_new, container, false);
        Toolbar toolbar;
        toolbar=(Toolbar)getActivity().findViewById(R.id.toolbar);
        TextView tv = (TextView) toolbar.findViewById(R.id.toolbar_title);
        tv.setText(R.string.nav_item_gallery);
        tv.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),
                "fonts/LobsterTwo-Regular.otf"));
        //toolbar.setTitle(R.string.nav_item_gallery);

        //Toast.makeText(getActivity(), "Gallery called", //Toast.LENGTH_LONG).show();
        mGrid = (JazzyGridView) rootView.findViewById(android.R.id.list);
        gridListAdapter = new GridListAdapter(rootView.getContext(), R.layout.grid_item);
        mGrid.setAdapter(gridListAdapter);

        mGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(getActivity(), "item click", //Toast.LENGTH_LONG).show();
                Intent i = new Intent(getActivity(), NewGalleryFragment.class);
                i.putExtra("position", position);
                getActivity().startActivity(i);
            }
        });


        if (savedInstanceState != null) {
            mCurrentTransitionEffect = savedInstanceState.getInt(KEY_TRANSITION_EFFECT, JazzyHelper.HELIX);
            setupJazziness(mCurrentTransitionEffect);
        }

        // Inflate the layout for this fragment
        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        /*for(Bitmap bm: GridListAdapter.listBitmaps)
            if(bm != null)
                bm.recycle();
        for(Bitmap bm: FullScreenImageAdapter.bitmapList)
            if(bm != null)
                bm.recycle();*/
        for (Bitmap bm:gridListAdapter.listBitmaps
                ) {
            if(bm != null)
                bm.recycle();
        }
        Log.i("TAG", "gallery grid is detached");
    }

    @Override
    public void onResume() {
        super.onResume();
        // Set title
        Toolbar toolbar;
        toolbar=(Toolbar)getActivity().findViewById(R.id.toolbar);
        TextView tv = (TextView) toolbar.findViewById(R.id.toolbar_title);
        tv.setText(R.string.nav_item_gallery);
        tv.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),
                "fonts/LobsterTwo-Regular.otf"));
        //toolbar.setTitle(R.string.nav_item_gallery);
    }

    private void setupJazziness(int effect) {
        mCurrentTransitionEffect = effect;
        mGrid.setTransitionEffect(mCurrentTransitionEffect);
    }

}
