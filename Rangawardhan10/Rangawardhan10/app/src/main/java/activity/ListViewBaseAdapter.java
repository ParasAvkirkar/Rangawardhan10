package activity;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.akashj.rangawardhan10.R;

import java.util.List;

/**
 * Created by Rohit on 22/11/2015.
 */
public class ListViewBaseAdapter extends BaseAdapter {

    private Context context;
    private List<String> names;
    private List<String> phoneNumber;
    private int layoutResId;

    ListViewBaseAdapter(Context context, int layoutResId, List<String> names, List<String> phoneNumber){
        this.context = context;
        this.names = names;
        this.layoutResId = layoutResId;
        this.phoneNumber = phoneNumber;
    }

    static class ViewHolder{
        TextView nameTextView, phoneNoTextView;
    }

    @Override
    public int getCount() {
        return names.size();
    }

    @Override
    public Object getItem(int position) {
        return names.get(position)+phoneNumber.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;

        LayoutInflater mInflater = (LayoutInflater)
                context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = mInflater.inflate(layoutResId, null);
            holder = new ViewHolder();
            holder.nameTextView = (TextView)convertView.findViewById(R.id.event_head_name);
            holder.phoneNoTextView = (TextView)convertView.findViewById(R.id.event_head_number);
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }
        if(holder.nameTextView == null)
        {
            //Toast.makeText(context,"names "+names.get(position),//Toast.LENGTH_LONG).show();
            return convertView;
        }
        holder.nameTextView.setText(names.get(position));
        holder.phoneNoTextView.setText(phoneNumber.get(position));

        return convertView;
    }
}
