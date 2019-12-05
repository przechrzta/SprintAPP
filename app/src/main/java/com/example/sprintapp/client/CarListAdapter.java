package com.example.sprintapp.client;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sprintapp.R;
import com.example.sprintapp.shared.EventListAdapter;

import org.w3c.dom.Text;

import java.util.List;

public class CarListAdapter extends RecyclerView.Adapter<CarListAdapter.CarViewHolder> {

    private List<car> cars;

    public CarListAdapter(List<car> cars){
        this.cars = cars;
    }

    @NonNull
    @Override
    public CarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.car_list_item, parent, false);

        return new CarViewHolder(v, parent.getContext());
    }

    public void onBindViewHolder(final CarViewHolder holder, int position){
        final car car = cars.get(position);

        holder.carBrandTextView.setText(car.getCarBrand());
        holder.carModelTextView.setText(car.getCarModel());
        holder.carRegistrationNumberTextView.setText(car.getCarRegistrationNumber());
    }

    @Override
    public int getItemCount() {
        return cars.size();
    }

    static class CarViewHolder extends RecyclerView.ViewHolder{

        TextView carBrandTextView;
        TextView carModelTextView;
        TextView carRegistrationNumberTextView;

        final Context context;

        CarViewHolder(View v, final Context context) {
            super(v);
            this.context = context;
            carBrandTextView = v.findViewById(R.id.carBrand);
            carModelTextView = v.findViewById(R.id.carModel);
            carRegistrationNumberTextView = v.findViewById(R.id.carRegistrationNumber);
        }
    }


}
