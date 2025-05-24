//package com.example.voltify;
//
//
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.appcompat.widget.SearchView;
//import androidx.recyclerview.widget.GridLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import android.os.Bundle;
//import android.widget.Toast;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Locale;
//
//public class cards extends AppCompatActivity {
//
//    RecyclerView recyclerView;
//    List<DataClass> dataList;
//    MyAdapter adapter;
//    DataClass androidData;
//    SearchView searchView;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_cards);
//
//        recyclerView = findViewById(R.id.recyclerView);
//        searchView = findViewById(R.id.search);
//
//        searchView.clearFocus();
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                searchList(newText);
//                return true;
//            }
//        });
//
//        GridLayoutManager gridLayoutManager = new GridLayoutManager(cards.this, 1);
//        recyclerView.setLayoutManager(gridLayoutManager);
//        dataList = new ArrayList<>();
//
//        androidData = new DataClass("cybertruck", R.string.camera, "tesla", R.drawable.car1_detail);
//        dataList.add(androidData);
//
//        androidData = new DataClass("Model-y", R.string.recyclerview, "tesla", R.drawable.car5_detail);
//        dataList.add(androidData);
//
//        androidData = new DataClass("EV-6", R.string.date, "KIA", R.drawable.car2_detail);
//        dataList.add(androidData);
//
//        androidData = new DataClass("E-Tron", R.string.edit, "Audi", R.drawable.car3_detail);
//        dataList.add(androidData);
//
//        androidData = new DataClass("Model-X", R.string.rating, "tesla", R.drawable.car4_detail);
//        dataList.add(androidData);
//
//        adapter = new MyAdapter(cards.this, dataList);
//        recyclerView.setAdapter(adapter);
//    }
//
//    private void searchList(String text){
//        List<DataClass> dataSearchList = new ArrayList<>();
//        for (DataClass data : dataList){
//            if (data.getDataTitle().toLowerCase().contains(text.toLowerCase())) {
//                dataSearchList.add(data);
//            }
//        }
//        if (dataSearchList.isEmpty()){
//            Toast.makeText(this, "Not Found", Toast.LENGTH_SHORT).show();
//        } else {
//            adapter.setSearchList(dataSearchList);
//        }
//    }
//}