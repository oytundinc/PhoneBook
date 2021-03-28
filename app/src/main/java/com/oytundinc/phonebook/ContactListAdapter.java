package com.oytundinc.phonebook;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ContactListAdapter extends RecyclerView.Adapter<ContactListAdapter.ContactListViewHolder> {

    private List<Contact> contactList;

    public ContactListAdapter(List<Contact> contactList) {
        this.contactList = contactList;
    }

    @NonNull
    @Override
    public ContactListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_list_item, parent, false);
        return new ContactListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactListViewHolder holder, int position) {
        Contact contact = contactList.get(position);

        holder.getTxtNameAndSurname().setText(contact.getName() + " " + contact.getSurname());
        holder.getTxtPhoneNumber().setText(contact.getPhoneNumber());
        holder.getTxtEmail().setText(contact.getEmail());
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    public static class ContactListViewHolder extends RecyclerView.ViewHolder {

        private TextView txtNameAndSurname;
        private TextView txtPhoneNumber;
        private TextView txtEmail;

        public ContactListViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNameAndSurname = itemView.findViewById(R.id.txtNameAndSurname);
            txtPhoneNumber = itemView.findViewById(R.id.txtPhoneNumber);
            txtEmail = itemView.findViewById(R.id.txtEmail);
        }

        public TextView getTxtNameAndSurname() {
            return this.txtNameAndSurname;
        }

        public TextView getTxtPhoneNumber() {
            return this.txtPhoneNumber;
        }

        public TextView getTxtEmail() {
            return this.txtEmail;
        }
    }

}
