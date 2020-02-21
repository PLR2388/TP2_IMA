package ca.ulaval.ima.tp2;

import android.os.Parcel;
import android.os.Parcelable;

public class Profile implements Parcelable {

    public String getFirstName() {
        return firstName;
    }

    public String getName() {
        return name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getSex() {
        return sex;
    }

    public String getField() {
        return field;
    }

    public Profile clone(){
        Profile profile=new Profile(firstName,name,birthDate,sex,field);
        return profile;
    }

    private String firstName;
    private String name;
    private String birthDate;
    private String sex;
    private String field;

    public Profile(String firstName,String name,String birthDate,String sex,String field){
        this.firstName=firstName;
        this.name=name;
        this.birthDate=birthDate;
        this.sex=sex;
        this.field=field;
    }

    protected Profile(Parcel in) {
        firstName = in.readString();
        name = in.readString();
        birthDate = in.readString();
        sex = in.readString();
        field = in.readString();
    }

    public static final Creator<Profile> CREATOR = new Creator<Profile>() {
        @Override
        public Profile createFromParcel(Parcel in) {
            return new Profile(in);
        }

        @Override
        public Profile[] newArray(int size) {
            return new Profile[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.firstName);
        dest.writeString(this.name);
        dest.writeString(this.birthDate);
        dest.writeString(this.sex);
        dest.writeString(this.field);

    }
}
