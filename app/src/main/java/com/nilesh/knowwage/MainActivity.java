package com.nilesh.knowwage;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private Fragment homeFragment;
    private Fragment contestFragment;
    private Fragment resultsFragment;
    private Fragment rewardsFragment;
    private Fragment activeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.btm_nav);

        // Initialize fragments
        homeFragment = new HomeFragment();
        contestFragment = new ContestFragment();
        resultsFragment = new ResultFragment();
        rewardsFragment = new RewardFragment();

        // Set default fragment
        activeFragment = homeFragment;
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_holder, activeFragment).commit();

        // Set the listener for item selection
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                        int itemId = menuItem.getItemId();
                        if (itemId == R.id.btm_home) {
                            activeFragment = homeFragment;
                        } else if (itemId == R.id.btm_contest) {
                            activeFragment = contestFragment;
                        } else if (itemId == R.id.btm_result) {
                            activeFragment = resultsFragment;
                        } else if (itemId == R.id.btm_reward) {
                            activeFragment = rewardsFragment;
                        }
                        // Replace the fragment
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_holder, activeFragment).commit();
                        return true;
                    }
                });
    }
}
