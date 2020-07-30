package edu.cnm.deepdive.buffy.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import edu.cnm.deepdive.buffy.BuildConfig;
import edu.cnm.deepdive.buffy.model.entity.Movie;
import io.reactivex.Single;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * This interface contains static methods, which act as the link between the user
 * and the TMDB service, by using an API KEY.
 */

public interface TmdbService {

  @GET("search/movie")
  Single<Movie.Result> search(@Query("api_key") String apiKey, @Query("query") String query);

  static TmdbService getInstance() {
    return InstanceHolder.INSTANCE;
  }

  class InstanceHolder {

    private static final TmdbService INSTANCE;

    static {
      Gson gson = new GsonBuilder()
          .excludeFieldsWithoutExposeAnnotation()
          .create();
      HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
      interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
      OkHttpClient client = new OkHttpClient.Builder()
          .addInterceptor(interceptor)
          .readTimeout(30, TimeUnit.SECONDS)
          .build();
      Retrofit retrofit = new Retrofit.Builder()
          .addConverterFactory(GsonConverterFactory.create(gson))
          .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
          .client(client)
          .baseUrl(BuildConfig.BASE_URL)
          .build();
      INSTANCE = retrofit.create(TmdbService.class);
    }

  }

}
