package eu.example.aida.movieslistclean.app.mvp;

import eu.example.aida.movieslistclean.app.presenter.Presenter;
import eu.example.aida.movieslistclean.app.view.LoadData;
import eu.example.aida.movieslistclean.domain.interactor.base.UseCaseFactory;
import eu.example.aida.movieslistclean.domain.model.MoviesDomain;

/**
 * Created by Aida on 1/16/2019.
 */

public class H_Model extends Presenter implements Containes.hModel {

    MoviesDomain moviesDomain;

    public H_Model(UseCaseFactory factory) {
        super(factory);
    }

    @Override
    public MoviesDomain getMovies() {

        return moviesDomain;
    }
}
