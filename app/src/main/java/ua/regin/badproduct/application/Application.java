package ua.regin.badproduct.application;

import com.firebase.client.Firebase;

import ua.regin.badproduct.inject.component.AppComponent;
import ua.regin.badproduct.inject.component.DaggerAppComponent;
import ua.regin.badproduct.inject.component.subcomponent.AdditiveComponent;
import ua.regin.badproduct.inject.module.AdditiveModule;
import ua.regin.badproduct.inject.module.AppModule;
import ua.regin.badproduct.inject.module.FirebaseModule;

public class Application extends android.app.Application {

    private static final String FIREBASE_URL = "https://badproduct.firebaseio.com/";

    private static Application application;
    private AppComponent appComponent;
    private AdditiveComponent additiveComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        Firebase.setAndroidContext(this);
        Firebase.getDefaultConfig().setPersistenceEnabled(true);
    }

    public static Application getApplication() {
        return application;
    }

    public AppComponent getAppComponent() {
        if (appComponent == null) {
            appComponent = DaggerAppComponent.builder()
                    .appModule(new AppModule(this))
                    .firebaseModule(new FirebaseModule(new Firebase(FIREBASE_URL)))
                    .build();
        }
        return appComponent;
    }

    public AdditiveComponent getAdditiveComponent() {
        if (additiveComponent == null) {
            additiveComponent = getAppComponent().plus(new AdditiveModule());
        }
        return additiveComponent;
    }
}

