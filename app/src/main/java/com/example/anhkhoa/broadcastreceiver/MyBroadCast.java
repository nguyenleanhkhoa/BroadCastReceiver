package com.example.anhkhoa.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by anh khoa on 11/7/2017.
 */

public class MyBroadCast extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String dulieu=intent.getStringExtra("dulieu");
        Toast.makeText(context, dulieu , Toast.LENGTH_SHORT).show();
    }
}
