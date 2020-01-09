package cordova.plugin.raqmiyat.alert;

import android.app.AlertDialog;
import org.json.JSONObject;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;


//Main Java class which should inherit CordovaPlugin
public class CustomAlert extends CordovaPlugin{

    //action  which will come from js file on www folder
    public static final String ACTION_DISPLAY_ALERT = "network";

    //plugin function which will invoked when user call the plugin in ionic 
    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext){
     try{
            if(ACTION_DISPLAY_ALERT.equals(action)){
                //Connectivity managet to get the device network information
                ConnectivityManager conn = (ConnectivityManager) this.cordova.getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo info = conn.getActiveNetworkInfo();
                AlertDialog.Builder dialog = new AlertDialog.Builder(this.cordova.getActivity());

                //Check whether network connected or not
                if(info != null && info.isConnected()) {
                    dialog.setTitle("Network Connected");
                    dialog.setMessage("You are online now!");
                }else{
                    dialog.setTitle("No Network Access");
                    dialog.setMessage("Please check your network connection!");
                }

                //Alert button
                dialog.setPositiveButton("CLOSE", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int id) {
                        //do thing
                    }
                });

                //this will show alert dialog
                dialog.show();

                //success callback 
                callbackContext.success("success");
                return true;
            }else {
                //error callback
                callbackContext.error("Something went wrong!");
                return false;
            }
        }catch(Exception e){
            //error callback
            callbackContext.error(e.getMessage());
            return false;
        }
    }
}