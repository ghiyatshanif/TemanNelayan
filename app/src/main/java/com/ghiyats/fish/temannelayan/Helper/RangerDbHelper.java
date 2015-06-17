package com.ghiyats.fish.temannelayan.Helper;

import android.content.Context;

import com.ghiyats.fish.temannelayan.Model.RangerModel;
import com.ghiyats.fish.temannelayan.Model.TurtleModel;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.UUID;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmResults;

/**
 * Created by Ghiyats on 6/12/2015.
 */
public class RangerDbHelper {
    private Context context;

    public RangerDbHelper(Context context) {
        this.context = context;
    }

    public ArrayList<RangerModel> load(){
        ArrayList<RangerModel> rangers = new ArrayList<RangerModel>();
        Realm realm = Realm.getInstance(context);
        RealmResults<RangerModel> results = realm.where(RangerModel.class).findAll();

        for (RangerModel rangerModel : results){
            rangers.add(rangerModel);
        }
        return rangers;
    }

    public void edit(String ID, RangerModel ranger){
        Realm realm = Realm.getInstance(context);
        RangerModel edit = new RangerModel();

        edit = realm.where(RangerModel.class).equalTo("uniqueID",ID).findFirst();

        realm.beginTransaction();

        edit.setRangerName(ranger.getRangerName());
        edit.setPassword(ranger.getPassword());
        edit.setMemberOf(ranger.getMemberOf());
        edit.setPhoneNumber(ranger.getPhoneNumber());
        edit.setInChargeFor(ranger.getInChargeFor());

        realm.commitTransaction();
    }

    public void delete(String ID){
        Realm realm = Realm.getInstance(context);

        RangerModel delete = new RangerModel();
        delete = realm.where(RangerModel.class).equalTo("uniqueID",ID).findFirst();

        realm.beginTransaction();
        delete.removeFromRealm();
        realm.commitTransaction();
    }

    public void add(RangerModel ranger){
        Realm realm = Realm.getInstance(context);

        RangerModel add = realm.createObject(RangerModel.class);

        realm.beginTransaction();
        add.setUniqueID(UUID.randomUUID().toString());
        add.setRangerID(ranger.getRangerID());
        add.setRangerName(ranger.getRangerName());
        add.setPassword(ranger.getPassword());
        add.setPhoneNumber(ranger.getPhoneNumber());
        add.setMemberOf(ranger.getMemberOf());
        add.setInChargeFor(ranger.getInChargeFor());
        realm.commitTransaction();
    }

    public RangerModel get(String ID){
        Realm realm = Realm.getInstance(context);

        RangerModel get = new RangerModel();
        get = realm.where(RangerModel.class).equalTo("uniqueID",ID).findFirst();

        return get;
    }

    public void clear(){
        Realm realm = Realm.getInstance(context);
        RealmResults<RangerModel> query = realm.where(RangerModel.class).findAll();

        realm.beginTransaction();
        query.clear();
        realm.commitTransaction();
    }

    public ArrayList<String> getRangerNames(){
        Realm realm = Realm.getInstance(context);
        ArrayList<String> rangers = new ArrayList<String>();

        RealmResults<RangerModel> query = realm.where(RangerModel.class).findAll();
        for (RangerModel rm : query){
            rangers.add(rm.getRangerID()+" "+getRangerNames());
        }
        return rangers;
    }

    public void addInCharge(String ID,TurtleModel turtle){
        Realm realm = Realm.getInstance(context);
        RangerModel ranger = new RangerModel();
        ranger = realm.where(RangerModel.class).equalTo("uniqueID",ID).findFirst();

        realm.beginTransaction();
        ranger.getInChargeFor().add(turtle);
        realm.commitTransaction();
    }

    public void deleteInCharge(TurtleModel turtle){
        Realm realm = Realm.getInstance(context);
        RangerModel ranger = new RangerModel();
        ranger = realm.where(RangerModel.class).equalTo("inChargeFor.ID",turtle.getID()).findFirst();

        realm.beginTransaction();
        ranger.getInChargeFor().remove(turtle);
        realm.commitTransaction();
    }

    public void init(String rangerID, String rangerName, String memberOf, String phoneNumber, String password, ArrayList<TurtleModel> inChargeFor){
        Realm realm = Realm.getInstance(context);

        RealmList<TurtleModel> inCharge = new RealmList<TurtleModel>();

        for (TurtleModel turtle : inChargeFor){
            inCharge.add(turtle);
        }


        RangerModel init = realm.createObject(RangerModel.class);

        realm.beginTransaction();
        init.setUniqueID(UUID.randomUUID().toString());
        init.setRangerID(rangerID);
        init.setRangerName(rangerName);
        init.setMemberOf(memberOf);
        init.setPhoneNumber(phoneNumber);
        init.setPassword(password);
        init.setInChargeFor(inCharge);
        realm.commitTransaction();
    }


}
