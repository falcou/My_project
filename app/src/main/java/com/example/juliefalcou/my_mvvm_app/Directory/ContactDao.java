package com.example.juliefalcou.my_mvvm_app.Directory;


import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface ContactDao {

    @Insert
    void insert(Contact contact);

    @Update
    void update(Contact contact);

    @Delete
    void delete(Contact contact);

    @Query("DELETE FROM List_of_contacts")
    void deleteAllContacts();

    @Query("SELECT * FROM List_of_contacts ORDER BY lastname ASC")
    LiveData<List<Contact>> getAllContacts();

}
