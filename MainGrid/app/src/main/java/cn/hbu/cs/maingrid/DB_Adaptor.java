package cn.hbu.cs.maingrid;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DB_Adaptor extends RecyclerView.Adapter<DB_Adaptor.ViewHolder>{

    private ArrayList<Student> mData;
    public DB_Adaptor(ArrayList<Student> data) {
        this.mData = data;
    }

    public void updateData(ArrayList<Student> data) {
        this.mData = data;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.database_item, parent, false);// 实例化展示的view
        ViewHolder viewHolder = new ViewHolder(v);// 实例化viewholder
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        //holder.mTv.setText(mData.get(position));// 绑定数据
        Student student = mData.get(position);
        holder.tvAge.setText(student.age+"");//注意数据类型
        holder.tvName.setText(student.name);
        holder.tvID.setText(student.student_ID+"");
    }

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvID,tvName,tvAge;
        public ViewHolder(View itemView) {
            super(itemView);
            tvID = itemView.findViewById(R.id.item_stuID);
            tvName =  itemView.findViewById(R.id.item_stuName);
            tvAge =  itemView.findViewById(R.id.item_stuAge);
        }
    }
}
