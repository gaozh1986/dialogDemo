package com.example.dialogtest;

import java.util.List;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiEnterpriseConfig;
import android.net.wifi.WifiEnterpriseConfig.Phase2;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import com.example.dialogtest.alertdialog.CommonAletDialog;
import com.example.dialogtest.alertdialog.ListAletDialog;
import com.example.dialogtest.alertdialog.MultiChkListAletDialog;
import com.example.dialogtest.alertdialog.SingleListAletDialog;
import com.example.dialogtest.datepickerdialog.DatePickDialogDialog;
import com.example.dialogtest.processdialog.ProcessDialogCommon;
import com.example.dialogtest.timepickerdialog.TimePickerDialogF;

public class MainActivity extends FragmentActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WifiManager mWifiManager = (WifiManager) getSystemService(Context.WIFI_SERVICE);
        List<WifiConfiguration> lstConfigs = mWifiManager.getConfiguredNetworks();
        /*for (WifiConfiguration w : lstConfigs)
        {
            mWifiManager.removeNetwork(w.networkId);
        }*/
        //mWifiManager.saveConfiguration();
        mWifiManager.startScan();
        /*List<WifiConfiguration> lstddConfigs = mWifiManager.getConfiguredNetworks();
        List<ScanResult> tmp = mWifiManager.getScanResults();
        WifiConfiguration wifiConfig = createWifiInfo0();
        int netWorkId = mWifiManager.addNetwork(wifiConfig);
        mWifiManager.enableNetwork(netWorkId, true);*/

    }

    private WifiConfiguration createWifiInfo()
    {
        WifiConfiguration config = new WifiConfiguration();
        config.allowedAuthAlgorithms.clear();
        config.allowedGroupCiphers.clear();
        config.allowedKeyManagement.clear();
        config.allowedPairwiseCiphers.clear();
        config.allowedProtocols.clear();
        // 1.保存SSID
        config.SSID = "\"" + "voip1" + "\"";
        // 2.公网WIFI都是无密码直接接入
        config.allowedKeyManagement.set(WifiConfiguration.KeyMgmt.WPA_PSK);
        config.preSharedKey = "\"" + "12344321" + "\"";
        config.allowedAuthAlgorithms.set(WifiConfiguration.AuthAlgorithm.OPEN);
        config.allowedGroupCiphers.set(WifiConfiguration.GroupCipher.TKIP);
        config.allowedKeyManagement.set(WifiConfiguration.KeyMgmt.WPA_PSK);
        config.allowedPairwiseCiphers.set(WifiConfiguration.PairwiseCipher.TKIP);
        //config.allowedProtocols.set(WifiConfiguration.Protocol.WPA);   
        config.allowedGroupCiphers.set(WifiConfiguration.GroupCipher.CCMP);
        config.allowedPairwiseCiphers.set(WifiConfiguration.PairwiseCipher.CCMP);
        config.status = WifiConfiguration.Status.ENABLED;
        return config;
    }

    private WifiConfiguration createWifiInfo0()
    {
        WifiEnterpriseConfig enterpriseConfig = new WifiEnterpriseConfig();
        WifiConfiguration wifiConfig = new WifiConfiguration();
        wifiConfig.SSID = "\"" + "Huawei-Employee" + "\"";
        wifiConfig.allowedKeyManagement.set(WifiConfiguration.KeyMgmt.WPA_EAP);
        wifiConfig.allowedKeyManagement.set(WifiConfiguration.KeyMgmt.IEEE8021X);
        enterpriseConfig.setIdentity("g00198787");
        enterpriseConfig.setPassword("@hongyu2014");
        enterpriseConfig.setEapMethod(WifiEnterpriseConfig.Eap.PEAP);
        enterpriseConfig.setPhase2Method(Phase2.MSCHAPV2);
        wifiConfig.enterpriseConfig = enterpriseConfig;
        return wifiConfig;
    }

    public void commonDialog(View v)
    {
        CommonAletDialog.newInstance().show(getSupportFragmentManager(), "dialog");
    }

    public void listDialog(View v)
    {
        ListAletDialog.newInstance().show(getSupportFragmentManager(), "dialog");
    }

    public void singleDialog(View v)
    {
        SingleListAletDialog.newInstance().show(getSupportFragmentManager(), "dialog");
    }

    public void multiDialog(View v)
    {
        MultiChkListAletDialog.newInstance().show(getSupportFragmentManager(), "dialog");
    }

    public void datePickDialog(View v)
    {
        DatePickDialogDialog.newInstance().show(getSupportFragmentManager(), "dialog");
    }

    public void timePickerDialog(View v)
    {
        TimePickerDialogF.newInstance().show(getSupportFragmentManager(), "dialog");
    }

    public void processDialogCommon(View v)
    {
        //ProcessDialogCommon.newInstance().show(getSupportFragmentManager(), "dialog");
        ProgressDialog.show(this, "title", "message");
    }

    public void processDialogNull(View v)
    {
        //ProcessDialogCommon.newInstance().show(getSupportFragmentManager(), "dialog");
        ProgressDialog.show(this, null, "message", true, true);
    }

    public void processDialogProcess(View v)
    {
        ProcessDialogCommon.newInstance().show(getSupportFragmentManager(), "dialog");

    }
}
