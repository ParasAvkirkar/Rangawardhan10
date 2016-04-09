package activity;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.akashj.rangawardhan10.R;


/**
 * Created by Rohit on 25/07/2015.
 */
public class ThemeFragment extends Fragment {

    public ThemeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.themefragment, container, false);
        Toolbar toolbar;
        toolbar=(Toolbar)getActivity().findViewById(R.id.toolbar);
        TextView tv = (TextView) toolbar.findViewById(R.id.toolbar_title);
        tv.setText(R.string.nav_item_theme);
        tv.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),
                "fonts/LobsterTwo-Regular.otf"));

        TextView myTextView=(TextView) rootView.findViewById(R.id.Theme_title);
        Typeface typeFace=Typeface.createFromAsset(getActivity().getAssets(), "fonts/JosefinSlab-Bold.ttf");
        myTextView.setTypeface(typeFace);
        myTextView=(TextView) rootView.findViewById(R.id.theme_desc);
        typeFace=Typeface.createFromAsset(getActivity().getAssets(), "fonts/JosefinSlab-Bold.ttf");
        myTextView.setTypeface(typeFace);

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
        // Set title
        Toolbar toolbar;
        toolbar=(Toolbar)getActivity().findViewById(R.id.toolbar);
        TextView tv = (TextView) toolbar.findViewById(R.id.toolbar_title);
        tv.setText(R.string.nav_item_theme);
        tv.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),
                "fonts/LobsterTwo-Regular.otf"));
    }
}
