package com.sloydev.redbooth.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.sloydev.redbooth.R;
import com.sloydev.redbooth.model.TaskModel;
import java.util.ArrayList;
import java.util.List;

public class CardTaskListAdapter extends RecyclerView.Adapter<CardTaskListAdapter.TaskItemViewHolder> {

    private List<TaskModel> tasks;

    public CardTaskListAdapter() {
        tasks = new ArrayList<>();
    }

    public void setTasks(List<TaskModel> tasks) {
        this.tasks = tasks;
        notifyDataSetChanged();
    }

    @Override public TaskItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_task, parent, false);
        return new TaskItemViewHolder(itemView);
    }

    @Override public void onBindViewHolder(TaskItemViewHolder holder, int position) {
        TaskModel taskModel = tasks.get(position);
        holder.title.setText(taskModel.getTitle());
        holder.description.setText(taskModel.getDescription());
    }

    @Override public int getItemCount() {
        return tasks.size();
    }

    public static class TaskItemViewHolder extends RecyclerView.ViewHolder {

        @InjectView(R.id.item_task_title) TextView title;
        @InjectView(R.id.item_task_description) TextView description;

        public TaskItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.inject(this, itemView);
        }
    }
}
