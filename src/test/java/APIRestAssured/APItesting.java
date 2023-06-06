package APIRestAssured;

import java.util.HashMap;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static org.hamcrest.core.IsEqual.equalTo;

public class APItesting {

        @Test
        public void verifyGetApiIsReturningValidResponseAuthorAndBook(){
            given()
                    .when()
                    .get("https://fakerestapi.azurewebsites.net/api/v1/Authors/3")
                    .then()
                    .statusCode(200)
                    .log()
                    .body()
                    .body("id",equalTo(3))
                    .body("idBook",equalTo(1));
            given()
                    .when()
                    .get("https://fakerestapi.azurewebsites.net/api/v1/Books/3")
                    .then()
                    .statusCode(200)
                    .log()
                    .body()
                    .body("id",equalTo(3))
                    .body("pageCount",equalTo(300));
        }
        @Test
        public void verifyPostApiIsReturningValidResponseOfAuthor() {
            HashMap payload = new HashMap();
            payload.put("id", 2);
            payload.put("idBook", 10);
            payload.put("firstName", "John");
            payload.put("lastName", "Doe");
            Response response = given().contentType("application/json").body(payload)
                    .when()
                    .post("https://fakerestapi.azurewebsites.net/api/v1/Authors")
                    .then()
                    .statusCode(200)
                    .log()
                    .body()
                    .extract()
                    .response();
            String output = response.asString();
            System.out.println("Output below");
            System.out.println(output);
            Assert.assertEquals(output.contains("Doe"), true);
        }

        @Test
        public void verifyPostApiIsReturningValidResponseOfBook() {

            HashMap payload2 = new HashMap();
            payload2.put("id", 0);
            payload2.put("title", "First");
            payload2.put("description", "book");
            payload2.put("pageCount", 10);
            payload2.put("excerpt", "string");
            payload2.put("publishDate", "2023-05-11T05:22:41.407Z");

            Response response1=given().contentType("application/json").body(payload2)
                    .when()
                    .post("https://fakerestapi.azurewebsites.net/api/v1/Books")
                    .then()
                    .statusCode(200)
                    .log()
                    .body()
                    .extract()
                    .response();
            String output1= response1.asString();
            System.out.println("output1");
            System.out.println(output1);
            Assert.assertEquals(output1.contains("First"),true);
        }

        @Test
        public void verifyPutApiIsReturningValidResponse(){
            HashMap payload = new HashMap();
            payload.put("id", 0);
            payload.put("idBook", 10);
            payload.put("firstName", "John");
            payload.put("lastName", "Doe");
            Response response = given().contentType("application/json").body(payload)
                    .when()
                    .put("https://fakerestapi.azurewebsites.net/api/v1/Authors/16")
                    .then()
                    .statusCode(200)
                    .log()
                    .body()
                    .extract()
                    .response();
            String output = response.asString();
            System.out.println("Output below");
            System.out.println(output);
            Assert.assertEquals(output.contains("Doe"), true);

            HashMap payload2 = new HashMap();
            payload2.put("id", 0);
            payload2.put("title", "First");
            payload2.put("description", "book");
            payload2.put("pageCount", 10);
            payload2.put("excerpt", "string");
            payload2.put("publishDate", "2023-05-11T05:22:41.407Z");

            Response response1=given().contentType("application/json").body(payload2)
                    .when()
                    .put("https://fakerestapi.azurewebsites.net/api/v1/Books/16")
                    .then()
                    .statusCode(200)
                    .log()
                    .body()
                    .extract()
                    .response();
            String output1= response1.asString();
            System.out.println("output1");
            System.out.println(output1);
            Assert.assertEquals(output1.contains("First"),true);


        }

    }


