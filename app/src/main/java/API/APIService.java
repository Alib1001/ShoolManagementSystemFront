package API;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {

    @GET("/api/schools/schoolList")
    Call<List<SchoolData>> getSchools();

    @GET("/api/students/studentsList")
    Call<List<SchoolData>> getStudents();

}
