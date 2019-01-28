package eu.example.aida.movieslistclean.app.adapter.adapter1;

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

public class Adapter1 extends RecyclerView.Adapter<Adapter1.ViewHolder1> {

    List<Movie> domain=new ArrayList<>();

    public Adapter1(Context context) {
        this.context = context;
    }

    Context context;

    public void setDomain(List<Movie> domains) {
        this.domain = domains;
        System.out.println(domain.size()+"majid12");
        notifyItemChanged(domain.size(),domains.size());
    }

    @Override
    public ViewHolder1 onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter1,parent,false);
        return new ViewHolder1(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder1 holder, int position) {
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

    public class ViewHolder1 extends RecyclerView.ViewHolder{

        @BindView(R.id.id_1)
        TextView id;

        @BindView(R.id.title_1)
        TextView title;

        @BindView(R.id.year_1)
        TextView year;

        @BindView(R.id.imdb_rating_1)
        TextView imdb_rating;

        @BindView(R.id.img_1)
        ImageView img;

        public ViewHolder1(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
