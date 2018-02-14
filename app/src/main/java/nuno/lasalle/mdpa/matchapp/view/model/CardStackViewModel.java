package nuno.lasalle.mdpa.matchapp.view.model;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.res.Resources;

import java.util.List;

import nuno.lasalle.mdpa.matchapp.manager.CardStackManager;
import nuno.lasalle.mdpa.matchapp.model.User;

/**
 * Created by nunoreis on 12/02/2018.
 */

public class CardStackViewModel extends ViewModel {

    private CardStackManager cardStackManager = new CardStackManager();

    private MutableLiveData<List<User>> userTitleList;

    public void setResources(Resources resources) { cardStackManager.setResources(resources); }

    public LiveData<List<User>> getUserTitleList() {
        if(userTitleList == null) {
            userTitleList = new MutableLiveData<>();
            populateUserList();
        }

        return userTitleList;
    }

    private void populateUserList() {
        List<User> userList = cardStackManager.getUsersList();
        userTitleList.setValue(userList);
    }

}
