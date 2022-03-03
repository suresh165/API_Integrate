package suresh.chandra.api_integrate;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface API_interface {
    @GET("WO6S")
    Call<List<RecyclerDataModel>> getdata();
}
