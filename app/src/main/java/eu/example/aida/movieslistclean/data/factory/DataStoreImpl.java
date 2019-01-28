package eu.example.aida.movieslistclean.data.factory;

import java.util.List;

import eu.example.aida.movieslistclean.data.model.MoviesData;
import eu.example.aida.movieslistclean.data.net.RestApi;
import io.reactivex.Observable;

/**
 * Created by Aida on 1/1/2019.
 */

public class DataStoreImpl implements DataStore {

    RestApi restApi;

    public DataStoreImpl(RestApi restApi) {
        this.restApi = restApi;
    }

    @Override
    public Observable<MoviesData> getMovies() {
        return restApi.getMovies();
    }
}
