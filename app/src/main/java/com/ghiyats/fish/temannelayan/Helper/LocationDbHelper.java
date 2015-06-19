package com.ghiyats.fish.temannelayan.Helper;

import android.content.Context;
import android.util.Log;

import com.ghiyats.fish.temannelayan.Model.RangerModel;
import com.ghiyats.fish.temannelayan.Model.TurtleModel;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

import io.realm.Realm;
import io.realm.RealmResults;


public class LocationDbHelper {

    private Context context;

    public LocationDbHelper(Context context) {
        this.context = context;
    }

    public ArrayList<TurtleModel> load(){
        ArrayList<TurtleModel> locations = new ArrayList<TurtleModel>();
        Realm realm = Realm.getInstance(context);

        RealmResults<TurtleModel> query = realm.where(TurtleModel.class).findAll();

        for (TurtleModel lm : query){
            locations.add(lm);
        }
        return locations;
    }

    public void init( String name, String turtleCategory,int jmlTelur, String latitude, String longitude, Date savedOn, String createdBy,String dropboxLink){

        Realm realm = Realm.getInstance(context);
        //beginning realm transaction
        realm.beginTransaction();

        TurtleModel lm = realm.createObject(TurtleModel.class);
        lm.setName(name);
        lm.setID(UUID.randomUUID().toString());
        lm.setJmlTelur(jmlTelur);
        lm.setTurtleCategory(turtleCategory);
        lm.setLatitude(latitude);
        lm.setLongitude(longitude);
        lm.setSavedBy(createdBy);
        lm.setSavedOn(savedOn);
        lm.setDropboxLink(dropboxLink);
        lm.setRandomNum(new Random().nextInt(6));


        realm.commitTransaction();
        Log.d("Realm init","added");
    }

    public void add(String name, String turtleCategory,int jmlTelur, String latitude, String longitude, Date savedOn, String createdBy,String dropboxLink, RangerModel rangerIncharge){
        Realm realm = Realm.getInstance(context);
        //beginning realm transaction
        realm.beginTransaction();

        TurtleModel lm = realm.createObject(TurtleModel.class);
        lm.setName(name);
        lm.setID(UUID.randomUUID().toString());
        lm.setTurtleCategory(turtleCategory);
        lm.setJmlTelur(jmlTelur);
        lm.setLatitude(latitude);
        lm.setLongitude(longitude);
        lm.setSavedBy(createdBy);
        lm.setSavedOn(savedOn);
        lm.setDropboxLink(dropboxLink);
        lm.setRandomNum(new Random().nextInt(6));
        lm.setRangerInCharge(rangerIncharge);

        realm.commitTransaction();
    }

    public void edit(String ID,TurtleModel turtle){
        Realm realm = Realm.getInstance(context);
        //beginning realm transaction

        TurtleModel lm = realm.where(TurtleModel.class)
                .equalTo("ID",ID).findFirst();

        realm.beginTransaction();

        lm.setName(turtle.getName());
        lm.setTurtleCategory(turtle.getTurtleCategory());
        lm.setJmlTelur(turtle.getJmlTelur());
        lm.setSavedOn(getCurentTime());
        lm.setDropboxLink(turtle.getDropboxLink());
        lm.setRangerInCharge(turtle.getRangerInCharge());

        realm.commitTransaction();
    }

    public void delete(String ID){
        Realm realm = Realm.getInstance(context);

        TurtleModel lm = realm.where(TurtleModel.class)
                .equalTo("ID",ID).findFirst();

        realm.beginTransaction();
        lm.removeFromRealm();
        realm.commitTransaction();
    }

    public TurtleModel get(String ID){
        Realm realm = Realm.getInstance(context);

        TurtleModel lm = realm.where(TurtleModel.class)
                .equalTo("ID",ID).findFirst();

        return lm;
    }

    public Date getCurentTime(){
        Calendar c = Calendar.getInstance();
        Date date= c.getTime();
        return date;
    }

    public void clear(){
        Realm realm = Realm.getInstance(context);
        RealmResults<TurtleModel> query = realm.where(TurtleModel.class).findAll();
        realm.beginTransaction();
        query.clear();
        realm.commitTransaction();
    }

}
