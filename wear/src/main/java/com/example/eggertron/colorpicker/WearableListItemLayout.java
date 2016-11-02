package com.example.eggertron.colorpicker;

import android.content.Context;
import android.support.wearable.view.WearableListView;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 * Created by eggertron on 11/2/16.
 */
public class WearableListItemLayout extends LinearLayout implements WearableListView.OnCenterProximityListener {
    public WearableListItemLayout(Context context) {
        super(context);
    }

    public WearableListItemLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public WearableListItemLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public WearableListItemLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    /*
        We let it extends LinearLayout and implement
        OnCenterProximityListener. When an item is centered on the screen, the callback method will be fired. Implement the callback
        method and the constructors.
     */
    @Override
    public void onCenterPosition(boolean b) {

    }

    @Override
    public void onNonCenterPosition(boolean b) {

    }

    // Now create a new XML layout called list_item.xml and change Root element to WearableListItemLayout
}
