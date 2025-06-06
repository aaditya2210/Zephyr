package com.example.voltify;


import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.github.clans.fab.FloatingActionButton;

public class DetailActivity extends AppCompatActivity {

    TextView detailDesc, detailTitle, detailLang,detailLng,detailLtd;
    ImageView detailImage;
    FloatingActionButton deleteButton, editButton;
    String key = "";
    String imageUrl = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        detailDesc = findViewById(R.id.detailDesc);
        detailImage = findViewById(R.id.detailImage);
        detailTitle = findViewById(R.id.detailTitle);
//        deleteButton = findViewById(R.id.deleteButton);
//        editButton = findViewById(R.id.editButton);
        detailLang = findViewById(R.id.detailLang);

        detailLtd = findViewById(R.id.detailLtd);
        detailLng = findViewById(R.id.detailLng);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            detailDesc.setText(bundle.getString("Description"));
            detailTitle.setText(bundle.getString("Title"));
            detailLang.setText(bundle.getString("Language"));
            detailLtd.setText(bundle.getString("Latitude"));
            detailLng.setText(bundle.getString("Longitude"));
//            key = bundle.getString("Key");
//            imageUrl = bundle.getString("Image");
            Glide.with(this).load(bundle.getString("Image")).into(detailImage);
        }
////        deleteButton.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View view) {
////                final DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Android Tutorials");
////                FirebaseStorage storage = FirebaseStorage.getInstance();
////
////                StorageReference storageReference = storage.getReferenceFromUrl(imageUrl);
////                storageReference.delete().addOnSuccessListener(new OnSuccessListener<Void>() {
////                    @Override
////                    public void onSuccess(Void unused) {
////                        reference.child(key).removeValue();
////                        Toast.makeText(DetailActivity.this, "Deleted", Toast.LENGTH_SHORT).show();
////                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
////                        finish();
////                    }
////                });
////            }
//        });
//        editButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(DetailActivity.this, UpdateActivity.class)
//                        .putExtra("Title", detailTitle.getText().toString())
//                        .putExtra("Description", detailDesc.getText().toString())
//                        .putExtra("Language", detailLang.getText().toString())
//                        .putExtra("Image", imageUrl)
//                        .putExtra("Key", key);
//                startActivity(intent);
//            }
//        });
    }
}