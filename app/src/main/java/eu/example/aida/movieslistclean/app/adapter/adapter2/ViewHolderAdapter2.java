package eu.example.aida.movieslistclean.app.adapter.adapter2;

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
import eu.example.aida.movieslistclean.app.adapter.adapter1.Adapter1;
import eu.example.aida.movieslistclean.app.adapter.adapter1.OnePresenterImp;
import eu.example.aida.movieslistclean.data.RepositoryImpl;
import eu.example.aida.movieslistclean.data.factory.DataStoreFactory;
import eu.example.aida.movieslistclean.data.net.RestApi;
import eu.example.aida.movieslistclean.data.net.RestApiImpl;
import eu.example.aida.movieslistclean.domain.interactor.base.UseCaseFactory;
import eu.example.aida.movieslistclean.domain.model.Movie;
import eu.example.aida.movieslistclean.domain.model.MoviesDomain;
import eu.example.aida.movieslistclean.domain.repository.Repository;

/**
 * Created by Aida on 1/17/2019.
 */

public class ViewHolderAdapter2 extends RecyclerView.ViewHolder implements TwoPresenter{

    private RecyclerView recyclerView2;

   private Adapter2 adapter2=new Adapter2(itemView.getContext());
   private TwoPresenterImp presenterImp;
   private Context context;



    public ViewHolderAdapter2(View itemView,Context context) {
        super(itemView);
        this.context=context;
       // recyclerView= (RecyclerView) itemView.findViewById(R.id.recycler_2);

      // init();
    }

    private void init() {
        recyclerView2.setHasFixedSize(true);
        recyclerView2.setLayoutManager(new GridLayoutManager(itemView.getContext(),1,LinearLayoutManager.HORIZONTAL,false));
    }

    public void onCreate(){

        RestApi restApi=new RestApiImpl();

        DataStoreFactory dataStoreFactory=new DataStoreFactory(restApi);

        Repository repository=new RepositoryImpl(dataStoreFactory);

        UseCaseFactory factory=new UseCaseFactory(repository);

        presenterImp=new TwoPresenterImp(factory);

        presenterImp.onCreate(this);
    }

    @Override
    public void getMoviesTwo(MoviesDomain moviesDomain) {
        recyclerView2= (RecyclerView) itemView.findViewById(R.id.recycler_2);
        init();
        adapter2.setDomain(moviesDomain.data);
        recyclerView2.setAdapter(adapter2);
    }
}
