package com.example.juliefalcou.my_mvvm_app.Directory;

import android.arch.persistence.room.Database;


import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

@Database(entities = {Contact.class}, version = 1)
public abstract class ContactDatabase extends RoomDatabase {

    private static ContactDatabase instance;

    public abstract ContactDao contactDao();

    static synchronized ContactDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    ContactDatabase.class, "contact_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }
        return instance;
    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {
        private ContactDao contactDao;

        private PopulateDbAsyncTask(ContactDatabase db) {
            contactDao = db.contactDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            contactDao.insert(new Contact("@string/firstname1", "@string/lastname1", "@string/role1", "@string/paris", "@string/email1", "@string/phone1", "@string/password1"));
            contactDao.insert(new Contact("@string/firstname2", "@string/lastname2", "@string/role2", "@string/paris", "@string/email2", "@string/phone2", "@string/password2"));
            contactDao.insert(new Contact("@string/firstname3", "@string/lastname3", "@string/role3", "@string/lavald", "@string/email3", "@string/phone3", "@string/password3"));
            contactDao.insert(new Contact("@string/firstname4", "@string/lastname4", "@string/role4", "@string/paris", "@string/email4", "@string/phone4", "@string/password4"));
            return null;
        }
    }
}


