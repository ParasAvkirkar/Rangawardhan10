package activity;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.akashj.rangawardhan10.R;

import java.util.Locale;

/**
 * Created by Dr.h3cker on 14/03/2015.
 */
public class ma_pager_adapter extends FragmentPagerAdapter {
    private Context context;
    private int position;
    public ma_pager_adapter(FragmentManager fm, Context context, int position) {
        super(fm);
        this.context = context;
        this.position = position;
    }


    @Override
    public Fragment getItem(int i) {

        switch (i) {
            case 0:
                return new IntroductionTabFragment(position);
            case 1:
                return new RulesTabFragment(position);
            case 2:
                return new EventHeadTabFragment(position);
            case 3:
                return new RegistrationTabFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 4;
    }//set the number of tabs

    @Override
    public CharSequence getPageTitle(int position) {
        Locale l = Locale.getDefault();
        String tabNames[] = context.getResources().getStringArray(R.array.event_tab_names);
        /*switch (position) {
            case 0:
                return "Top stories";
            case 1:

                return "Members";
            case 2:

                return "Setting";
        }*/
        if(position > 3)
            return "";
        else
            return tabNames[position];
    }



}
