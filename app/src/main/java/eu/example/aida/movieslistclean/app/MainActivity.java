package eu.example.aida.movieslistclean.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import eu.example.aida.movieslistclean.R;
import eu.example.aida.movieslistclean.app.adapter.adapter1.Adapter1;
import eu.example.aida.movieslistclean.app.adapter.adapter2.Adapter2;
import eu.example.aida.movieslistclean.app.adapter.adapterMain.Adapter;
import eu.example.aida.movieslistclean.app.adapter.AdapterMain;
import eu.example.aida.movieslistclean.app.adapter.model.DataMain;
import eu.example.aida.movieslistclean.app.presenter.Presenter;
import eu.example.aida.movieslistclean.app.view.LoadData;
import eu.example.aida.movieslistclean.data.RepositoryImpl;
import eu.example.aida.movieslistclean.data.factory.DataStoreFactory;
import eu.example.aida.movieslistclean.data.net.RestApi;
import eu.example.aida.movieslistclean.data.net.RestApiImpl;
import eu.example.aida.movieslistclean.domain.interactor.base.UseCaseFactory;
import eu.example.aida.movieslistclean.domain.model.MoviesDomain;
import eu.example.aida.movieslistclean.domain.repository.Repository;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

public class MainActivity extends AppCompatActivity implements Observer<Integer>,LoadData{

    @BindView(R.id.recycler)
    RecyclerView recyclerView;

    @BindView(R.id.progressBar2)
    ProgressBar progressBar;

    Adapter adapter;
    AdapterMain adapterMain;
    UseCaseFactory factory;
    Presenter presenter;

    Adapter1 adapter1;
    Adapter2 adapter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        Observable<Integer> observable=Observable.just(1,2,3,4);
        observable.subscribe(this);

        RestApi restApi=new RestApiImpl();

        DataStoreFactory dataStoreFactory=new DataStoreFactory(restApi);

        Repository repository=new RepositoryImpl(dataStoreFactory);

        factory=new UseCaseFactory(repository);

       // presenter=new Presenter(factory);
        //presenter.init(this);

        adapterMain=new AdapterMain(this);

    //    adapter1=new Adapter1(this);
      //  adapter2=new Adapter2(this);

        init();
    //    setUpBar(true);
    }



    @Override
    public void getMovies(MoviesDomain moviesDomain) {
        setUpBar(false);
      //  adapter1.setDomain(moviesDomain.data);
        //adapter2.setDomain(moviesDomain.data);
//        adapterMain.setMovies(moviesDomain.data);

        for (int i = 0; i <  moviesDomain.data.size(); i++) {
            System.out.println(moviesDomain.data.get(i).getId()+moviesDomain.data.get(i).getImdb_rating()+moviesDomain.data.get(i).getPoster()+"majid");
        }

        System.out.println(moviesDomain.metadata.current_page+"majid");
    }



    public void init(){
        DataMain dataMain=new DataMain();
        dataMain.setType(1);

        DataMain dataMain1=new DataMain();
        dataMain1.setType(2);

        List<DataMain> list=new ArrayList<>();
        list.add(dataMain);
        list.add(dataMain1);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapterMain);
        adapterMain.setData(list);

        /*adapter=new Adapter(this);
        LinearLayoutManager layoutManager=new LinearLayoutManager(MainActivity.this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);*/
    }

    public void setUpBar(boolean b){
        if (b){
            progressBar.setVisibility(View.VISIBLE);
        }else {
            progressBar.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void onSubscribe(@NonNull Disposable d) {

    }

    @Override
    public void onNext(@NonNull Integer integer) {

    }

    @Override
    public void onError(@NonNull Throwable e) {

    }

    @Override
    public void onComplete() {

    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }
}
