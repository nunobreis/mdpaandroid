package nuno.lasalle.mdpa.matchapp.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.app.FragmentManager;
import android.widget.ImageView;

import java.util.List;

import nuno.lasalle.mdpa.matchapp.R;
import nuno.lasalle.mdpa.matchapp.model.Chat;

/**
 * Created by nunoreis on 12/02/2018.
 */

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ViewHolder> {

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView author;
        public TextView date;
        public TextView content;
//        public ImageView profilePicture;

        public ViewHolder(View itemView) {
            super(itemView);

            author = (TextView) itemView.findViewById(R.id.author);
            date = (TextView) itemView.findViewById(R.id.date);
            content = (TextView) itemView.findViewById(R.id.content);

        }
    }

    private final Context context;
    private List<Chat> values;
    private Integer lastPosition = -1;

    public ChatAdapter(Context context, List<Chat> values) {
        this.context = context;
        this.values = values;
    }

    @Override
    public ChatAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View chatView = inflater.inflate(R.layout.chat_layout, parent, false);

        ChatAdapter.ViewHolder viewHolder = new ChatAdapter.ViewHolder(chatView);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(ChatAdapter.ViewHolder holder, int position) {
        Chat chat = values.get(position);

        //   holder.profilePicture.setImageResource(Integer.parseInt(user.getProfilePicture()));
        holder.author.setText(chat.getName());
        holder.content.setText(chat.getContent());
        holder.date.setText(chat.getDate());
    }

    @Override
    public int getItemCount() {
        return values.size();
    }

    public void setValues(List<Chat> values) {
        this.values = values;
    }

    @Override
    public void onViewDetachedFromWindow(ChatAdapter.ViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
        holder.itemView.clearAnimation();
    }

}