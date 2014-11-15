package com.example.dialogtest.timepickerdialog;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.TimePicker;
import android.widget.Toast;

public class TimePickerDialogF extends DialogFragment
{
    public static TimePickerDialogF newInstance()
    {
        return new TimePickerDialogF();
    }

    private TimePickerDialogF()
    {
    }

    OnTimeSetListener listener = new OnTimeSetListener()
    {

        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute)
        {
            Toast.makeText(getActivity(), hourOfDay + "-" + minute, Toast.LENGTH_SHORT).show();

        }
    };

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState)
    {
        TimePickerDialog dialog = new TimePickerDialog(getActivity(), listener, 10, 11, false);
        return dialog;
    }
}
