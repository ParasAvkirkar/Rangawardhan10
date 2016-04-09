package activity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.akashj.rangawardhan10.R;

/**
 * Created by Dr.h3cker on 14/03/2015.
 */
public class IntroductionTabFragment extends Fragment {

    int position;
    private TextView descriptionTextView;

    public IntroductionTabFragment(int position) {
        this.position = position;
    }

    public IntroductionTabFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_tab_introduction,container,false);
        descriptionTextView = (TextView)view.findViewById(R.id.tabIntroduction);

        Typeface typeFace=Typeface.createFromAsset(getActivity().getAssets(), "fonts/JosefinSlab-Bold.ttf");
        descriptionTextView.setTypeface(typeFace);

        descriptionTextView.setText(getResources().getString(MainTab.descriptionIds[position]));

        return  view;
    }

}
