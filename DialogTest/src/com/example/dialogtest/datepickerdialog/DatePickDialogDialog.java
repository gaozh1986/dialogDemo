package com.example.dialogtest.datepickerdialog;

import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;
import android.widget.Toast;

public class DatePickDialogDialog extends DialogFragment
{
    public static DatePickDialogDialog newInstance()
    {
        return new DatePickDialogDialog();
    }

    private DatePickDialogDialog()
    {
    }

    OnDateSetListener listener = new OnDateSetListener()
    {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth)
        {
            Toast.makeText(getActivity(), year + "-" + monthOfYear + "-" + dayOfMonth, Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState)
    {
        DatePickerDialog dialog = new DatePickerDialog(getActivity(), listener, 2014, 11, 10);
        return dialog;
    }
}
