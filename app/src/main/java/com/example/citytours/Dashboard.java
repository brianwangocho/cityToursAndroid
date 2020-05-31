package com.example.citytours;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.citytours.HomeAdapter.FeaturedAdapter;
import com.example.citytours.HomeAdapter.FeaturedTrips;
import com.example.citytours.HomeAdapter.WeekTrips;
import com.example.citytours.HomeAdapter.WeekTripsAdapter;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class Dashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    RecyclerView featurerecyclerView,weekTripRecyclerView;
    RecyclerView.Adapter adapter,weekTripAdapter;
    ImageView menuIcon;

    ///drawerMenu
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        featurerecyclerView = findViewById(R.id.feature_recycler);
        weekTripRecyclerView = findViewById(R.id.weektrip_recycler);

        ///menu variables
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);
        menuIcon = findViewById(R.id.menu_icon);

        ///create a method for the recycler
        featuredRecycler();
        weekTripRecycler();
        ////drawer animations
        navigationDrawer();

    }

    private void navigationDrawer() {
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home);


        menuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(drawerLayout.isDrawerVisible(GravityCompat.START)){
                    drawerLayout.closeDrawer(GravityCompat.START);
                }
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        animateNavigationDrawer();
    }

    private void animateNavigationDrawer() {
        drawerLayout.setScrimColor(getResources().getColor(R.color.colorPrimary));
    }

    ///// handle clicks of item of the navigation drawer
    //TODO :(1)ADD ACTIVITY TO LINK TO IN EACH DRAWER ITEM
    //TODO:(2) HANDLE HOW TO CLOSE DRAWER WHEN YOU RESUME AN ACTIVITY


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();


        if(id == R.id.logout){
            Intent i = new Intent(Dashboard.this,Login.class);
            startActivity(i);
            finish();


        }else if(id==R.id.profile){
            Intent i = new Intent(Dashboard.this,UserProfile.class);
            startActivity(i);
        }else if(id == R.id.nav_home){


        }else if(id == R.id.history){

        }else if (id == R.id.settings){

        }
        else if(id == R.id.camping){

        }else if (id == R.id.hiking){

        }
        else if(id == R.id.forest_walks){

        }



        return true;
    }

    @Override
    public void onBackPressed() {
        /// make sure drawer is closed when closing the app

        if(drawerLayout.isDrawerVisible(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else

        super.onBackPressed();
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
