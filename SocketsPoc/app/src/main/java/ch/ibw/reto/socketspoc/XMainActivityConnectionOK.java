package ch.ibw.reto.socketspoc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;


import org.json.JSONException;
import org.json.JSONObject;

import java.net.URISyntaxException;

import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;

// neue variante mit https://github.com/socketio/socket.io-client-java


public class XMainActivityConnectionOK extends AppCompatActivity {


    private static final String PROG = "*********Sockets";


   //"http://localhost:3100");
   Socket socket = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i(PROG,"ready...");


        try {
            socket = IO.socket("http://192.168.1.39:3100");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        socket.on(Socket.EVENT_CONNECT, new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                Log.i(PROG,"ready 2...");
                socket.emit("foo", "hi");
                socket.disconnect();
            }

        }).on("event", new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                Log.i(PROG,"ready 3...");
            }

        }).on(Socket.EVENT_DISCONNECT, new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                Log.i(PROG,"ready 4...");
            }

        });
        Log.i(PROG,"ready 5...");
        socket.connect();
        Log.i(PROG,"socket id : " + socket.id());
        socket.emit("test", "kuckuck");

        // Sending an object
        JSONObject obj = new JSONObject();
        try {
            obj.put("username", "Jack Daniels");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        socket.emit("add_user", obj);
        //socket.io().emit("add_user", obj);

//    // Receiving an object
//    socket.on("foo", new Emitter.Listener() {
//            @Override
//            public void call(Object... args) {
//                JSONObject obj = (JSONObject)args[0];
//            }
//        });


    }
}
