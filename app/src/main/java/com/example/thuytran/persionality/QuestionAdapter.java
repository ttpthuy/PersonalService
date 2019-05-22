package com.example.thuytran.persionality;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class QuestionAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Question> questionList;
    ViewHolder viewHolder;

    public QuestionAdapter(Context context, int layout, List<Question> questionList) {
        this.context = context;
        this.layout = layout;
        this.questionList = questionList;
    }

    public QuestionAdapter() {
        this.questionList = new ArrayList<>();
    }
    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(layout, null);
            viewHolder = new ViewHolder();
            viewHolder.textViewHolder = (TextView) convertView.findViewById(R.id.textView);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        String txtQs = questionList.get(position).getQus();
        viewHolder.textViewHolder.setText(txtQs);

        return convertView;
    }
    static class ViewHolder{
        TextView textViewHolder;

    }
}
