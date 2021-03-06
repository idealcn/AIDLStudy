// IMyAidlInterface.aidl
package com.idealcn.aidlstudy;

// Declare any non-default types here with import statements
//★★手动导入★★
import com.idealcn.aidlstudy.bean.Student;
interface IMyAidlInterface {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
            double aDouble, String aString);

            int add(int a,int b);
            void delete();
            List<Student> makeStudentList();
}
