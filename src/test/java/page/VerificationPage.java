package page;

import com.codeborne.selenide.SelenideElement;
import data.DataGeneration;

import static com.codeborne.selenide.Selenide.$;

public class VerificationPage {
    private SelenideElement verificationField = $("input[name=\"code\"]");
    private SelenideElement verificationButton = $("[data-test-id=action-verify]");

    public DashboardPage verify(DataGeneration.VerificationCode code) {
        verificationField.setValue(code.getCode());
        verificationButton.click();
        return new DashboardPage();
    }
}