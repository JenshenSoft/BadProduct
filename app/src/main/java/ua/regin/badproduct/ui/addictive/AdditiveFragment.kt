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
import ua.regin.badproduct.entity.Additive
import ua.regin.badproduct.manager.IAdditiveManager
import ua.regin.badproduct.ui.BaseFragment
import ua.regin.badproduct.ui.addictive.adapter.AdditiveAdapter
import ua.regin.badproduct.util.knife.bindView
import java.util.*
import javax.inject.Inject

class AdditiveFragment : BaseFragment(), ValueEventListener {
    override fun getResId() = R.layout.fragment_additive;
    override fun getOptionsId() = R.menu.menu_search;

    val recyclerView: RecyclerView by bindView(R.id.recyclerView)

    var dangerFrom by bindArgument<Int>()
    var dangerTo by bindArgument<Int>()

    @Inject
    lateinit var additiveManager: IAdditiveManager;

    lateinit private var adapter: AdditiveAdapter;

    override fun injectComponent() = Application.getApplication().additiveComponent.inject(this);

    override fun afterViews() {
        adapter = AdditiveAdapter(context, {});
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
        adapter.additiveList = additiveList.filter { it.danger > dangerFrom && it.danger < dangerTo };
    }

    override public fun onCancelled(firebaseError: FirebaseError) {

    }

    public companion object { //TODO refactoring fragment creation
        public fun newInstance(dangerFrom: Int, dangerTo: Int): AdditiveFragment = AdditiveFragment().apply {
            this.dangerFrom = dangerFrom;
            this.dangerTo = dangerTo;
        }
    }
}
