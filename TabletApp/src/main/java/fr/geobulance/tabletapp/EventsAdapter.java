package fr.geobulance.tabletapp;

import android.content.Context;
import android.content.pm.LauncherActivityInfo;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import fr.geobulance.tabletapp.ObjectType.Events;

import java.util.List;

/**
 * Created by louis on 16/01/2016.
 */
public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.ViewHolder> {
    private List<Events> dataSet;

    public EventsAdapter( List<Events> objects) {
        dataSet=objects;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.view_events,viewGroup,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.action.setText(dataSet.get(i).getAction());
        viewHolder.id.setText(dataSet.get(i).get_id());
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        public TextView id;
        public TextView action;

        public ViewHolder(View itemView) {
            super(itemView);
            id = (TextView) itemView.findViewById(R.id.events_id);
            action = (TextView) itemView.findViewById(R.id.events_action);
        }
    }
}
