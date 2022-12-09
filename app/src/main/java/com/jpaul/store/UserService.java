package com.jpaul.store;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UserService {

    private String url;
    private IUserService iUserService;
    private List<User> userList;
    private User user;

    private ArrayList<IChangeEventListener> iChangeEventListeners;

    public UserService(String url) {
        this.url = url;
        configUserService();
        iChangeEventListeners = new ArrayList<IChangeEventListener>();
    }

    private void configUserService() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        iUserService = retrofit.create(IUserService.class);
        userList = new ArrayList();
    }

    public User login(User _user){
        Call<User> userCall = iUserService.login(_user);
        userCall.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(response.isSuccessful()){
                    user = response.body();
                    dispatchEvent("login");
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
        return user;
    }
    public void addEventListener(IChangeEventListener iChangeEventListener) {
        iChangeEventListeners.add(iChangeEventListener);
    }

    public void removeEventListener(IChangeEventListener iChangeEventListener){
        iChangeEventListeners.remove(iChangeEventListener);
    }

    public void dispatchEvent(String event){


        ListIterator listIterator = iChangeEventListeners.listIterator();
        while (listIterator.hasNext()){

            IChangeEventListener iChangeEventListener = (IChangeEventListener) listIterator.next();
            ChangeEvent changeEvent = new ChangeEvent(this,this);
            (iChangeEventListener).fetch(changeEvent);
            (iChangeEventListener).login(changeEvent);

        }
    }

}
