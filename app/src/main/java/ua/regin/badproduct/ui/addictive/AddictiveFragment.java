package ua.regin.badproduct.ui.addictive;

import android.support.v7.widget.RecyclerView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import ua.regin.badproduct.R;
import ua.regin.badproduct.application.Application;
import ua.regin.badproduct.entity.Additive;
import ua.regin.badproduct.manager.IAdditiveManager;
import ua.regin.badproduct.ui.BaseFragment;
import ua.regin.badproduct.ui.addictive.adapter.AdditiveAdapter;

@EFragment(R.layout.fragment_additive)
public class AddictiveFragment extends BaseFragment implements ValueEventListener {

    @ViewById
    protected RecyclerView recyclerView;

    @Inject
    protected IAdditiveManager additiveManager;

    private AdditiveAdapter adapter;

    @Override
    protected void injectComponent() {
        Application.getApplication().getAdditiveComponent().inject(this);
    }

    @AfterViews
    protected void afterViews() {
        adapter = new AdditiveAdapter(getContext());
        recyclerView.setAdapter(adapter);
        additiveManager.addAdditiveListener(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        additiveManager.removeAdditiveListener(this);
    }

    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        List<Additive> additiveList = new ArrayList<>();
        for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
            Additive additive = postSnapshot.getValue(Additive.class);
            additiveList.add(additive);
        }
        adapter.setAdditiveList(additiveList);
    }

    @Override
    public void onCancelled(FirebaseError firebaseError) {

    }
}
