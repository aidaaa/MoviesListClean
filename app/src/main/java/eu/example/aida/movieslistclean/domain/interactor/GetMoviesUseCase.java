package eu.example.aida.movieslistclean.domain.interactor;

import eu.example.aida.movieslistclean.domain.interactor.base.UseCase;
import eu.example.aida.movieslistclean.domain.model.MoviesDomain;
import eu.example.aida.movieslistclean.domain.repository.Repository;
import io.reactivex.Observable;

/**
 * Created by Aida on 1/1/2019.
 */

public class GetMoviesUseCase extends UseCase<MoviesDomain> {

    Repository repository;

    public GetMoviesUseCase(Repository repository) {
        this.repository = repository;
    }

    @Override
    public Observable<MoviesDomain> buildObservable() {
        return repository.getMovies();
    }
}
