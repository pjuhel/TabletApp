package fr.geobulance.tabletapp;

import android.content.Context;
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
public class EventsAdapter extends ArrayAdapter<Events>{
    public EventsAdapter(Context context, List<Events> objects) {
        super(context,0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView= LayoutInflater.from(getContext()).inflate(R.layout.view_events,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.id = (TextView) convertView.findViewById(R.id.events_id);
            viewHolder.action = (TextView) convertView.findViewById(R.id.events_action);
            convertView.setTag(viewHolder);
        }
        else
        {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Events events = getItem(position);
        viewHolder.id.setText(events.getImei());
        viewHolder.action.setText(events.getAction());
        return convertView;
    }
    public static class ViewHolder
    {
        public TextView id;
        public TextView action;
    }
}
