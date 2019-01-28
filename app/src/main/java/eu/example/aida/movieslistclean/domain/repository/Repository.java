package eu.example.aida.movieslistclean.domain.repository;

import eu.example.aida.movieslistclean.domain.model.MoviesDomain;
import io.reactivex.Observable;

/**
 * Created by Aida on 1/1/2019.
 */

public interface Repository {
    Observable<MoviesDomain> getMovies();

    //Observable<T> getMovies();
}
