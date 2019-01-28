package eu.example.aida.movieslistclean.app.mvp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

import eu.example.aida.movieslistclean.R;
import eu.example.aida.movieslistclean.app.presenter.Presenter;
import eu.example.aida.movieslistclean.app.view.LoadData;
import eu.example.aida.movieslistclean.data.RepositoryImpl;
import eu.example.aida.movieslistclean.data.factory.DataStoreFactory;
import eu.example.aida.movieslistclean.data.net.RestApi;
import eu.example.aida.movieslistclean.data.net.RestApiImpl;
import eu.example.aida.movieslistclean.domain.interactor.base.UseCaseFactory;
import eu.example.aida.movieslistclean.domain.model.MoviesDomain;
import eu.example.aida.movieslistclean.domain.repository.Repository;

/**
 * Created by Aida on 1/16/2019.
 */

class H_View extends FrameLayout implements Containes.hView{

    RecyclerView recyclerView;

    private Button btn;

    public H_View(@NonNull Context context) {
        super(context);

        View view=LayoutInflater.from(context).inflate(R.layout.activity_main,this);
        btn= (Button) view.findViewWithTag("btn");
        recyclerView= (RecyclerView) view.findViewWithTag("recycler");
    }

    @Override
    public void setMovies(final MoviesDomain moviesDomain) {
        btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),moviesDomain.data.get(0).getId(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
