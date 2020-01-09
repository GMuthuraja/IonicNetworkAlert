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

    public static final String ACTION_CHECK_NETWORK = "displayNetStatus";

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext){
        try{
            if(ACTION_CHECK_NETWORK.equals(action)){
                ConnectivityManager conn = (ConnectivityManager) this.cordova.getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo info = conn.getActiveNetworkInfo();
                if(info != null && info.isConnected()) {
                    callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK,"Internet Connected"));
                }
                else{
                    callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK,"Internet not Connected"));
                }
                return true;
            }
            else{
                callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.NO_RESULT,"Invalid Action"));
                return false;
            }
        }
        catch(Exception e){
            callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.NO_RESULT,e.getMessage()));
            return false;
        }
    }
}