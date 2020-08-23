package com.demo.imagesearchapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.demo.imagesearchapp.R;
import com.demo.imagesearchapp.databasehelper.DBHelper;

public class SecondActivity extends AppCompatActivity {
    final DBHelper dbHelper = new DBHelper(this);
    TextView comment_textview;
    TextView image_details_title;
    EditText comment_edittext;
    ImageView detail_image;
    Button submit_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        detail_image = findViewById(R.id.image_detail);
        comment_edittext = findViewById(R.id.comment_edittext);
        comment_textview = findViewById(R.id.comment_textview);
        image_details_title = findViewById(R.id.image_detail_title);
        submit_button = findViewById(R.id.submit_button);

        if (getSupportActionBar() != null)
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        String image_url = intent.getStringExtra("image_url");
        final String image_id = intent.getStringExtra("image_id");
        String image_title = intent.getStringExtra("image_title");

        image_details_title.setText(String.format("%s%s", getString(R.string.title_string), image_title));
        Glide.with(getApplicationContext())
                .load(image_url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(detail_image);

        showComment(image_id);
        submit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbHelper.updateComment(comment_edittext.getText().toString(), image_id);
                showComment(image_id);
            }
        });

    }

    public void showComment(String image_id) {
        Cursor rs = dbHelper.getData(image_id);
        rs.moveToFirst();
        String comment = rs.getString(rs.getColumnIndex(DBHelper.IMAGES_COLUMN_COMMENT));
        if(comment != null) {
            comment_textview.setText(String.format("%s%s", getString(R.string.comment_string), comment));
        } else {
            comment_textview.setText(getString(R.string.comment_string));
        }

        if (!rs.isClosed())  {
            rs.close();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                onBackPressed();
        }
        return (super.onOptionsItemSelected(menuItem));
    }
}