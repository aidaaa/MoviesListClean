package eu.example.aida.movieslistclean.app.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import eu.example.aida.movieslistclean.R;
import eu.example.aida.movieslistclean.app.adapter.adapter1.ViewHolderAdapter1;
import eu.example.aida.movieslistclean.app.adapter.adapter2.ViewHolderAdapter2;
import eu.example.aida.movieslistclean.app.adapter.model.DataMain;
import eu.example.aida.movieslistclean.domain.model.Movie;

/**
 * Created by Aida on 1/17/2019.
 */

public class AdapterMain extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private static final int VIEW_TYPE_1=1;
    private static final int VIEW_TYPE_2=2;

    List<DataMain> list=new ArrayList<>();
    Context context;

    public AdapterMain(Context context) {
        this.context = context;
    }


    public void setData(List<DataMain> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {

            case VIEW_TYPE_1:
                View view = LayoutInflater.from(context).inflate(R.layout.view_holder_adapter_1, parent, false);
                return new ViewHolderAdapter1(view,context);

           case VIEW_TYPE_2:
                View view1 = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_holder_adapter_2, parent, false);
                return new ViewHolderAdapter2(view1,context);
            default:
                return null;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ViewHolderAdapter1)
        {
            ViewHolderAdapter1 baner1= (ViewHolderAdapter1) holder;
            baner1.onCreate();
        }
         else if (holder instanceof ViewHolderAdapter2)
        {
            ViewHolderAdapter2 baner2= (ViewHolderAdapter2) holder;
            baner2.onCreate();
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (list.get(position).getType()==1){
            return VIEW_TYPE_1;
        }else if (list.get(position).getType()==2){
            return VIEW_TYPE_2;
        }else {
            return VIEW_TYPE_2;
        }
    }

 @Override
    public void onViewDetachedFromWindow(RecyclerView.ViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
        holder.itemView.clearAnimation();
    }
}
