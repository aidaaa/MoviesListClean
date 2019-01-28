package eu.example.aida.movieslistclean.app.adapter.adapter1;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import eu.example.aida.movieslistclean.R;
import eu.example.aida.movieslistclean.app.MainActivity;
import eu.example.aida.movieslistclean.data.RepositoryImpl;
import eu.example.aida.movieslistclean.data.factory.DataStoreFactory;
import eu.example.aida.movieslistclean.data.model.MoviesData;
import eu.example.aida.movieslistclean.data.net.RestApi;
import eu.example.aida.movieslistclean.data.net.RestApiImpl;
import eu.example.aida.movieslistclean.domain.interactor.base.UseCaseFactory;
import eu.example.aida.movieslistclean.domain.model.Movie;
import eu.example.aida.movieslistclean.domain.model.MoviesDomain;
import eu.example.aida.movieslistclean.domain.repository.Repository;

/**
 * Created by Aida on 1/17/2019.
 */

public class ViewHolderAdapter1 extends RecyclerView.ViewHolder implements OnePresenter{


    RecyclerView recyclerView1;

    private Adapter1 adapter1 = new Adapter1(itemView.getContext());

    private OnePresenterImp presenterImp;
    private Context context;



    public ViewHolderAdapter1(View itemView,Context context) {
        super(itemView);
        this.context=context;
        //recyclerView= (RecyclerView) itemView.findViewById(R.id.recycler_1);

      // init();
    }

    private void init() {
        recyclerView1.setHasFixedSize(true);
        recyclerView1.setLayoutManager(new GridLayoutManager(itemView.getContext(),1,LinearLayoutManager.HORIZONTAL,false));
    }

    public void onCreate(){

       RestApi restApi=new RestApiImpl();

        DataStoreFactory dataStoreFactory=new DataStoreFactory(restApi);

        Repository repository=new RepositoryImpl(dataStoreFactory);

        UseCaseFactory factory=new UseCaseFactory(repository);

       presenterImp=new OnePresenterImp(factory);

        presenterImp.onCreate(this);
    }

    @Override
    public void getMoviesOne(MoviesDomain moviesDomain) {
        recyclerView1= (RecyclerView) itemView.findViewById(R.id.recycler_1);
        init();
        adapter1.setDomain(moviesDomain.data);
        recyclerView1.setAdapter(adapter1);
    }
}
