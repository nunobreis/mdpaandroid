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
import nuno.lasalle.mdpa.matchapp.model.User;

/**
 * Created by nunoreis on 13/02/2018.
 */

public class CardStackManager {

    private List<User> usersList;

    private Resources resources;

    public CardStackManager() {
        fillUsersListFromFile();
    }

    public List<User> getUsersList() {
        return usersList;
    }


    public void setResources(Resources resources) {
        this.resources = resources;
        fillUsersListFromFile();
    }

    private void fillUsersListFromFile() {
        try {
            String jsonContent = readJsonFile(R.raw.users);
            if(jsonContent.isEmpty()) {
                return;
            }

            usersList= new ArrayList<User>();
            JSONArray jsonArray = new JSONArray(jsonContent);
            for(int index = 0; index < jsonArray.length(); ++index)
            {
                JSONObject jsonObject = jsonArray.getJSONObject(index);
                String profilePicture = jsonObject.getString("url");
                String name = jsonObject.getString("name");
                int age = jsonObject.getInt("age");
                String location = jsonObject.getString("location");

                usersList.add(new User(profilePicture, name, age, location));
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
