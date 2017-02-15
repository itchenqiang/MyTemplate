package com.a1zu.xiangyucustomer.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.a1zu.xiangyucustomer.R;

/**
 * Description:产品列表adapter
 * Creator: Chenqiang
 * Date: 2017/2/15
 */

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {

    private Context mContext;

    @Override
    public ProductAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View view = LayoutInflater.from(mContext)
                .inflate(R.layout.item_product_adapter, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductAdapter.ViewHolder holder, int position) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false);
        holder.mRlEvent.setLayoutManager(layoutManager);
    }

    @Override
    public int getItemCount() {
        return 2;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        RecyclerView mRlEvent;
        TextView mTvItemTitle;

        ViewHolder(View itemView) {
            super(itemView);
            mTvItemTitle = (TextView) itemView.findViewById(R.id.tv_item_title);
            mRlEvent = (RecyclerView) itemView.findViewById(R.id.rl_event);
        }
    }
}
