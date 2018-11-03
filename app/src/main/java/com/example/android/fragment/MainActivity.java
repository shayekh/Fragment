package com.example.android.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    //private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                   // mTextMessage.setText(R.string.title_home);
                    openFrament1();
                    return true;
                case R.id.navigation_dashboard:
                    //mTextMessage.setText(R.string.title_dashboard);
                    openFrament2();
                    return true;
                case R.id.navigation_notifications:
                    //mTextMessage.setText(R.string.title_notifications);
                    openFrament3();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        openFrament1();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.navigation,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id=item.getItemId();
        if(id==R.id.navigation_home)
        {
            openFrament1();
        }
        else if(id==R.id.navigation_dashboard){
            openFrament2();
        }
        else if(id==R.id.navigation_notifications)
        {
            openFrament3();
        }
        return super.onOptionsItemSelected(item);
    }

    private void openFrament1() {
        FirstFragment firstFragment=new FirstFragment();
        FragmentManager fm= getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.firstframe,firstFragment);
        ft.addToBackStack("Home");
        ft.commit();

    }
    private void openFrament2() {
        //FirstFragment firstFragment=new FirstFragment();
        SecondFragment secondFragment=new SecondFragment();
        FragmentManager fm= getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.firstframe,secondFragment);
        ft.addToBackStack("Home");
        ft.commit();

    }
    private void openFrament3() {
        //FirstFragment firstFragment=new FirstFragment();
        ThirdFragment thirdFragment=new ThirdFragment();
        FragmentManager fm= getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.firstframe,thirdFragment);
        ft.addToBackStack("Home");
        ft.commit();

    }

    @Override
    public void onBackPressed() {
        int backStackCount=getSupportFragmentManager().getBackStackEntryCount();
        if(backStackCount==1) {
            finish();
        }
        else {
            super.onBackPressed();
        }
    }
}
