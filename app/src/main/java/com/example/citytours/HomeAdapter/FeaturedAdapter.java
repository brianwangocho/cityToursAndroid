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

public class FeaturedAdapter extends RecyclerView.Adapter<FeaturedAdapter.featuredViewHolder> {

    ///// create  an ArrayList of the object that will be used in the recycler

    ArrayList<FeaturedTrips>featuredTripsArrayList;

    //// create a constructor for the class
    public FeaturedAdapter(ArrayList<FeaturedTrips> featuredTripsArrayList) {
        this.featuredTripsArrayList = featuredTripsArrayList;
    }

    @NonNull
    @Override
    public featuredViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        /// give it the xml resource it will use
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.featured_card_design,parent,false);

        FeaturedAdapter.featuredViewHolder featuredViewHolder = new FeaturedAdapter.featuredViewHolder(view);
        return featuredViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull featuredViewHolder holder, int position) {
        FeaturedTrips featuredTrip = featuredTripsArrayList.get(position);

        holder.image.setImageResource(featuredTrip.getImage());
        holder.title.setText(featuredTrip.getTitle());
        holder.description.setText(featuredTrip.description);

    }

    @Override
    public int getItemCount() {
        return featuredTripsArrayList.size();
    }
    ///// create an inner class viewHolder

    public static class  featuredViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView title,description;

        public featuredViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.feature_image);
            title = itemView.findViewById(R.id.feature_title);
            description = itemView.findViewById(R.id.feature_description);
        }
    }
}
