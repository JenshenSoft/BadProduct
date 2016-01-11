package ua.regin.badproduct.ui.main;

import android.util.Log;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;

import ua.regin.badproduct.R;
import ua.regin.badproduct.entity.Additive;
import ua.regin.badproduct.ui.BaseActivity;

@EActivity(R.layout.activity_main)
public class MainActivity extends BaseActivity {


    @AfterViews
    protected void afterViews() {
        Firebase firebase = new Firebase("https://badproduct.firebaseio.com/");

        firebase.limitToLast(5).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                for (DataSnapshot msgSnapshot : snapshot.getChildren()) {
                    Additive additive = msgSnapshot.getValue(Additive.class);
                    Log.i("Chat", additive.getName());
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                Log.e("Chat", "The read failed: " + firebaseError.getMessage());
            }
        });
    }
}
