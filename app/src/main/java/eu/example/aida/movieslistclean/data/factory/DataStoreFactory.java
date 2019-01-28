package eu.example.aida.movieslistclean.data.factory;

import eu.example.aida.movieslistclean.data.net.RestApi;

/**
 * Created by Aida on 1/1/2019.
 */

public class DataStoreFactory {

    RestApi restApi;

    public DataStoreFactory(RestApi restApi) {
        this.restApi = restApi;
    }

    public DataStore getDataStore(){
        return new DataStoreImpl(restApi);
    }
}
