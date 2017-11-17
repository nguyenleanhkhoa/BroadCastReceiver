package com.example.anhkhoa.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by anh khoa on 11/17/2017.
 */

public class BroadcastGPS extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().matches("android.location.PROVIDERS_CHANGED")) {
            Toast.makeText(context, "in android.location.PROVIDERS_CHANGED",
                    Toast.LENGTH_SHORT).show();
            Intent pushIntent = new Intent(context, MainActivity.class);
            context.startService(pushIntent);
        }
    }
}
