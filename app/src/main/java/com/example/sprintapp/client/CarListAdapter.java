package com.example.sprintapp.client;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sprintapp.R;

import java.util.List;

public class CarListAdapter extends RecyclerView.Adapter<CarListAdapter.CarViewHolder> {

    private List<Car> cars;

    public CarListAdapter(List<Car> cars) {
        this.cars = cars;
    }

    @NonNull
    @Override
    public CarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.car_list_item, parent, false);

        return new CarViewHolder(v, parent.getContext());
    }

    @Override
    public void onBindViewHolder(final CarViewHolder holder, int position){
        final Car car = cars.get(position);

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
