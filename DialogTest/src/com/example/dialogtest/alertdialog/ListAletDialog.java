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

public class ListAletDialog extends DialogFragment
{
    public static ListAletDialog newInstance()
    {
        return new ListAletDialog();
    }

    private ListAletDialog()
    {
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState)
    {
        AlertDialog.Builder build = new AlertDialog.Builder(getActivity());
        // 1.���ñ��⼰ͼ��
        build.setIcon(R.drawable.ic_launcher);
        build.setTitle("����");
        // 2.��������
        //build.setMessage("XXXXXXXXXXXXXXXXXXXX");
        // list��msg����AlertController��setupContent������֤��
        final CharSequence[] items = {"Red", "Green", "Blue" };
        build.setItems(items, new DialogInterface.OnClickListener()
        {
            public void onClick(DialogInterface dialog, int item)
            {
                Toast.makeText(getActivity(), items[item], Toast.LENGTH_SHORT).show();
            }
        });
        // 3.�����Զ�������
        View view = ((LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(
            R.layout.checkbox, null);
        build.setView(view);

        // 4.���ð�ť
        DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                switch (which)
                {
                    case DialogInterface.BUTTON_POSITIVE:
                        Toast.makeText(getActivity(), "ȷ����ť������", 3).show();
                        break;
                    case DialogInterface.BUTTON_NEGATIVE:
                        Toast.makeText(getActivity(), "ȡ����ť������", 3).show();
                        break;
                }
            }
        };
        build.setPositiveButton("ȷ��", listener);
        build.setNegativeButton("ȡ��", listener);
        return build.create();
    }
}