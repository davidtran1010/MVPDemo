package com.example.davidtran.mvpdemo.view.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.davidtran.mvpdemo.R;
import com.example.davidtran.mvpdemo.model.entity.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by davidtran on 7/26/17.
 */

public class StudentAdapter extends BaseAdapter {
    List<Student> mStudentList = new ArrayList<>();
    Context mContext;

    public StudentAdapter(List<Student> mStudentList, Context context) {
        this.mStudentList = mStudentList;
        mContext = context;
    }

    @Override
    public int getCount() {
        return mStudentList.size();
    }

    @Override
    public Object getItem(int position) {
        return mStudentList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    private static class ViewHolder {
        TextView tvId;
        TextView tvFName;
        TextView tvBDate;
        TextView IDNumber;
        TextView tvAcademicYear;
        TextView tvMajor;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(R.layout.item_sv, parent, false);

            /*TextView tvId;
            TextView tvFName;
            TextView tvBDate;
            TextView IDNumber;
            TextView tvAcademicYear;
            TextView tvMajor;*/
            viewHolder.tvId = (TextView) convertView.findViewById(R.id.tvId);
            viewHolder.tvFName = (TextView) convertView.findViewById(R.id.tvFName);
            viewHolder.tvBDate = (TextView) convertView.findViewById(R.id.tvBDate);
            viewHolder.IDNumber = (TextView) convertView.findViewById(R.id.tvIDNumber);
            viewHolder.tvAcademicYear = (TextView) convertView.findViewById(R.id.tvAcademicYear);
            viewHolder.tvMajor = (TextView) convertView.findViewById(R.id.tvMajor);


            result = convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result = convertView;
        }

        viewHolder.tvId.setText(mStudentList.get(position).getID());

        viewHolder.tvFName.setText(mStudentList.get(position).getFName());

        viewHolder.tvBDate.setText(mStudentList.get(position).getBDate());

        viewHolder.IDNumber.setText(mStudentList.get(position).getIDNumber());

        String acaYear = "" + mStudentList.get(position).getAcaYear();
        viewHolder.tvAcademicYear.setText(acaYear);

        viewHolder.tvMajor.setText(mStudentList.get(position).getMajor());

        // Return the completed view to render on screen
        return convertView;
    }
}
