package com.example.alaramclock;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Alarm extends Fragment {
        private setalarm childFragment;


private Button addAlarmButton;

public Alarm() {
        // Required empty public constructor
        }

@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_alarm, container, false);

        addAlarmButton = view.findViewById(R.id.addAlarmButton);

        addAlarmButton.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
        // Open the set alarm fragment
        Fragment setAlarmFragment = new setalarm();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.navcbar, setAlarmFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
        }
        });

        return view;
        }

        }
//
//    public Alarm(int hour, int minute, boolean snoozeEnabled, int snoozeTime, String amPm) {
//    }
//
//    @Override
//        public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                                 Bundle savedInstanceState) {
//            View view = inflater.inflate(R.layout.fragment_alarm, container, false);
//
//            Button addAlarmButton = view.findViewById(R.id.addAlarmButton);
//            addAlarmButton.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    childFragment = new setalarm();
//                    FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
//                    transaction.replace(R.id.child_fragment_container, childFragment).commit();
//                }
//            });
//        View alarmListView = view.findViewById(R.id.alarmTimeTextView);
//
//            // Create an array of alarm details
//            ArrayList<Object> alarmList = new ArrayList<>();
//            Bundle alarmDetails = getArguments();
//            if (alarmDetails != null) {
//                int hour = alarmDetails.getInt("hour");
//                int minute = alarmDetails.getInt("minute");
//                boolean snoozeEnabled = alarmDetails.getBoolean("snoozeEnabled");
//                int snoozeTime = alarmDetails.getInt("snoozeTime");
//                String amPm = alarmDetails.getString("amPm");
//                Alarm alarm = new Alarm(hour, minute, snoozeEnabled, snoozeTime, amPm);
//                alarmList.add(alarm);
//            }
//
//            // Create a custom adapter to display the alarm details
//            AlarmAdapter adapter = new AlarmAdapter(getActivity(), Alarm);
//            alarmListView.setAdapter(adapter);
//            return view;
//        }
//
//    public String getFormattedTime() {
//    }
//
//    public boolean isOn() {
//    }
//
//    public Object getHour() {
//    }
//
//    public Object getMinute() {
//    }
//
//    public Object getAmPm() {
//    }
//}
//class Alarm {
//    private int hour;
//    private int minute;
//    private boolean snoozeEnabled;
//    private int snoozeTime;
//    private String amPm;
//
//    public Alarm(int hour, int minute, boolean snoozeEnabled, int snoozeTime, String amPm) {
//        this.hour = hour;
//        this.minute = minute;
//        this.snoozeEnabled = snoozeEnabled;
//        this.snoozeTime = snoozeTime;
//        this.amPm = amPm;
//    }
//
//    public int getHour() {
//        return hour;
//    }
//
//    public int getMinute() {
//        return minute;
//    }
//
//    public boolean isSnoozeEnabled() {
//        return snoozeEnabled;
//    }
//
//    public int getSnoozeTime() {
//        return snoozeTime;
//    }
//
//    public String getAmPm() {
//        return amPm;
//    }
//}
//
//class AlarmAdapter extends BaseAdapter {
//    private Context context;
//    private List<Alarm> alarmList;
//
//    public AlarmAdapter(Context context, List<Alarm> alarmList) {
//        this.context = context;
//        this.alarmList = alarmList;
//    }
//
//    @Override
//    public int getCount() {
//        return alarmList.size();
//    }
//
//    @Override
//    public Object getItem(int position) {
//        return alarmList.get(position);
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return position;
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        View view = convertView;
//        if (view == null) {
//            view = LayoutInflater.from(context).inflate(R.layout.Alarm, parent, false);
//        }
//
//        Alarm alarm = alarmList.get(position);
//
//        TextView alarmTimeTextView = view.findViewById(R.id.alarmTimeTextView);
//        alarmTimeTextView.setText(String.format("%02d:%02d %s", alarm.getHour(), alarm.getMinute(), alarm.getAmPm()));
//
//        Switch alarmSwitch = view.findViewById(R.id.alarmSwitch);
//        alarmSwitch.setChecked(true); // set to true for now, but you can add logic to toggle the switch based on the alarm status
//
//        return view;
//    }
//}
//

