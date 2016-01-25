package ua.regin.badproduct.manager.impl

import android.content.Context
import com.firebase.client.Firebase
import com.firebase.client.ValueEventListener
import org.androidannotations.annotations.EBean
import ua.regin.badproduct.application.Application
import ua.regin.badproduct.manager.IAdditiveManager

@EBean(scope = EBean.Scope.Singleton)
open class AdditiveManager : IAdditiveManager {

    private val firebase: Firebase;
    private val context: Context;

    constructor(context: Context) {
        this.context = context;
        firebase = Firebase(Application.FIREBASE_URL);
    }

    override fun addAdditiveListener(valueEventListener: ValueEventListener) {
        firebase.addValueEventListener(valueEventListener)
    }

    override fun removeAdditiveListener(valueEventListener: ValueEventListener) {
        firebase.removeEventListener(valueEventListener)
    }
}
