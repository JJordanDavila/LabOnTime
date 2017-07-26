package pe.edu.upc.labontime.adapters;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import pe.edu.upc.labontime.LabUpApp;
import pe.edu.upc.labontime.R;
import pe.edu.upc.labontime.activities.IconMedicoAnalisisActivity;
import pe.edu.upc.labontime.models.AnalisisMedico;


public class AnalisisMedicoAdapter extends RecyclerView.Adapter<AnalisisMedicoAdapter.ViewHolder>{

    public AnalisisMedicoAdapter setAnalisisMedicoAdapter(List<AnalisisMedico> analisisMedicos) {
        this.analisisMedicos = analisisMedicos;
        return this;
    }

    private List<AnalisisMedico> analisisMedicos;

    public AnalisisMedicoAdapter(List<AnalisisMedico> analisisMedicos) {
        this.analisisMedicos = analisisMedicos;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_analisis_medico, parent, false);
        return  new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.tipoAnalisisTextView.setText(analisisMedicos.get(position).getTipo_analisis());
        holder.nombrePacienteTextView.setText("Paciente:  "+ analisisMedicos.get(position).getNombres_paciente());
        holder.nombreLaboratorioTextView.setText("Laboratorio:  "+ analisisMedicos.get(position).getNombre_laboratorio());
        holder.nombreMedicoTextView.setText("Medico:  "+ analisisMedicos.get(position).getNombres_doctor());
        holder.analisisMedicoCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LabUpApp.getInstance().setCurrentAnalisisMedico(analisisMedicos.get(position));//0
                view.getContext().startActivity(new Intent(view.getContext(), IconMedicoAnalisisActivity.class));


                }
            });

    }

    @Override
    public int getItemCount() {
        return analisisMedicos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        //ConstraintLayout sourceConstraintLayout;
        CardView analisisMedicoCardView;
        TextView tipoAnalisisTextView;
        TextView nombrePacienteTextView;
        TextView nombreLaboratorioTextView;
        TextView nombreMedicoTextView;
        TextView motivoConsultaPacienteTextView;
        TextView resultadoAnalisisLaboratorioTextView;

        public ViewHolder(View itemView) {
            super(itemView);

            analisisMedicoCardView = (CardView) itemView.findViewById(R.id.analisisMedicoCardView);
            tipoAnalisisTextView = (TextView) itemView.findViewById(R.id.tipoAnalisisTextView);
            nombrePacienteTextView = (TextView) itemView.findViewById(R.id.nombrePacienteTextView);
            nombreLaboratorioTextView = (TextView) itemView.findViewById(R.id.nombreLaboratorioTextView);
            nombreMedicoTextView = (TextView) itemView.findViewById(R.id.nombreMedicoTextView);
            motivoConsultaPacienteTextView= (TextView) itemView.findViewById(R.id.motivoConsultaPacienteTextView);
            resultadoAnalisisLaboratorioTextView= (TextView) itemView.findViewById(R.id.resultadoAnalisisLaboratorioTextView);

        }
    }
}
