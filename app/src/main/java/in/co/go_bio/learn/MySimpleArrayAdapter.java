package in.co.go_bio.learn;

/**
 * Created by rishabh on 13/6/16.
 */

import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.widget.ArrayAdapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


public class MySimpleArrayAdapter extends ArrayAdapter<String> {
    private final Context context;
    private final List<String> category;
    private LayoutInflater inflater = null;
    public MySimpleArrayAdapter(Context context, List<String> category) {
        super(context,-1,category);
        this.context = context;
        this.category = category;
        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    static class ViewHolder {
        public TextView text;
        public ImageView[] images;
        public TextView[] t;
        public int position;
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;
        ViewHolder viewHolder;
        if (rowView == null) {
            rowView = inflater.inflate(R.layout.learn_list_row, null);
            viewHolder = new ViewHolder();
            viewHolder.text = (TextView) rowView.findViewById(R.id.nayatext1);
            viewHolder.images = new ImageView[6];
            viewHolder.t = new TextView[6];
            viewHolder.images[0] = (ImageView) rowView.findViewById(R.id.imageView_1);
            viewHolder.images[1] = (ImageView) rowView.findViewById(R.id.imageView_2);
            viewHolder.images[2] = (ImageView) rowView.findViewById(R.id.imageView_3);
            viewHolder.images[3] = (ImageView) rowView.findViewById(R.id.imageView_4);
            viewHolder.images[4] = (ImageView) rowView.findViewById(R.id.imageView_5);
            viewHolder.images[5] = (ImageView) rowView.findViewById(R.id.imageView_6);
            viewHolder.t[0] = (TextView) rowView.findViewById(R.id.textView_1);
            viewHolder.t[1] = (TextView) rowView.findViewById(R.id.textView_2);
            viewHolder.t[2] = (TextView) rowView.findViewById(R.id.textView_3);
            viewHolder.t[3] = (TextView) rowView.findViewById(R.id.textView_4);
            viewHolder.t[4] = (TextView) rowView.findViewById(R.id.textView_5);
            viewHolder.t[5] = (TextView) rowView.findViewById(R.id.textView_6);
            rowView.setTag(viewHolder);
        } else
            viewHolder = (ViewHolder) rowView.getTag();
        viewHolder.text.setText(category.get(position));
        for(int i=0;i<6;i++)
            viewHolder.t[i].setText("Wow "+ position+" "+i);
        String s = category.get(position);
        for(int i=0;i<6;i++) {
            viewHolder.images[i].setImageResource(R.drawable.root);
           // viewHolder.images[i+1].setImageResource(R.drawable.plant);
        }
        viewHolder.position = position;
        //new ThumbnailTask(position, viewHolder);
        return rowView;
    }

    private static class ThumbnailTask extends AsyncTask {
        private int mPosition;
        private ViewHolder mHolder;

        public ThumbnailTask(int position, ViewHolder holder) {
            mPosition = position;
            mHolder = holder;
        }

        protected Cursor doInBackground(Void... arg0) {
            // Download bitmap here

            return null;
        }

        protected void onPostExecute(Bitmap bitmap) {
            if (mHolder.position == mPosition) {
                mHolder.images[0].setImageBitmap(bitmap);
            }
        }

        @Override
        protected Object doInBackground(Object[] params) {

            return null;
        }
    }


}