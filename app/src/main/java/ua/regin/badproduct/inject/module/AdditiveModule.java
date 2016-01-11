package ua.regin.badproduct.inject.module;

import com.firebase.client.Firebase;

import dagger.Module;
import dagger.Provides;
import ua.regin.badproduct.inject.scope.ActivityScope;
import ua.regin.badproduct.manager.IAdditiveManager;
import ua.regin.badproduct.manager.impl.AdditiveManager;

@Module
public class AdditiveModule {

    @Provides
    @ActivityScope
    public IAdditiveManager provideAddictiveManager(Firebase firebase) {
        return new AdditiveManager(firebase);
    }
}