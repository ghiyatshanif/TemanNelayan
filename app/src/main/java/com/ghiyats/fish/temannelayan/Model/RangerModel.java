package com.ghiyats.fish.temannelayan.Model;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Ghiyats on 6/12/2015.
 */
public class RangerModel extends RealmObject {
    @PrimaryKey
    private String uniqueID;

    private String rangerID;
    private String rangerName;
    private String thumbnail;
    private String memberOf;
    private String phoneNumber;
    private String password;
    private RealmList<TurtleModel> inChargeFor;

    public String getUniqueID() {
        return uniqueID;
    }

    public void setUniqueID(String uniqueID) {
        this.uniqueID = uniqueID;
    }

    public String getRangerID() {
        return rangerID;
    }

    public void setRangerID(String rangerID) {
        this.rangerID = rangerID;
    }

    public String getRangerName() {
        return rangerName;
    }

    public void setRangerName(String rangerName) {
        this.rangerName = rangerName;
    }

    public String getMemberOf() {
        return memberOf;
    }

    public void setMemberOf(String memberOf) {
        this.memberOf = memberOf;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RealmList<TurtleModel> getInChargeFor() {
        return inChargeFor;
    }

    public void setInChargeFor(RealmList<TurtleModel> inChargeFor) {
        this.inChargeFor = inChargeFor;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
}
