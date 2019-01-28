package eu.example.aida.movieslistclean.data.factory;

import java.util.List;

import eu.example.aida.movieslistclean.data.model.MoviesData;
import io.reactivex.Observable;

/**
 * Created by Aida on 1/1/2019.
 */

public interface DataStore {
    Observable<MoviesData> getMovies();
}
