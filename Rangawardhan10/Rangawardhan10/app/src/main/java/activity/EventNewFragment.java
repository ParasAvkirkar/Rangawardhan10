package activity;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import com.example.akashj.rangawardhan10.R;
import com.twotoasters.jazzylistview.JazzyHelper;
import com.twotoasters.jazzylistview.JazzyListView;

import java.util.HashMap;

public class EventNewFragment extends Fragment {
    private JazzyListView mJazzyList;
    private HashMap<String, Integer> mEffectMap;
    //private int mCurrentTransitionEffect = JazzyHelper.ZIPPER;
    private int mCurrentTransitionEffect = JazzyHelper.REVERSE_FLY;
    private static final String KEY_TRANSITION_EFFECT = "transition_effect";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_event_new, container, false);

        Toolbar toolbar;
        toolbar=(Toolbar)getActivity().findViewById(R.id.toolbar);
        TextView tv = (TextView) toolbar.findViewById(R.id.toolbar_title);
        tv.setText(R.string.nav_item_events);
        tv.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),
                "fonts/LobsterTwo-Regular.otf"));
        //toolbar.setTitle(R.string.nav_item_events);


        //Toast.makeText(getActivity(), "Event New called", //Toast.LENGTH_LONG).show();
        mJazzyList = (JazzyListView) rootView.findViewById(R.id.event_list);
        // if(mGrid == null)
        //   //Toast.makeText(getActivity(), "null", //Toast.LENGTH_LONG).show();
        mJazzyList.setAdapter(new JazzyListAdapter(rootView.getContext(), R.layout.event_list_item));
        mJazzyList.setSmoothScrollbarEnabled(true);
        mJazzyList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                /*Intent i = new Intent(getActivity(), FullScreenViewActivity.class);
                i.putExtra("position", position);
                getActivity().startActivity(i);*/
            }
        });
        if (savedInstanceState != null) {
            //mCurrentTransitionEffect = savedInstanceState.getInt(KEY_TRANSITION_EFFECT, JazzyHelper.ZIPPER);
            mCurrentTransitionEffect = savedInstanceState.getInt(KEY_TRANSITION_EFFECT, JazzyHelper.REVERSE_FLY);
            setupJazziness(mCurrentTransitionEffect);
        }
        else
            setupJazziness(mCurrentTransitionEffect);

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
    }
    @Override
    public void onResume() {
        super.onResume();
        Toolbar toolbar;
        toolbar=(Toolbar)getActivity().findViewById(R.id.toolbar);
        TextView tv = (TextView) toolbar.findViewById(R.id.toolbar_title);
        tv.setText(R.string.nav_item_events);
        tv.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),
                "fonts/LobsterTwo-Regular.otf"));
        //toolbar.setTitle(R.string.nav_item_events);

    }

    private void setupJazziness(int effect) {
        mCurrentTransitionEffect = effect;
        mJazzyList.setTransitionEffect(mCurrentTransitionEffect);
    }

}
