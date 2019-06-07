package com.example.lestudis;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView mTextMessage;
    private FragmentManager fragmentManager = getSupportFragmentManager();
//    private RecyclerView recyclerView; test
//    private RecyclerView.Adapter mAdapter;
//    private RecyclerView.LayoutManager layoutManager;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    loadFragment(new AllDiscountFragment());
                    return true;
                case R.id.available_discounts:
                    loadFragment(new AvailableDiscountFragment());
                    return true;
                case R.id.saved_discounts:
                    loadFragment(new SavedDiscountFragment());
                    return true;
                case R.id.saved_cards:
                    loadFragment(new SavedCardFragment());
                    return true;
            }
            return false;
        }

    };

    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.main_fragment, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
//        recyclerView = findViewById(R.id.my_recycler_view);
//        recyclerView.setHasFixedSize(true);
//        layoutManager = new LinearLayoutManager(this);
//        recyclerView.setLayoutManager(layoutManager);
//        mAdapter = new DiscountAdapter(myDataset);
//        recyclerView.setAdapter(mAdapter);
    }


}
