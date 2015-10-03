package trackme.vandyapps.com.trackme;

import android.support.v4.app.NotificationCompat;

        import android.app.IntentService;
        import android.app.NotificationManager;
        import android.content.Intent;
        import android.location.Location;
        import android.support.v4.app.NotificationCompat;
        import android.support.v4.app.NotificationCompat.Builder;
        import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.FusedLocationProviderApi;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;

import java.util.Arrays;

public class LocationService extends IntentService {

    private String TAG = this.getClass().getSimpleName();
    public LocationService() {
        super("trackme.vandyapps.com.trackme.LocationService");
    }

    public LocationService(String name) {
        super("Fused Location");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        //Location location = Location.extractResult(intent);

        Location location = intent.getParcelableExtra(FusedLocationProviderApi.KEY_LOCATION_CHANGED);

        Log.e("started",location.getLatitude()+"");
        Log.e("started",location.getLongitude()+"");
        MainActivity2.user.add("Lat", Arrays.asList(location.getLatitude()));
        MainActivity2.user.add("Longitude", Arrays.asList(location.getLongitude()));
        MainActivity2.user.saveInBackground();

        //Toast.makeText(getApplicationContext(),"hey",Toast.LENGTH_LONG).show();

        if(location !=null){
            Log.i(TAG, "onHandleIntent " + location.getLatitude() + "," + location.getLongitude());
            NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            Builder noti = new NotificationCompat.Builder(this);
            noti.setContentTitle("Fused Location");
            noti.setContentText(location.getLatitude() + "," + location.getLongitude());
            noti.setSmallIcon(R.drawable.ic_launcher);

            notificationManager.notify(1234, noti.build());


        }

    }

}
