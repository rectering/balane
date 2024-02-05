package com.rectering.balane.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.View;
import android.view.Window;

import com.rectering.balane.Adapter.PopularAdapter;
import com.rectering.balane.Domain.PopularDomain;
import com.rectering.balane.R;
import com.rectering.balane.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        statusBarColor();
        initRecyclerView();
        bottomNavigation();
    }

    private void bottomNavigation() {
        binding.cartBtn.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, CartActivity.class)));
    }

    private void statusBarColor() {
        Window window = MainActivity.this.getWindow();
        window.setStatusBarColor(ContextCompat.getColor(MainActivity.this,R.color.purple_dark));
    }

    private void initRecyclerView() {
        ArrayList<PopularDomain> items = new ArrayList<>();
        items.add(new PopularDomain("T-shirt black","item_1",15,4,65,"Immerse yourself in timeless elegance with this plain black T-shirt. Its minimalist and modern design makes it an essential staple for any closet. Crafted from high quality fabric, this shirt offers effortless comfort and style. Its perfect fit and soft touch make it ideal for any occasion, from a casual look to a more sophisticated one. Whether worn alone or as a base for your outfits, this plain black t-shirt is the versatile piece you need to stand out with simplicity and elegance."));
        items.add(new PopularDomain("Smart Watch","item_2",9,4.5,330,"Discover the perfect fusion of advanced technology and sophisticated style with this smartwatch. Designed to fit your dynamic lifestyle, this smart device offers you a unique experience. With its high-resolution touch screen, you can easily access all your apps and notifications with a simple touch. Plus, its sleek, modern design makes it the perfect companion for any occasion, whether it's an intense workout or a business meeting."));
        items.add(new PopularDomain("Phone","item_3",12,4.9,800,"Immerse yourself in technological innovation with this cutting-edge cell phone. Designed to deliver an unparalleled user experience, this device takes you to new heights of connectivity and performance. With its high-resolution display and vibrant colors, every image comes to life with breathtaking clarity. Equipped with a powerful processor and ample storage, this phone ensures smooth and fast performance in all your daily tasks, from surfing the web to playing your favorite games."));

        binding.PopularView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        binding.PopularView.setAdapter(new PopularAdapter(items));
    }
}