package workflows;

import extensions.APIActions;
import io.qameta.allure.Step;
import utilities.CommonOps;

public class APIFlows extends CommonOps {

    @Step("Business Flow: Get Property From A User")
    public static String getUserProperty(String id, String jPath) {
        response = APIActions.get("api/users/" + id);
        return APIActions.extractFromJSON(response, jPath);
    }

    @Step("Business Flow: Create New User")
    public static int createUser(String name, String job) {
        params.put("name", name);
        params.put("job", job);
        return APIActions.post(params, "api/users");
    }

    @Step("Business Flow: Update User")
    public static int updateUser(String name, String job, String id) {
        params.put("name", name);
        params.put("job", job);
        return APIActions.put(params, "api/users/" + id);
    }

    @Step("Business Flow: Delete User")
    public static int deleteUser(String id) {
        return APIActions.delete("api/users/" + id);
    }
}
