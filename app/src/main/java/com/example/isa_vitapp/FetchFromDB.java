package com.example.isa_vitapp;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Source;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FetchFromDB {

    private String name;
    private String instagram_link;
    private String linkedin_link;
    private String github_link;

    private String mobile;
    private String pemail;
    private String vemail;
    private String reg_number;

    private String room_number;
    private String position;

    public static Map<String, Object> position_name = new HashMap<>();
    Map<String, Object> member_details = new HashMap<>();


    public void getBoardMemberNames() {

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        DocumentReference docRef = db.collection("Board").document("Names");

        // Source can be CACHE, SERVER, or DEFAULT.
        Source source = Source.CACHE;

        // Get the document, forcing the SDK to use the offline cache
        docRef.get(source).addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    // Document found in the offline cache
                    DocumentSnapshot document = task.getResult();
                    assert document != null;
                    Log.d("TAG", "Cached document data: " + document.getData());

                    position_name = document.getData();

                } else {
                    Log.d("TAG", "Cached get failed: ", task.getException());
                }
            }
        });

    }

    public Map<String, Object> getBoardMemberDetails(String name) {

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        DocumentReference docRef = db.collection("Board").document(name);

        // Source can be CACHE, SERVER, or DEFAULT.
        Source source = Source.CACHE;

        // Get the document, forcing the SDK to use the offline cache
        docRef.get(source).addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    // Document found in the offline cache
                    DocumentSnapshot document = task.getResult();
                    assert document != null;
                    Log.d("TAG", "Cached document data: " + document.getData());

                    member_details = document.getData();

                } else {
                    Log.d("TAG", "Cached get failed: ", task.getException());
                }
            }
        });

        return member_details;
    }

    public void getData() {

        ArrayList<String> board_members_list = new ArrayList<>();
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        DocumentReference docRef = db.collection("Board").document();
        docRef.get().

                addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        if (task.isSuccessful()) {
                            DocumentSnapshot document = task.getResult();
                            if (document != null) {

                            } else {
                                Log.d("LOGGER", "No such document");
                            }
                        } else {
                            Log.d("LOGGER", "get failed with ", task.getException());
                        }
                    }
                });
    }


}

