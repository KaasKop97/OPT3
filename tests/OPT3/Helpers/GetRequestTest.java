package OPT3.Helpers;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class GetRequestTest {

    @Test
    void makeRequest() throws IOException, ParseException {
        GetRequest getTest = new GetRequest();
        JSONObject returns = getTest.makeRequest("/consumer/get_all");
        assertEquals(returns.get("status").toString(), "success");
    }
}