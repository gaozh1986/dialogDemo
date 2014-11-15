package com.example.dialogtest.processdialog;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.TimePicker;
import android.widget.Toast;

public class ProcessDialogCommon extends DialogFragment
{
    public static ProcessDialogCommon newInstance()
    {
        return new ProcessDialogCommon();
    }

    private ProcessDialogCommon()
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
        ProgressDialog p = new ProgressDialog(getActivity())
        {
            @Override
            public void onStart()
            {
                super.onStart();
                setProgress(40);
            }
        };
        p.setTitle("正在获取联系人信息，请稍等：");
        p.setMessage("hello");
        p.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        p.setMax(100);
        //p.setProgress(40);//这种写法，一级进度不能展示
        p.setSecondaryProgress(60);
        //p.incrementProgressBy(10);//这个值会在onstart方法中被覆盖
        // p.incrementSecondaryProgressBy(70);
        p.setIndeterminate(false);
        return p;
    }

    @Override
    public void onResume()
    {
        // TODO Auto-generated method stub
        super.onResume();
    }
}
