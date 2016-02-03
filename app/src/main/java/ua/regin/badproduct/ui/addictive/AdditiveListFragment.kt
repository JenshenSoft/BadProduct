package ua.regin.badproduct.ui.addictive;

import android.support.v7.widget.RecyclerView
import android.support.v7.widget.SearchView
import android.view.Menu
import android.view.MenuInflater
import com.firebase.client.DataSnapshot
import com.firebase.client.FirebaseError
import com.firebase.client.ValueEventListener
import com.github.vmironov.jetpack.arguments.bindArgument
import ua.regin.badproduct.R
import ua.regin.badproduct.application.Application
import ua.regin.badproduct.manager.IAdditiveManager
import ua.regin.badproduct.model.Additive
import ua.regin.badproduct.model.Danger
import ua.regin.badproduct.ui.BaseFragment
import ua.regin.badproduct.ui.addictive.adapter.AdditiveAdapter
import ua.regin.badproduct.ui.addictive.details.AdditiveDetailsActivity
import ua.regin.badproduct.ui.addictive.force.ForceFragmentDialog
import ua.regin.badproduct.util.knife.bindView
import java.util.*
import javax.inject.Inject

class AdditiveListFragment : BaseFragment(), ValueEventListener {
    override fun getResId() = R.layout.fragment_additive;
    override fun getOptionsId() = R.menu.menu_search;

    private val recyclerView: RecyclerView by bindView(R.id.recyclerView)

    private var danger by bindArgument<Danger>()

    @Inject
    lateinit var additiveManager: IAdditiveManager;

    lateinit private var adapter: AdditiveAdapter;

    override fun injectComponent() = Application.getApplication().additiveComponent.inject(this);

    override fun afterViews() {
        adapter = AdditiveAdapter(context, {
            startActivity(AdditiveDetailsActivity.newInstance(context, adapter.filteredList as ArrayList<Additive>, it))
        }, {
            val forceDialog = ForceFragmentDialog();
            forceDialog.show(childFragmentManager, null);
        });
        recyclerView.adapter = adapter;
        additiveManager.addAdditiveListener(this);
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
        var myActionMenuItem = menu?.findItem(R.id.action_search);
        var searchView = myActionMenuItem?.actionView as SearchView;
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                return false;
            }

            override fun onQueryTextChange(query: String): Boolean {
                adapter.search(query);
                return false;
            }
        });
    }

    override fun onDestroy() {
        super.onDestroy();
        additiveManager.removeAdditiveListener(this);
    }

    override fun onDataChange(dataSnapshot: DataSnapshot) {
        var additiveList = ArrayList<Additive>();
        for (postSnapshot in dataSnapshot.children) {
            var additive = postSnapshot.getValue(Additive::class.java);
            additiveList.add(additive);
        }
        adapter.additiveList = additiveList.filter { it.danger >= danger.from && it.danger <= danger.to };
    }

    override public fun onCancelled(firebaseError: FirebaseError) {

    }

    public companion object {
        public fun newInstance(danger: Danger): AdditiveListFragment = AdditiveListFragment().apply {
            this.danger = danger;
        }
    }
}
