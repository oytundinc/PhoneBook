package com.oytundinc.phonebook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Contact> contactList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


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