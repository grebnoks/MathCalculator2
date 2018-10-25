package cordova.plugin.mathcalculator;

import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaInterface;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * This class echoes a string called from JavaScript.
 */
public class MathCalculator extends CordovaPlugin {
    private static final String TAG = "mathcalculator";

    @Override
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
        Log.d(TAG, "Initializing mathcalculator");
    }

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException
     {
        if(action.equals("add"))
        {
            this.add(args, callbackContext);
            return true;
        }
        else if(action.equals("substract")) {
            this.substract(args, callbackContext);
            return true;
        }
//        else if(action.equals("getDate")) {
//            //An example of returning data back to the web layer]
//            final PluginResult result = new PluginResult(PluginResult.Status.OK, (new Date()).toString());
//            callbackContent.sendPluginResult(result);
//        }
        return false;
    }

//   private void getDate()
//   {
//       if(){}
//   }

    private void add(JSONArray args, CallbackContext callback)
    {
        if(args != null)
        {
                try
                {
                     int p1 = Integer.parseInt(args.getJSONObject(0).getString("param1"));
                     int p2 = Integer.parseInt(args.getJSONObject(0).getString("param2"));
                       
                     callback.success(""+ (p1+p2) );
                          
                }catch(Exception ex)
                {
                    callback.error("Something went wrong "  + ex);
                }
        }else
        {
            callback.error("Please donot pass null value");
        }
    }


    private void substract(JSONArray args, CallbackContext callback)
    {
        if(args != null)
        {
                try
                {
                     int p1 = Integer.parseInt(args.getJSONObject(0).getString("param1"));
                     int p2 = Integer.parseInt(args.getJSONObject(0).getString("param2"));
                       
                     callback.success(""+ (p1-p2) );
                          
                }catch(Exception ex)
                {
                    callback.error("Something went wrong "  + ex);
                }
        }else
        {
            callback.error("Please donot pass null value");
        }
    }

}
