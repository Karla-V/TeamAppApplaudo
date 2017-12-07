package karlavillavicencio.teamappapplaudo;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;



public class DetailActivity extends YouTubeBaseActivity {
    //para que funcione los arreglos deben estar en el mismo orden que en la TeamActivity

    //contiene las descripciones de los equipos
    private String description[]=new String[]{"Juega en la máxima categoría del fútbol de ese país, la Premier League. Uno de los más laureados del fútbol inglés, ha ganado 43 títulos en su país, incluyendo 13 campeonatos de liga y un récord de 13 Copas de Inglaterra; también ha ganado dos títulos internacionales",
    "Es el club inglés con mayor número de títulos internacionales, con cinco Copas de Europa, tres Copas de la UEFA y tres Supercopas de Europa. A nivel nacional, ha ganado dieciocho títulos de liga, siete FA Cups, ocho Copas de la Liga —siendo el equipo que más ha ganado dicha competición— y quince Community Shields, sumando más de sesenta títulos oficiales.",
    "Fue fundado en 1880 bajo el nombre de St. Mark's (West Gorton), luego pasó a llamarse Ardwick Association Football Club en 1887 y finalmente, el 13 de abril de 1894, se convirtió en el Manchester City.",
    "Fundado el 10 de marzo de 1905, el club se mantuvo la mayor parte de su historia en la máxima categoría del fútbol británico. Su estadio es el Stamford Bridge, el cual tiene una capacidad para 41 837 espectadores",
    "A nivel nacional Manchester United ha obtenido un récord de 20 títulos de liga, 12 FA Cup y 20 Supercopas de Inglaterra. A lo anterior se suman 3 Copas de Europa, una Recopa de Europa, una Copa de la UEFA, una Copa Intercontinental y una Copa Mundial de Clubes de la FIFA",
    "Durante la temporada 2012-13 de la Football League Championship (Segunda División Del Fútbol Inglés), el Palace terminó quinto y ganó el ascenso a la Premier League a través de los play-offs.",
    "Es una de las entidades más laureadas y reconocidas del mundo en ambas disciplinas, y ha sido galardonado a nivel futbolístico nacional e internacional por la FIFA como el Mejor Club del siglo xx, y como el Mejor Club Europeo y Mundial del siglo xx por la Federación Internacional de Historia y Estadística de Fútbol (IFFHS)"
    };
    //contiene las imagenes de los logos de cada equipo
    private Integer image[] = {
            R.drawable.arsenal,
            R.drawable.liverpool,
            R.drawable.manchester_city,
            R.drawable.chelsea,
            R.drawable.manchester_united,
            R.drawable.crystal_palace,
            R.drawable.real_madrid
    };
    //contiene parte de la url del video para que pueda ser encontrado y mostrado en la app
    private  String video[]={
            "oRNjTug7bnA",
            "r5PpG2pmWDc",
            "R3DCV-KX0_U",
            "TE1ZoBI1qj4",
            "kkx499fmH0g",
            "AUnWAL-ty4U",
            "uhpzKrRmz0c"
    };

    //declaracion de variables
    TeamClass info = new TeamClass();
    YouTubePlayerView videoPlayerView;
    YouTubePlayer.OnInitializedListener listener;
    Button btnUbicacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        //obtener los parametros de la activity anterior
        info=(TeamClass)getIntent().getExtras().getSerializable("info");

        //incializacion de las variables y asociacion con el layout
        ImageView imageView = (ImageView) findViewById(R.id.logo);
        TextView txtTeam = (TextView) findViewById(R.id.txtTeam);
        TextView txtDescription=(TextView)findViewById(R.id.txtDescription);
        videoPlayerView=(YouTubePlayerView) findViewById(R.id.videoPlayerView);
        btnUbicacion=(Button)findViewById(R.id.btnMap);

        //asignacion de la informacion a cada elemento del layout
        Log.d("nombre",info.name);
        Log.d("posicion", String.valueOf(info.position));
        txtTeam.setText(info.name);
        txtDescription.setText(description[info.position]);
        txtDescription.setMovementMethod(new ScrollingMovementMethod());
        imageView.setImageResource(image[info.position]);

        //Inicializar y mostrar el video de youtube
        listener=new YouTubePlayer.OnInitializedListener(){

            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b)
            {
                youTubePlayer.loadVideo(video[info.position]);
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult)
            {

            }
        };

        videoPlayerView.initialize(VideoPlayerConfig.API_KEY, listener);


        btnUbicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent =new Intent(DetailActivity.this,MapsActivity.class);
                intent.putExtra("position",info.position);
                startActivity(intent);
            }
        });


    }




}
