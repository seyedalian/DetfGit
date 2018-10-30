package ir.malv.detfgit.network.provider;


import ir.malv.detfgit.network.RetrofitUtils;
import retrofit2.Retrofit;

/**
 * This class provides data for the activities.
 * I've added an example of how this is done.
 * But since there's no model to return it does nothing.
 * Don't use retrofit in activities.
 * Use this class instead.
 */
public class DataProvider {

    // TODO : Read the document above this class

    private static DataProvider dataProvider;

    private Retrofit retrofit;


    public static DataProvider getInstance() {
        if (dataProvider == null) {
            dataProvider = new DataProvider();
        }

        return dataProvider;
    }



    /**
     * We don't want anyone to new this. He/She must use {@link #getInstance()}
     */
    private DataProvider() {
        retrofit = RetrofitUtils.getInstance();
    }
}
