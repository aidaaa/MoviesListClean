package eu.example.aida.movieslistclean.app.adapter.adapter2;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.lang.ref.WeakReference;

import eu.example.aida.movieslistclean.app.adapter.adapter1.Adapter1;
import eu.example.aida.movieslistclean.app.adapter.adapter1.OnePresenter;
import eu.example.aida.movieslistclean.domain.interactor.base.UseCase;
import eu.example.aida.movieslistclean.domain.interactor.base.UseCaseFactory;
import eu.example.aida.movieslistclean.domain.model.MoviesDomain;
import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;

/**
 * Created by Aida on 1/19/2019.
 */

public class TwoPresenterImp extends DisposableObserver<MoviesDomain> {

    private UseCaseFactory factory;
    private UseCase useCase;
    private WeakReference<TwoPresenter> view;

    public TwoPresenterImp(UseCaseFactory factory) {
        this.factory = factory;
    }

    public void onCreate(TwoPresenter twoPresenter){
        view=new WeakReference<TwoPresenter>(twoPresenter);
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
            TwoPresenter twoPresenter=view.get();
            if (twoPresenter!=null){
                twoPresenter.getMoviesTwo(moviesDomain);
            }
    }

    @Override
    public void onError(@NonNull Throwable e) {

    }

    @Override
    public void onComplete() {

    }
}
