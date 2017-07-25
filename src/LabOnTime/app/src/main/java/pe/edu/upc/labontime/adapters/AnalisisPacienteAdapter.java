package pe.edu.upc.labontime.adapters;


import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import pe.edu.upc.labontime.R;
import pe.edu.upc.labontime.models.AnalisisPaciente;

public class AnalisisPacienteAdapter extends RecyclerView.Adapter<AnalisisPacienteAdapter.ViewHolder> {

    public AnalisisPacienteAdapter AnalisisPacienteAdapter(List<AnalisisPaciente> analisisPacientes) {
        this.analisisPacientes = analisisPacientes;
        return this;
    }

    private List<AnalisisPaciente> analisisPacientes;

    public AnalisisPacienteAdapter(List<AnalisisPaciente> analisisPacientes) {
        this.analisisPacientes = analisisPacientes;
    }

    @Override
    public AnalisisPacienteAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_analisis_pacientes,parent,false);
        return  new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AnalisisPacienteAdapter.ViewHolder holder, final int position) {
        holder.tipoAnalisisPaTextView.setText(analisisPacientes.get(position).getTipo_analisis());
        holder.nombrePacientePaTextView.setText("Paciente:  "+ analisisPacientes.get(position).getNombres_paciente());
        holder.nombreLaboratorioPaTextView.setText("Laboratorio:  "+ analisisPacientes.get(position).getNombre_laboratorio());
        holder.nombreMedicoPaTextView.setText("Medico:  "+ analisisPacientes.get(position).getNombres_doctor());

    }

    @Override
    public int getItemCount() {
        return analisisPacientes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        //CardView personCardView;
        CardView analisisPacienteCardView;
        TextView tipoAnalisisPaTextView;
        TextView nombrePacientePaTextView;
        TextView nombreLaboratorioPaTextView;
        TextView nombreMedicoPaTextView;
        TextView motivoConsultaPacientePaTextView;
        TextView resultadoAnalisisLaboratorioPaTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            analisisPacienteCardView = (CardView) itemView.findViewById(R.id.analisisPacienteCardView);
            tipoAnalisisPaTextView = (TextView) itemView.findViewById(R.id.tipoAnalisisPaTextView);
            nombrePacientePaTextView = (TextView) itemView.findViewById(R.id.nombrePacientePaTextView);
            nombreLaboratorioPaTextView = (TextView) itemView.findViewById(R.id.nombreLaboratorioPaTextView);
            nombreMedicoPaTextView = (TextView) itemView.findViewById(R.id.nombreMedicoPaTextView);
           // motivoConsultaPacientePaTextView= (TextView) itemView.findViewById(R.id.motivoConsultaPacientePaTextView);
           // resultadoAnalisisLaboratorioPaTextView= (TextView) itemView.findViewById(R.id.resultadoAnalisisLaboratorioPaTextView);
        }
    }


}
