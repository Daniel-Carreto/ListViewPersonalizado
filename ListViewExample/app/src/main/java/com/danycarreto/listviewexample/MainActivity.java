package com.danycarreto.listviewexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.danycarreto.listviewexample.adapter.PeliculaAdapter;
import com.danycarreto.listviewexample.model.Pelicula;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listViewPeliculas;
    private ArrayList<Pelicula> peliculas;
    private PeliculaAdapter peliculaAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listViewPeliculas = (ListView) findViewById(R.id.listViewPeliculas);
        peliculas = new ArrayList<Pelicula>();
        peliculas.add(new Pelicula("Inception", "Christopher Nolan"));
        peliculas.add(new Pelicula("The Dark Knight", "Christopher Nolan"));
        peliculas.add(new Pelicula("Memento", "Christopher Nolan"));

        peliculaAdapter = new PeliculaAdapter(this, peliculas);

        listViewPeliculas.setAdapter(peliculaAdapter);
        listViewPeliculas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(), "Elemento: " + peliculas.get(position).getTitulo(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
