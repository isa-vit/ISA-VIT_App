package com.example.isa_vitapp;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class NotMemberPage extends AppCompatActivity{

    Button github_isa, flagship_button, events_button, technitudes_button;
    ImageView member_image, photos;

    Button back_page, front_page;

    LinearLayout main_page, main_layout;

//    private SimpleGestureFilter detector;
//
//    public OnSwipeTouchListener onSwipeTouchListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_not_member_page);

        github_isa = findViewById(R.id.github_link);
        member_image = findViewById(R.id.member_photo);
        photos = findViewById(R.id.photos);

        flagship_button = findViewById(R.id.flagship_event_button);
        events_button = findViewById(R.id.events_button);
        technitudes_button = findViewById(R.id.technitudes_button);

        back_page = findViewById(R.id.back_button);
        front_page = findViewById(R.id.front_button);

        main_page = findViewById(R.id.board_page_layout);
        main_layout = findViewById(R.id.member_prof_layout);

//        detector = new SimpleGestureFilter(NotMemberPage.this, this);
//        onSwipeTouchListener = new OnSwipeTouchListener(getApplicationContext(), main_layout);

        back_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int[] colors = {Color.parseColor("#008000"),Color.parseColor("#ADFF2F")};

                //create a new gradient color
                GradientDrawable gd = new GradientDrawable(
                        GradientDrawable.Orientation.LEFT_RIGHT, colors);

                gd.setCornerRadius(0f);
                //apply the button background to newly created drawable gradient
                back_page.setBackground(gd);

                back_page.setBackgroundResource(R.drawable.gradient_view_blue_left);
                main_page.setBackgroundResource(R.drawable.gradient_view2);
                front_page.setBackgroundResource(R.drawable.gradient_view2);
                Toast.makeText(NotMemberPage.this, "Back!", Toast.LENGTH_SHORT).show();
            }
        });

        front_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                main_page.setBackgroundResource(R.drawable.gradient_view1);
                Toast.makeText(NotMemberPage.this, "Front!", Toast.LENGTH_SHORT).show();
            }
        });

        member_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Home.class));
            }
        });

        github_isa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://github.com/isa-vit"); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        flagship_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MyActivity.class));
            }
        });

        events_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MyActivity.class));
            }
        });

        technitudes_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MyActivity.class));
            }
        });
    }

}