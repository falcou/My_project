package com.example.juliefalcou.my_mvvm_app.Directory;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.juliefalcou.my_mvvm_app.R;

import java.util.List;

public class Display_repository extends AppCompatActivity {

    private ContactViewModel contactViewModel;
    public static final int ADD_CONTACT_REQUEST = 1;
    public static final int EDIT_CONTACT_REQUEST = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.all_contacts);


        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        final ContactAdapter adapter = new ContactAdapter();
        recyclerView.setAdapter(adapter);

        FloatingActionButton displayadd = findViewById(R.id.Display_add);
        displayadd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Display_repository.this,Modify_Contact.class);
                startActivityForResult(intent,ADD_CONTACT_REQUEST);
            }});


        contactViewModel = ViewModelProviders.of(this).get(ContactViewModel.class);
        contactViewModel .getAllContacts().observe(this, new Observer<List<Contact>>() {
            @Override
            public void onChanged(@Nullable List<Contact> contacts) {
                adapter.setContacts(contacts);
            }
        });

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,
                ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                contactViewModel.delete(adapter.getContactAt(viewHolder.getAdapterPosition()));
                Toast.makeText(Display_repository.this, "Contact deleted", Toast.LENGTH_SHORT).show();
            }
        }).attachToRecyclerView(recyclerView);

        adapter.setOnItemClickListener(new ContactAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Contact contact) {
                Intent intent = new Intent(Display_repository.this,Modify_Contact.class);
                intent.putExtra(Modify_Contact.EXTRA_ID,contact.getId());
                intent.putExtra(Modify_Contact.EXTRA_FIRSTNAME,contact.getFirstname());
                intent.putExtra(Modify_Contact.EXTRA_LASTNAME,contact.getLastname());
                intent.putExtra(Modify_Contact.EXTRA_ROLE,contact.getRole());
                intent.putExtra(Modify_Contact.EXTRA_PLACE,contact.getPlace());
                intent.putExtra(Modify_Contact.EXTRA_EMAIL,contact.getEmail());
                intent.putExtra(Modify_Contact.EXTRA_PASSWORD,contact.getPassword());
                intent.putExtra(Modify_Contact.EXTRA_PHONENUMBER,contact.getPhonenumber());

                startActivityForResult(intent,EDIT_CONTACT_REQUEST);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        String firstname = data.getStringExtra(Modify_Contact.EXTRA_FIRSTNAME);
        String lastname = data.getStringExtra(Modify_Contact.EXTRA_LASTNAME);
        String role = data.getStringExtra(Modify_Contact.EXTRA_ROLE);
        String place = data.getStringExtra(Modify_Contact.EXTRA_PLACE);
        String email = data.getStringExtra(Modify_Contact.EXTRA_EMAIL);
        String password = data.getStringExtra(Modify_Contact.EXTRA_PASSWORD);
        String phonenumber = data.getStringExtra(Modify_Contact.EXTRA_PHONENUMBER);

        if (requestCode == ADD_CONTACT_REQUEST && resultCode == RESULT_OK) {

            Contact contact = new Contact(firstname, lastname,role, place, email, phonenumber, password);
            contactViewModel.insert(contact);

            Toast.makeText(this, "Contact saved", Toast.LENGTH_SHORT).show();
        }
        else if (requestCode == EDIT_CONTACT_REQUEST && resultCode == RESULT_OK){
            int id = data.getIntExtra(Modify_Contact.EXTRA_ID,-1);

            if(id==-1){
                Toast.makeText(this, "Contact can't be updated", Toast.LENGTH_SHORT).show();
            }

            Contact contact = new Contact(firstname, lastname,role, place, email, phonenumber, password);
            contact.setId(id);
            contactViewModel.update(contact);
            Toast.makeText(this, "Contact is updated", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "Contact not saved", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.delete_all_notes:
                contactViewModel.deleteAllContacts();
                Toast.makeText(this, "All contacts deleted", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
