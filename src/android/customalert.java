package cordova.plugin.raqmiyat.alert;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import android.content.Context;
import android.net.NetworkInfo;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import org.json.JSONArray;


public class CustomAlert extends CordovaPlugin{

    public static final String ACTION_DISPLAY_ALERT = "displayAndroidAlert";

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext){
     try{
         if(ACTION_DISPLAY_ALERT.equals(action)){
             
                LayoutInflater inflater = this.cordova.getActivity().getLayoutInflater();
                int layout_dialog = this.cordova.getActivity().getResources().getIdentifier("my_dialog", "layout", this.cordova.getActivity().getPackageName());
                int layout_id = this.cordova.getActivity().getResources().getIdentifier("main_content", "id", this.cordova.getActivity().getPackageName());
                final View customLayout = inflater.inflate(layout_dialog, (ViewGroup) this.cordova.getActivity().findViewById(layout_id));
                int text_id = this.cordova.getActivity().getResources().getIdentifier("alert_title", "id", this.cordova.getActivity().getPackageName());
                TextView title = (TextView) this.cordova.getActivity().findViewById(text_id);
                int button_id = this.cordova.getActivity().getResources().getIdentifier("ok_button", "id", this.cordova.getActivity().getPackageName());

                ConnectivityManager conn = (ConnectivityManager) this.cordova.getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo info = conn.getActiveNetworkInfo();

                if(info != null && info.isConnected()) {    
            
                    title.setText("Network Connected. You have connected to the network!");        
                    final AlertDialog dialog = new AlertDialog.Builder(this.cordova.getActivity()).create();
                    dialog.setView(customLayout);
                    dialog.show();

                    Button ok_btn = (Button) customLayout.findViewById(button_id);
                        ok_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }
                    });

                    callbackContext.success("connected");
                    return true;
                }else{
                    title.setText("No Network Access. Please check your network connection!");  
                    final AlertDialog dialog = new AlertDialog.Builder(this.cordova.getActivity()).create();
                    dialog.setView(customLayout);
                    dialog.show();

                    Button ok_btn = (Button) customLayout.findViewById(button_id);
                        ok_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }
                    });
                    callbackContext.success("success");
                    return true;
                }
            }else {
                callbackContext.error("wrong method");
                return false;
            }
            }catch(Exception e){
         callbackContext.error(e.getMessage());
         return false;
     }
    }
}