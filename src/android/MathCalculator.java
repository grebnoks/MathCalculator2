package cordova.plugin.mathcalculator;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaInterface;

import com.lexisnexis.risk.mobile.telematics.vanguardshared.settings.SdkSetting;
import com.lexisnexis.risk.mobile.telematics.vanguardshared.settings.SdkSettingUtil;
import com.lexisnexis.risk.mobile.telematics.vanguardshared.settings.SettingsValues;
import com.lexisnexis.risk.telematics.vanguard.sdk.VGDApiService;
import com.lexisnexis.risk.telematics.vanguard.sdk.VGDJourneyManager;
import com.lexisnexis.risk.telematics.vanguard.sdk.VGDSettingsManager;
import com.lexisnexis.risk.telematics.vanguard.sdk.VGDUserManager;
import com.lexisnexis.risk.telematics.vanguard.sdk.Vanguard;
import com.lexisnexis.risk.telematics.vanguard.sdk.enums.VGDJourneyStartType;
import com.lexisnexis.risk.telematics.vanguard.sdk.enums.VGDJourneyStopType;
import com.lexisnexis.risk.telematics.vanguard.sdk.errors.VGDError;
import com.lexisnexis.risk.telematics.vanguard.sdk.errors.VGDJourneyError;
import com.lexisnexis.risk.telematics.vanguard.sdk.interfaces.ICompleteListener;
import com.lexisnexis.risk.telematics.vanguard.sdk.interfaces.IVGDHttpCompleteListener;
import com.lexisnexis.risk.telematics.vanguard.sdk.interfaces.IVGDJourneyRecording;
import com.lexisnexis.risk.telematics.vanguard.sdk.interfaces.IVGDSettingsManager;
import com.lexisnexis.risk.telematics.vanguard.sdk.interfaces.IVGDUserManagerCompleteListener;
import com.lexisnexis.risk.telematics.vanguard.sdk.model.VGDHttpRequest;
import com.lexisnexis.risk.telematics.vanguard.sdk.model.VGDHttpResponse;
import com.lexisnexis.risk.telematics.vanguard.sdk.model.configurations.VGDConfigurationTripCollectionEnabled;
import com.wunelli.android.vanguard.dataobjects.VGDUser;
import com.wunelli.android.vanguard.logging.ServiceSendLogs;
import com.wunelli.android.vanguard.settings.SettingsUtils;
import com.wunelli.android.vanguard.webservicepojo.ResponseCode;
import com.wunelli.android.wunelliutilities.StringUtils;
import com.wunelli.android.wunelliutilities.WunelliResultReceiver;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;


/**
 * This class echoes a string called from JavaScript.
 */
public class MathCalculator extends CordovaPlugin {
    private static final String TAG = "mathcalculator";

    @Override
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        Log.d(TAG, "Initializing mathcalculator");
        super.initialize(cordova, webView);
        Vanguard vgd = new Vanguard(this).initialize(
                "CLIENT_KEY", new VGDManager.VGDInitializationListener() {
                    @Override
                    public void onInitializationError(VGDError error) {
                        Log.e(TAG, "there was an error.");
                        Log.e(error.message());
//                        Handle error here};});
                    }
                }
            )
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
        else if(action.equals("initializeVGD")) {
            this.initializeVGD(args, callbackContext);
            return true;
        }
        return false;
    }

    private void initializeVGD(JSONArray args, CallbackContext callback)
    {
        if(args != null)
        {
            try
            {
//                int p1 = Integer.parseInt(args.getJSONObject(0).getString("param1"));
//                int p2 = Integer.parseInt(args.getJSONObject(0).getString("param2"));
//
//                callback.success(""+ (p1+p2) );

            }catch(Exception ex)
            {
                callback.error("Something went wrong "  + ex);
            }
        }else
        {
            callback.error("Please donot pass null value");
        }
    }


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
