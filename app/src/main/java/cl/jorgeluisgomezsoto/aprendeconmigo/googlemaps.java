package cl.jorgeluisgomezsoto.aprendeconmigo;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import cl.jorgeluisgomezsoto.aprendeconmigo.databinding.ActivityGooglemapsBinding;

public class googlemaps extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityGooglemapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityGooglemapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
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

        // Add a marker in Sydney and move the camera
        LatLng Semilla = new LatLng(-36.603253517634386, -72.10603799675023);
        LatLng Chillan = new LatLng(-36.60649578903192, -72.1033331018263);
        LatLng Carrusel = new LatLng(-36.60126688088297, -72.09394163486867);
        LatLng Tortuguita = new LatLng(-36.60362475105181, -72.101619690124 );
        LatLng Chinitas = new LatLng(-36.609716760048414, -72.10880186958349);

        mMap.addMarker(new MarkerOptions().position(Semilla).title("Jardín Infantil Semilla"));
        mMap.addMarker(new MarkerOptions().position(Carrusel).title("Jardín Infantinl Carrusel"));
        mMap.addMarker(new MarkerOptions().position(Tortuguita).title("Jardín Infantil Tortuguita"));
        mMap.addMarker(new MarkerOptions().position(Chinitas).title("Jardín Infantil Chinitas"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Chillan,14f));
    }
}