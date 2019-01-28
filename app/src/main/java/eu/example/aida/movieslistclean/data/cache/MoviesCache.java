package eu.example.aida.movieslistclean.data.cache;

import java.util.List;

import eu.example.aida.movieslistclean.data.model.MoviesData;
import io.reactivex.Observable;

/**
 * Created by Aida on 1/1/2019.
 */

public interface MoviesCache {

    Observable<List<MoviesData>> get(int current_page);
    void put(MoviesData movies);
    boolean is_Cached(int current_page);
    boolean time_finished(int current_page);

}
