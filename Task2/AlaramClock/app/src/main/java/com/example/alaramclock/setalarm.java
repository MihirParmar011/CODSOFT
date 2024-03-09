package com.example.alaramclock;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.NumberPicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;

public class setalarm extends Fragment {
        private TimePicker timePicker;
        private CheckBox snoozeCheckBox;
        private TextView snoozeTimeTextView;
        private NumberPicker snoozeTimeNumberPicker;
        private RadioGroup amPmRadioGroup;
        private RadioButton amRadioButton;
        private RadioButton pmRadioButton;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_setalarm, container, false);

            timePicker = view.findViewById(R.id.timePicker);
            snoozeCheckBox = view.findViewById(R.id.snoozeCheckBox);
            snoozeTimeTextView = view.findViewById(R.id.snoozeTimeTextView);
            snoozeTimeNumberPicker = view.findViewById(R.id.snoozeTimeNumberPicker);
            amPmRadioGroup = view.findViewById(R.id.amPmRadioGroup);
            amRadioButton = view.findViewById(R.id.amRadioButton);
            pmRadioButton = view.findViewById(R.id.pmRadioButton);

            snoozeTimeNumberPicker.setMinValue(1);
            snoozeTimeNumberPicker.setMaxValue(60);

            snoozeCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        snoozeTimeTextView.setVisibility(View.VISIBLE);
                        snoozeTimeNumberPicker.setVisibility(View.VISIBLE);
                    } else {
                        snoozeTimeTextView.setVisibility(View.GONE);
                        snoozeTimeNumberPicker.setVisibility(View.GONE);
                    }
                }
            });

            amPmRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    if (checkedId == R.id.amRadioButton) {
                        // Handle AM
                    } else if (checkedId == R.id.pmRadioButton) {
                        // Handle PM
                    }
                }
            });

            Button saveAlarmButton = view.findViewById(R.id.saveAlarmButton);
            saveAlarmButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int hour = timePicker.getHour();
                    int minute = timePicker.getMinute();
                    boolean snoozeEnabled = snoozeCheckBox.isChecked();
                    int snoozeTime = (snoozeTimeNumberPicker.getValue() * 10) * 60 * 1000; // convert minutes to milliseconds
                    String amPm = amPmRadioGroup.getCheckedRadioButtonId() == R.id.amRadioButton ? "AM" : "PM";

                    // Pass the alarm details to the Alarm fragment
                    Alarm alarmFragment = new Alarm();
                    Bundle alarmDetails = new Bundle();
                    alarmDetails.putInt("hour", hour);
                    alarmDetails.putInt("minute", minute);
                    alarmDetails.putBoolean("snoozeEnabled", snoozeEnabled);
                    alarmDetails.putInt("snoozeTime", snoozeTime);
                    alarmDetails.putString("amPm", amPm);
                    alarmFragment.setArguments(alarmDetails);

                    // Replace the current fragment with the Alarm fragment
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.nav_alarm, alarmFragment);
                    transaction.commit();
                }
            });

            return view;
        }
}

//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_setalarm, container, false);
//    }
//}