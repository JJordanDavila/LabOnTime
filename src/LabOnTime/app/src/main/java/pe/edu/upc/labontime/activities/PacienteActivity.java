package pe.edu.upc.labontime.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import pe.edu.upc.labontime.fragments.paciente.ConfiguracionPacienteFragment;
import pe.edu.upc.labontime.fragments.paciente.HomePacienteFragment;
import pe.edu.upc.labontime.R;
import pe.edu.upc.labontime.fragments.paciente.ResultadoPacienteFragment;

public class PacienteActivity extends AppCompatActivity {



    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            return navigateAcordingTo(item.getItemId());
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paciente);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigateAcordingTo(R.id.navigation_home_paciente);
    }

    private Fragment getFragmentFor (int id){
        switch (id){
            case R.id.navigation_home_paciente:
                return  new HomePacienteFragment();
            case R.id.navigation_listaResultado_pacientes:
                return  new ResultadoPacienteFragment();
            case R.id.navigation_configuraciones_pacientes:
                return  new ConfiguracionPacienteFragment();

        }

        return  null;
    }

    private  boolean navigateAcordingTo(int id){
        try{
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.content,getFragmentFor(id))
                    .commit();
            return  true;
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return  false;
    }

}
