package karlavillavicencio.teamappapplaudo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class TeamActivity extends AppCompatActivity {
    private String team[]=new String[]{"Arsenal","Liverpool","ManchesterCity","Chelsea","ManchesterUnited", "Crystal Palace","RealMadrid"};

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

        TeamListAdapter adapter=new TeamListAdapter(this,team,image);
        teamList=(ListView)findViewById(R.id.teamList);
        teamList.setAdapter(adapter);
        teamList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem=team[+position];
                Toast.makeText(getApplicationContext(), selectedItem, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
