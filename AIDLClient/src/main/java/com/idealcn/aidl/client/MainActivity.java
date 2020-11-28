package com.idealcn.aidl.client;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;

import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.idealcn.aidlstudy.IMyAidlInterface;
import com.idealcn.aidlstudy.bean.Student;

import java.security.cert.CollectionCertStoreParameters;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public class MainActivity extends AppCompatActivity {
    IMyAidlInterface iMyAidlInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private final ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            iMyAidlInterface = IMyAidlInterface.Stub.asInterface(service);
//            try {
//               int result =  iMyAidlInterface.add(10,10);
//
//                Toast.makeText(MainActivity.this,"result--"+result,Toast.LENGTH_SHORT).show();
//            } catch (RemoteException e) {
//                e.printStackTrace();
//            }
            Toast.makeText(MainActivity.this,"bind success",Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            iMyAidlInterface = null;
        }
    };

    public void bind(View view) {
        Intent intent = new Intent();
        intent.setAction("com.idealcn.aidlstudy.MyService");
        intent.setPackage("com.idealcn.aidlstudy");
        bindService(intent,connection, Context.BIND_AUTO_CREATE);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(connection);
    }

    public void add(View view) throws RemoteException {
        int add = iMyAidlInterface.add(10, 20);
        Toast.makeText(this, "add: "+add, Toast.LENGTH_SHORT).show();
    }


    public void getStudent(View view) throws RemoteException {
        List<Student> students = iMyAidlInterface.makeStudentList();
        for (Student student : students) {
            System.out.println("student: =>"+student.toString());
        }
    }
}
