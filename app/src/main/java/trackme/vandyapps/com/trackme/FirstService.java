package trackme.vandyapps.com.trackme;

import android.app.Service;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;

/**
 * Created by Sam on 10/2/2015.
 */
public class FirstService extends Service {

    private static String TAG = "";
    protected GoogleApiClient mGoogleApiClient;

    /**
     * Represents a geographical location.
     */
    protected Location mLastLocation;

    @Override
    public IBinder onBind(Intent arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void onStart(Intent intent, int startId) {
        // TODO Auto-generated method stub
        super.onStart(intent, startId);
        MainActivity2 main = new MainActivity2();
        main.startLocationUpdates();
       // MainActivity2.startLocationUpdates();
       // buildGoogleApiClient();
        //mGoogleApiClient.connect();


        final Handler handler = new Handler();
        while(true){
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                    Toast.makeText(getApplicationContext(),mLastLocation.getLatitude()+"",Toast.LENGTH_LONG).show();

            }
        }, 10000);
        }
        //this.stopSelf();
    }

}
