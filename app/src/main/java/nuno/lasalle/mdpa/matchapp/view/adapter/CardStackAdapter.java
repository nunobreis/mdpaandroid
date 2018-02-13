package nuno.lasalle.mdpa.matchapp.view.adapter;

import android.app.FragmentManager;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import nuno.lasalle.mdpa.matchapp.R;
import nuno.lasalle.mdpa.matchapp.model.User;

/**
 * Created by nunoreis on 12/02/2018.
 */

public class CardStackAdapter extends RecyclerView.Adapter<CardStackAdapter.ViewHolder>{

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        public TextView name;
        public TextView age;
        public TextView location;

        public ViewHolder(View itemView)
        {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.name);
            age = (TextView) itemView.findViewById(R.id.age);
            location = (TextView) itemView.findViewById(R.id.location);

        }
    }

    private final Context context;
    private List<User> values;
    private Integer lastPosition = -1;

    public CardStackAdapter(Context context, List<User> values) {
        this.context = context;
        this.values = values;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View contactView = inflater.inflate(R.layout.card_layout, parent, false);

        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        User user = values.get(position);

        holder.name.setText(user.getName() + ", " + Integer.toString(user.getAge()));
        holder.location.setText(user.getLocation());

    }

    @Override
    public int getItemCount() {
        return values.size();
    }

    public void setValues(List<User> values) {
        this.values = values;
    }

    @Override
    public void onViewDetachedFromWindow(ViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
        holder.itemView.clearAnimation();
    }

}
