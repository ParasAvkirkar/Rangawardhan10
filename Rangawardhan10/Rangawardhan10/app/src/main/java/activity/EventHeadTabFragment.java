package activity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.akashj.rangawardhan10.R;

/**
 * Created by Rohit on 22/11/2015.
 */
public class EventHeadTabFragment extends Fragment{

    private int position;
    private TextView descriptionTextView;
    private ListView eventHeadsListView;
    private ListViewBaseAdapter listViewBaseAdapter;


    public EventHeadTabFragment(int position) {
        this.position = position;
    }

    public EventHeadTabFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_tab_eventhead, container, false);
        eventHeadsListView = (ListView)view.findViewById(R.id.eventHeadsListView);

        listViewBaseAdapter = new ListViewBaseAdapter(getActivity(), R.layout.eventhead_list_item, MainTab.names, MainTab.phoneNo);


        //Toast.makeText(getActivity(), "Event Head Fragment Called", //Toast.LENGTH_LONG).show();
        eventHeadsListView.setAdapter(listViewBaseAdapter);
        return view;
    }

}
