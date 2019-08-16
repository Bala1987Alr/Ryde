package com.bala.rydetask.service.datarepo;

import com.bala.rydetask.service.datamodel.data;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ContactsRepo {

    private RYDEService rydeService;
    private static ContactsRepo contactsRepo;

    private ContactsRepo()
    {
        Retrofit retrofit = new Retrofit.Builder().
                baseUrl(RYDEService.base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        rydeService = retrofit.create(RYDEService.class);

    }

    public synchronized static ContactsRepo getInstance()
    {
        if(contactsRepo!=null)
        {
             contactsRepo = new ContactsRepo();
        }
        return contactsRepo;
    }

    public LiveData<List<data>> getContactList(int page) {

        final MutableLiveData<List<data>> contactList = new MutableLiveData<>();

        rydeService.getContactList(2).enqueue(new Callback<List<data>>() {
            @Override
            public void onResponse(Call<List<data>> call, Response<List<data>> response) {

                contactList.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<data>> call, Throwable t) {

            }
        });

        return contactList;
    }


    public LiveData<data> getContact(int id)
    {
        final MutableLiveData<data> contact = new MutableLiveData<>();

        rydeService.getContact(id).enqueue(new Callback<data>() {
            @Override
            public void onResponse(Call<data> call, Response<data> response) {

                contact.setValue(response.body());
            }

            @Override
            public void onFailure(Call<data> call, Throwable t) {

            }
        });

        return  contact;

    }



}
