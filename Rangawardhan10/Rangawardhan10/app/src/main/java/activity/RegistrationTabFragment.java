package activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.andexert.library.RippleView;
import com.example.akashj.rangawardhan10.R;

/**
 * Created by Dr.h3cker on 16/03/2015.
 */
public class RegistrationTabFragment extends Fragment {

    private int position;

    public RegistrationTabFragment(int position) {
        this.position = position;
    }
    public RegistrationTabFragment(){}
    RippleView rippleView;


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_tab_registration, container, false);

        rippleView=(RippleView)view.findViewById(R.id.registerRipple);
        rippleView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                /*if(position==7) //Toast.makeText(getActivity(),"Registration for fun events will be on the spot",//Toast.LENGTH_LONG).show();
                else*/ {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("https://docs.google.com/forms/d/1baWMzcMyCLM7WMP4rVaq0teyd7hBIL0xyRPK-1SjTy8/formResponse"));
                    startActivity(intent);
                }
            }
        });

        return view;
    }


}
