package nuno.lasalle.mdpa.matchapp.view;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import nuno.lasalle.mdpa.matchapp.R;

/**
 * Created by nunoreis on 07/02/2018.
 */

public class ChatFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.chat_fragment, container, false);
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
