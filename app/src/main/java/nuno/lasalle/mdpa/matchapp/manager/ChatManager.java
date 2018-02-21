package nuno.lasalle.mdpa.matchapp.manager;

import android.content.res.Resources;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import nuno.lasalle.mdpa.matchapp.R;
import nuno.lasalle.mdpa.matchapp.model.Chat;
import nuno.lasalle.mdpa.matchapp.model.User;

/**
 * Created by nunoreis on 21/02/2018.
 */

public class ChatManager {

    private List<Chat> messagesList;

    private Resources resources;

    public ChatManager() {
        fillChatListFromFile();
    }

    public List<Chat> getUsersList() {
        return messagesList;
    }


    public void setResources(Resources resources) {
        this.resources = resources;
        fillChatListFromFile();
    }

    private void fillChatListFromFile() {
        try {
            String jsonContent = readJsonFile(R.raw.chat);
            if(jsonContent.isEmpty()) {
                return;
            }

            messagesList = new ArrayList<Chat>();
            JSONArray jsonArray = new JSONArray(jsonContent);
            for(int index = 0; index < jsonArray.length(); ++index)
            {
                JSONObject jsonObject = jsonArray.getJSONObject(index);
                String profilePicture = jsonObject.getString("url");
                String name = jsonObject.getString("name");
                String date = jsonObject.getString("date");
                String content = jsonObject.getString("content");

                messagesList.add(new Chat(profilePicture, name, date, content));
            }
        }
        catch (Exception e) {
            Log.e(this.getClass().getName(), e.getMessage());
        }
    }


    private String readJsonFile(int file) {
        InputStream is = resources.openRawResource(file);
        Writer writer = new StringWriter();
        char[] buffer = new char[1024];
        try {
            Reader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            int n;
            while ((n = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, n);
            }
        }
        catch (Exception e) {
            Log.e(this.getClass().getName(), e.getMessage());
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                Log.e(this.getClass().getName(), e.getMessage());
            }
        }

        String jsonString = writer.toString();
        return jsonString;
    }
}
