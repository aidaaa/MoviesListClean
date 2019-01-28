package eu.example.aida.movieslistclean.app.mvp;

/**
 * Created by Aida on 1/16/2019.
 */

public class H_Presenter {

    Containes.hModel model;
    Containes.hView view;

    public H_Presenter(Containes.hModel model, Containes.hView view) {
        this.model = model;
        this.view = view;
    }

    public void onCreate(){
        view.setMovies(model.getMovies());
    }
}
