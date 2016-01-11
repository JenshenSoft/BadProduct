package ua.regin.badproduct.manager

import com.firebase.client.ValueEventListener

interface IAdditiveManager {

    fun addAdditiveListener(valueEventListener: ValueEventListener);

    fun removeAdditiveListener(valueEventListener: ValueEventListener);

}
