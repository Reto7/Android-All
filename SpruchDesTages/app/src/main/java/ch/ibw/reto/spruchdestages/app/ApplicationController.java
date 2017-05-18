package ch.ibw.reto.spruchdestages.app;

import android.app.Application;
import android.text.TextUtils;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/*
 * Application ist die Basisklasse aller Applikationen
 * wir benoetigen auch 'com.mcxiaoke.volley:library:1.0.+' in /home/rk/AndroidStudioProjects/SpruchDesTages/app/build.gradle
 * wir benoetigen auch android:name=".app.ApplicationController" im Manifest
 * wir benoetigen auch <uses-permission android:name="android.permission.INTERNET" /> im Manifest
 */

public class ApplicationController extends Application {

    private static ApplicationController instance;   //Singleton: Es kann/darf nur 1 Instanz geben
    private RequestQueue requestqueue;
    public static final String TAG = "ApplicationController";

    // constructor wegen singleton (wir instanzieren aber ja nicht selber!)
    public static synchronized ApplicationController getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }


    public RequestQueue getRequestQueue(){
        if (requestqueue == null) {
            requestqueue = Volley.newRequestQueue(getApplicationContext());
        }
        return requestqueue;
    }

    public <T> void addToRequestQueue(Request<T> req, String tag){
        req.setTag(TextUtils.isEmpty(tag) ? TAG : tag);  // 1. den Parameter Tag, falls null dann die Konstante
        getRequestQueue().add(req);
    }

    public <T> void addToRequestQueue(Request<T> req){
        req.setTag(TAG);
        getRequestQueue().add(req);
    }

    public void cancelPendingRequests(String tag){
        if (requestqueue!= null) {
            requestqueue.cancelAll(tag);
        }
    }
}
