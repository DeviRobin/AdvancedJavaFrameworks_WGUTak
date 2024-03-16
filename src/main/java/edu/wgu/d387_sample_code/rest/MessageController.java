package edu.wgu.d387_sample_code.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class MessageController {

    private Executor executor = Executors.newFixedThreadPool(2);

    @RequestMapping(path ="/presentation", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<String>> getWelcomeMessage() {
        List<String> m = new ArrayList<String>();

        executor.execute(() -> {
            DisplayMessage messageEnglish = new DisplayMessage("en","US");
            m.add(messageEnglish.getWelcomeMessage());
        });

        executor.execute(() -> {
            DisplayMessage messageFrench = new DisplayMessage("fr","CA");
            m.add(messageFrench.getWelcomeMessage());
        });

        return new ResponseEntity<List<String>>(m, HttpStatus.OK);
    }
}
