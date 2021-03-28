package com.oytundinc.phonebook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private NewContactDialog contactDialog = null;

    private ContactListAdapter adapter;

    private List<Contact> contactList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ConstraintLayout constraintLayout = findViewById(R.id.mainView);
        RecyclerView rcyVContactList = findViewById(R.id.contactList);
        Button btnNewContact = findViewById(R.id.btnNewContact);
        btnNewContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contactDialog = new NewContactDialog(new NewContactListener() {
                    @Override
                    public void onSaveContact(Contact contact) {
                        saveContact(contact);
                        adapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onCancel() {
                        if (contactDialog != null) {
                            contactDialog.dismiss();
                        }
                    }
                });
                contactDialog.show(getSupportFragmentManager(), "NewContactFragment");
            }
        });

        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        rcyVContactList.setLayoutManager(layoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(rcyVContactList.getContext(), layoutManager.getOrientation());
        rcyVContactList.addItemDecoration(dividerItemDecoration);

        //List<Contact> testData = prepareTestData();
        adapter = new ContactListAdapter(getContactList());
        rcyVContactList.setAdapter(adapter);
    }

    public List<Contact> prepareTestData() {
        List<Contact> testList = new ArrayList<>();
        for(int i = 0; i <= 100; i++) {
            Contact test = new Contact("test" + i,"test" + i,"test" + i,"test" + i);
            testList.add(test);
        }
        return testList;
    }

    public List<Contact> getContactList() {
        return this.contactList;
    }

    public void saveContact(Contact contact) {
        this.contactList.add(contact);
    }

    public void saveContact(String name, String surname, String phoneNumber, String email) {
        this.contactList.add(new Contact(name, surname, phoneNumber, email));
    }

}