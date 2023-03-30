package com.app.quizz.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.app.quizz.repository.AuthRepository;
import com.google.firebase.auth.FirebaseUser;

public class AuthViewModel  extends AndroidViewModel {


    private MutableLiveData<FirebaseUser> firebaseUserMutableLiveData;
    private FirebaseUser currentUser;
    private AuthRepository repository;

    public MutableLiveData<FirebaseUser> getFirebaseUserMutableLiveData() {
        return firebaseUserMutableLiveData;
    }

    public FirebaseUser getCurrentUser() {
        return currentUser;
    }

    public AuthViewModel(@NonNull Application application) {
        super(application);

        repository = new AuthRepository(application);
        currentUser = repository.getFirebaseUser();
        firebaseUserMutableLiveData = repository.getFirebaseUserMutableLiveData();
    }

    public void signUp(String email, String pass){
        repository.signUp(email, pass);

    }
    public void signIn(String email, String pass){
        repository.signIn(email, pass);
    }
    public void signOut(String email, String pass){
        repository.signOut();
    }
}