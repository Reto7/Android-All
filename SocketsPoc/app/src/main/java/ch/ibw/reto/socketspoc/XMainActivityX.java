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


public class XMainActivityX extends AppCompatActivity {


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

        Log.i(PROG,"ready...");

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

        mSocket.emit("add_user","hallo");
        Log.i(PROG, "gesendet");
    }



    //With this we listen on the new message event to receive messages from other users.
    private Emitter.Listener onNewMessage = new Emitter.Listener() {
        @Override
        public void call(final Object... args) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    JSONObject data = (JSONObject) args[0];
                    Log.i(PROG, "******************" +data.toString());
                    String username;
                    String message;
                    try {
                        username = data.getString("username");
                        message = data.getString("message");
                    } catch (JSONException e) {
                        return;
                    }

                    // add the message to view
                    //addMessage(username, message);
                    Log.i(PROG, "******************" +message);
                }
            });
        }
    };
}
