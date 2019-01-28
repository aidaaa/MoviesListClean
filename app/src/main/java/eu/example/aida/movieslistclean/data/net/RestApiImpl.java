package eu.example.aida.movieslistclean.data.net;

import java.io.IOException;

import eu.example.aida.movieslistclean.data.model.MoviesData;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Aida on 1/1/2019.
 */

public class RestApiImpl implements RestApi {


    @Override
    public Observable<MoviesData> getMovies() {
        return Observable.create(new ObservableOnSubscribe<MoviesData>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<MoviesData> emitter) throws Exception {

                MoviesData moviesData=getDataNet();

                if (!emitter.isDisposed() && moviesData!=null)
                {
                    emitter.onNext(moviesData);
                }
                else
                {
                    emitter.onError(new Exception());
                }
                emitter.onComplete();
            }
        });
     /*   .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread());*/
    }

    public MoviesData getDataNet(){
        Api api=ApiService.create("http://moviesapi.ir/api/v1/").create(Api.class);
        try {
            return api.getMovies(1).execute().body();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
