package activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.akashj.rangawardhan10.R;

/**
 * Created by Rohit on 23/11/2015.
 */
public class RWallFragment extends Fragment implements View.OnClickListener{
    private Button btn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View v = (View)inflater.inflate(R.layout.rwall_fragment_layout, container, false);
            btn = (Button)v.findViewById(R.id.show_images);
            btn.setOnClickListener(this);

        Toolbar toolbar;
        toolbar=(Toolbar)getActivity().findViewById(R.id.toolbar);
        TextView tv = (TextView) toolbar.findViewById(R.id.toolbar_title);
        tv.setText(R.string.nav_item_rwall);
        tv.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),
                "fonts/LobsterTwo-Regular.otf"));
        //toolbar.setTitle(R.string.title_home);

        TextView myTextView=(TextView) v.findViewById(R.id.text1_rwall);
        Typeface typeFace=Typeface.createFromAsset(getActivity().getAssets(), "fonts/JosefinSlab-Bold.ttf");
        myTextView.setTypeface(typeFace);

         myTextView=(TextView) v.findViewById(R.id.text2_rwall);
         typeFace=Typeface.createFromAsset(getActivity().getAssets(), "fonts/JosefinSlab-Bold.ttf");
        myTextView.setTypeface(typeFace);


        myTextView=(TextView) v.findViewById(R.id.text3_rwall);
        typeFace=Typeface.createFromAsset(getActivity().getAssets(), "fonts/JosefinSlab-Bold.ttf");
        myTextView.setTypeface(typeFace);


        myTextView=(TextView) v.findViewById(R.id.text4_rwall);
        typeFace=Typeface.createFromAsset(getActivity().getAssets(), "fonts/JosefinSlab-Bold.ttf");
        myTextView.setTypeface(typeFace);


        myTextView=(TextView) v.findViewById(R.id.text5_rwall);
        typeFace=Typeface.createFromAsset(getActivity().getAssets(), "fonts/JosefinSlab-Bold.ttf");
        myTextView.setTypeface(typeFace);


        myTextView=(TextView) v.findViewById(R.id.text6_rwall);
        typeFace=Typeface.createFromAsset(getActivity().getAssets(), "fonts/JosefinSlab-Bold.ttf");
        myTextView.setTypeface(typeFace);


        myTextView=(TextView) v.findViewById(R.id.text7_rwall);
        typeFace=Typeface.createFromAsset(getActivity().getAssets(), "fonts/JosefinSlab-Bold.ttf");
        myTextView.setTypeface(typeFace);


        myTextView=(TextView) v.findViewById(R.id.text8_rwall);
        typeFace=Typeface.createFromAsset(getActivity().getAssets(), "fonts/JosefinSlab-Bold.ttf");
        myTextView.setTypeface(typeFace);

        return v;
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.show_images)
        {
            Intent i = new Intent(getActivity(), RWallPagerActivity.class);
            startActivity(i);
        }
    }


    @Override
    public void onResume() {
        super.onResume();
        // Set title
        Toolbar toolbar;
        toolbar=(Toolbar)getActivity().findViewById(R.id.toolbar);
        TextView tv = (TextView) toolbar.findViewById(R.id.toolbar_title);
        tv.setText(R.string.nav_item_rwall);
        tv.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),
                "fonts/LobsterTwo-Regular.otf"));
        //toolbar.setTitle(R.string.title_home);
    }

}
