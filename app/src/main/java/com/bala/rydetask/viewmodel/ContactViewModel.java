package com.bala.rydetask.viewmodel;

import android.app.Application;

import com.bala.rydetask.service.datamodel.data;
import com.bala.rydetask.service.datarepo.ContactsRepo;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class ContactViewModel extends AndroidViewModel {

    private final LiveData<data> contact;

    public ContactViewModel(@NonNull Application application, int id) {
        super(application);

        contact = ContactsRepo.getInstance().getContact(id);
    }

    public LiveData<data> getContact()
    {
        return contact;
    }
}
