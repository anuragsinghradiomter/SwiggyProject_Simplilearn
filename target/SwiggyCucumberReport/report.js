$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("SwiggyTestSuite.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#Swiggy Project Feature File"
    }
  ],
  "line": 3,
  "name": "Swiggy Bill Total Check",
  "description": "I want to use check the correctness of Swiggy Menu Bill Total",
  "id": "swiggy-bill-total-check",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 6,
  "name": "Total Bill value check",
  "description": "",
  "id": "swiggy-bill-total-check;total-bill-value-check",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 7,
  "name": "User has add menu items into Swiggy site",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "Menu list and price are added into excelsheets",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "Total Bill has been generated",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "I validate the correctness of total bill value",
  "keyword": "Then "
});
formatter.match({
  "location": "SwiggyBillCheck.user_has_add_menu_items_into_Swiggy_site()"
});
formatter.result({
  "duration": 91376400,
  "status": "passed"
});
formatter.match({
  "location": "SwiggyBillCheck.menu_list_and_price_are_added_into_excelsheets()"
});
formatter.result({
  "duration": 11448900,
  "status": "passed"
});
formatter.match({
  "location": "SwiggyBillCheck.total_Bill_has_been_generated()"
});
formatter.result({
  "duration": 10022500,
  "status": "passed"
});
formatter.match({
  "location": "SwiggyBillCheck.i_validate_the_correctness_of_total_bill_value()"
});
formatter.result({
  "duration": 10585300,
  "status": "passed"
});
});