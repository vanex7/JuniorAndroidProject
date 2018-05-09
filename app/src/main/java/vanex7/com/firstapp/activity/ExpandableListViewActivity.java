package vanex7.com.firstapp.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import vanex7.com.firstapp.R;

public class ExpandableListViewActivity extends Activity {

    private ExpandableListView expandableListView = null;
    private MyBaseExpandableListAdapter adapter = null;
    private ArrayList<GroupData> groupData = new ArrayList<>();
    private ArrayList<ArrayList<ItemData>> itemData = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandable_listview);


        groupData.add(new GroupData("AD"));
        groupData.add(new GroupData("AP"));
        groupData.add(new GroupData("TANK"));

        ArrayList<ItemData> temp = new ArrayList<>();
        temp.add(new ItemData("剑圣", R.drawable.iv_lol_icon3));
        temp.add(new ItemData("德莱文", R.drawable.iv_lol_icon4));
        temp.add(new ItemData("男枪", R.drawable.iv_lol_icon13));
        temp.add(new ItemData("维鲁斯", R.drawable.iv_lol_icon14));
        itemData.add(temp);

        temp = new ArrayList<>();
        temp.add(new ItemData("火女", R.drawable.iv_lol_icon7));
        temp.add(new ItemData("狐狸", R.drawable.iv_lol_icon11));
        temp.add(new ItemData("泽拉斯", R.drawable.iv_lol_icon9));
        temp.add(new ItemData("天使", R.drawable.iv_lol_icon8));
        itemData.add(temp);

        temp = new ArrayList<>();
        temp.add(new ItemData("诺手", R.drawable.iv_lol_icon2));
        temp.add(new ItemData("奥拉夫", R.drawable.iv_lol_icon6));
        temp.add(new ItemData("赵信", R.drawable.iv_lol_icon5));
        temp.add(new ItemData("狗熊", R.drawable.iv_lol_icon12));
        itemData.add(temp);

        expandableListView = findViewById(R.id.expandable_listview);
        adapter = new MyBaseExpandableListAdapter(groupData, itemData, ExpandableListViewActivity.this);
        expandableListView.setAdapter(adapter);
    }

    private class MyBaseExpandableListAdapter extends BaseExpandableListAdapter {

        private ArrayList<GroupData> groupData;
        private ArrayList<ArrayList<ItemData>> itemData;
        private Context ctx;

        public MyBaseExpandableListAdapter(ArrayList<GroupData> groupData, ArrayList<ArrayList<ItemData>> itemData, Context ctx) {
            this.groupData = groupData;
            this.itemData = itemData;
            this.ctx = ctx;
        }

        @Override
        public int getGroupCount() {
            return this.groupData.size();
        }

        @Override
        public int getChildrenCount(int groupPosition) {
            return itemData.get(groupPosition).size();
        }

        @Override
        public Object getGroup(int groupPosition) {
            return groupData.get(groupPosition);
        }

        @Override
        public Object getChild(int groupPosition, int childPosition) {
            return itemData.get(groupPosition).get(childPosition);
        }

        @Override
        public long getGroupId(int groupPosition) {
            return groupPosition;
        }

        @Override
        public long getChildId(int groupPosition, int childPosition) {
            return childPosition;
        }

        @Override
        public boolean hasStableIds() {
            return false;
        }

        @Override
        public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
            ViewHolderGroup holder;
            if (convertView == null) {
                convertView = LayoutInflater.from(ctx).inflate(R.layout.activity_expandable_listview_group, parent, false);
                TextView textView = convertView.findViewById(R.id.expandable_listview_group_text);
                holder = new ViewHolderGroup(textView);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolderGroup) convertView.getTag();
            }
            holder.getTextViewGroupName().setText(groupData.get(groupPosition).getName());
            return convertView;
        }

        @Override
        public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
            ViewHolderItem holder;
            if (convertView == null) {
                convertView = LayoutInflater.from(ctx).inflate(R.layout.activity_expandable_listview_item, parent, false);
                ImageView icon = convertView.findViewById(R.id.expandable_listview_item_icon);
                TextView txt = convertView.findViewById(R.id.expandable_listview_item_txt);
                holder = new ViewHolderItem(icon, txt);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolderItem) convertView.getTag();
            }
            holder.getImageViewIcon().setImageResource(itemData.get(groupPosition).get(childPosition).getIconId());
            holder.getTextViewName().setText(itemData.get(groupPosition).get(childPosition).getName());
            return convertView;
        }

        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return true;
        }

        private class ViewHolderGroup {
            private TextView textViewGroupName;

            public ViewHolderGroup(TextView textViewGroupName) {
                this.textViewGroupName = textViewGroupName;
            }

            public TextView getTextViewGroupName() {
                return textViewGroupName;
            }
        }

        private class ViewHolderItem {
            private ImageView imageViewIcon;
            private TextView textViewName;

            public ViewHolderItem(ImageView imageViewIcon, TextView textViewName) {
                this.imageViewIcon = imageViewIcon;
                this.textViewName = textViewName;
            }

            public ImageView getImageViewIcon() {
                return imageViewIcon;
            }

            public TextView getTextViewName() {
                return textViewName;
            }
        }


    }

    private class GroupData {
        private String name;

        public GroupData(String name) {
            this.name = name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    private class ItemData {
        private String name;
        private int iconId;

        public ItemData(String name, int iconId) {
            this.name = name;
            this.iconId = iconId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getIconId() {
            return iconId;
        }

        public void setIconId(int iconId) {
            this.iconId = iconId;
        }
    }
}
