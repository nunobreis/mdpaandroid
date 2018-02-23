package nuno.lasalle.mdpa.matchapp.view;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import java.util.ArrayList;

import nuno.lasalle.mdpa.matchapp.R;
import nuno.lasalle.mdpa.matchapp.model.Chat;
import nuno.lasalle.mdpa.matchapp.model.User;
import nuno.lasalle.mdpa.matchapp.view.adapter.CardStackAdapter;
import nuno.lasalle.mdpa.matchapp.view.adapter.ChatAdapter;
import nuno.lasalle.mdpa.matchapp.view.model.CardStackViewModel;
import nuno.lasalle.mdpa.matchapp.view.model.ChatViewModel;

/**
 * Created by nunoreis on 07/02/2018.
 */

public class ChatFragment extends Fragment {

    private ChatViewModel chatViewModel;

    public static ChatFragment newInstance() {
        ChatFragment fragment = new ChatFragment();
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        chatViewModel = ViewModelProviders.of(getActivity()).get(ChatViewModel.class);
        chatViewModel.setResources(getResources());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.chat_fragment, container, false);

        setupRecyclerView(view);

        return view;

    }

    private void setupRecyclerView(View view) {
        RecyclerView chatRecyclerView = (RecyclerView) view.findViewById(R.id.chat_list);
        final ChatAdapter chatAdapter = new ChatAdapter(getContext(), new ArrayList<Chat>());
        chatRecyclerView.setAdapter(chatAdapter);
        chatRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));

        chatViewModel.getChatTitleList().observe(this, chatTitleList -> {
            chatAdapter.setValues(chatTitleList);
            chatAdapter.notifyDataSetChanged();
        });
    }
}
