package com.group5.android_project;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

import java.util.Calendar;

public class MainDatePickerFragment extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current time as the default values for the picker
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        // Activity needs to implement this interface
        DatePickerDialog.OnDateSetListener listener = (DatePickerDialog.OnDateSetListener) getActivity();

        //when the date is not been set yet
        MainActivity mainActivity = (MainActivity) getActivity();
        if ((MainActivity.mainflag.equals("searchStartDate") && (mainActivity.mainSearchStartDate == null || mainActivity.mainSearchStartDate.equals("")))
                || (MainActivity.mainflag.equals("searchEndDate") && (mainActivity.mainSearchEndDate == null || mainActivity.mainSearchEndDate.equals("")))
                || (MainActivity.mainflag.equals("postStartDate") && (mainActivity.postStartDate == null || mainActivity.postStartDate.equals("")))
                || (MainActivity.mainflag.equals("postEndDate") && (mainActivity.postEndDate == null || mainActivity.postEndDate.equals("")))) {
            // Create a new instance of DatePickerDialog and return with current date
            return new DatePickerDialog(getActivity(), listener, year, month, day);
        }

        //input default date
        String date;
        if (MainActivity.mainflag.equals("searchStartDate")) {
            date = mainActivity.mainSearchStartDate;
        } else if (MainActivity.mainflag.equals("searchEndDate")) {
            date = mainActivity.mainSearchEndDate;
        } else if (MainActivity.mainflag.equals("postStartDate")) {
            date = mainActivity.postStartDate;
        } else if (MainActivity.mainflag.equals("postEndDate")) {
            date = mainActivity.postEndDate;
        } else {
            return new DatePickerDialog(getActivity(), listener, year, month, day);
        }

        int nday = Integer.valueOf(date.substring(0, 2));
        int nmonth = Integer.valueOf(date.substring(3, 5)) - 1;
        int nyear = Integer.valueOf(date.substring(6, 10));
        return new DatePickerDialog(getActivity(), listener, nyear, nmonth, nday);
    }
}
