package adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.example.akashj.rangawardhan10.R;

import java.util.ArrayList;

import activity.StickySponsor;
import se.emilsjolander.stickylistheaders.StickyListHeadersAdapter;

/**
 * Created by akashj on 20/11/2015.
 */


public class SponsorStickyAdapter extends ArrayAdapter<StickySponsor> implements StickyListHeadersAdapter {


    private Context context;
    private String[] mHeaders;
    //private int[] imageIds;
    int length;

    public SponsorStickyAdapter(Context context, ArrayList<StickySponsor> mItems, String[] mHeaders) {
        super(context, R.layout.sticky_sponsor_fragment, mItems);
        this.context = context;
        this.mHeaders = mHeaders;
        this.length = mItems.size();
        //this.imageIds = context.getResources().getIntArray(R.array.ranga_spons);
    }

    public static final class ViewHolder {
        ImageView sponsorImageView;

        public ImageView getSponsorImageView() {
            return sponsorImageView;
        }
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.sponsor_list_item, parent, false);
            holder.sponsorImageView = (ImageView)convertView.findViewById(R.id.sponsor_list_item_image);
            convertView.setTag(holder);
            YoYo.with(Techniques.Pulse)
                    .duration(1000)
                    .playOn(holder.sponsorImageView);
            Log.i("TAG", "pulsing");
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.sponsorImageView.setImageResource(getItem(position).getImageId());
        ViewGroup.LayoutParams lp = holder.sponsorImageView.getLayoutParams();
        lp.width = (int)(((WindowManager)context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getWidth());
        lp.height = (int)(((WindowManager)context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getHeight()*0.33f);
        holder.sponsorImageView.setLayoutParams(lp);
       /* if(position == length-1){
            holder.sponsorImageView.setPadding(0,0,0,100);
        }
*/
        return convertView;
    }

    @Override
    public long getHeaderId(int i) {
        return getItem(i).getPosition();
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    private static final class HeaderViewHolder {
        TextView textView;
    }

    @Override
    public View getHeaderView(int i, View view, ViewGroup viewGroup) {

        HeaderViewHolder holder;

        if (view == null) {
            holder = new HeaderViewHolder();
            view = LayoutInflater.from(context).inflate(R.layout.sponsor_sticky_list_item_header, viewGroup, false);
            holder.textView = (TextView) view.findViewById(R.id.sponsor_list_item_header);
            view.setTag(holder);
            YoYo.with(Techniques.FlipInX)
                    .duration(1000)
                    .playOn((TextView) view.findViewById(R.id.sponsor_list_item_header));

        } else {
            holder = (HeaderViewHolder) view.getTag();
        }
        holder.textView.setText(mHeaders[getItem(i).getPosition()]);

        return view;
    }
}

