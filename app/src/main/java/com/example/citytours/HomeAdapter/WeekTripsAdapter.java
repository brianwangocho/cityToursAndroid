package com.example.citytours.HomeAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.citytours.R;

import java.util.ArrayList;

public class WeekTripsAdapter extends RecyclerView.Adapter<WeekTripsAdapter.WeekTripsViewHolder> {

    ArrayList<WeekTrips>weekTrips;

    public WeekTripsAdapter(ArrayList<WeekTrips> weekTrips) {
        this.weekTrips = weekTrips;
    }

    @NonNull
    @Override
    public WeekTripsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.week_trip,parent,false);
        WeekTripsViewHolder weekTripsViewHolder = new WeekTripsViewHolder(view);
        return weekTripsViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull WeekTripsViewHolder holder, int position) {
        WeekTrips weekTrip = weekTrips.get(position);
        holder.name.setText(weekTrip.getName());
        holder.description.setText(weekTrip.getDescription());
        holder.image.setImageResource(weekTrip.getImage());

    }

    @Override
    public int getItemCount() {
        return weekTrips.size();
    }


    public static class WeekTripsViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView name,description;

        public WeekTripsViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.week_image);
            name = itemView.findViewById(R.id.week_name);
            description = itemView.findViewById(R.id.week_description);

        }
    }
}
