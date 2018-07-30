package com.example.greendao.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Master {
    @Id
    private Long mId;
    private String mUserName;
    private String mSex;
    @Generated(hash = 120154453)
    public Master(Long mId, String mUserName, String mSex) {
        this.mId = mId;
        this.mUserName = mUserName;
        this.mSex = mSex;
    }
    @Generated(hash = 1646309065)
    public Master() {
    }
    public Long getMId() {
        return this.mId;
    }
    public void setMId(Long mId) {
        this.mId = mId;
    }
    public String getMUserName() {
        return this.mUserName;
    }
    public void setMUserName(String mUserName) {
        this.mUserName = mUserName;
    }
    public String getMSex() {
        return this.mSex;
    }
    public void setMSex(String mSex) {
        this.mSex = mSex;
    }
}
