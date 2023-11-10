package API;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APIService {

    @GET("/api/schools/schoolList")
    Call<List<SchoolData>> getSchools();
    @GET("/api/users/userList")
    Call<List<StudentData>> getStudents();

    @GET("/api/users/userList")
    Call<List<UserData>> getUsers();
    @POST("/api/users/login")
    Call<UserData> login(@Body UserData userData);

}
