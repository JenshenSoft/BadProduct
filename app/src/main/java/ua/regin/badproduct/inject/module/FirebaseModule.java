package ua.regin.badproduct.inject.module;

import com.firebase.client.Firebase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class FirebaseModule {

    private final Firebase firebase;

    public FirebaseModule(Firebase firebase) {
        this.firebase = firebase;
    }

    @Provides
    @Singleton
    public Firebase provideFirebase() {
        return firebase;
    }
}