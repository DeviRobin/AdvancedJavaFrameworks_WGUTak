package edu.wgu.d387_sample_code.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Locale;
import java.util.ResourceBundle;

@Component
public class DisplayMessage {

    private Locale locale;
    private ResourceBundle resourceBundle;

    public String getWelcomeMessage(){
        return resourceBundle.getString("welcome");
    }

    public DisplayMessage(){
    }

    public DisplayMessage(String language, String country) {
        locale = new Locale(language, country);
        resourceBundle = ResourceBundle.getBundle("translations",locale);
        System.out.printf("%s, %s%n", language, country);
    }

}
