package utilities;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;


public class ApiUtil {
    public static Response response;

    public static void setBaseURI (String baseURI){
        RestAssured.baseURI= baseURI;
    }

    public static void setBasePath(String basePathTerm){
        RestAssured.basePath = basePathTerm;
    }

    public static void checkStatusCode(String methodName){
        if(response.statusCode()==200){
            System.out.println(methodName+" Basarili");
        }else{
            System.out.println(methodName +" Basarisiz");
        }
    }

}
