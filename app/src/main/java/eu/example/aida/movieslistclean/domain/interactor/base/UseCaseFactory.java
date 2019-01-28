package eu.example.aida.movieslistclean.domain.interactor.base;

import eu.example.aida.movieslistclean.domain.interactor.GetMoviesUseCase;
import eu.example.aida.movieslistclean.domain.repository.Repository;

/**
 * Created by Aida on 1/1/2019.
 */

public class UseCaseFactory {

    Repository repository;

    public UseCaseFactory(Repository repository) {
        this.repository = repository;
    }

    public UseCase getUseCase(){
        return new GetMoviesUseCase(repository);
    }
}
