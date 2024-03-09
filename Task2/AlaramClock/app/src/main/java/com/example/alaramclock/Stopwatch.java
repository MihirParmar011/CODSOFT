package com.example.alaramclock;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.os.Handler;

import android.widget.Button;
import android.widget.TextView;

public class Stopwatch extends Fragment {

    private TextView timeView;
    private Button startButton;
    private Button lapButton;
    private Button resetButton;
    private boolean isRunning;
    private long startTime;
    private long lapTime;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_stopwatch, container, false);

        timeView = view.findViewById(R.id.time_view);
        startButton = view.findViewById(R.id.start_button);
        lapButton = view.findViewById(R.id.lap_button);
        resetButton = view.findViewById(R.id.reset_button);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isRunning) {
                    isRunning = true;
                    startTime = System.currentTimeMillis();
                    startButton.setText("Pause");
                    lapButton.setEnabled(true);
                    resetButton.setEnabled(false);
                    updateTime();
                } else {
                    isRunning = false;
                    lapTime = System.currentTimeMillis() - startTime;
                    startButton.setText("Resume");
                    lapButton.setText("Lap");
                    resetButton.setEnabled(true);
                }
            }
        });

        lapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isRunning) {
                    lapTime = System.currentTimeMillis() - startTime;
                    // Add the lap time to a list or display it in a separate view
                } else {
                    // Resume the timer
                    isRunning = true;
                    startTime = System.currentTimeMillis() - lapTime;
                    startButton.setText("Pause");
                    lapButton.setText("Lap");
                    resetButton.setEnabled(false);
                    updateTime();
                }
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isRunning = false;
                startTime = 0;
                lapTime = 0;
                startButton.setText("Start");
                lapButton.setText("Lap");
                resetButton.setEnabled(false);
                timeView.setText("00:00.00");
            }
        });

        return view;
    }

    private void updateTime() {
        long time = System.currentTimeMillis() - startTime;
        int seconds = (int) (time / 1000);
        int milliseconds = (int) (time % 1000);
        int minutes = seconds / 60;
        seconds %= 60;
        timeView.setText(String.format("%02d:%02d.%03d", minutes, seconds, milliseconds));
        if (isRunning) {
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    updateTime();
                }
            }, 10);
        }
    }

}