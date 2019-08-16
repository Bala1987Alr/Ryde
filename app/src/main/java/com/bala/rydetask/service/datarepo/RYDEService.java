package com.bala.rydetask.service.datarepo;

import com.bala.rydetask.service.datamodel.data;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RYDEService {

     String base_url = "https://reqres.in/api";

     @GET("/users")
     Call<List<data>> getContactList(@Query("page") int page);

     @GET("/users/{id}")
     Call<data> getContact(@Path("id") int id);


}
