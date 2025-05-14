package Steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.given;

public class mysteps {

    RequestSpecification requestSpecification;
    ResponseSpecification responseSpecification;
    Response response;
    static String boardId;
    static String listId;
    static String cardId;
    static String checklistId;

    public static void main(String[] args) {
        String token = System.getenv("TRELLO_TOKEN");
        System.out.println(token);
    }

    @Before
    public void setup() {
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri("https://api.trello.com/1")
                .addQueryParam("key", System.getenv("TRELLO_KEY"))
                .addQueryParam("token", System.getenv("TRELLO_TOKEN"))
                .addHeader("Content-Type", "application/json")
                .build();


    }

    @Given("The request is set up with board name")
    public void the_request_is_set_up_with_board_name_and_key() {
        requestSpecification = given().spec(requestSpecification).log().all()
                .queryParam("name", "Test");

    }

    @When("POST request is sent")
    public void post_request_is_send() {
        response = requestSpecification.when().post("/boards");

    }

    @Then("Response status code is 200")
    public void status_code_is_200() {
        String res = response.then().log().all().statusCode(200)
                .extract().response().asString();
        JsonPath jsonPath = new JsonPath(res);
        boardId = jsonPath.getString("id");


    }

    //create list

    @Given("The request is set up with the list name")
    public void the_request_is_set_up_with_list_name_and_key() {
        requestSpecification = given().spec(requestSpecification).log().all()
                .queryParam("name", "list test")
                .queryParam("idBoard", boardId);

    }

    @When("POST request is sent to create list")
    public void post_list_request_is_send() {
        response = requestSpecification.when().post("/lists");

    }

    @Then("the status code is egual to 200")
    public void status_code_isequal_to_200() {
        String res = response.then().log().all().statusCode(200)
                .extract().response().asString();
        JsonPath jsonPath = new JsonPath(res);
        listId = jsonPath.getString("id");


    }
    //create a card

    @Given("The request is set up with the card name")
    public void the_request_is_set_up_with_card_name_and_key() {
        requestSpecification = given().spec(requestSpecification).log().all()
                .queryParam("name", "card test")
                .queryParam("idList", listId);

    }

    @When("POST request is sent to create a new card")
    public void post_request_is_sendwith_card_name() {
        response = requestSpecification.when().post("/cards");

    }

    @Then("my status code is successful 200")
    public void status_code_success_200() {
        String res = response.then().log().all().statusCode(200)
                .extract().response().asString();
        JsonPath jsonPath = new JsonPath(res);
        cardId = jsonPath.getString("id");


    }

    //update the board
    @Given("The new name of board is sent")
    public void the_request_is_set_up_with_board_name_and_key_update() {
        requestSpecification = given().spec(requestSpecification).log().all()
                .queryParam("name", "Test update");

    }

    @When("Put request is sent to update the board")
    public void put_request_is_send() {
        response = requestSpecification.when().put("/boards/" + boardId);
    }

    @Then("the status code of req successful 200")
    public void status_code_equal200_update() {
        response.then().log().all().statusCode(200);
    }


    //update the list
    @Given("The new name of list is sent")
    public void the_request_is_set_up_with_list_name_and_key_update() {
        requestSpecification = given().spec(requestSpecification).log().all()
                .queryParam("name", "new list");

    }

    @When("Put request is sent to update the list")
    public void put_request_is_send_list() {
        response = requestSpecification.when().put("/lists/" + listId);
    }

    @Then("the status code of request success 200")
    public void status_code_equal200_put_list() {
        response.then().log().all().statusCode(200);
    }

    //update the card
    @Given("The new name of card is sent")
    public void the_request_is_set_up_with_card_name() {
        requestSpecification = given().spec(requestSpecification).log().all()
                .queryParam("name", "new card");

    }

    @When("Put request is sent to update the card")
    public void put_request_is_send_card() {
        response = requestSpecification.when().put("/cards/" + cardId);
    }

    @Then("our status code of req is success 200")
    public void status_code_equal200_put_card() {
        response.then().log().all().statusCode(200);
    }

    //get board
    @Given("request is set up with board ID")
    public void the_request_is_set_up_with_boardId() {
        requestSpecification = given().spec(requestSpecification).log().all();

    }

