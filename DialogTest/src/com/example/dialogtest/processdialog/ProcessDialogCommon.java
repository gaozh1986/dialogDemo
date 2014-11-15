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
        p.setTitle("���ڻ�ȡ��ϵ����Ϣ�����Եȣ�");
        p.setMessage("hello");
        p.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        p.setMax(100);
        //p.setProgress(40);//����д����һ�����Ȳ���չʾ
        p.setSecondaryProgress(60);
        //p.incrementProgressBy(10);//���ֵ����onstart�����б�����
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
