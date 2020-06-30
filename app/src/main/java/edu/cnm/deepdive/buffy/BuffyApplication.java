package edu.cnm.deepdive.buffy;

import android.app.Application;
import com.facebook.stetho.Stetho;
import edu.cnm.deepdive.buffy.service.BuffyDatabase;
import io.reactivex.schedulers.Schedulers;

public class BuffyApplication extends Application {

  @Override
  public void onCreate() {
    super.onCreate();
    BuffyDatabase.setContext(this);
    BuffyDatabase database = BuffyDatabase.getInstance();
    Stetho.initializeWithDefaults(this);
  }

}