    @When("Get request is sent")
    public void get_request_is_send() {
        response = requestSpecification.when().get("/boards/" + boardId);

    }

    @Then("get Response status code is 200")
    public void Get_status_code_is_200() {
        response.then().log().all().statusCode(200);


    }

    //get list
    @Given("request is set up with list ID")
    public void the_request_is_set_up_with_listId() {
        requestSpecification = given().spec(requestSpecification).log().all();

    }

    @When("Get list request is sent")
    public void getlist_request_is_send() {
        response = requestSpecification.when().get("/lists/" + listId);

    }

    @Then("get list Response status code is 200")
    public void Getlist_status_code_is_200() {
        response.then().log().all().statusCode(200);


    }

    //get card
    @Given("request is set up with card ID")
    public void the_request_is_set_up_with_cardId() {
        requestSpecification = given().spec(requestSpecification).log().all();

    }

    @When("Get card request is sent")
    public void getcard_request_is_send() {
        response = requestSpecification.when().get("/cards/" + cardId);

    }

    @Then("get card Response status code is 200")
    public void Getcard_status_code_is_200() {
        response.then().log().all().statusCode(200);


    }

    //create checklist
    @Given("request is set up with chicklist ID")
    public void the_request_is_set_up_with_check_name() {
        requestSpecification = given().spec(requestSpecification).log().all()
                .queryParam("name", "checklist new")
                .queryParam("idCard", cardId);

    }

    @When("post card request is sent with chicklist id")
    public void post_request_is_send_with_checklist_id() {
        response = requestSpecification.when().post("/checklists");

    }

    @Then("post chicklist Response status code is 200")
    public void status_checklist_code_success_200() {
        String res = response.then().log().all().statusCode(200)
                .extract().response().asString();
        JsonPath jsonPath = new JsonPath(res);
        checklistId = jsonPath.getString("id");


    }

    //update the checklist
    @Given("The new name of check list is sent")
    public void the_request_is_set_up_with_check_list() {
        requestSpecification = given().spec(requestSpecification).log().all()
                .queryParam("name", "new check list");

    }

    @When("Put request is sent to update the checklist")
    public void put_request_is_send_checklist() {
        response = requestSpecification.when().put("/checklists/" + checklistId);
    }

    @Then("checklist status code of req is success 200")
    public void status_code_equal200_put_checklist() {
        response.then().log().all().statusCode(200);
    }

    //get checklist
    @Given("request is set up with checklist ID2")
    public void the_request_is_set_up_with_checklistId() {
        requestSpecification = given().spec(requestSpecification).log().all();

    }

    @When("Get checklist request is sent")
    public void getchecklist_request_is_send() {
        response = requestSpecification.when().get("/checklists/" + checklistId);

    }

    @Then("get checklist Response status code is 200")
    public void Getchecklist_status_code_is_200() {
        response.then().log().all().statusCode(200);

    }

    //Delete checklist
    @Given("Delete request is set up with checklist ID2")
    public void Delete_request_is_set_up_with_checklistId() {
        requestSpecification = given().spec(requestSpecification).log().all();

    }

    @When("Delete checklist request is sent")
    public void Dchecklist_request_is_send() {
        response = requestSpecification.when().delete("/checklists/" + checklistId);

    }

    @Then("Delete checklist Response status code is 200")
    public void Dchecklist_status_code_is_200() {
        response.then().log().all().statusCode(200);


    }

    //Delete card
    @Given("Delete request is set up with card IDD")
    public void Delete_request_is_set_up_with_cardId() {
        requestSpecification = given().spec(requestSpecification).log().all();

    }

    @When("Delete card request is sent")
    public void Dcard_request_is_send() {
        response = requestSpecification.when().delete("/cards/" + cardId);

    }

    @Then("Delete card_req Response status code is 200")
    public void Dcard_status_code_is_200() {
        response.then().log().all().statusCode(200);


    }


    //Delete board
    @Given("The request is set up")
    public void the_request_is_set_up() {
        requestSpecification = given().spec(requestSpecification).log().all();


    }

    @When("DELETE request is send")
    public void DELETE_request_is_send() {
        response = requestSpecification.when().delete("/boards/" + boardId);

    }

    @Then("status code response equal 200")
    public void status_code_equal200() {
        response.then().log().all().statusCode(200);

    }
}







