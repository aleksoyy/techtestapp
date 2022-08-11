package com.soydomain.stava.wingapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.soydomain.stava.wingapp.API.APIRequest;
import com.soydomain.stava.wingapp.API.RetrofitHelper;
import com.soydomain.stava.wingapp.Adapter.AdapterData;
import com.soydomain.stava.wingapp.Model.ProductModel;
import com.soydomain.stava.wingapp.Model.ResponseModel;
import com.soydomain.stava.wingapp.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductListActivity extends AppCompatActivity {

    private RecyclerView rvProduct;
    private RecyclerView.Adapter adapterProduct;
    private RecyclerView.LayoutManager lmProduct;

    private List<ProductModel> listProduct = new ArrayList<>();
    Button btn_checkout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        rvProduct = findViewById(R.id.rvProdList);
        btn_checkout = findViewById(R.id.btn_checkout);

        lmProduct = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvProduct.setLayoutManager(lmProduct);
        retrieveData();

    }

    private void retrieveData() {
        APIRequest requestData = RetrofitHelper.conRetrofit().create(APIRequest.class);
        Call<ResponseModel> fetchData = requestData.getproductfunct();
        fetchData.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                int code = response.body().getCode();
                String message = response.body().getMessage();

                Toast.makeText(ProductListActivity.this, "Code :" +code+" | Msg : "+message, Toast.LENGTH_SHORT).show();

                listProduct = response.body().getData();
                adapterProduct = new AdapterData(ProductListActivity.this, listProduct);
                rvProduct.setAdapter(adapterProduct);
                adapterProduct.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Failed to connect with server."+t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}