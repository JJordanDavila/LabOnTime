package pe.edu.upc.labontime.adapters;

import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import pe.edu.upc.labontime.R;
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
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tipoAnalisisTextView.setText(analisisMedicos.get(position).getTipo_analisis());
        holder.nombrePacienteTextView.setText(analisisMedicos.get(position).getNombres_paciente());
        holder.sourceConstraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //codigo para linkear a otro activity
            }
        });

    }

    @Override
    public int getItemCount() {
        return analisisMedicos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ConstraintLayout sourceConstraintLayout;
        TextView tipoAnalisisTextView;
        TextView nombrePacienteTextView;
        public ViewHolder(View itemView) {
            super(itemView);
            sourceConstraintLayout=(ConstraintLayout) itemView.findViewById(R.id.analisisMedicoConstraintLayout);
            //logoANImageView = (ANImageView) itemView.findViewById(R.id.logoANImageView);
            tipoAnalisisTextView = (TextView) itemView.findViewById(R.id.tipoAnalisisTextView);
            nombrePacienteTextView = (TextView) itemView.findViewById(R.id.nombrePacienteTextView);
        }
    }
}
