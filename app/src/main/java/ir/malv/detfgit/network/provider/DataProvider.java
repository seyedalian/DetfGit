package ir.malv.detfgit.network.provider;


import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import ir.malv.detfgit.Constant;
import ir.malv.detfgit.R;
import ir.malv.detfgit.network.RetrofitUtils;
import ir.malv.detfgit.network.model.Rss;
import ir.malv.detfgit.network.request.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
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
    private Rss rss= null;

    public static DataProvider getInstance() {
        if (dataProvider == null) {
            dataProvider = new DataProvider();
        }

        return dataProvider;
    }




    /**

     * We don't want anyone to new this. He/She must use {@link #getInstance()}
     */
    public DataProvider() {
        retrofit = RetrofitUtils.getInstance();
        final Request request =retrofit.create(Request.class);
        Call call = request.getRss();
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                if(response.isSuccessful()){
                    rss = (Rss) response.body();
                    if(rss ==null){
                        Log.e(Constant.APP_NAME,"rss is Null");
                    }else{
                        Log.i(Constant.APP_NAME,"Rss is ok");
                    }
                    Log.i(Constant.APP_NAME,response.message()+"---------------->");
                }else {
                    Log.e(Constant.APP_NAME,response.message()+"---------------->");
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {

                Log.e(Constant.APP_NAME,t.toString()+"---------------->");
            }
        });

    }

    public Rss getRss() {
        return rss;
    }



    public Retrofit getRetrofit() {
        return retrofit;
    }
}
