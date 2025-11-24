package com.example.aplicacion_moviles3c;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

public class CatalogAdapter extends ListAdapter<CatalogItem, CatalogAdapter.ViewHolder> {

    public CatalogAdapter() {
        super(DIFF_CALLBACK);
    }

    private static final DiffUtil.ItemCallback<CatalogItem> DIFF_CALLBACK = new DiffUtil.ItemCallback<CatalogItem>() {
        @Override
        public boolean areItemsTheSame(@NonNull CatalogItem oldItem, @NonNull CatalogItem newItem) {
            return oldItem.getName().equals(newItem.getName());
        }

        @Override
        public boolean areContentsTheSame(@NonNull CatalogItem oldItem, @NonNull CatalogItem newItem) {
            return oldItem.getDescription().equals(newItem.getDescription())
                    && oldItem.getPrice().equals(newItem.getPrice())
                    && oldItem.getHighlight().equals(newItem.getHighlight())
                    && oldItem.getCategoryKey().equals(newItem.getCategoryKey());
        }
    };

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(getItem(position));
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView title;
        private final TextView subtitle;
        private final TextView highlight;
        private final TextView price;
        private final TextView categoryChip;
        private final ImageView hero;

        ViewHolder(@NonNull ViewGroup parent) {
            super(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_catalogo, parent, false));
            title = itemView.findViewById(R.id.textViewItemTitle);
            subtitle = itemView.findViewById(R.id.textViewItemDescription);
            highlight = itemView.findViewById(R.id.textViewItemHighlight);
            price = itemView.findViewById(R.id.textViewItemPrice);
            categoryChip = itemView.findViewById(R.id.textViewItemCategory);
            hero = itemView.findViewById(R.id.imageViewItemHero);
        }

        void bind(CatalogItem item) {
            title.setText(item.getName());
            subtitle.setText(item.getDescription());
            highlight.setText(item.getHighlight());
            price.setText(item.getPrice());
            categoryChip.setText(item.getCategoryLabel());

            int imageResId = item.getImageResId();
            if (imageResId != 0) {
                hero.setImageResource(imageResId);
            } else {
                hero.setImageResource(R.drawable.gallery_placeholder);
            }
        }
    }
}
