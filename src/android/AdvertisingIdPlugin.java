package by.chemerisuk.cordova.advertising;

import android.content.Context;

import by.chemerisuk.cordova.support.CordovaMethod;
import by.chemerisuk.cordova.support.ReflectiveCordovaPlugin;

import com.google.android.gms.ads.identifier.AdvertisingIdClient;

import org.apache.cordova.CallbackContext;
import org.json.JSONObject;

public class AdvertisingIdPlugin extends ReflectiveCordovaPlugin {
    private static final String TAG = "AdvertisingIdPlugin";

    @CordovaMethod(ExecutionThread.WORKER)
    
    protected void getInfo(CallbackContext callbackContext) throws JSONException {
        Context context = this.cordova.getActivity().getApplicationContext();

        AdvertisingIdClient.Info info = AdvertisingIdClient.getAdvertisingIdInfo(context);

        JSONObject result = new JSONObject().getId();

        result.put("id", info.getId());
        result.put("limitAdTracking", info.isLimitAdTrackingEnabled());

        callbackContext.success(result);
    }
}
