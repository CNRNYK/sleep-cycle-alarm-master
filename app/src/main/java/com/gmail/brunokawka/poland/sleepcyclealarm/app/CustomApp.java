package com.gmail.brunokawka.poland.sleepcyclealarm.app;

import android.app.Application;
import android.content.Context;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

import io.realm.Realm;
import sdk.pendo.io.*;



public class CustomApp extends Application {

    private static WeakReference<Context> contextWeakReference;

    @Override
    public void onCreate() {
        super.onCreate();
        Pendo.PendoInitParams pendoParams = new Pendo.PendoInitParams();
        int i = 0;
        String accountId = "My account name " + i;
        pendoParams.setVisitorId("New Visitor ID --> " + i++);
        pendoParams.setAccountId("Account name --> " + accountId);

//send Visitor Level Data
        Map<String, String> userData = new HashMap<>();
        userData.put("age", "27");
        userData.put("country", "USA");
        pendoParams.setUserData(userData);

//send Account Level Data
        Map<String, String> accountData = new HashMap<>();
        accountData.put("Tier", "1");
        accountData.put("Size", "Enterprise");
        pendoParams.setAccountData(accountData);


        Pendo.initSDK(
                this,
                "eyJhbGciOiJSUzI1NiIsImtpZCI6IiIsInR5cCI6IkpXVCJ9.eyJkYXRhY2VudGVyIjoidXMiLCJrZXkiOiI3M2QxZDE5MDk0M2Q0NWU3MDA0YjBiNjczYTc5NzU2NTRhNGJhMjRmYjg1MmQzNThmZDVjNzg4ZjdmMTBlMTk1MzJlNDYyNmZmMTA3MzVjMzg1YmM3OWY1MGRjYTNkY2MzMjE3NDgzYjYzY2IyYWMxNDA3YjdiNjQyODkwMzVjZGEwZjhiYWRmYmM2ZTFjNjUxOTQ1N2E2OTMwOTU5MzdiLmI0MDM2MzdlY2Q3ZDk2ZjViMTMyM2U4MGYyNDc0NzI2Ljc0MDM4MGUxMmJmNWFkYmU5MGEwMGQ4ZjVlYjgxN2Y1OGYwMzk1ODQ2ODY5MTA0ZWEyYzYzMjI0NTYyZjc2MWQifQ.pY_pG1eaF4GpiRBbe2vOKQSCVe-peiyjoO8XxedcNq-pAf05cQzDOKukF-dqf_Zu-P2swze7ZdlXFO1X2dMqxA8VUI2vxWX_xjctF1fIAPrGKnG-mwRI9z5BU5SWmAZlvZqituUMVndnsHXDpZ-b6uI1dUDrVM_WFD_Un0ASbvg", pendoParams);

        Realm.init(this);
        contextWeakReference = new WeakReference<>(getApplicationContext());
    }

    public static Context getContext() {
        return contextWeakReference.get();
    }
}
