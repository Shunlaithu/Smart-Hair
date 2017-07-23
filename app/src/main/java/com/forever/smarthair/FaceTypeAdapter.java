package com.forever.smarthair;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by User on 7/16/2017.
 */

public class FaceTypeAdapter extends RecyclerView.Adapter<FaceTypeAdapter.FaceTypeViewHolder> {


    int[] image;
    String[] text;
    OnClickHandler onClickHandler;
    @Override
    public FaceTypeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.face_type_item_list, parent, false);
        return new FaceTypeViewHolder(view);
    }
    private List<Facetype> facetypes = null;
    public FaceTypeAdapter(List<Facetype> facetypes){
        this.facetypes=facetypes;
    }

    public FaceTypeAdapter(int[] image,OnClickHandler onClickHandler) {
        this.image=image;
        this.onClickHandler=onClickHandler;
    }

    public interface OnClickHandler {
        void  onClick(int id);
    }
    @Override
    public void onBindViewHolder(FaceTypeViewHolder holder, int position) {
        Facetype facetype = facetypes.get(position);
        holder.ivImage.setImageResource(facetype.getImageView());
        holder.tvText.setText(facetype.getTextView());
    }

    @Override
    public int getItemCount() {
        return facetypes.size();
    }

    public class FaceTypeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView ivImage;
        private TextView tvText;

        public FaceTypeViewHolder(View itemView) {
            super(itemView);

            ivImage = (ImageView) itemView.findViewById(R.id.iv_image);
            tvText = (TextView) itemView.findViewById(R.id.tv_text);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            onClickHandler.onClick(getAdapterPosition());
        }
    }


}
