package com.example.jurir.minuapp;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private List<BookItem> bookItems;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView mTextView;

        MyViewHolder(View view) {
            super(view);
            mTextView = view.findViewById(R.id.text);

            itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {

                    BookItem bookItem = bookItems.get(getLayoutPosition());
                    if (bookItem.isSelected()) {
                        return;
                    }

                    Context context = view.getContext(); //view context context.
                    MainActivity activity = (MainActivity) context; //contexti cästisime activitiks

                    for (int i = 0; i < bookItems.size(); i++) {
                        BookItem bookItem1 = bookItems.get(i);
                        if (bookItem1.isSelected()) {
                            bookItem1.setSelected(false);
                            bookItems.set(i, bookItem1);
                            notifyItemChanged(i);
                        }
                    }

                    activity.displayDetailsFragment(getViewClick(getLayoutPosition()));

                    String title = bookItem.getTitle();
                  //  String author = bookItem.getAuthor();

                    bookItem.setSelected(true);
                    notifyItemChanged(getLayoutPosition());

                    Toast.makeText(view.getContext(), title, Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    MyAdapter(List<BookItem> myDataset) {
        bookItems = myDataset;
    }

    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem,
                parent, false);

        MyViewHolder vh = new MyViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        BookItem bookItem = bookItems.get(position);
        String title = bookItem.getTitle();
        holder.mTextView.setText(title);


        Context context = holder.mTextView.getContext();

        if (bookItems.get(position).isSelected()) {
            holder.mTextView.setTextColor(ContextCompat.getColor(context, R.color.red));
        } else {
            holder.mTextView.setTextColor(ContextCompat.getColor(context, R.color.royal_blue));
        }

    }

    @Override
    public int getItemCount() {
        return bookItems.size();
    }

    private Fragment getViewClick(int position) {
        Bundle arguments = new Bundle();

        BookItem bookItem = bookItems.get(position);
        String title = bookItem.getTitle();
        String image = bookItem.getImage();
        String author = bookItem.getAuthor();
        String description = bookItem.getDescription();

        arguments.putString(ViewClick.BOOKS_NAME, title);
        arguments.putString(ViewClick.BOOKS_IMAGE, image);
        arguments.putString(ViewClick.BOOKS_AUTHOR, author);
        arguments.putString(ViewClick.BOOKS_DESCRIPTION, description);


        Fragment viewClick = new ViewClick();
        viewClick.setArguments(arguments);

        return viewClick;












    }
}
