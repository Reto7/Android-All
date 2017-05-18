package ch.ibw.reto.spruchdestages;

import android.app.Application;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/*
 * Application ist die Basisklasse aller Applikationen
 * wir benoetigen auch 'com.mcxiaoke.volley:library:1.0.+' in /home/rk/AndroidStudioProjects/SpruchDesTages/app/build.gradle
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

    public <T> void addToRequestQueue(Request<T> req){
        req.setTag(TAG);
        getRequestQueue().add(req);
    }

    public void cancelPendingRequests(Object tag){
        if (requestqueue!= null) {
            requestqueue.cancelAll(tag);
        }
    }
}
