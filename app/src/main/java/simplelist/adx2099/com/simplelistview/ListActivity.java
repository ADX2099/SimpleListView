package simplelist.adx2099.com.simplelistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {
    private ListView listView;
    private List<String> names;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView)findViewById(R.id.listview);
        //datos a mostrar
        names = new ArrayList<String>();
        names.add("Alejandro");
        names.add("Fernando");
        names.add("Adrian");
        names.add("Santiago");
        names.add("Alejandro");
        names.add("Fernando");
        names.add("Adrian");
        names.add("Santiago");
        //Forma visual en que mostraremos los datos, casi nunca se use con array adapter
        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, names);
        //Enlazamos el adaptador con nuestro listview
        //listView.setAdapter(adapter);


        //Enlazamos con nuestro adaptador personalizado
       MyAdapter myAdapter = new MyAdapter(this, R.layout.list_item, names);
       listView.setAdapter(myAdapter);
       listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(ListActivity.this, "clickeado" + names.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }
}

