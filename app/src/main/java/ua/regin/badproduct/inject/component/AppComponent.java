package ua.regin.badproduct.inject.component;

import javax.inject.Singleton;

import dagger.Component;
import ua.regin.badproduct.inject.component.subcomponent.AdditiveComponent;
import ua.regin.badproduct.inject.module.AdditiveModule;
import ua.regin.badproduct.inject.module.AppModule;
import ua.regin.badproduct.inject.module.FirebaseModule;

@Singleton
@Component(modules = {AppModule.class, FirebaseModule.class})
public interface AppComponent {

    AdditiveComponent plus(AdditiveModule module);

}
