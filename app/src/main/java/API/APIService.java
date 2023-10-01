package API;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {

    @GET("/api/schoolList")
    Call<List<SchoolData>> getSchools();
}
