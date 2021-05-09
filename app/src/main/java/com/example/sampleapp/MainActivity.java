package com.example.sampleapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    //from model class
    private List<cardViewModel> cardList = new ArrayList<>();
    //from adaptor class
    private cardViewAdaptor cAdaptor;
    private LinearLayoutManager lLmanager;
    private RecyclerView recyclerView;

    //for tab layout
    private TabLayout tabLayout;
    private ViewPager viewPager;

    //bottom nav view
    private BottomNavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //initialization
        recyclerView = findViewById(R.id.recView);
        cAdaptor =new cardViewAdaptor(cardList);
        lLmanager = new LinearLayoutManager(getApplicationContext());
        lLmanager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(lLmanager);
        recyclerView.setAdapter(cAdaptor);

        // adding data to list method
        addCardData();

        //init  view for tablayout
        tabLayout = (TabLayout)findViewById(R.id.sampleTab);
        viewPager = (ViewPager)findViewById(R.id.sampleViewPager);
        // add text to the tabs to display
        tabLayout.addTab(tabLayout.newTab().setText("SampleOne"));
        tabLayout.addTab(tabLayout.newTab().setText("SampleTwo"));
        tabLayout.addTab(tabLayout.newTab().setText("SampleThree"));
        tabLayout.addTab(tabLayout.newTab().setText("SampleFour"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        //adaptor to count and populate the tab
        //from tab view adaptor class
        final TabViewAdaptor tabViewAdaptor = new TabViewAdaptor(this,getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(tabViewAdaptor);
        //page on change
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        //tab on select
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //populate the current tab content
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });



        // bottom navigation view activity
        navigationView = findViewById(R.id.bottomNavigationView);
        //fragment ids differ dest
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_person, R.id.nav_contact, R.id.nav_setting).build();
        //init navController
        NavController navController = Navigation.findNavController(this, R.id.sampleNavHostFrag);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
        //end of bottom nav view activity
    }



    private void addCardData(){
        cardViewModel cModel = new cardViewModel("card 1", "This is the 1st card");
        cardList.add(cModel);
        cModel = new cardViewModel("card 2", "This is the 2nd card");
        cardList.add(cModel);
        cModel = new cardViewModel("card 3", "This is the 3rd card");
        cardList.add(cModel);
        cModel = new cardViewModel("card 4", "This is the 4th card");
        cardList.add(cModel);
        cModel = new cardViewModel("card 5", "This is the 5th card");
        cardList.add(cModel);

        cAdaptor.notifyDataSetChanged();
    }
}
