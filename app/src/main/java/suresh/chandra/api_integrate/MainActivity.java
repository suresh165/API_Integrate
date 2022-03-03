package suresh.chandra.api_integrate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    API_interface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.idRVCourse);

        apiInterface = Retrofit_Convertor.getRetrofit().create(API_interface.class);
        apiInterface.getdata().enqueue(new Callback<List<RecyclerDataModel>>() {
            @Override
            public void onResponse(Call<List<RecyclerDataModel>> call, Response<List<RecyclerDataModel>> response) {
                if (response.body().size()>0){
                    List<RecyclerDataModel> listdata = response.body();
                    AdapterRecyclerView adapterRecyclerView = new AdapterRecyclerView(listdata,MainActivity.this);
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
                    recyclerView.setLayoutManager(linearLayoutManager);
                    recyclerView.setAdapter(adapterRecyclerView);
                    Toast.makeText(MainActivity.this, "List is not empty", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<RecyclerDataModel>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "List is empty", Toast.LENGTH_SHORT).show();
            }
        });
    }
}