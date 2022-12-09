package pl.appcake.dotaskman;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class StringRecyclerViewAdapter extends RecyclerView.Adapter<StringRecyclerViewAdapter.ViewHolder> {

    String[] array;

    // klasyczny viewholder który trzyma referencje do widoków
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private FrameLayout frameLayout;

        public ViewHolder(@NonNull FrameLayout itemView) {
            super(itemView);
            frameLayout = itemView;
        }
    }

    // Konstruktor przyjmujacy dane, które będę potem pakkował do widoków
    public StringRecyclerViewAdapter(String[] array) {
        this.array = array;
    }

    // Tutaj Podpinamy / pompujemy wcześniej przygotowanym widokiem. To jakny ten pojedyńczy item
    // z których się składa się recycler view
    @NonNull
    @Override
    public StringRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        FrameLayout fl = (FrameLayout) LayoutInflater.from(parent.getContext()).inflate(
                R.layout.drawer_item, parent, false);

        return new ViewHolder(fl);
    }

    // Tutaj podpinamy pod moje widoki dane z araya
    @Override
    public void onBindViewHolder(@NonNull StringRecyclerViewAdapter.ViewHolder holder, int position) {
        FrameLayout fragmentLayout = holder.frameLayout;
        TextView textView = (TextView) fragmentLayout.findViewById(R.id.itemTextView);
        textView.setText(array[position]);
    }

    @Override
    public int getItemCount() {
        return array.length;
    }
}
