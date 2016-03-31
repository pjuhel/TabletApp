package fr.geobulance.tabletapp.ObjectType;

import android.content.Context;
import android.widget.CheckBox;

/**
 * Created by louis on 17/01/2016.
 * A checkbox, starting checked, used for filter.
 */
public class Filter extends CheckBox {
    public Filter(Context context, String name) {
        super(context);
        setText(name);
        setChecked(true);
    }
}
