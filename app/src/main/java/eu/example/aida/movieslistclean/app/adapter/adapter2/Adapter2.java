package eu.example.aida.movieslistclean.app.adapter.adapter2;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import eu.example.aida.movieslistclean.R;
import eu.example.aida.movieslistclean.domain.model.Movie;

/**
 * Created by Aida on 1/17/2019.
 */

public class Adapter2 extends RecyclerView.Adapter<Adapter2.ViewHolder2> {

    List<Movie> domain=new ArrayList<>();

    public Adapter2(Context context) {
        this.context = context;
    }

    Context context;

    public void setDomain(List<Movie> domains) {
        this.domain = domains;
        System.out.println(domain.size()+"majid12");
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder2 onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter2,parent,false);
        return new ViewHolder2(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder2 holder, int position) {
        holder.id.setText(Integer.toString(domain.get(position).getId()));
        holder.title.setText(domain.get(position).getTitle());
        holder.year.setText(domain.get(position).getTitle());
        holder.imdb_rating.setText(domain.get(position).getImdb_rating());

        final String img_url=domain.get(position).getPoster();
        Picasso picasso=new Picasso.Builder(context).build();
        picasso.load(img_url).into(holder.img);
    }

    @Override
    public int getItemCount() {
        return domain.size();
    }

    public class ViewHolder2 extends RecyclerView.ViewHolder{

        @BindView(R.id.id_2)
        TextView id;

        @BindView(R.id.title_2)
        TextView title;

        @BindView(R.id.year_2)
        TextView year;

        @BindView(R.id.imdb_rating_2)
        TextView imdb_rating;

        @BindView(R.id.img_2)
        ImageView img;

        public ViewHolder2(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
