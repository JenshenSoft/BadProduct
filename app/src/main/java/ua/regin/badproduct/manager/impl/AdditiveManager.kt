package ua.regin.badproduct.manager.impl

import com.firebase.client.Firebase
import com.firebase.client.ValueEventListener
import ua.regin.badproduct.manager.IAdditiveManager

class AdditiveManager(private val firebase: Firebase) : IAdditiveManager {

    override fun addAdditiveListener(valueEventListener: ValueEventListener) {
        firebase.addValueEventListener(valueEventListener)
    }

    override fun removeAdditiveListener(valueEventListener: ValueEventListener) {
        firebase.removeEventListener(valueEventListener)
    }
}
