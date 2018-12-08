package com.testapp.travel.ui.files;


import android.graphics.Point;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import com.testapp.travel.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddressFragment extends android.support.v4.app.DialogFragment implements View.OnClickListener{

    private TextView location;
    private Button done;



    public AddressFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_adress, container, false);
        location = (TextView) rootView.findViewById(R.id.location);
        done = (Button) rootView.findViewById(R.id.done);
        done.setOnClickListener(this);

        CharSequence charSequence = getArguments().getCharSequence("curAddress");
        location.setText(charSequence);
        return  rootView;
    }

    public interface onClickDoneListener {
        void saveAddress(CharSequence gender);
    }

    @Override
    public void onClick(View view) {
        onClickDoneListener activity = (onClickDoneListener) getTargetFragment();
        activity.saveAddress(location.getText());
        dismiss();

    }

    public void onResume() {
        // Store access variables for window and blank point
        Window window = getDialog().getWindow();
        Point size = new Point();
        // Store dimensions of the screen in `size`
        Display display = window.getWindowManager().getDefaultDisplay();
        display.getSize(size);
        // Set the width of the dialog proportional to 75% of the screen width
        window.setLayout((int) (size.x * 0.75), WindowManager.LayoutParams.WRAP_CONTENT);
        window.setGravity(Gravity.CENTER);
        // Call super onResume after sizing
        super.onResume();
    }
}
