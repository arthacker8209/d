package com.example.marvelapp.data.model;import android.os.Parcel;import android.os.Parcelable;import androidx.room.ColumnInfo;import com.google.gson.annotations.SerializedName;public class CharacterImage implements Parcelable {        @ColumnInfo(name = "path")        @SerializedName("path")        private String path;        @ColumnInfo(name = "extension")        @SerializedName("extension")        private String extension;        public CharacterImage(String path, String extension) {            this.path = path;            this.extension = extension;        }    protected CharacterImage(Parcel in) {        path = in.readString();        extension = in.readString();    }    @Override    public void writeToParcel(Parcel dest, int flags) {        dest.writeString(path);        dest.writeString(extension);    }    @Override    public int describeContents() {        return 0;    }    public static final Creator<CharacterImage> CREATOR = new Creator<CharacterImage>() {        @Override        public CharacterImage createFromParcel(Parcel in) {            return new CharacterImage(in);        }        @Override        public CharacterImage[] newArray(int size) {            return new CharacterImage[size];        }    };    public String getPath() {            return path;        }        public void setPath(String path) {            this.path = path;        }        public String getExtension() {            return extension;        }        public void setExtension(String extension) {            this.extension = extension;        }    }