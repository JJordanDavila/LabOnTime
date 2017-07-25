package pe.edu.upc.labontime.fragments.paciente;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import pe.edu.upc.labontime.R;
import pe.edu.upc.labontime.models.User;


public class HomePacienteFragment extends Fragment {

    User entityUser = new User();
    TextView nombrePacienteTextView;
    TextView DNIPaTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_home_paciente, container, false);
        View myView = inflater.inflate(R.layout.fragment_home_paciente,container,false);

        Bundle bundle = getActivity().getIntent().getExtras();

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

        //Inicializar variable con nombre paciente

        nombrePacienteTextView = (TextView) myView.findViewById(R.id.nombrePacienteTextView);
        DNIPaTextView = (TextView) myView.findViewById(R.id.DNIPaTextView);

        nombrePacienteTextView.setText("Bienvenido:  " + entityUser.getNames() + " "+entityUser.getLastnames());
        DNIPaTextView.setText("Documento:  " + entityUser.getDocumentnumber());

        return  myView;
    }

}
