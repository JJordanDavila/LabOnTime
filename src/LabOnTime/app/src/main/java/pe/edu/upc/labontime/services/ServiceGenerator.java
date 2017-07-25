package pe.edu.upc.labontime.services;

import android.text.TextUtils;

import okhttp3.Credentials;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrador on 30/03/2017.
 */

public class ServiceGenerator {

 // public static final String API_BASE_URL =  "http://34.223.247.148:8097/apilogisticateayuda/";
  public static final String API_BASE_URL =  "http://labontime.somee.com/api/";
   // public static final String API_BASE_URL =  "http://10.100.22.85:8097/";

    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

    private static Retrofit.Builder builder =
            new Retrofit.Builder()
                    .baseUrl(API_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofit = builder.build();


    public static <S> S createService(
            Class<S> serviceClass, String clientId, String clientSecret) {
        if (!TextUtils.isEmpty(clientId)
                && !TextUtils.isEmpty(clientSecret)) {
            String authToken = Credentials.basic(clientId, clientSecret);
            return createService(serviceClass);
        }

        return createService(serviceClass, null, null);
    }

    public static <S> S createService(
            Class<S> serviceClass) {


        return retrofit.create(serviceClass);
    }
}
