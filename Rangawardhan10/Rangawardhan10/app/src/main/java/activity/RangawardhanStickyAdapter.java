package activity;

/**
 * Created by akashj on 20/11/2015.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.example.akashj.rangawardhan10.R;

import java.util.ArrayList;

import se.emilsjolander.stickylistheaders.StickyListHeadersAdapter;


public class RangawardhanStickyAdapter extends ArrayAdapter<RangawardhanStickyCommittee> implements StickyListHeadersAdapter {


    private Context context;
    private String[] mHeaders;

    public RangawardhanStickyAdapter(Context context, ArrayList<RangawardhanStickyCommittee> mItems, String[] mHeaders) {
        super(context, R.layout.rangawardhan_sticky_list_item_committee, mItems);
        this.context = context;
        this.mHeaders = mHeaders;
    }

    private static final class ViewHolder {
        TextView name;
        TextView number;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.rangawardhan_sticky_list_item_committee, parent, false);
            holder.name =  (TextView) convertView.findViewById(R.id.rangawardhan_list_item_event_head_name);
            holder.number = (TextView) convertView.findViewById(R.id.rangawardhan_list_item_event_head_number);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.name.setText(getItem(position).getName().split(":")[0]);
        try {
            holder.number.setText(getItem(position).getName().split(":")[1].replace(" ", ""));
            YoYo.with(Techniques.FlipInX)
                    .duration(1000)
                    .playOn((TextView)convertView.findViewById(R.id.rangawardhan_list_item_event_head_name));

            YoYo.with(Techniques.FlipInX)
                    .duration(1000)
                    .playOn(convertView.findViewById(R.id.rangawardhan_list_item_event_head_number));

        } catch (ArrayIndexOutOfBoundsException ignore) {
            holder.number.setText("");
        }
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
            view = LayoutInflater.from(context).inflate(R.layout.rangawardhan_sticky_list_item_header, viewGroup, false);
            holder.textView = (TextView) view.findViewById(R.id.rangawardhan_list_item_header);
            view.setTag(holder);
        } else {
            holder = (HeaderViewHolder) view.getTag();
        }

        holder.textView.setText(mHeaders[getItem(i).getPosition()]);
        return view;
    }
}

