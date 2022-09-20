package FirstScript;

import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.RequestOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class AppTest {

    Playwright playwright;
    APIRequestContext apiRequestContext;

    @BeforeClass
    public void setUp(){
        playwright = Playwright.create();
        apiRequestContext = playwright.request().newContext(new APIRequest.NewContextOptions()
                .setBaseURL("https://jsonplaceholder.typicode.com/"));

    }

    @Test
    public void getAllPost() {

        //GET
        Integer responseCode = apiRequestContext.get("/posts").status();
        Assert.assertEquals(200, responseCode);

    }

    @Test
    public void addNewPost(){

        //POST
        Map<String,String> payloadPost = new HashMap<>();
        payloadPost.put("title", "foo");
        payloadPost.put("body", "bar");
        payloadPost.put("userId", "2");

        String response = apiRequestContext.post("/posts", RequestOptions.create().setData(payloadPost)).text();
        System.out.println(response);



    }

    @AfterClass
    public void tearDown(){
        apiRequestContext.dispose();
        playwright.close();
    }

}
