package ua.regin.badproduct.ui.main;

import com.firebase.client.DataSnapshot;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;

import javax.inject.Inject;

import ua.regin.badproduct.R;
import ua.regin.badproduct.application.Application;
import ua.regin.badproduct.entity.Additive;
import ua.regin.badproduct.manager.IAdditiveManager;
import ua.regin.badproduct.ui.BaseFragment;

@EFragment(R.layout.fragment_main)
public class MainFragment extends BaseFragment implements ValueEventListener {

    @Inject
    protected IAdditiveManager additiveManager;

    @Override
    protected void injectComponent() {
        Application.getApplication().getAdditiveComponent().inject(this);
    }

    @AfterViews
    protected void afterViews() {
        additiveManager.addAdditiveListener(this);
    }

    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
            Additive additive = postSnapshot.getValue(Additive.class);
            System.out.println(additive.toString());
        }
    }

    @Override
    public void onCancelled(FirebaseError firebaseError) {

    }
}
