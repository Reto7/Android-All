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

/**
 * https://socket.io/blog/native-socket-io-and-android/
 */
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

        JSONObject obj = new JSONObject();
        try {
            obj.put("username", "Jack Daniels");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        mSocket.emit("add_user", obj);

        Log.i(PROG, "gesendet");




//        send_action(player, field) {
//            socket.emit('player_action', {'player': player, 'field': field})
//        }

        mSocket.on("start_game", onStartGame);




    } // end on-create lifecycle


    //With this we listen on the new message event to receive messages from other users.
    private Emitter.Listener onStartGame = new Emitter.Listener() {
        @Override
        public void call(final Object... args) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Log.i(PROG, "****************** game started");
//                    JSONObject data = (JSONObject) args[0];
//                    Log.i(PROG, "******************" +data.toString());
//                    String username;
//                    String message;
//                    try {
//                        username = data.getString("username");
//                        message = data.getString("message");
//                    } catch (JSONException e) {
//                        return;
//                    }

                    // add the message to view
                    //addMessage(username, message);
                    //Log.i(PROG, "******************" +message);
                }
            });
        }
    };


}
