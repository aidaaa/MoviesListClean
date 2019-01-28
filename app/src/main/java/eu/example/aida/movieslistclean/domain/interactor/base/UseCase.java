package eu.example.aida.movieslistclean.domain.interactor.base;


import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Aida on 1/1/2019.
 */

public abstract class UseCase<T> {

    private CompositeDisposable mdisposable;

    public UseCase() {
        mdisposable=new CompositeDisposable();
    }

    public abstract Observable<T> buildObservable();

    public void execute(DisposableObserver<T> observer){
        Observable<T> observable=this.buildObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        addDisposable(observable.subscribeWith(observer));
       /* DisposableObserver dd=observable.subscribeWith(observer);
        mdisposable.add(dd);*/
    }

    private void addDisposable(Disposable disposable){
        mdisposable.add(disposable);
    }

    public void dispos(){
        mdisposable.dispose();
    }

}
