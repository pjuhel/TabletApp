package fr.geobulance.tabletapp;


import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import android.widget.ToggleButton;
import fr.geobulance.tabletapp.ObjectType.Events;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class MenuFragment extends Fragment {

    public MenuFragment() {
        eventsFragment = new EventsFragment();
        filterFragment = new FilterFragment();
        activeFragment = true;
    }

    private EventsFragment eventsFragment;
    private FilterFragment filterFragment;
    private boolean activeFragment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

            android.support.v4.app.FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
            transaction.add(R.id.fragment_container,eventsFragment);
            transaction.commit();
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu, container, false);
    }


    public void SwitchHandler(View view) {
        android.support.v4.app.FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        if(activeFragment) {
            transaction.replace(R.id.fragment_container,filterFragment);
        }
        else {
            transaction.replace(R.id.fragment_container,eventsFragment);
        }
        //transaction.addToBackStack(null);
        transaction.commit();
        activeFragment=!activeFragment;
    }
}
