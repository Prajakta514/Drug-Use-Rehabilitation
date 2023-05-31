package com.example.sober;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.VideoView;

import com.example.sober.databinding.ActivityMyprofileBinding;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;


public class NavigationActivity extends AppCompatActivity{
    Fragment temp;
    Button test;
    View profile,rehab,progress,about_us,login,rate_us,resource;

    VideoView videoView;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        videoView=findViewById(R.id.videoview);
        Uri uri =Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.app_video2);
        videoView.setVideoURI(uri);
        videoView.start();

        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener(){
            @Override
            public void onPrepared(MediaPlayer mp){
                mp.setLooping(true);
            }

        });
        test = findViewById(R.id.test);
        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent( NavigationActivity.this,Quiz.class));

            }
        });


        MaterialToolbar toolbar = findViewById(R.id.topAppbar);
        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.navigation_view);

        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle =new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);

        drawerLayout.addDrawerListener(toggle);


        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                drawerLayout.closeDrawer(GravityCompat.START);
                profile = findViewById(R.id.nav_profile);
                rehab = findViewById(R.id.nav_rehab);
                progress = findViewById(R.id.nav_progress);
                about_us = findViewById(R.id.nav_about);
                rate_us=findViewById(R.id.nav_rate);
                resource=findViewById(R.id.nav_resource);

                switch (id) {

                    case R.id.nav_profile: {
                        startActivity(new Intent(NavigationActivity.this, profile2.class));
                        Toast.makeText(NavigationActivity.this, "Profile is selected", Toast.LENGTH_SHORT).show();
//                        replaceFragment(new HomeFragment());
                        break;
                    }
                    case R.id.nav_rehab: {
                       startActivity(new Intent(NavigationActivity.this, Rehab2.class));
                        break;
                    }
                    case R.id.nav_progress: {
                        startActivity(new Intent(NavigationActivity.this, progress2.class));
                        break;
                    }
                    case R.id.nav_about: {
                        startActivity(new Intent(NavigationActivity.this,Aboutus2.class));
                        break;
                    }

                    case R.id.nav_rate: {
                        startActivity(new Intent(NavigationActivity.this,rateus2.class));
                          break;
                    }
                    case R.id.nav_login: {
                        Toast.makeText(NavigationActivity.this, "Log-out is selected", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(NavigationActivity.this, LoginActivity.class));
                        break;
                    }
                        case R.id.contact_us: {
                            Toast.makeText(NavigationActivity.this, "Contact-Us is selected", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(NavigationActivity.this, contact_us2.class));
                            break;
                    }
                    case R.id.nav_resource: {
                        Toast.makeText(NavigationActivity.this, "Contact-Us is selected", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(NavigationActivity.this, resource.class));
                        break;
                    }
                    default:
                        return true;
//

                }
                drawerLayout.closeDrawer(GravityCompat.START);

                return true;
            }
        });
    }

private void replaceFragment(Fragment fragment)
{
    FragmentManager fragmentManager =getSupportFragmentManager();
    FragmentTransaction fragmentTransaction= fragmentManager.beginTransaction();
    fragmentTransaction.replace(R.id.FrameLayout,fragment);
    fragmentTransaction.commit();
}
   @Override
    protected void onPostResume(){
        videoView.resume();
        super.onPostResume();
}
    @Override
    protected void onRestart(){
        videoView.start();
        super.onRestart();
    }

    @Override
    protected void onPause(){
        videoView.suspend();
        super.onPause();
    }
    @Override
    protected void onDestroy(){
        videoView.stopPlayback();
        super.onDestroy();
    }
}


