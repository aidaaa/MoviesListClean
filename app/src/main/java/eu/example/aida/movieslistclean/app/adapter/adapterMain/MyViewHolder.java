package eu.example.aida.movieslistclean.app.adapter.adapterMain;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import eu.example.aida.movieslistclean.R;

/**
 * Created by Aida on 1/17/2019.
 */

public class MyViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.id)
    TextView id;

    @BindView(R.id.title)
    TextView title;

    @BindView(R.id.year)
    TextView year;

    @BindView(R.id.imdb_rating)
    TextView imdb_rating;

    @BindView(R.id.img)
    ImageView img;

    public MyViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }

}
