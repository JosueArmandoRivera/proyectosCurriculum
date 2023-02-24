package org.dsm.serviciosandroidstudio;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class MyService extends Service {
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
    //Es como el oncreate()

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "Se inició myService", Toast.LENGTH_SHORT).show();
        return START_STICKY;
        //Es para que lo reinicie nuevamente si se cierra el sistema
        //Se destruye también si se cierra la app
    }
    @Override
    public void onDestroy() {
        Toast.makeText(this, "myService fue Destruido/Parado", Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }



}