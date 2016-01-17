package fr.geobulance.tabletapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import fr.geobulance.tabletapp.ObjectType.Filter;

import java.util.List;

/**
 * Created by louis on 17/01/2016.
 */
public class FilterAdapter extends ArrayAdapter<Filter> {

    public FilterAdapter(Context context, List<Filter> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView= LayoutInflater.from(getContext()).inflate(R.layout.view_filter,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.name = (CheckBox) convertView.findViewById(R.id.filter_name);
            convertView.setTag(viewHolder);
        }
        else
        {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Filter filter = getItem(position);

        viewHolder.name.setText(filter.getName());
        Globals.filtreStatus.add(viewHolder.name);
        if(Globals.filtreNameList.contains(filter.getName()))
        {
            viewHolder.name.setChecked(false);
        }
        return convertView;
    }
    public static class ViewHolder
    {
        public CheckBox name;
    }
}
