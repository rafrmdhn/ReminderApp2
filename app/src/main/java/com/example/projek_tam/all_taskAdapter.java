package com.example.projek_tam;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class all_taskAdapter extends RecyclerView.Adapter<all_taskAdapter.TaskViewHolder> {
    private List<TaskObject> TaskList;

    public all_taskAdapter(List<TaskObject> list){
        this.TaskList = list;
    }

    public void setTaskList(List<TaskObject> list) {
        this.TaskList = list;
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.all_task, parent, false);

        return new TaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        TaskObject taskObject = TaskList.get(position);
        holder.text.setText(taskObject.getAcara());

    }

    @Override
    public int getItemCount() {
        return 0;
    }


    static class TaskViewHolder extends RecyclerView.ViewHolder{
        TextView text;
        TaskViewHolder(View itemView){
            super(itemView);
            text = itemView.findViewById(R.id.textView);
        }
    }


}
