package com.oytundinc.phonebook;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class NewContactDialog extends DialogFragment {

    private NewContactListener newContactListener;

    public NewContactDialog(NewContactListener newContactListener) {
        this.newContactListener = newContactListener;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = requireActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_new_contact, null);


        EditText edtTxtName = view.findViewById(R.id.edtTxtName);
        EditText edtTxtSurname = view.findViewById(R.id.edtTxtSurname);
        EditText edtTxtPhone = view.findViewById(R.id.edtTxtPhone);
        EditText edtTxtEmail = view.findViewById(R.id.edtTxtEmail);

        builder.setView(view)
          .setPositiveButton("Save", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (validate(edtTxtName.getText().toString(), edtTxtSurname.getText().toString(), edtTxtPhone.toString())) {
                    newContactListener.onSaveContact(new Contact(edtTxtName.getText().toString(), edtTxtSurname.getText().toString(), edtTxtPhone.getText().toString(), edtTxtEmail.getText().toString()));
                } else {
                    // Show message.
                }
            }
        }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                newContactListener.onCancel();
            }
        });
        return builder.create();
    }

    private boolean validate(String name, String surname, String phone) {
        if (name == null || name.isEmpty() || surname == null || surname.isEmpty() || phone == null || phone.isEmpty()) {
            return false;
        }
        return true;
    }
}
