package eu.example.aida.movieslistclean.data.cache;

import java.util.List;

import eu.example.aida.movieslistclean.data.model.MoviesData;
import io.reactivex.Observable;

/**
 * Created by Aida on 1/1/2019.
 */

public class MoviesCacheImpl implements MoviesCache {

    private FileManagment fileM;

    public MoviesCacheImpl(FileManagment fileM) {
        this.fileM = fileM;
    }

    @Override
    public Observable<List<MoviesData>> get(int current_page) {
        return null;
    }

    @Override
    public void put(MoviesData movies) {

    }

    @Override
    public boolean is_Cached(int current_page) {
        return false;
    }

    @Override
    public boolean time_finished(int current_page) {
        return false;
    }
}
