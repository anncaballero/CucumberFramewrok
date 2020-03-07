$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/Login.feature");
formatter.feature({
  "name": "Login",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@sprint"
    },
    {
      "name": "@login"
    }
  ]
});
formatter.scenario({
  "name": "Valid login",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@sprint"
    },
    {
      "name": "@login"
    },
    {
      "name": "@test"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I open browser and navigate to the HRMS",
  "keyword": "Given "
});
formatter.match({
  "location": "LoginSteps.i_open_browser_and_navigate_to_the_HRMS()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I enter valid username and password",
  "keyword": "When "
});
formatter.match({
  "location": "LoginSteps.i_enter_valid_username_and_password()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click on login button",
  "keyword": "And "
});
formatter.match({
  "location": "LoginSteps.i_click_on_login_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I succesfully logged in",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginSteps.i_succesfully_logged_in()"
});
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded0.png");
formatter.after({
  "status": "passed"
});
});