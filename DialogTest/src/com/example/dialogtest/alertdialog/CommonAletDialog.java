package com.example.dialogtest.alertdialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.example.dialogtest.R;

public class CommonAletDialog extends DialogFragment
{
    public static CommonAletDialog newInstance()
    {
        return new CommonAletDialog();
    }

    private CommonAletDialog()
    {
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState)
    {
        AlertDialog.Builder build = new AlertDialog.Builder(getActivity());
        // 1.设置标题及图标
        build.setIcon(R.drawable.ic_launcher);
        build.setTitle("标题");
        // 2.设置内容
        build.setMessage("XXXXXXXXXXXXXXXXXXXX");
        // 3.增加自定义内容
        View view = ((LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(
            R.layout.checkbox, null);
        build.setView(view);

        // 4.设置按钮
        DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                switch (which)
                {
                    case DialogInterface.BUTTON_POSITIVE:
                        Toast.makeText(getActivity(), "确定按钮被按下", 3).show();
                        break;
                    case DialogInterface.BUTTON_NEGATIVE:
                        Toast.makeText(getActivity(), "取消按钮被按下", 3).show();
                        break;
                }
            }
        };
        build.setPositiveButton("确定", listener);
        build.setNegativeButton("取消", listener);
        return build.create();
    }
}
