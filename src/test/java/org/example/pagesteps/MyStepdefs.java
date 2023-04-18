package org.example.pagesteps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.App;
import  org.example.page.AppLauncher;
import org.example.page.Search;

public class MyStepdefs {

   AppLauncher app = new AppLauncher();
    Search search= new Search();

    @When("User open the homepage")
    public void userOpenTheHomepage() {
        app.openHome();


    }

    @Then("Search {string}")
    public void search(String term) {
       search.kelimeAra(term);

    }

    @Then("Open the {string} product")
    public void productsec(Integer productNo) throws InterruptedException {
            search.productTik(productNo);

    }

    @Then("Add to selected product")
    public void addToSelectedProduct() throws InterruptedException {
        search.addToCart();
    }
}
