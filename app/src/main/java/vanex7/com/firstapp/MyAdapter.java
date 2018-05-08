package vanex7.com.firstapp;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.List;

public class MyAdapter extends BaseAdapter {

    private Context context;
    private List<Data> data;

    public MyAdapter(Context context, List<Data> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHoler holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
            holder = new ViewHoler();
            holder.imgIcon = convertView.findViewById(R.id.img_icon);
            holder.txtContent = convertView.findViewById(R.id.txt_content);
            convertView.setTag(holder);
        } else {
            holder = (ViewHoler) convertView.getTag();
        }
        holder.imgIcon.setImageResource(data.get(position).getImgID());
        holder.txtContent.setText(data.get(position).getContent());
//        Log.i("");
        return convertView;
    }

    public void add(Data data, int position) {
        if (this.data == null){
            this.data = new LinkedList<>();
        }
        this.data.add(position, data);
        notifyDataSetChanged();
    }


    private class ViewHoler {
        ImageView imgIcon;
        TextView txtContent;
    }
}
