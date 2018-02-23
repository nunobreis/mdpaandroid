package nuno.lasalle.mdpa.matchapp.view.model;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.res.Resources;

import java.util.List;

import nuno.lasalle.mdpa.matchapp.manager.ChatManager;
import nuno.lasalle.mdpa.matchapp.model.Chat;

/**
 * Created by nunoreis on 21/02/2018.
 */

public class ChatViewModel extends ViewModel {

    private ChatManager chatManger = new ChatManager();

    private MutableLiveData<List<Chat>> chatTitleList;

    public void setResources(Resources resources) { chatManger.setResources(resources); }

    public LiveData<List<Chat>> getChatTitleList() {
        if(chatTitleList == null) {
            chatTitleList = new MutableLiveData<>();
            chatChatList();
        }

        return chatTitleList;
    }

    private void chatChatList() {

        List<Chat> chatList = chatManger.getUsersList();
        chatTitleList.setValue(chatList);
    }
}
