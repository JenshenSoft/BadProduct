package ua.regin.badproduct.ui.addictive;

import com.firebase.client.DataSnapshot
import com.firebase.client.FirebaseError
import com.firebase.client.ValueEventListener
import kotlinx.android.synthetic.main.fragment_additive.*
import ua.regin.badproduct.R
import ua.regin.badproduct.application.Application
import ua.regin.badproduct.entity.Additive
import ua.regin.badproduct.manager.IAdditiveManager
import ua.regin.badproduct.ui.BaseFragment
import ua.regin.badproduct.ui.addictive.adapter.AdditiveAdapter
import java.util.*
import javax.inject.Inject

class AddictiveFragment : BaseFragment(), ValueEventListener {

    @Inject
    lateinit var additiveManager: IAdditiveManager;

    lateinit private var adapter: AdditiveAdapter;

    override fun getResId() = R.layout.fragment_additive;
    override fun injectComponent() = Application.getApplication().additiveComponent.inject(this);

    override fun afterViews() {
        adapter = AdditiveAdapter(context);
        recyclerView.adapter = adapter;
        additiveManager.addAdditiveListener(this);
    }

    override fun onDataChange(dataSnapshot: DataSnapshot) {
        var additiveList = ArrayList<Additive>();
        for (postSnapshot in dataSnapshot.children) {
            var additive = postSnapshot.getValue(Additive::class.java);
            additiveList.add(additive);
        }
        adapter.additiveList = additiveList;
    }

    override public fun onCancelled(firebaseError: FirebaseError) {

    }
}
