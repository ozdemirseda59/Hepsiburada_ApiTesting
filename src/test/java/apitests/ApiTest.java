package apitests;

import org.json.simple.JSONObject;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import utilities.ApiUtil;

import static com.jayway.restassured.RestAssured.given;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ApiTest extends ApiUtil {
    private JSONObject requestParams;

    @Before
    public void setup(){
        requestParams=new JSONObject();
        setBaseURI("https://generator.swagger.io");
    }
    @Test
    public void T01_getResponseBody() {
        response = given()
                .when().get("/api/gen/clients");

        //Methoad Adı + basarılı-basarısız durumu yazdırılır
        checkStatusCode("T01_getResponseBody");
    }
    @Test
    public void T02_postResponseBody(){
        requestParams.put("framework","lumen");

         response = given()
                .header("Content-Type", "application/json")
                .body(requestParams.toJSONString())
                .when().post("/api/gen/servers/lumen")
                .then().extract().response();

        //Methoad Adı + basarılı-basarısız durumu yazdırılır
        checkStatusCode("T01_getResponseBody");
    }
}
