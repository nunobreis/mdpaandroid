package nuno.lasalle.mdpa.matchapp.view;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;


import nuno.lasalle.mdpa.matchapp.R;
import nuno.lasalle.mdpa.matchapp.view.adapter.CardStackAdapter;
import nuno.lasalle.mdpa.matchapp.view.model.CardStackViewModel;

/**
 * Created by nunoreis on 05/02/2018.
 */

public class DiscoveryActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discovery);

        CardStackViewModel cardStackViewModel = ViewModelProviders.of(this).get(CardStackViewModel.class);
        cardStackViewModel.setResources(getResources());

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        initFragmentManager();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.bottom_navigation_main, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;
        switch(item.getItemId())
        {
            case R.id.cards:
                fragment = CardFragment.newInstance();
                break;

            case R.id.settings:
                fragment = SettingsFragment.newInstance();
                break;

            case R.id.chat:
                fragment = ChatFragment.newInstance();
                break;

            case R.id.profile:
                fragment = ProfileFragment.newInstance();
                break;
        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.fragment_container, fragment).commit();

        item.setChecked(true);
        setTitle(item.getTitle());

        return true;
    }

    private void initFragmentManager() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        CardFragment fragment = CardFragment.newInstance();
        fragmentManager.beginTransaction().replace(R.id.fragment_container, fragment).commit();
    }
}