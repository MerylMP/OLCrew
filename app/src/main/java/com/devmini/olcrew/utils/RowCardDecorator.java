package com.devmini.olcrew.utils;

import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RowCardDecorator extends RecyclerView.ItemDecoration {

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {

        int margin8 = ScreenUtils.dpToPx(8, parent.getContext());
        int margin16 = ScreenUtils.dpToPx(16, parent.getContext());

        if (parent.getChildAdapterPosition(view) == 0) {
            outRect.top = margin16;

        } else {
            outRect.top = margin8;
        }

        outRect.left = margin8;
        outRect.right = margin8;

        if (parent.getChildAdapterPosition(view) == parent.getAdapter().getItemCount() - 1) {
            outRect.bottom = margin16;
        }
    }
}