package ua.regin.badproduct.inject.component.subcomponent;

import dagger.Subcomponent;
import ua.regin.badproduct.inject.module.AdditiveModule;
import ua.regin.badproduct.inject.scope.ActivityScope;
import ua.regin.badproduct.ui.addictive.AdditiveListFragment;
import ua.regin.badproduct.ui.search.SearchFragment;

@ActivityScope
@Subcomponent(modules = AdditiveModule.class)
public interface AdditiveComponent {

    void inject(AdditiveListFragment additiveListFragment);

    void inject(SearchFragment searchFragment);

}
