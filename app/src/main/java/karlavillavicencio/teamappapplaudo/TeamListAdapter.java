package karlavillavicencio.teamappapplaudo;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
/**
 * Created by Karla Villavicencio on 1/12/2017.
 */

public class TeamListAdapter extends ArrayAdapter<String> {
    private final Activity context; //activity que contiene la lista
    private final String[] team;    //lista de equipos
    private final Integer[] image; // logotipos de equipo
    private final String[] address; //direccin del equipo

    public TeamListAdapter(Activity context, String[]team, Integer[] image,String[]address) {
        super(context, R.layout.list_element, team);
        this.context=context;
        this.team=team;
        this.image=image;
        this.address=address;
    }

    public View getView(int posicion,View view, ViewGroup parent){

        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.list_element,null,true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.teamName);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.logo);
        TextView txtDescripcion = (TextView) rowView.findViewById(R.id.teamAddress);

        txtTitle.setText(team[posicion]);
        imageView.setImageResource(image[posicion]);
        txtDescripcion.setText(address[posicion]);

        return rowView;
    }
}
