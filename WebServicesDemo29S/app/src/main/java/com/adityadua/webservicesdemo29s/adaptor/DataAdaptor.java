package com.adityadua.webservicesdemo29s.adaptor;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.adityadua.webservicesdemo29s.R;
import com.adityadua.webservicesdemo29s.model.DataHandler;

import java.util.List;

/**
 * Created by AdityaDua on 22/11/17.
 */

public class DataAdaptor extends RecyclerView.Adapter<DataAdaptor.ViewHolder> {


    Context context;
    List<DataHandler> data;
    ClickListener clickListener;

    public DataAdaptor(Context context, List<DataHandler> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.row,null);

        ViewHolder viewHolder = new ViewHolder(v);



        return viewHolder;

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        holder.name.setText(data.get(position).getName());
        //holder.order.setText(data.get(position).getOrder());
        holder.character.setText(data.get(position).getCharacter());

        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(clickListener !=null){
                    clickListener.itemClicked(v,position);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{


        TextView name,order,character;
        RelativeLayout relativeLayout;
        public ViewHolder(View itemView) {
            super(itemView);
            name = (TextView)itemView.findViewById(R.id.name);
            order = (TextView)itemView.findViewById(R.id.order);
            character = (TextView)itemView.findViewById(R.id.character);
            relativeLayout = (RelativeLayout)itemView.findViewById(R.id.rlayout);

        }
    }

    public interface ClickListener{
        void itemClicked(View v,int position);

    }

    public void setClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;
    }
}
