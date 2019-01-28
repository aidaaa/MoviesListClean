package eu.example.aida.movieslistclean.app.adapter.adapterMain;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
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
import eu.example.aida.movieslistclean.app.adapterClick.ClickAdapter;
import eu.example.aida.movieslistclean.domain.model.Movie;

/**
 * Created by Aida on 1/2/2019.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    List<Movie> domain=new ArrayList<>();
    Context context;

    public Adapter(Context context) {
        this.context = context;
    }

    public void setDomain(List<Movie> domains) {
        this.domain = domains;
        notifyItemChanged(domain.size(),domains.size());
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.id.setText(Integer.toString(domain.get(position).getId()));
        holder.title.setText(domain.get(position).getTitle());
        holder.year.setText(domain.get(position).getTitle());
        holder.imdb_rating.setText(domain.get(position).getImdb_rating());

        final String img_url=domain.get(position).getPoster();
        Picasso picasso=new Picasso.Builder(context).build();
        picasso.load(img_url).into(holder.img);

    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        return domain.size();
    }



    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

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
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int index=Integer.valueOf(String.valueOf(id.getText()));
            Intent intent=new Intent(context, ClickAdapter.class);
            intent.putExtra("id",index);
            intent.putExtra("poster",domain.get(index-1).getPoster());
            context.startActivity(intent);
        }
    }
}
