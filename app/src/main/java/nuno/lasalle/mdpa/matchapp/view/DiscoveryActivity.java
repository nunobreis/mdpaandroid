package nuno.lasalle.mdpa.matchapp.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.BottomBarBadge;
import com.roughike.bottombar.BottomBarTab;
import com.roughike.bottombar.OnMenuTabClickListener;

import nuno.lasalle.mdpa.matchapp.R;

/**
 * Created by nunoreis on 05/02/2018.
 */

public class DiscoveryActivity extends AppCompatActivity {

    BottomBar mBottomBar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discovery);

        mBottomBar = BottomBar.attach(this, savedInstanceState);
        mBottomBar.setItemsFromMenu(R.menu.bottom_navigation_main, new OnMenuTabClickListener() {
            @Override
            public void onMenuTabSelected(int menuItemId) {
                if (menuItemId == R.id.cards) {

                    GameFragment f = new GameFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame,f).commit();

                } else if (menuItemId == R.id.settings) {

                    SettingsFragment f = new SettingsFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame,f).commit();

                } else if (menuItemId == R.id.chat) {

                    ChatFragment f = new ChatFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame,f).commit();

                }  else if (menuItemId == R.id.profile) {

                    ProfileFragment f = new ProfileFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame,f).commit();
                }
            }

            @Override
            public void onMenuTabReSelected(int menuItemId) {

            }
        });
        mBottomBar.mapColorForTab(0, R.color.white);
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.bottom_navigation_main, menu);
//        return super.onCreateOptionsMenu(menu);
//    }
//
//    @Override
//    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//        switch (item.getItemId())
//        {
//            case R.id.cards:
//                Toast.makeText(DiscoveryActivity.this, "Cards clicked", Toast.LENGTH_SHORT).show();
//                break;
//            case R.id.settings:
//                Toast.makeText(DiscoveryActivity.this, "Settings clicked", Toast.LENGTH_SHORT).show();
//                break;
//            case R.id.chat:
//                Toast.makeText(DiscoveryActivity.this, "Chat clicked", Toast.LENGTH_SHORT).show();
//                break;
//            case R.id.profile:
//                Toast.makeText(DiscoveryActivity.this, "Profile clicked", Toast.LENGTH_SHORT).show();
//                break;
//        }
//        return true;
//    }
}

//cards , settings , chat , profile