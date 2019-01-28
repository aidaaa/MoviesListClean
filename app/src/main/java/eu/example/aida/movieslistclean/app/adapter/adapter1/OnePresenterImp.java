package eu.example.aida.movieslistclean.app.adapter.adapter1;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.lang.ref.WeakReference;

import eu.example.aida.movieslistclean.R;
import eu.example.aida.movieslistclean.app.view.LoadData;
import eu.example.aida.movieslistclean.domain.interactor.base.UseCase;
import eu.example.aida.movieslistclean.domain.interactor.base.UseCaseFactory;
import eu.example.aida.movieslistclean.domain.model.MoviesDomain;
import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;

/**
 * Created by Aida on 1/19/2019.
 */

public class OnePresenterImp extends DisposableObserver<MoviesDomain> {

    private UseCaseFactory factory;
    private UseCase useCase;
    private WeakReference<OnePresenter> view;


    public OnePresenterImp(UseCaseFactory factory) {
        this.factory = factory;
    }

    public void onCreate(OnePresenter onePresenter){
        view=new WeakReference<OnePresenter>(onePresenter);
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
        OnePresenter onePresenter=view.get();
        if (onePresenter!=null){
            onePresenter.getMoviesOne(moviesDomain);
        }
    }

    @Override
    public void onError(@NonNull Throwable e) {
        System.out.println(e.getMessage().toString()+"SAAT");
    }

    @Override
    public void onComplete() {

    }
}
