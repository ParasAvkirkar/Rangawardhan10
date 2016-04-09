package activity;

/**
 * Created by akashj on 20/11/2015.
 */

import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.example.akashj.rangawardhan10.R;
import com.nhaarman.listviewanimations.appearance.StickyListHeadersAdapterDecorator;
import com.nhaarman.listviewanimations.appearance.simple.AlphaInAnimationAdapter;

import java.util.ArrayList;

import adapter.SponsorStickyAdapter;
import se.emilsjolander.stickylistheaders.StickyListHeadersListView;


public class SponsorStickyFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Toolbar toolbar;
        toolbar=(Toolbar)getActivity().findViewById(R.id.toolbar);
        TextView tv = (TextView) toolbar.findViewById(R.id.toolbar_title);
        tv.setText(R.string.nav_item_sponsors);
        tv.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),
                "fonts/LobsterTwo-Regular.otf"));
        //toolbar.setTitle(R.string.title_home);

        return inflater.inflate(R.layout.sticky_sponsor_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        ArrayList<StickySponsor> stickySponsors = new ArrayList<>();
        //int imageIds[] = getResources().getIntArray(R.array.ranga_spons);

        TypedArray array = getResources().obtainTypedArray(R.array.ranga_spons);
        int imageIds[] = new int[array.length()];
        for (int i = 0; i < imageIds.length; i++) {
            imageIds[i] = array.getResourceId(i, -1);
        }

        stickySponsors.add(new StickySponsor(imageIds[0], 0));
        stickySponsors.add(new StickySponsor(imageIds[1], 1));
        stickySponsors.add(new StickySponsor(imageIds[2], 2));
        stickySponsors.add(new StickySponsor(imageIds[3], 3));
        stickySponsors.add(new StickySponsor(imageIds[4],4 ));
        stickySponsors.add(new StickySponsor(imageIds[5], 4));
        stickySponsors.add(new StickySponsor(imageIds[6],4 ));
        stickySponsors.add(new StickySponsor(imageIds[7],4 ));
        stickySponsors.add(new StickySponsor(imageIds[8], 5));
        stickySponsors.add(new StickySponsor(imageIds[9],5 ));
        stickySponsors.add(new StickySponsor(imageIds[10],6 ));
        stickySponsors.add(new StickySponsor(imageIds[11],7 ));
        stickySponsors.add(new StickySponsor(imageIds[12],8 ));
        stickySponsors.add(new StickySponsor(imageIds[13],9 ));



        AlphaInAnimationAdapter animationAdapter = new AlphaInAnimationAdapter(new SponsorStickyAdapter(
                getActivity(), stickySponsors, getResources().getStringArray(R.array.sponsor_headers)));
        StickyListHeadersAdapterDecorator decorator = new StickyListHeadersAdapterDecorator(animationAdapter);
        StickyListHeadersListView stickyListView = (StickyListHeadersListView)
                getActivity().findViewById(R.id.rangawardhan_fragment_sponsor_list);
        decorator.setStickyListHeadersListView((stickyListView));
        stickyListView.setAdapter(decorator);
        stickyListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                YoYo.with(Techniques.Pulse)
                        .duration(1000)
                        .playOn(view);
            }
        });
    }


    @Override
    public void onResume() {
        super.onResume();
        // Set title
        Toolbar toolbar;
        toolbar=(Toolbar)getActivity().findViewById(R.id.toolbar);
        TextView tv = (TextView) toolbar.findViewById(R.id.toolbar_title);
        tv.setText(R.string.nav_item_sponsors);
        tv.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),
                "fonts/LobsterTwo-Regular.otf"));
        //toolbar.setTitle(R.string.title_home);
    }

}
