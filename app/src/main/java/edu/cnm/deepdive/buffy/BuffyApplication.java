package edu.cnm.deepdive.buffy;

import android.app.Application;
import com.facebook.stetho.Stetho;
import edu.cnm.deepdive.buffy.service.BuffyDatabase;
import edu.cnm.deepdive.buffy.service.GoogleSignInService;
import io.reactivex.schedulers.Schedulers;

public class BuffyApplication extends Application {

  @Override
  public void onCreate() {
    super.onCreate();
    GoogleSignInService.setContext(this);
    BuffyDatabase.setContext(this);
    BuffyDatabase database = BuffyDatabase.getInstance();
    database.getMovieDao().delete()
        .subscribeOn(Schedulers.io())
        .subscribe();

    Stetho.initializeWithDefaults(this);


  }

}


