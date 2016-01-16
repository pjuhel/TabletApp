package fr.geobulance.tabletapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import fr.geobulance.tabletapp.ObjectType.Ambulances;

import java.util.List;

/**
 * Created by louis on 16/01/2016.
 */
public class AmbulancesAdapter extends ArrayAdapter<Ambulances>{
    public AmbulancesAdapter(Context context, List<Ambulances> objects) {
        super(context,0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView= LayoutInflater.from(getContext()).inflate(R.layout.ambulance_view,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.name = (TextView) convertView.findViewById(R.id.ambulance_name);
            viewHolder.immatriculation = (TextView) convertView.findViewById(R.id.ambulance_immatriculation);
            convertView.setTag(viewHolder);
        }
        else
        {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Ambulances ambulances = getItem(position);
        viewHolder.immatriculation.setText(ambulances.getImmatriculation());
        viewHolder.name.setText("TODO !");
        return convertView;
    }
    public static class ViewHolder
    {
        public TextView name;
        public TextView immatriculation;
    }
}
