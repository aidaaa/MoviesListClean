package eu.example.aida.movieslistclean.data.net;


import eu.example.aida.movieslistclean.data.model.MoviesData;
import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.Query;

/**
 * Created by Aida on 1/1/2019.
 */

public interface RestApi {
    Observable<MoviesData> getMovies();
}
