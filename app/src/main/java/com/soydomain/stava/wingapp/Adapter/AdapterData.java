package com.soydomain.stava.wingapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.soydomain.stava.wingapp.Model.ProductModel;
import com.soydomain.stava.wingapp.R;

import java.util.List;

public class AdapterData extends RecyclerView.Adapter<AdapterData.HolderData> {

    private Context context;
    private List<ProductModel> productList;

    public AdapterData(Context context, List<ProductModel> productList) {
        this.context = context;
        this.productList = productList;
    }

    @NonNull
    @Override
    public HolderData onCreateViewHolder(ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_product_list, parent, false);
        HolderData holderData = new HolderData(layout);
        return holderData;
    }

    @Override
    public void onBindViewHolder(HolderData holder, int position) {
        ProductModel pm = productList.get(position);

        holder.prod_name.setText(pm.getPname());
        if (pm.getDisc() != 0) {
            holder.csDiscount.setVisibility(View.VISIBLE);
            int tempPrice = (pm.getPrice() * pm.getDisc()) / 100;
            holder.discountPrice.setText(
                    String.valueOf(pm.getPrice()));
            holder.discountPrice.setVisibility(View.VISIBLE);
            holder.divideLine.setVisibility(View.VISIBLE);
            holder.price.setText(
                    String.valueOf(pm.getPrice() - tempPrice));
        } else {
            holder.price.setText(
                    String.valueOf(pm.getPrice()));
            holder.csDiscount.setVisibility(View.INVISIBLE);
            holder.discountPrice.setVisibility(View.INVISIBLE);
            holder.divideLine.setVisibility(View.INVISIBLE);
        }

    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public static class HolderData extends RecyclerView.ViewHolder {
        private final TextView prod_code;
        private final TextView prod_name;
        private final TextView csDiscount;
        private final TextView discountPrice;
        private final TextView divideLine;
        private final TextView price;

        public HolderData(View itemView) {
            super(itemView);

            prod_code = itemView.findViewById(R.id.prod_code);
            prod_name = itemView.findViewById(R.id.product_name);
            csDiscount = itemView.findViewById(R.id.csDiscount);
            discountPrice = itemView.findViewById(R.id.discount_price);
            divideLine = itemView.findViewById(R.id.divideLine);
            price = itemView.findViewById(R.id.price);

            Button btn_buy = (Button) itemView.findViewById(R.id.btn_buy);
        }
    }
}

