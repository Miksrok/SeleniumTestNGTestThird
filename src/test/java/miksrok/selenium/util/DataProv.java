package miksrok.selenium.util;

import org.testng.annotations.DataProvider;

/**
 * Created by Залізний Мозок on 19.04.2017.
 */
public class DataProv {

    @DataProvider(name = "getAuthorizationData")
    public static Object [][] getAuthorizationData (){
        return new Object[][] {
                {"webinar.test@gmail.com", "Xcg7299bnSmMuRLp9ITw"}
    };

    }
}
