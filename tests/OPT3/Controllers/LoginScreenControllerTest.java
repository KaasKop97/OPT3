package OPT3.Controllers;

import OPT3.Helpers.PostRequest;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class LoginScreenControllerTest {

    Map<String, String> credentialsHolder = new HashMap<String, String>();
    private final PostRequest postRequest = new PostRequest();

    @BeforeEach
    public void initializeTest() {
        // All possible combinations, so entirely wrong pass / user, partly correct user / pass, and working ones.
        credentialsHolder.put("test", "test");
        credentialsHolder.put("kaas", "topkek");
        credentialsHolder.put("kaas", "asdasd");
        credentialsHolder.put("testing", "topkek");
    }

    @Test
    void loginButtonClicked() throws IOException, ParseException {
        //Equivalance class testing2
        Base64.Encoder encodeCredentials = Base64.getEncoder();

        int i = 0;
        Iterator<Map.Entry<String, String>> it = credentialsHolder.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> pair = it.next();
            String usernameEncoded = encodeCredentials.encodeToString(pair.getKey().getBytes());
            String passwordEncoded = encodeCredentials.encodeToString(pair.getValue().getBytes());
            String[][] headers = {{"Authentication", "Basic " + usernameEncoded + ":" + passwordEncoded}};
            JSONObject response = postRequest.makeRequest("login", headers);
            PostRequest.makeRequest();
            String success = response.get("status").toString();
            boolean result = Boolean.parseBoolean(response.get("result").toString());

            // If the API returns anything the result is always success since it delivered the data.
            assertEquals(success, "success");
            if(pair.getKey().equals("kaas") && pair.getValue().equals("topkek"))   {
                assertTrue(result);
            } else {
                assertFalse(result);
            }
            i++;
        }
    }
}