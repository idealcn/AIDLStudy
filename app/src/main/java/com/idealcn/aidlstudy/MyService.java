package com.idealcn.aidlstudy;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;


import com.idealcn.aidlstudy.bean.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ideal-gn on 2017/9/27.
 */

public class MyService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return stub;
    }


    IMyAidlInterface.Stub stub = new IMyAidlInterface.Stub() {
        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

        }

        @Override
        public int add(int a, int b) throws RemoteException {
           return a + b ;
        }

        @Override
        public void delete() throws RemoteException {

        }

        @Override
        public List<Student> makeStudentList(){
            ArrayList<Student> students = new ArrayList<>();
            students.add(new Student("john",15));
            return students;
        }
    };


}
