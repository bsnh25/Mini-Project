package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.thucydides.core.annotations.Steps;
import starter.pages.CartToOrder;
import starter.pages.PurchaseOrder;

public class PurchaseOrderStep {
    @Steps
    PurchaseOrder purchaseOrder;
    @Steps
    CartToOrder cartToOrder;
    @And("I click purchase")
    public void iClickPurchase() {
        purchaseOrder.clickPurchaseIcon();
    }
    @Then("I will see the history transaction")
    public void iWillSeeTheHistoryTransaction() {
        purchaseOrder.seeHistoryTransaction();
    }

    @Given("I dont have login on Alta Store")
    public void iDontHaveLoginOnAltaStore() {
        cartToOrder.altaStoreUrl();
    }
}
