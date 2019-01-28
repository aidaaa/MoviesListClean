package eu.example.aida.movieslistclean.app.presenter;

import java.lang.ref.WeakReference;

import eu.example.aida.movieslistclean.app.mvp.Containes;
import eu.example.aida.movieslistclean.app.view.LoadData;
import eu.example.aida.movieslistclean.domain.interactor.base.UseCase;
import eu.example.aida.movieslistclean.domain.interactor.base.UseCaseFactory;
import eu.example.aida.movieslistclean.domain.model.MoviesDomain;
import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;

/**
 * Created by Aida on 1/1/2019.
 */

public class Presenter extends DisposableObserver<MoviesDomain> {

    private UseCaseFactory factory;
    private UseCase useCase;
    private WeakReference<LoadData> view;


    public Presenter(UseCaseFactory factory) {
        this.factory = factory;
    }

    public void init(LoadData loadData){
        view=new WeakReference<LoadData>(loadData);
        if (view!=null){
            invoke();
        }
    }

    private void invoke() {
        useCase=factory.getUseCase();
        useCase.execute(this);
    }

    @Override
    public void onNext(@NonNull MoviesDomain moviesDomain) {
        LoadData loadData=view.get();
        if (loadData!=null){
            loadData.getMovies(moviesDomain);
        }
    }

    @Override
    public void onError(@NonNull Throwable e) {
        LoadData loadData=view.get();
        if (loadData !=null){
            System.out.println(e.getMessage()+"Error"+"majid");        }
    }

    @Override
    public void onComplete() {

    }

    public void onDestroy(){
       useCase.dispos();
    }
}
