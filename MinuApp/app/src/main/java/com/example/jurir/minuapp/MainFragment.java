package com.example.jurir.minuapp;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static android.content.ContentValues.TAG;


public class MainFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView mRecyclerView = view.findViewById(R.id.recycler_view);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);

        RecyclerView.Adapter mAdapter = new MyAdapter(getData());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

    }

//    public List<String> getData() {
////        String booksArr[] = getResources().getStringArray(R.array.books);
////        return Arrays.asList(booksArr);
////    }

    public List<BookItem> getData(){
        List<BookItem> bookItems = new ArrayList<>();
        String booksArr[] = getResources().getStringArray(R.array.books);
        String imageArr[] = getResources().getStringArray(R.array.pildid);
        String authorArr[] = getResources().getStringArray(R.array.author);
        String descriptionArr[] = getResources().getStringArray(R.array.description);




        for (int i=0; i<booksArr.length; i++) {
            String title = booksArr[i];
            String image =imageArr[i];
            String author = authorArr[i];
            String description = descriptionArr[i];
            BookItem bookItem = new BookItem(title, image, author, description);
            bookItems.add(bookItem);
        }

             return bookItems;
    }



}
