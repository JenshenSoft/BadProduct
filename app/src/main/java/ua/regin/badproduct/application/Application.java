package ua.regin.badproduct.application;

import com.firebase.client.Firebase;

public class Application extends android.app.Application {

    public static final String FIREBASE_URL = "https://badproduct.firebaseio.com/";

    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
        Firebase.getDefaultConfig().setPersistenceEnabled(true);
    }
}

