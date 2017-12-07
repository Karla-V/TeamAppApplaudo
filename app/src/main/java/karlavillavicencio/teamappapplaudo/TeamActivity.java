package karlavillavicencio.teamappapplaudo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class TeamActivity extends AppCompatActivity {
    private String team[]=new String[]{"Arsenal","Liverpool","ManchesterCity","Chelsea","ManchesterUnited", "Crystal Palace","RealMadrid"};
    private  String address[]= new  String[]{"Holloway, Londres,Inglaterra","Liverpool, Inglaterra","Mánchester, Inglaterra ","Fulham, Londres"," Mánchester, Inglaterra","Sur de la ciudad de Londres, Inglaterra","Madrid, España"};
    private Integer image[] = {
            R.drawable.arsenal,
            R.drawable.liverpool,
            R.drawable.manchester_city,
            R.drawable.chelsea,
            R.drawable.manchester_united,
            R.drawable.crystal_palace,
            R.drawable.real_madrid
    };

    private ListView teamList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);
        setTitle("Team List");
        //inicializar el adaptador de la lista
        TeamListAdapter adapter=new TeamListAdapter(this,team,image,address);
        teamList=(ListView)findViewById(R.id.teamList);
        teamList.setAdapter(adapter);
        teamList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               //obtener la informacion del equipo seleccionado y enviarla al siguiente activity
                String selectedItem=team[+position];
                TeamClass info=new TeamClass();
                info.name=selectedItem;
                info.position=position;
                Intent intent=new Intent(TeamActivity.this,DetailActivity.class);
                intent.putExtra("info",info);
                startActivity(intent);

               // Toast.makeText(getApplicationContext(), selectedItem, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
