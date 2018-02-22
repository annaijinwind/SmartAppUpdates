package com.annaijin.smartupdates;

import android.app.ProgressDialog;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import java.io.File;

public class MainActivity extends AppCompatActivity {
   private Button btnOk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ProgressDialog progressDialog= new ProgressDialog(this);
        final File newscApk = new File(Environment.getExternalStorageDirectory(), "fengjq/lalal.apk");
        final File oldApk = new File(Environment.getExternalStorageDirectory(), "fengjq/old.apk");
        final File patch = new File(Environment.getExternalStorageDirectory(), "fengjq/patch.patch");
        btnOk=findViewById(R.id.sample_text);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressDialog.show();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        AppPatchUtils.getNewApk(oldApk.getAbsolutePath(),patch.getAbsolutePath(),newscApk.getAbsolutePath());
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                progressDialog.dismiss();
                                Toast.makeText(MainActivity.this,"好了",Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                }).start();
            }
        });
    }
}
