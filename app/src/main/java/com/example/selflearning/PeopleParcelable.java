package com.example.selflearning;

import android.os.Parcel;
import android.os.Parcelable;

public class PeopleParcelable implements Parcelable {
    private String name;
    private int age;

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
    public PeopleParcelable(String name, int age) {
        this.age = age;
        this.name = name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(getName());
        dest.writeInt(getAge());
    }

    public static final Creator<PeopleParcelable> CREATOR = new Creator<PeopleParcelable>() {
        @Override
        public PeopleParcelable createFromParcel(Parcel source) {
            return new PeopleParcelable(source.readString(), source.readInt());
        }

        @Override
        public PeopleParcelable[] newArray(int size) {
            return new PeopleParcelable[size];
        }
    };
}
