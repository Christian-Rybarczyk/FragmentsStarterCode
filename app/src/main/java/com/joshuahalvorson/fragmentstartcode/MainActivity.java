package com.joshuahalvorson.fragmentstartcode;

import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements
        ItemListFragment.OnFragmentInteractionListener{

    public static final String SPACE_IMAGE_KEY = "space_image";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction
                .replace(R.id.fragment_container, new ItemListFragment())
                .commit();
    }


    @Override
    public void onFragmentInteraction(SpaceImageListItem item) {
        SpaceImageDetailFragment spaceImageDetailFragment = new SpaceImageDetailFragment();

        Bundle bundle = new Bundle();
        bundle.putSerializable(SPACE_IMAGE_KEY, item);
        spaceImageDetailFragment.setArguments(bundle);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, spaceImageDetailFragment)
                .addToBackStack(null)
                .commit();
    }
}
