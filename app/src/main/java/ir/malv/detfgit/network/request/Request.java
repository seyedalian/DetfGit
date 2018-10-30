package ir.malv.detfgit.network.request;

import ir.malv.detfgit.network.model.Rss;
import retrofit2.Call;
import retrofit2.http.GET;

public interface Request {
    // TODO: All your requests here.
    @GET("14")
    Call<Rss> getRss();

}
