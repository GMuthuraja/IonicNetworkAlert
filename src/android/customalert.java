package cordova.plugin.raqmiyat.alert;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.widget.Toast;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;

public class CustomAlert extends CordovaPlugin{

    public static final String ACTION_DISPLAY_ALERT = "displayAndroidAlert";

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext){
     try{
         if(ACTION_DISPLAY_ALERT.equals(action)){
             ConnectivityManager conn = (ConnectivityManager) this.cordova.getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo info = conn.getActiveNetworkInfo();
                if(info != null && info.isConnected()) {
                    AlertDialog.Builder dialog = new AlertDialog.Builder(this.cordova.getActivity());
                    dialog.setTitle("Network Connected"));
                    dialog.setMessage("You have connected to the network!");
                    dialog.show();
                    callbackContext.success("success");
                     return true;
                }else{
                   AlertDialog.Builder dialog = new AlertDialog.Builder(this.cordova.getActivity());
                    dialog.setTitle("No Network Access"));
                    dialog.setMessage("Please check your network connection!");
                    dialog.show();
                    callbackContext.success("success");
                     return true;
                }
            }
        }
     catch(Exception e){
         callbackContext.error(e.getMessage());
         return false;
     }
    }
}