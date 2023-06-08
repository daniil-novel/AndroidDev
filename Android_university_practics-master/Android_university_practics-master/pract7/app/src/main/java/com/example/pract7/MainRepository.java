package com.example.pract7;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainRepository {
    String[] partsListRemote = {"CPU", "GPU", "Motherboard", "PSU", "Case", "CPU Cooling",
            "Case Cooling", "RAM", "SSD", "HDD"};

    public MainRepository() {
    }

    public void loginRemote(LoginBody loginBody, ILoginResponse loginResponse){
        ILoginService loginService = RetrofitClientInstance.getInstance().create(ILoginService.class);
        Call<LoginResponse> initiateLogin = loginService.login(loginBody);


        initiateLogin.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.isSuccessful()){
                    loginResponse.onResponse(response.body());
                } else {
                    loginResponse.onFailure(new Throwable(response.message()));
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                loginResponse.onFailure(t);
            }
        });

    }

    public void suggestNewDrink(IDrinkCallback drinkCallback) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        //Before executing background task

        executor.execute(new Runnable() {
            @Override
            public void run() {

                //Background work here
                try {
                    Thread.sleep(1000); // Mimic server request / long execution

                    String drinkName = partsListRemote[new Random()
                            .nextInt(partsListRemote.length)];
                    drinkCallback.onDrinkSuggested(drinkName);
                } catch (InterruptedException e) {
                    drinkCallback.onErrorOccurred();
                    e.printStackTrace();
                } catch (Exception e){
                    e.printStackTrace();
                    drinkCallback.onErrorOccurred();
                }
            }
        });
    }

    public interface ILoginResponse{
        void onResponse(LoginResponse loginResponse);
        void onFailure(Throwable t);
    }

    public interface IDrinkCallback {
        void onDrinkSuggested(String drinkName);
        void onErrorOccurred();
    }
}
