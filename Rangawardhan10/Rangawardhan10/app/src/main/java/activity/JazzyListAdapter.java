package activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.andexert.library.RippleView;
import com.example.akashj.rangawardhan10.R;

/**
 * Created by akashj on 20/11/2015.
 */
public class JazzyListAdapter extends ArrayAdapter {

    private final LayoutInflater inflater;
    private final Resources res;
    private final int itemLayout;
    private int imageIds[];
    // private List imageListIds;
    private Context context;

    public JazzyListAdapter(Context context, int itemLayout) {
        super(context, itemLayout);
        this.context = context;
        imageIds = ListModel.getEventImagesIdArray();
        inflater = LayoutInflater.from(context);
        res = context.getResources();
        this.itemLayout = itemLayout;
    }



    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;


        if (convertView == null) {
            convertView = inflater.inflate(itemLayout, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        ViewGroup.LayoutParams lp = holder.imgV.getLayoutParams();
        //lp.width = (int)(((WindowManager)context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getWidth());
        lp.width = ViewGroup.LayoutParams.MATCH_PARENT;
        lp.height = (int)(((WindowManager)context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getHeight()*0.25f);


        //int colorResId = position % 2 == 0 ? R.color.even : R.color.odd;
        //holder.text.setBackgroundColor(res.getColor(colorResId));
        //holder.text.setText(ListModel.getModelItem(position));

        //holder.imgV.setImageResource(imageIds[position]);
        holder.imgV.setImageBitmap(
                utilsol.decodeSampledBitmapFromResource(context.getResources(), imageIds[position], lp.width, lp.height));
        holder.imgV.setLayoutParams(lp);


        ////Toast.makeText(getContext(), ""+imageIds[position], //Toast.LENGTH_LONG).show();
        RippleView rippleView = (RippleView) convertView.findViewById(R.id.eventListRipple);
        rippleView.setOnRippleCompleteListener(new RippleView.OnRippleCompleteListener() {

            @Override
            public void onComplete(RippleView rippleView) {
                //Toast.makeText(context, "ripple clicked", //Toast.LENGTH_LONG).show();
               /* Intent i = new Intent(context, NewTabEventActivity.class);
                i.putExtra("position", position);
             String eventNamesArray[] = context.getResources().getStringArray(R.array.event_names_array);*/

                Intent i = new Intent(context, MainTab.class);
                i.putExtra(context.getString(R.string.position), position);
                context.startActivity(i);

            }

        });

        return convertView;
    }

    @Override
    public int getCount() {
        return imageIds.length;
    }


    static class ViewHolder {
        final ImageView imgV;

        ViewHolder(View view) {
            imgV = (ImageView) view.findViewById(R.id.event_image_item);
        }
    }
}
