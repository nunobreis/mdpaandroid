package nuno.lasalle.mdpa.matchapp.view;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.arch.lifecycle.ViewModelProviders;

import java.util.ArrayList;

import nuno.lasalle.mdpa.matchapp.R;
import nuno.lasalle.mdpa.matchapp.model.User;
import nuno.lasalle.mdpa.matchapp.view.adapter.CardStackAdapter;
import nuno.lasalle.mdpa.matchapp.view.model.CardStackViewModel;

/**
 * Created by nunoreis on 07/02/2018.
 */

public class CardFragment extends Fragment {

    private CardStackViewModel cardStackViewModel;

    public static CardFragment newInstance() {
        CardFragment fragment = new CardFragment();
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        cardStackViewModel = ViewModelProviders.of(getActivity()).get(CardStackViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.card_fragment, container, false);

        setupRecyclerView(view);

        return view;

    }

    private void setupRecyclerView(View view) {
        RecyclerView userRecyclerView = (RecyclerView) view.findViewById(R.id.user_list);
        final CardStackAdapter cardstackAdapter = new CardStackAdapter(getContext(), new ArrayList<User>());
        userRecyclerView.setAdapter(cardstackAdapter);
        userRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        cardStackViewModel.getUserTitleList().observe(this, userTitleList -> {
            cardstackAdapter.setValues(userTitleList);
            cardstackAdapter.notifyDataSetChanged();
        });
    }
}
