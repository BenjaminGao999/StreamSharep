package com.gaos.streamsharep;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "file";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnstream(View view) {
        Log.i(TAG, "btnstream: " + getCacheDir());
        File file = new File(getFilesDir(), "dir1/dir2/dir3/f1");
        file.getParentFile().mkdirs();
        try {
            file.createNewFile();
            Log.i(TAG, "btnstream: " + file.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Log.i(TAG, "btnstream: " + getDir("fm1", MODE_PRIVATE));

//        /*我要知道的是： 读取不存在的文件会报错吗？*/
//        FileOutputStream lalala = null;
//        try {
//            lalala = openFileOutput("lalala", MODE_PRIVATE);
//            lalala.write("fafhljhgfla".getBytes());
//            lalala.close();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        FileInputStream lalala1 = null;
        try {
            lalala1 = openFileInput("lalala111");
            byte[] ints = new byte[1024];
            int read = lalala1.read(ints);
            Log.i(TAG, "btnstream: lalala1 = " + new String(ints, 0, read, "utf-8"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void btnsharep(View view) {
        SharedPreferences sharep = getSharedPreferences("sharep", MODE_PRIVATE);
        sharep.edit().putString("key", "value").commit();

        String key = sharep.getString("key", null);
        Log.i(TAG, "btnsharep: sharep value = " + key);
    }
}
