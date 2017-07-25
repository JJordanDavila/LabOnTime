package pe.edu.upc.labontime.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import pe.edu.upc.labontime.R;
import pe.edu.upc.labontime.models.User;
import pe.edu.upc.labontime.fragments.medico.ConfiguracionMedicoFragment;
import pe.edu.upc.labontime.fragments.medico.HomeMedicoFragment;
import pe.edu.upc.labontime.fragments.medico.ResultadoMedicoFragment;
import pe.edu.upc.labontime.fragments.paciente.ConfiguracionPacienteFragment;
import pe.edu.upc.labontime.fragments.paciente.HomePacienteFragment;
import pe.edu.upc.labontime.fragments.paciente.ResultadoPacienteFragment;

public class MedicoActivity extends AppCompatActivity {


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            return navigateAcordingTo(item.getItemId());
        }

    };
    User entityUser = new User();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medico);

        Bundle bundle = getIntent().getExtras();

        //WCB:Se recibe los datos de la entidad User
        entityUser.setId(bundle.getInt("id"));
        entityUser.setRoles_id(bundle.getInt("roles_id"));
        entityUser.setDescription(bundle.getString("description"));
        entityUser.setPersons_id(bundle.getInt("persons_id"));
        entityUser.setName(bundle.getString("name"));
        entityUser.setPassword(bundle.getString("password"));
        entityUser.setNames(bundle.getString("names"));
        entityUser.setLastnames(bundle.getString("lastnames"));
        entityUser.setAddress(bundle.getString("address"));
        entityUser.setPhone(bundle.getString("phone"));
        entityUser.setEmail(bundle.getString("email"));
        entityUser.setDocumentnumber(bundle.getString("documentnumber"));
        entityUser.setRuc(bundle.getString("ruc"));
        entityUser.setType(bundle.getString("type"));
        entityUser.setBussinessname(bundle.getString("bussinessname"));
        entityUser.setDoctornumber(bundle.getString("doctornumber"));
        entityUser.setSpeciality(bundle.getString("speciality"));


        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigateAcordingTo(R.id.navigation_home);
    }

    private Fragment getFragmentFor (int id){
        switch (id){
            case R.id.navigation_home:
                return  new HomeMedicoFragment();
            case R.id.navigation_listaResultado:
                return  new ResultadoMedicoFragment();
            case R.id.navigation_configuraciones:
                return  new ConfiguracionMedicoFragment();

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
