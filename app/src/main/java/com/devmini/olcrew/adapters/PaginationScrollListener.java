package com.devmini.olcrew.adapters;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public abstract class PaginationScrollListener extends RecyclerView.OnScrollListener {

    private static final int THRESHOLDITEMS = 3;


    @Override
    public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);

        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        int visibleItemCount = linearLayoutManager.getChildCount();
        int totalItemCount = linearLayoutManager.getItemCount();
        int firstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();

        if (!isLoading() && !isLastPage()) {
            if (((this.THRESHOLDITEMS + visibleItemCount + firstVisibleItemPosition) >= totalItemCount)
                    && (firstVisibleItemPosition >= 0)) {
                loadMoreItems();
            }
        }
    }


    protected abstract void loadMoreItems();

    protected abstract boolean isLoading();

    protected abstract boolean isLastPage();
}
