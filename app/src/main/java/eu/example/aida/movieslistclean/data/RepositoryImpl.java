package eu.example.aida.movieslistclean.data;

import java.util.List;

import eu.example.aida.movieslistclean.data.factory.DataStore;
import eu.example.aida.movieslistclean.data.factory.DataStoreFactory;
import eu.example.aida.movieslistclean.data.mapper.Mapper;
import eu.example.aida.movieslistclean.domain.model.MoviesDomain;
import eu.example.aida.movieslistclean.domain.repository.Repository;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Predicate;

/**
 * Created by Aida on 1/1/2019.
 */

public class RepositoryImpl implements Repository {

    DataStoreFactory factory;

    public RepositoryImpl(DataStoreFactory factory) {
        this.factory = factory;
    }

    @Override
    public Observable<MoviesDomain> getMovies() {
        return factory.getDataStore().getMovies().map(new Mapper());
    }
}
