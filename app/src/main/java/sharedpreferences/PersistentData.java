package sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;

public class PersistentData {

    private static String USERNAME_KEY = "username_key";
    private static String DATA_KEY = "com.example.proyectofinal.PERSISTENT_DATA";

    public static void saveUser (String username, Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(DATA_KEY, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(USERNAME_KEY, username);
        editor.commit();
    }

    public static String returnedLoggedUser (Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(DATA_KEY, Context.MODE_PRIVATE);
        String username = sharedPreferences.getString(USERNAME_KEY, "");
        return username;
    }
}
