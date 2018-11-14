package com.group5.android_project;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.text.format.DateFormat;

import java.util.Calendar;

public class TimePickerFragment extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current time as the default values for the picker
        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);

        // Activity has to implement this interface
        TimePickerDialog.OnTimeSetListener listener = (TimePickerDialog.OnTimeSetListener) getActivity();

        VehicleProfileActivity vehicleProfileActivity = (VehicleProfileActivity) getActivity();
        if ((VehicleProfileActivity.flag.equals("startTime") &&
                vehicleProfileActivity.txtStartTime.toString().length() < 2) ||
                (VehicleProfileActivity.flag.equals("endTime") &&
                        vehicleProfileActivity.txtEndTime.toString().length() < 2)) {
            // Create a new instance of TimePickerDialog and return it
            return new TimePickerDialog(getActivity(), listener, hour, minute,
                    DateFormat.is24HourFormat(getActivity()));

        }

        //input default date
        String time;
        if (VehicleProfileActivity.flag.equals("startDate")) {
            time = vehicleProfileActivity.txtStartTime.getText().toString();
        } else {
            time = vehicleProfileActivity.txtEndTime.getText().toString();
        }

        int nhour = Integer.valueOf(time.substring(0, 2));
        int nminute = Integer.valueOf(time.substring(3, 5));
        return new TimePickerDialog(getActivity(), listener, nhour, nminute,
                DateFormat.is24HourFormat(getActivity()));
    }


}
