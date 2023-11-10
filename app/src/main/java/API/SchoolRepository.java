package API;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SchoolRepository {

    public static final String BASE_URL = "http://192.168.0.217:8082";
    private static SchoolRepository instance;
    private final APIService apiService;

    private SchoolRepository() {

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        apiService = retrofit.create(APIService.class);
    }

    public static SchoolRepository getInstance() {
        if (instance == null) {
            instance = new SchoolRepository();
        }
        return instance;
    }

    public void getSchools(Callback<List<SchoolData>> callback) {
        Call<List<SchoolData>> call = apiService.getSchools();
        call.enqueue(callback);
    }

    public void getStudents(Callback<List<StudentData>> callback) {
        Call<List<StudentData>> call = apiService.getStudents();
        call.enqueue(callback);
    }

    public void getUsers(Callback<List<UserData>> callback) {
        Call<List<UserData>> call = apiService.getUsers();
        call.enqueue(callback);
    }

    public void login(UserData userData, Callback<UserData> callback) {
        Call<UserData> call = apiService.login(userData);
        call.enqueue(callback);
    }

}
