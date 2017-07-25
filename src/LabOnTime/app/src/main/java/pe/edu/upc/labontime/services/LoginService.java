package pe.edu.upc.labontime.services;

import pe.edu.upc.labontime.models.ResponseBD01;
import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by hp on 25/07/2017.
 */

public interface LoginService {

    @POST("Login/UpdateUser")
    Call<ResponseBD01> getAccessToken(
            @Query("id") int id,
            @Query("password") String password,
            @Query("address") String address,
            @Query("email") String email,
            @Query("phone") String phone);

}
