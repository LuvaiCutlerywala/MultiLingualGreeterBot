package bot;

import java.util.HashMap;

public class ResponseEngine {

    private static HashMap<String, String> languages = new HashMap<>();

    static{
        String[] langs = {"German", "French", "Italian"};
        String[] phrases = {"Wilkommen! Ich bin Greeter.", "Bonjour, Je suis Greeter.", "Benvenuto! Sono Greeter."};
        for(int i = 0; i < langs.length; ++i){
            languages.put(langs[i], phrases[i]);
        }
    }

    private static String getLanguage(String content){
        String purgedContent = purgeContent(content);
        return purgedContent.split(",")[0];
    }

    private static String purgeContent(String content){
         return content.replaceAll("[<!>]", "");
    }

    private static String getMessage(String content) {
        String purgedContent = purgeContent(content);
        return purgedContent.split(",")[1];
    }

    public static String getDynamicResponse(String content){
        String lang = getLanguage(content);
        return languages.get(lang);
    }
}
