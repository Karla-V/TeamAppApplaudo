package karlavillavicencio.teamappapplaudo;

import android.app.Activity;
import android.app.Dialog;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.telecom.Connection;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
    // los arreglos contienen la latitud, longitud y el texto del marcador para cada estadio de futboll, deben estar en el mismo orden
    // segun la Team activity
    private double latitude[]=new double[]{
            51.5548885,
            53.430829482979604,
            53.48313810000001,
            51.481663,
            53.4630589,
            51.3983261,
            40.4530541
    };

    private double longitude[]=new double[]{
            -0.10843799999997827,
            -2.9608315229415894,
            -2.2003952999999683,
            -0.19095649999997022,
            -2.2913401000000704,
            -0.08659549999993033,
            -3.688344499999971
    };

    private String marker[]=new String[]{
            "Arsenal FC, Emirates Stadium",
            "Liverpool FC, Andfield",
            "Manchester City FC, Etihad Stadium",
            "Chelsea FC, Stamford Bridge",
            "Manchester United, Stamford Bridge",
            "Crystal Palace FC, Selhurst Park",
            "Real Madrid CF, Santiago Bernabeu"
    };


    private GoogleMap mMap;
    private int selectedTeam;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        //obtener la posicion en el arreglo del equipo seleccionado
        selectedTeam=(Integer)getIntent().getExtras().getSerializable("position");

        //validar servicios de google esten activos
        int status= GooglePlayServicesUtil.isGooglePlayServicesAvailable(getApplicationContext());
        if(status== ConnectionResult.SUCCESS)
        {
            // Obtain the SupportMapFragment and get notified when the map is ready to be used.
            SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.map);
            mapFragment.getMapAsync(this);
        }else {
            Dialog dialog =GooglePlayServicesUtil.getErrorDialog(status,(Activity)getApplicationContext(),10);
            dialog.show();
        }



    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        UiSettings uiSettings=mMap.getUiSettings();
        uiSettings.setZoomControlsEnabled(true);

        // Segun el equipo seleccionado se asigna la posicion y el texto para el marcador
        LatLng sydney = new LatLng(latitude[selectedTeam], longitude[selectedTeam]);
        mMap.addMarker(new MarkerOptions().position(sydney).title(marker[selectedTeam]));
        float zoomLevel=16;
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney,zoomLevel));
    }
}
