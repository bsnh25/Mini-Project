package starter.Users;

import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static net.serenitybdd.rest.SerenityRest.*;
import static org.hamcrest.Matchers.equalTo;

public class GetAccount {

    private static String url,content, validToken, invalidToken, nullToken;

    public void setUrlAndValidToken() {
        url = "https://alta-shop.herokuapp.com/api/auth/info";
        validToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkJheXUiLCJFbWFpbCI6ImJheXVzZXB0eWFuNDNAZ21haWwuY29tIn0.a0gMWUgpOlTv-_7pu9PThdDrZVoKhT14Q4sYkcuH95w";
    }
    public void setUrlAndInvalidToken() {
        url = "https://alta-shop.herokuapp.com/api/auth/info";
        invalidToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9";
    }
    public void setUrlAndNullToken() {
        url = "https://alta-shop.herokuapp.com/api/auth/info";
        nullToken = "";
    }

    public static void requestGetAccount(){
        given().header("accept", "*/*")
                .header("Content-Type","application/json")
                .header("Authorization","Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkJheXUiLCJFbWFpbCI6ImJheXVzZXB0eWFuNDNAZ21haWwuY29tIn0.a0gMWUgpOlTv-_7pu9PThdDrZVoKhT14Q4sYkcuH95w");
        when().get(url);

    }
    public static void requestWithInvalidToken(){
        given().header("accept", "application/json")
                .header("Content-Type","application/json")
                .header("Authorization","Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9");
        when().get(url);
    }
    public static void requestWithNullToken(){
        given().header("accept", "application/json")
                .header("Content-Type","application/json")
                .header("Authorization", "Bearer ");
        when().get(url);
    }
    public static void validationOfToken(){
        then().body("Data", equalTo(content));
    }
    public static void validationOfInvalid(){
        then().body("error", equalTo("token contains an invalid number of segments"));
    }
    public static void validationOfUnauthor(){
        then().body("error", equalTo("invalid token"));
    }


    public List<JSONObject> bodyData(){
        List<JSONObject> body = new ArrayList<>();

        JSONObject data = new JSONObject();
        data.put("product_id", 428);
        data.put("quantity", 2);

        body.add(data);
        return body;
}
