package com.example.citytours;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.example.citytours.HomeAdapter.FeaturedAdapter;
import com.example.citytours.HomeAdapter.FeaturedTrips;
import com.example.citytours.HomeAdapter.WeekTrips;
import com.example.citytours.HomeAdapter.WeekTripsAdapter;

import java.util.ArrayList;

public class Dashboard extends AppCompatActivity {
    RecyclerView featurerecyclerView,weekTripRecyclerView;
    RecyclerView.Adapter adapter,weekTripAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        featurerecyclerView = findViewById(R.id.feature_recycler);
        weekTripRecyclerView = findViewById(R.id.weektrip_recycler);

        ///create a method for the recycler

        featuredRecycler();
        weekTripRecycler();
    }

    private void weekTripRecycler() {
        weekTripRecyclerView.setHasFixedSize(true);

        weekTripRecyclerView.setLayoutManager(new LinearLayoutManager
                (this,LinearLayoutManager.HORIZONTAL,false));

        ArrayList<WeekTrips>weekTrips = new ArrayList<>();
        weekTrips.add(new WeekTrips(R.drawable.avatar,"Wangocho","10 guys to 14 falls"));
        weekTrips.add(new WeekTrips(R.drawable.car,"Jack","10 guys to Mt Kenya Saturday"));
        weekTrips.add(new WeekTrips(R.drawable.hiking," Ken","10 guys to 14 falls"));
        weekTrips.add(new WeekTrips(R.drawable.hike2,"Jerry","20 guys to 14 falls"));

        weekTripAdapter = new WeekTripsAdapter(weekTrips);
        weekTripRecyclerView.setAdapter(weekTripAdapter);


    }

    private void featuredRecycler() {
        /// make has fixed size true
         featurerecyclerView.setHasFixedSize(true);
         ///set layout
        featurerecyclerView.setLayoutManager(new LinearLayoutManager(this,
                                                                        LinearLayoutManager.HORIZONTAL,
                                                            false));

        ArrayList<FeaturedTrips>featuredTrips = new ArrayList<>();
        featuredTrips.add(new FeaturedTrips(R.drawable.hiking,"MT.KENYA","come join use to conqure this mountain"));
        featuredTrips.add(new FeaturedTrips(R.drawable.hike2,"MT.Elgon","come join use to conqure this mountain"));
        featuredTrips.add(new FeaturedTrips(R.drawable.hike3,"MT.Kilimanjaro","Tallest mountain in Africa"));
        featuredTrips.add(new FeaturedTrips(R.drawable.hike4,"Karura Forest","time to take a walk in the woods"));

        adapter = new FeaturedAdapter(featuredTrips);
        featurerecyclerView.setAdapter(adapter);
    }
}
