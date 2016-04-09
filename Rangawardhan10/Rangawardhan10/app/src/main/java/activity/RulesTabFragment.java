package activity;

import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.BulletSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.akashj.rangawardhan10.R;

/**
 * Created by Dr.h3cker on 14/03/2015.
 */
public class RulesTabFragment extends Fragment {
    TextView textView;
    String eventName;
    private int position;

    public RulesTabFragment(int position) {
        this.position = position;
    }

    public RulesTabFragment(){}


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view =inflater.inflate(R.layout.fragment_tab_rules, container, false);

        textView=(TextView)view.findViewById(R.id.tabRules);
        Typeface typeFace=Typeface.createFromAsset(getActivity().getAssets(), "fonts/JosefinSlab-Bold.ttf");
        textView.setTypeface(typeFace);

        TypedArray array = getResources().obtainTypedArray(R.array.event_rule_array);
        int id = array.getResourceId(position, -1);
        //Toast.makeText(getActivity(), "position "+position, //Toast.LENGTH_LONG).show();
        if(position < 0 )
            return view;
        String rulesArray[] = getResources().getStringArray(id);
        CharSequence cs;
        SpannableString ss[]=new SpannableString[rulesArray.length];
        for(int i = 0; i < rulesArray.length; i++)
        {
            cs = rulesArray[i];
            ss[i] = new SpannableString(cs);
            ss[i].setSpan(new BulletSpan((15)), 0, rulesArray[i].length(), 0);
        }
        /*CharSequence t1 = getText(R.string.rules_kawadsa1);
        SpannableString s1 = new SpannableString(t1);
        s1.setSpan(new BulletSpan(15),0,t1.length(),0);

        CharSequence t2 = getText(R.string.rules_kawadsa2);
        SpannableString s2 = new SpannableString(t2);
        s2.setSpan(new BulletSpan(15),0,t2.length(),0);

        CharSequence t3 = getText(R.string.rules_kawadsa3);
        SpannableString s3 = new SpannableString(t3);
        s3.setSpan(new BulletSpan(15),0,t3.length(),0);


        CharSequence t4 = getText(R.string.rules_kawadsa4);
        SpannableString s4 = new SpannableString(t4);
        s4.setSpan(new BulletSpan(15),0,t4.length(),0);

        CharSequence t5 = getText(R.string.rules_kawadsa5);
        SpannableString s5 = new SpannableString(t5);
        s5.setSpan(new BulletSpan(15),0,t5.length(),0);

        CharSequence t6 = getText(R.string.rules_kawadsa6);
        SpannableString s6 = new SpannableString(t6);
        s6.setSpan(new BulletSpan(15),0,t6.length(),0);


        CharSequence t7 = getText(R.string.rules_kawadsa7);
        SpannableString s7 = new SpannableString(t7);
        s7.setSpan(new BulletSpan(15),0,t7.length(),0);


        CharSequence t8 = getText(R.string.rules_kawadsa8);
        SpannableString s8 = new SpannableString(t8);
        s8.setSpan(new BulletSpan(15),0,t8.length(),0);
*/
        //textView.setText(TextUtils.concat(s1, s2, s3, s4, s5, s6, s7, s8));
        textView.setText(TextUtils.concat(ss));
        return view;
    }
}
