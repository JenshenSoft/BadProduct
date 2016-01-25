package ua.regin.badproduct.ui.addictive;

import android.support.v7.widget.RecyclerView
import android.support.v7.widget.SearchView
import android.text.InputType
import android.view.Menu
import android.view.MenuInflater
import com.firebase.client.DataSnapshot
import com.firebase.client.FirebaseError
import com.firebase.client.ValueEventListener
import org.androidannotations.annotations.*
import ua.regin.badproduct.R
import ua.regin.badproduct.entity.Additive
import ua.regin.badproduct.manager.IAdditiveManager
import ua.regin.badproduct.manager.impl.AdditiveManager
import ua.regin.badproduct.ui.BaseFragment
import ua.regin.badproduct.ui.addictive.adapter.AdditiveAdapter
import ua.regin.badproduct.ui.addictive.details.AdditiveDetailsActivity
import java.util.*

@EFragment(R.layout.fragment_additive)
@OptionsMenu(R.menu.menu_search)
open class AdditiveFragment : BaseFragment(), ValueEventListener {
    override fun getResId() = R.layout.fragment_additive;
    override fun getOptionsId() = R.menu.menu_search;

    @FragmentArg lateinit protected var dangerFrom: Integer;
    @FragmentArg lateinit protected var dangerTo: Integer;

    @field:ViewById lateinit var recyclerView: RecyclerView;

    @Bean(AdditiveManager::class)
    lateinit var additiveManager: IAdditiveManager;

    lateinit private var adapter: AdditiveAdapter;

    @AfterViews
    open fun afterViews() {
        adapter = AdditiveAdapter(context, {
            startActivity(AdditiveDetailsActivity.newInstance(context, it))
        });
        recyclerView.adapter = adapter;
        additiveManager.addAdditiveListener(this);
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
        var myActionMenuItem = menu?.findItem(R.id.action_search);
        var searchView = myActionMenuItem?.actionView as SearchView;
        searchView.inputType = InputType.TYPE_CLASS_NUMBER or InputType.TYPE_CLASS_TEXT;
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
        adapter.additiveList = additiveList;
    }

    override public fun onCancelled(firebaseError: FirebaseError) {

    }
}
