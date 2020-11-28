package com.idealcn.aidlstudy.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by ideal-gn on 2017/9/27.
 */

public class Student implements Parcelable{

    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private Student(Parcel in) {
        name = in.readString();
        age = in.readInt();
    }

    public static final Creator<Student> CREATOR = new Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel in) {
            return new Student(in);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
       dest.writeString(name);
       dest.writeInt(age);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
