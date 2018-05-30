package com.yexiaomo.expandablelistview.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.yexiaomo.expandablelistview.R;

public class MyBaseExpandableListAdapter extends BaseExpandableListAdapter {

    private String[] groupStrings;
    private String[][] childStrings;

    public MyBaseExpandableListAdapter(String[] groupStrings, String[][] childStrings) {
        this.groupStrings = groupStrings;
        this.childStrings = childStrings;
    }

    @Override
    public int getGroupCount() {
        // 获取分组的个数
        return groupStrings.length;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        // 获取指定分组中的子选项的个数
        return childStrings[groupPosition].length;
    }

    @Override
    public Object getGroup(int groupPosition) {
        // 获取指定的分组数据
        return groupStrings[groupPosition];
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        // 获取指定分组中指定子选项数据
        return childStrings[groupPosition][childPosition];
    }

    @Override
    public long getGroupId(int groupPosition) {
        // 获取指定分组的ID，这个ID必须是唯一的
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        // 获取子选项的ID，这个ID必须是唯一的
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        // 分组和子选项是否持有稳定的ID，就是说底层数据的改变会不会影响到它们
        return true;
    }

    // 获取显示指定分组的视图
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        GroupViewHolder groupViewHolder;
        if (convertView == null){
            convertView = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.group_layout, parent, false);
            groupViewHolder = new GroupViewHolder();
            groupViewHolder.tvGroupText = convertView.findViewById(R.id.label_expend_group);
            convertView.setTag(groupViewHolder);
        } else {
            groupViewHolder = (GroupViewHolder) convertView.getTag();
        }
        groupViewHolder.tvGroupText.setText(groupStrings[groupPosition]);
        return convertView;
    }

    // 获取显示指定分组中的指定子选项的视图
    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ChildViewHolder childViewHolder;
        if (convertView == null){
            convertView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.child_layout, parent, false);
            childViewHolder = new ChildViewHolder();
            childViewHolder.tvChildText = convertView.findViewById(R.id.label_expend_child);
            convertView.setTag(childViewHolder);
        } else {
            childViewHolder = (ChildViewHolder) convertView.getTag();
        }
        childViewHolder.tvChildText.setText(childStrings[groupPosition][childPosition]);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        // 指定位置上的子元素是否可选中
        return true;
    }

    static class GroupViewHolder{
        TextView tvGroupText;
    }

    static class ChildViewHolder{
        TextView tvChildText;
    }
}
