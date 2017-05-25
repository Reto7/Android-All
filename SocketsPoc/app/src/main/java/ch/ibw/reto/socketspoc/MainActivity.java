package ch.ibw.reto.socketspoc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.github.nkzawa.emitter.Emitter;
import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.URISyntaxException;


public class MainActivity extends AppCompatActivity {


    private static final String PROG = "*********Sockets";


    private Socket mSocket;
    {
        try {
            Log.i(PROG, "socking...");
            mSocket = IO.socket("http://192.168.1.39:3100");
        } catch (URISyntaxException e) {}
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i(PROG,"los gehts ...");

        // listening on socket events
        //mSocket.on("chat", onNewMessage);

        mSocket.connect();
        Log.i(PROG, mSocket.toString());

        // username senden

//        JSONObject obj = new JSONObject();
//        try {
//            obj.put("username", "Jack Daniels");
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//        mSocket.emit("add_user", obj);

        mSocket.emit("test","hallo");
        mSocket.emit("add_user","hallo");
        Log.i(PROG, "gesendet");
    }



}
