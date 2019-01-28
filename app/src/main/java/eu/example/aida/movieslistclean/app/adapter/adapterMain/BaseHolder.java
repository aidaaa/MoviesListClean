package eu.example.aida.movieslistclean.app.adapter.adapterMain;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Aida on 1/17/2019.
 */

public class BaseHolder<P> extends RecyclerView.ViewHolder {

    private P presenter;

    public void getPresenter() {

    }

    public void setPresenter(P presenter) {
        this.presenter = presenter;
    }

    public BaseHolder(View itemView) {
        super(itemView);
    }
}
