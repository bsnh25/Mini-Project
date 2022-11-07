package starter.Users;

import static net.serenitybdd.rest.SerenityRest.*;
import static org.hamcrest.Matchers.equalTo;

public class GetAllProduct {
    private static String url, content;

    public static void setUrlProduct(){
        url = "https://alta-shop.herokuapp.com/api/products";
    }

    public static String requestGetAllOfProduct(){
        given().header("Content-Type", "application/json");
        when().get(url);
        content = lastResponse().body().path("col-md-4 col-lg-3 col-6");
        return content;
    }
    public static void validateAllOfTheInfromationOfTheProduct(){
        then().body("col-md-4 col-lg-3 col-6", equalTo(content));
    }
    public static void validateStatus200(){
        then().statusCode(200);
    }

}