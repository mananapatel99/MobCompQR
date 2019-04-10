package com.rpatil.cybersociety.mobcompqr;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements fragmentOperation.OnFragmentInteractionListener, fragmentHistory.OnFragmentInteractionListener{

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            int id = item.getItemId();
            Fragment fragment = null;
            switch (item.getItemId()) {
                case R.id.navigation_history:
                    fragment = fragmentHistory.newInstance();
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, fragment).commit();
                break;

                case R.id.navigation_operation:
                    fragment = fragmentOperation.newInstance();
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, fragment).commit();
                break;

            }
            return false;
        }

        private void commit() {

        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
