package com.example.aplicacion_moviles3c;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

public class CatalogAdapter extends ListAdapter<CatalogItem, CatalogAdapter.ViewHolder> {

    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(CatalogItem item);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

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
                    && oldItem.getCategoryKey().equals(newItem.getCategoryKey())
                    && oldItem.getImageResId() == newItem.getImageResId();
        }
    };

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_catalogo, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(getItem(position));
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView title;
        private final TextView subtitle;
        private final TextView highlight;
        private final TextView price;
        private final TextView categoryChip;
        private final ImageView hero;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.textViewItemTitle);
            subtitle = itemView.findViewById(R.id.textViewItemDescription);
            highlight = itemView.findViewById(R.id.textViewItemHighlight);
            price = itemView.findViewById(R.id.textViewItemPrice);
            categoryChip = itemView.findViewById(R.id.textViewItemCategory);
            hero = itemView.findViewById(R.id.imageViewItemHero);

            itemView.setOnClickListener(v -> {
                int position = getAdapterPosition();
                if (listener != null && position != RecyclerView.NO_POSITION) {
                    listener.onItemClick(getItem(position));
                }
            });
        }

        void bind(CatalogItem item) {
            title.setText(item.getName());
            subtitle.setText(item.getDescription());
            highlight.setText(item.getHighlight());
            price.setText(item.getPrice());
            categoryChip.setText(item.getCategoryLabel());

            Glide.with(hero.getContext())
                    .load(item.getImageResId())
                    .placeholder(R.drawable.gallery_placeholder)
                    .centerCrop()
                    .into(hero);
        }
    }
}
