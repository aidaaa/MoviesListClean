package eu.example.aida.movieslistclean.app.mvp;

import eu.example.aida.movieslistclean.domain.model.MoviesDomain;

/**
 * Created by Aida on 1/16/2019.
 */

public interface Containes {
    interface hView{
        void setMovies(MoviesDomain moviesDomain);
    }
    interface hModel{
        MoviesDomain getMovies();
    }
}
