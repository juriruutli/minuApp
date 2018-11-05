package com.example.jurir.minuapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import static android.support.constraint.Constraints.TAG;
import static java.util.ResourceBundle.getBundle;

public class ViewClick extends Fragment {

    public static final String BOOKS_NAME = "BOOKS_NAME";
    public static final String BOOKS_AUTHOR = "BOOKS_AUTHOR";
    public static final String BOOKS_DESCRIPTION = "BOOKS_DESCRIPTION" ;
    public static final String BOOKS_IMAGE = "BOOKS_IMAGE";


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.click_view, container, false);
        //siia vaja argumendid, ja text mis sisse tuleb


        TextView view1 = view.findViewById(R.id.clickview);
        Bundle argsTitle = getArguments();
        assert argsTitle != null;
        String books = argsTitle.getString(BOOKS_NAME);
        view1.setText(books);

        ImageView imageView = view.findViewById(R.id.image);
        Bundle argsImage = getArguments();
        String image = argsImage.getString(BOOKS_IMAGE);
        Log.d(TAG, "onCreateView: !!!!!!!!!!!!!pildiurltuleb" + image);
        Glide.with(getContext())
                .load(image)
                .into(imageView);



        TextView view2 = view.findViewById(R.id.author);
        Bundle argsAuthor = getArguments();
        String author = argsAuthor.getString(BOOKS_AUTHOR);
        view2.setText(String.format(getString(R.string.author_format), author));

        TextView view3 = view.findViewById(R.id.description);
        Bundle argsDescription = getArguments();
        String description = argsDescription.getString(BOOKS_DESCRIPTION);
        view3.setText(description);


        return view;
    }
}
