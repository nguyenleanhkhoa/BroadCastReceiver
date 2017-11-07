package com.example.anhkhoa.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    BroadcastReceiver broadcastReceiver=new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, final Intent intent) {


                ConnectivityManager connectivityManager= (ConnectivityManager) context.getSystemService(context.CONNECTIVITY_SERVICE);
                if(connectivityManager.getActiveNetworkInfo()!=null) {
                    Toast.makeText(context, "đã có mạng", Toast.LENGTH_SHORT).show();
                }
                else{
                    AlertDialog.Builder thongbao=new AlertDialog.Builder(MainActivity.this)
                            .setTitle("Lỗi!")
                            .setMessage("Bạn chưa kết nối mạng!")
                            .setPositiveButton("Kết nối lại", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    dialogInterface.dismiss();
                                    finish();
                                    Intent intent1=getIntent();
                                    startActivity(intent1);

                                }
                            }).setNegativeButton("Đóng", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    dialogInterface.dismiss();
                                    finish();
                                }
                            });
                    thongbao.create().show();
                }


        }
    };

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "onPause", Toast.LENGTH_SHORT).show();
        if(broadcastReceiver!=null){
            unregisterReceiver(broadcastReceiver);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show();
        IntentFilter filter=new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(broadcastReceiver,filter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void OnClick(View view) {
        Intent intent =new Intent();
        intent.setAction("com.example.anhkhoa.broadcastreceiver.CUSTOM_BROADCAST");
        intent.putExtra("dulieu","du lieu gui tu intent");

        sendBroadcast(intent);
        Toast.makeText(this, "Đã click", Toast.LENGTH_SHORT).show();
    }
}
