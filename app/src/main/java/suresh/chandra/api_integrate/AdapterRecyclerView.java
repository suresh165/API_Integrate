package suresh.chandra.api_integrate;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterRecyclerView extends RecyclerView.Adapter<AdapterRecyclerView.HolderView> {
   private List<RecyclerDataModel> dataList;
   private Context context;

    public AdapterRecyclerView(List<RecyclerDataModel> dataList, Context context) {
        this.dataList = dataList;
        this.context = context;
    }

    @NonNull
    @Override
    public HolderView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.design_data_set,parent,false);
        return new HolderView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderView holder, int position) {
        RecyclerDataModel modal = dataList.get(position);
        holder.courseNameTV.setText(dataList.get(position).getCourseName());
        holder.courseTracksTV.setText(dataList.get(position).getCourseTracks());
        holder.courseModeTV.setText(dataList.get(position).getCourseMode());
        Picasso.get().load(modal.getCourseimg()).into(holder.courseIV);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class HolderView extends RecyclerView.ViewHolder {
        private TextView courseNameTV, courseModeTV, courseTracksTV;
        private ImageView courseIV;
        public HolderView(@NonNull View itemView) {
            super(itemView);
            courseNameTV = itemView.findViewById(R.id.idTVCourseName);
            courseModeTV = itemView.findViewById(R.id.idTVBatch);
            courseTracksTV = itemView.findViewById(R.id.idTVTracks);
            courseIV = itemView.findViewById(R.id.idIVCourse);
        }
    }
}
