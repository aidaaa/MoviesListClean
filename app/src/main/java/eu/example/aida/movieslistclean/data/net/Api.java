package eu.example.aida.movieslistclean.data.net;

import eu.example.aida.movieslistclean.data.model.MoviesData;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Aida on 1/1/2019.
 */

public interface Api {
    @GET("movies")
    Call<MoviesData> getMovies(@Query("page") Integer page);
}
