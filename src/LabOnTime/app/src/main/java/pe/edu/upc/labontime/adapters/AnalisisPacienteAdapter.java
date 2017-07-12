package pe.edu.upc.labontime.adapters;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import pe.edu.upc.labontime.R;
import pe.edu.upc.labontime.activities.IconPacienteAnalisisActivity;
import pe.edu.upc.labontime.activities.MainActivity;
import pe.edu.upc.labontime.activities.MedicoActivity;
import pe.edu.upc.labontime.beans.AnalisisPacienteBean;

public class AnalisisPacienteAdapter extends RecyclerView.Adapter<AnalisisPacienteAdapter.ViewHolder> {

    List<AnalisisPacienteBean> analisispaciente;
    public void setAnalisispaciente(List<AnalisisPacienteBean> analisispaciente) { this.analisispaciente = analisispaciente; }

    @Override
    public AnalisisPacienteAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_analisis_pacientes,parent,false);
        return  new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AnalisisPacienteAdapter.ViewHolder holder, final int position) {
        holder.nameTextView.setText(analisispaciente.get(position).getNombreAnalisis());
        holder.pictureImageView.setImageResource(analisispaciente.get(position).getPictureId());
        holder.titleTextView.setText(analisispaciente.get(position).getDescripcionAnalisis());
        holder.companyTextView.setText(analisispaciente.get(position).getLaboratorio());
        holder.personCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putInt("currentPosition", position);
                Intent iconIntent = new Intent(view.getContext(), IconPacienteAnalisisActivity.class);
                iconIntent.putExtras(bundle);
                view.getContext().startActivity(iconIntent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return analisispaciente.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CardView personCardView;
        ImageView pictureImageView;
        TextView nameTextView;
        TextView titleTextView;
        TextView companyTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            personCardView = (CardView) itemView.findViewById(R.id.personCardView);
            pictureImageView = (ImageView) itemView.findViewById(R.id.pictureImageView);
            nameTextView = (TextView) itemView.findViewById(R.id.nameTextView);
            titleTextView = (TextView) itemView.findViewById(R.id.titleTextView);
            companyTextView = (TextView) itemView.findViewById(R.id.companyTextView);
        }
    }


}
