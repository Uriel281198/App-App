package walpaper.appchan.com.appchan.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Callback;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import walpaper.appchan.com.appchan.Activities.ListImages;
import walpaper.appchan.com.appchan.Common.Common;
import walpaper.appchan.com.appchan.Interface.ItemClickListener;
import walpaper.appchan.com.appchan.Model.CategoryItem;
import walpaper.appchan.com.appchan.R;
import walpaper.appchan.com.appchan.ViewHolder.CategoryViewHolder;

public class CategoryFragment extends Fragment {

    private static CategoryFragment INSTANCE =null;

    //FIre
    FirebaseDatabase database;
    DatabaseReference categoryBackground;

    //Fire adapater
    FirebaseRecyclerOptions<CategoryItem> options;
    FirebaseRecyclerAdapter<CategoryItem,CategoryViewHolder> adapter;


    RecyclerView recyclerView;

    public CategoryFragment() {
        // Required empty public constructor

        database = FirebaseDatabase.getInstance();
        categoryBackground= database.getReference(Common.STR_CATEGORY_BACKGROUND);

        options = new FirebaseRecyclerOptions.Builder<CategoryItem>()
                .setQuery(categoryBackground,CategoryItem.class)
                .build();
        adapter = new FirebaseRecyclerAdapter<CategoryItem, CategoryViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull final CategoryViewHolder holder, int position, @NonNull final CategoryItem model) {
                Picasso.with( getActivity())
                        .load(model.getImageLink())
                        .networkPolicy(NetworkPolicy.OFFLINE)
                        .networkPolicy(NetworkPolicy.OFFLINE)
                        .into(holder.background_image, new Callback() {
                            @Override
                            public void onSuccess() {

                            }

                            @Override
                            public void onError() {
                                Picasso.with( getActivity())
                                        .load(model.getImageLink())
                                        .error(R.drawable.ic_menu_slideshow)
                                        .into(holder.background_image, new Callback() {
                                            @Override
                                            public void onSuccess() {

                                            }

                                            @Override
                                            public void onError() {
                                                Log.e("error","Adasdasdas");
                                            }
                                        });
                            }
                        });

                holder.category_name.setText(model.getName());
               holder.setItemClickListener(new ItemClickListener() {
                   @Override
                   public void onClick(View view, int position) {
                        Common.CATEGORY_ID_SELECTED= adapter.getRef(position).getKey();
                        Common.CATEGORY_SELECTED = model.getName();
                        Intent intent = new Intent(getActivity(),ListImages.class);
                        startActivity(intent);
                   }
               });
            }

            @NonNull
            @Override
            public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View itemView = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.layout_category_item ,parent,false);
                return new CategoryViewHolder(itemView);
            }
        };
    }

    public static CategoryFragment getInstance(){
        if (INSTANCE ==null)
            INSTANCE = new CategoryFragment();
        return INSTANCE;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view =inflater.inflate(R.layout.fragment_category, container, false);
       recyclerView=(RecyclerView)view.findViewById(R.id.recycler_category);
       recyclerView.setHasFixedSize(true);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),2);
        recyclerView.setLayoutManager(gridLayoutManager);

        setCategory();
        return view;
    }



    private void setCategory() {
        adapter.startListening();
        recyclerView.setAdapter(adapter);

    }
    @Override
    public void onStart() {
        super.onStart();
        if (adapter!=null)
            adapter.startListening();
    }

    @Override
    public void onStop() {
        if (adapter!=null)
            adapter.stopListening();
        super.onStop();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (adapter!=null)
            adapter.startListening();
    }
}



