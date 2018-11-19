package ir.malv.detfgit.network;


import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

import static ir.malv.detfgit.Constant.API_BASE_URL;

public class RetrofitUtils {

    private static Retrofit retrofit;

    /**
     * @return an instance of retrofit
     */
    public static Retrofit getInstance() {
        // Don't waste the instance if it already exists.
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(API_BASE_URL)
                    .client(new OkHttpClient())
                    .addConverterFactory(SimpleXmlConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

}
