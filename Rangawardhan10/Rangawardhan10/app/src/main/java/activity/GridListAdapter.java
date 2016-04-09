package activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.andexert.library.RippleView;
import com.example.akashj.rangawardhan10.R;

import java.util.ArrayList;
import java.util.List;

class GridListAdapter extends ArrayAdapter{

    private final LayoutInflater inflater;
    private final Resources res;
    private final int itemLayout;
    private int imageIds[];
    // private List imageListIds;
    private Context context;
    public static List<Bitmap> listBitmaps;
    public GridListAdapter(Context context, int itemLayout) {
        super(context, itemLayout);
        this.context = context;
        imageIds = ListModel.getModelImage();
        inflater = LayoutInflater.from(context);
        res = context.getResources();
        this.itemLayout = itemLayout;
        listBitmaps = new ArrayList<>();
        for (int i = 0; i < imageIds.length; i++) {
            listBitmaps.add(null);
        }
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

        //int colorResId = position % 2 == 0 ? R.color.even : R.color.odd;
        //holder.text.setBackgroundColor(res.getColor(colorResId));
        //holder.text.setText(ListModel.getModelItem(position));

        //holder.imgV.setImageResource(ListModel.getModelImageItem(position));
        int gridImageId = ListModel.getModelImageItem(position);
        ViewGroup.LayoutParams lp = holder.imgV.getLayoutParams();
        lp.width = (int)(((WindowManager)getContext().getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getWidth()*0.5f);
        lp.height = (int)(((WindowManager)getContext().getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getHeight()*0.25f);






        if(listBitmaps.get(position) != null)
            holder.imgV.setImageBitmap(listBitmaps.get(position));
        else{
            Bitmap bm = utilsol.decodeSampledBitmapFromResource(context.getResources(),
                    imageIds[position],lp.width, lp.height);
            //Bitmap bm = utilsol.decodeFile(imageIds[position], context.getResources(), lp.width, lp.height);
            listBitmaps.add(position, bm);
            holder.imgV.setImageBitmap(bm);
        }

        holder.imgV.setLayoutParams(lp);
        /*holder.imgV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, FullScreenViewActivity.class);
                i.putExtra("position", position);
                context.startActivity(i);

            }});*/
        ////Toast.makeText(getContext(), ""+imageIds[position], //Toast.LENGTH_LONG).show();
        RippleView rippleView = (RippleView) convertView.findViewById(R.id.gridItemRipple);
        rippleView.setOnRippleCompleteListener(new RippleView.OnRippleCompleteListener() {

            @Override
            public void onComplete(RippleView rippleView) {
                //Toast.makeText(context, "item click", //Toast.LENGTH_LONG).show();
                Intent i = new Intent(context, NewGalleryFragment.class);
                i.putExtra("position", position);
                /*for (Bitmap bm:listBitmaps
                        ) {
                    if(bm != null)
                        bm.recycle();
                }*/

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
            imgV = (ImageView) view.findViewById(R.id.grid_image_item);
        }
    }

}
