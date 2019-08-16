package com.bala.rydetask.viewmodel;

import android.app.Application;

import com.bala.rydetask.service.datamodel.data;
import com.bala.rydetask.service.datarepo.ContactsRepo;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;


//This view model used to retrieve the data from services and supply to view
public class ContactListViewModel extends AndroidViewModel {

    private final LiveData<List<data>> contactList;

    public ContactListViewModel(@NonNull Application application) {
        super(application);
        contactList = ContactsRepo.getInstance().getContactList(2);
    }

    //This method is used to make ui to consume the data whenever updated
    public LiveData<List<data>> getContactList()
    {
        return contactList;
    }
}
