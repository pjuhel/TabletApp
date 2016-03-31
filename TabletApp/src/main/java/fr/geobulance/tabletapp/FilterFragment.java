package fr.geobulance.tabletapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import fr.geobulance.tabletapp.ObjectType.Filter;

import java.util.ArrayList;
import java.util.List;


/**
 * A fragment showing all the available filter
 */
public class FilterFragment extends Fragment {
    public FilterFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(   LayoutInflater inflater, ViewGroup container,
                                Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_filter,container,false);
    }

}