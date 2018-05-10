package vanex7.com.firstapp.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import vanex7.com.firstapp.R;
import vanex7.com.firstapp.activity.ExpandableListViewActivity;
import vanex7.com.firstapp.activity.ListViewActivity;
import vanex7.com.firstapp.activity.ViewFlipperActivity;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private List<Entry> entryList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        listView = findViewById(R.id.main_listView);

        entryList = new ArrayList<>();
        entryList.add(new Entry("ListView", ListViewActivity.class));
        entryList.add(new Entry("ExpandableListView", ExpandableListViewActivity.class));
        entryList.add(new Entry("ViewFlipper", ViewFlipperActivity.class));

        listView.setAdapter(new MyAdapter(MainActivity.this, entryList));
    }

    private class Entry {
        private String name;
        private Class newActivity;

        public Entry(String name, Class newActivity) {
            this.name = name;
            this.newActivity = newActivity;
        }

        public Class getNewActivity() {
            return newActivity;
        }

        public void setNewActivity(Class newActivity) {
            this.newActivity = newActivity;
        }


        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }


    private class MyAdapter extends BaseAdapter {

        private List<Entry> entryList = null;
        private Context ctx;

        public MyAdapter(Context ctx, List<Entry> entryList) {
            this.ctx = ctx;
            this.entryList = entryList;
        }

        @Override
        public int getCount() {
            return this.entryList.size();
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
        public View getView(final int position, View convertView, ViewGroup parent) {
            Button btn;
            if (convertView == null) {
                convertView = LayoutInflater.from(ctx).inflate(R.layout.main_list_item, parent, false);
                btn = convertView.findViewById(R.id.btn);
                convertView.setTag(btn);
                if (this.entryList.get(position).getNewActivity() != null)
                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            startActivity(new Intent(MyAdapter.this.ctx, MyAdapter.this.entryList.get(position).getNewActivity()));
                        }
                    });
            } else {
                btn = (Button) convertView.getTag();
            }
            btn.setText(this.entryList.get(position).getName());
            return convertView;
        }
    }
}
