package com.example.shiozaki.networkinfo;

import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //WiFiの情報を取得する
        //ACCESS_WIFI_STATEのパーミッションをマニフェストに追加する
        WifiManager manager = (WifiManager)getSystemService(WIFI_SERVICE);
        WifiInfo info = manager.getConnectionInfo();

        //SSIDを取得
        Log.d("SSID:", info.getSSID());
        //IPを取得
        Log.d("IP:", String.valueOf(info.getIpAddress()));
        //macアドレスを取得
        Log.d("MAC:", String.valueOf(info.getMacAddress()));
        //RSSIを取得
        Log.d("RSSI:", String.valueOf(info.getRssi()));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
