package activity;

/**
 * Created by akashj on 20/11/2015.
 */

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.akashj.rangawardhan10.R;
import com.nhaarman.listviewanimations.appearance.StickyListHeadersAdapterDecorator;
import com.nhaarman.listviewanimations.appearance.simple.AlphaInAnimationAdapter;

import java.util.ArrayList;

import se.emilsjolander.stickylistheaders.StickyListHeadersListView;


public class RangawardhanStickyCommitteeFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        Toolbar toolbar;
        toolbar=(Toolbar)getActivity().findViewById(R.id.toolbar);
        TextView tv = (TextView) toolbar.findViewById(R.id.toolbar_title);
        tv.setText(R.string.nav_item_aboutus);
        tv.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),
                "fonts/LobsterTwo-Regular.otf"));
        //toolbar.setTitle(R.string.title_home);
        return inflater.inflate(R.layout.rangawardhan_sticky_committee_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        ArrayList<RangawardhanStickyCommittee> mCommittee = new ArrayList<>();

        mCommittee.add(new RangawardhanStickyCommittee("Akshay Khairkar: +918976137589", 0));

        mCommittee.add(new RangawardhanStickyCommittee("Pranoti Tarde: +917756974898", 1));

        mCommittee.add(new RangawardhanStickyCommittee("Akshay Chaudhary: +919503711710", 2));

        mCommittee.add(new RangawardhanStickyCommittee("Pravin Waghe: +919960618082", 3));

        mCommittee.add(new RangawardhanStickyCommittee("Ankit Chaudhary: +919403639459", 4));
        mCommittee.add(new RangawardhanStickyCommittee("Chaitanya Rekhi: +918796748222", 4));
        mCommittee.add(new RangawardhanStickyCommittee("Neeraj Kulkarni: +919702216911", 4));
        mCommittee.add(new RangawardhanStickyCommittee("Priya Masne: +918806209812", 4));
        mCommittee.add(new RangawardhanStickyCommittee("Pushkar Oke: +918976598432", 4));

        mCommittee.add(new RangawardhanStickyCommittee("Ketan Thakare: +919167749669", 5));
        mCommittee.add(new RangawardhanStickyCommittee("Prajyot Hasbe: +919967937897", 5));
        mCommittee.add(new RangawardhanStickyCommittee("Sagar Mehta: +918793197183", 5));

        mCommittee.add(new RangawardhanStickyCommittee("Ajay Wayal: +917767901801", 6));
        mCommittee.add(new RangawardhanStickyCommittee("Shraddha Kadamwar: +917666287316", 6));
        mCommittee.add(new RangawardhanStickyCommittee("Vyankatesh Khadakkar: +918806609444", 6));

        mCommittee.add(new RangawardhanStickyCommittee("Ajinkya Palwe: +919404323538", 7));
        mCommittee.add(new RangawardhanStickyCommittee("Alok Kadam: +917028926244", 7));

        mCommittee.add(new RangawardhanStickyCommittee("Akshay Raskar: +919594933765", 8));
        mCommittee.add(new RangawardhanStickyCommittee("Poorva Bagale: +919029833961", 8));
        mCommittee.add(new RangawardhanStickyCommittee("Shivanee Shinde: +918421619006", 8));

        mCommittee.add(new RangawardhanStickyCommittee("Aishwarya Kale: +919699541984", 9));
        mCommittee.add(new RangawardhanStickyCommittee("Vishkha Munde: +917798027823", 9));

        mCommittee.add(new RangawardhanStickyCommittee("Dhananjay Nagarjoge: +918888771135", 10));
        mCommittee.add(new RangawardhanStickyCommittee("Nilesh Bhoir: +918693090260", 10));
        mCommittee.add(new RangawardhanStickyCommittee("Priya Vaity: +919987888397", 10));

        mCommittee.add(new RangawardhanStickyCommittee("Shubham Puri: +917620763020", 11));
        mCommittee.add(new RangawardhanStickyCommittee("", 11));





        AlphaInAnimationAdapter animationAdapter = new AlphaInAnimationAdapter(new RangawardhanStickyAdapter(
                getActivity(), mCommittee, getResources().getStringArray(R.array.rangawardhan_committe_posts)));
        StickyListHeadersAdapterDecorator decorator = new StickyListHeadersAdapterDecorator(animationAdapter);
        decorator.setStickyListHeadersListView(((StickyListHeadersListView) getActivity().findViewById(R.id.rangawardhan_fragment_committee_list)));
        ((StickyListHeadersListView) getActivity().findViewById(R.id.rangawardhan_fragment_committee_list)).setAdapter(decorator);

    }

    @Override
    public void onResume() {
        super.onResume();
        // Set title
        Toolbar toolbar;
        toolbar=(Toolbar)getActivity().findViewById(R.id.toolbar);
        TextView tv = (TextView) toolbar.findViewById(R.id.toolbar_title);
        tv.setText(R.string.nav_item_aboutus);
        tv.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),
                "fonts/LobsterTwo-Regular.otf"));
        //toolbar.setTitle(R.string.title_home);
    }

}
