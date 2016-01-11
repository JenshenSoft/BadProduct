package ua.regin.badproduct.manager.impl;

import com.firebase.client.Firebase;

import javax.inject.Inject;

import ua.regin.badproduct.manager.IAdditiveManager;

public class AdditiveManager implements IAdditiveManager {

    private final Firebase firebase;

    @Inject
    public AdditiveManager(Firebase firebase) {
        this.firebase = firebase;
    }

    @Override
    public void additiveListener() {

    }
}
