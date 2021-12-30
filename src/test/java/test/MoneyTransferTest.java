package test;

import data.DataGeneration;
import lombok.val;
import org.junit.jupiter.api.Test;
import page.DashboardPage;
import page.LoginPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MoneyTransferTest {


    @Test
    public void shouldTransferFromFirstToSecond9999() {
        int amount = 9999;
        val loginPage = open("http://localhost:9999", LoginPage.class);
        val authInfo = DataGeneration.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataGeneration.getVerificationCode(authInfo);
        val dashboardPage = verificationPage.verify(verificationCode);
        int balanceOfFirstCardBefore = DashboardPage.getCurrentBalanceOfFirstCard();
        int balanceOfSecondCardBefore = DashboardPage.getCurrentBalanceOfSecondCard();
        val transferPage = dashboardPage.secondCard();
        val cardInfo = DataGeneration.getFirstCardInfo();
        transferPage.transferCard(cardInfo, amount);
        int balanceAfterTransferFirstCard = DataGeneration.balanceOfSecondCardAfterTransfer(balanceOfSecondCardBefore, amount);
        int balanceAfterTransferSecondCard = DataGeneration.balanceOfFirstCardAfterTransfer(balanceOfFirstCardBefore, amount);
        int balanceOfFirstCardAfter = DashboardPage.getCurrentBalanceOfSecondCard();
        int balanceOfSecondCardAfter = DashboardPage.getCurrentBalanceOfFirstCard();
        assertEquals(balanceAfterTransferFirstCard, balanceOfFirstCardAfter);
        assertEquals(balanceAfterTransferSecondCard, balanceOfSecondCardAfter);
    }

    @Test
    public void shouldTransferFromSecondToFirst7500() {
        int amount = 7500;
        val loginPage = open("http://localhost:9999", LoginPage.class);
        val authInfo = DataGeneration.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataGeneration.getVerificationCode(authInfo);
        val dashboardPage = verificationPage.verify(verificationCode);
        int balanceOfFirstCardBefore = DashboardPage.getCurrentBalanceOfFirstCard();
        int balanceOfSecondCardBefore = DashboardPage.getCurrentBalanceOfSecondCard();
        val transferPage = dashboardPage.firstCard();
        val cardInfo = DataGeneration.getSecondCardInfo();
        transferPage.transferCard(cardInfo, amount);
        int balanceAfterTransferFirstCard = DataGeneration.balanceOfSecondCardAfterTransfer(balanceOfFirstCardBefore, amount);
        int balanceAfterTransferSecondCard = DataGeneration.balanceOfFirstCardAfterTransfer(balanceOfSecondCardBefore, amount);
        int balanceOfFirstCardAfter = DashboardPage.getCurrentBalanceOfFirstCard();
        int balanceOfSecondCardAfter = DashboardPage.getCurrentBalanceOfSecondCard();
        assertEquals(balanceAfterTransferFirstCard, balanceOfFirstCardAfter);
        assertEquals(balanceAfterTransferSecondCard, balanceOfSecondCardAfter);
    }

    @Test
    void shouldTransferMoreThanRestOfBalance77777() { // производится перевод средств, которых нет на счету
        int amount = 77777;
        val loginPage = open("http://localhost:9999", LoginPage.class);
        val authInfo = DataGeneration.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataGeneration.getVerificationCode(authInfo);
        val dashboardPage = verificationPage.verify(verificationCode);
        int balanceOfFirstCardBefore = DashboardPage.getCurrentBalanceOfFirstCard();
        int balanceOfSecondCardBefore = DashboardPage.getCurrentBalanceOfSecondCard();
        val transferPage = dashboardPage.firstCard();
        val cardInfo = DataGeneration.getSecondCardInfo();
        transferPage.transferCard(cardInfo, amount);
        int balanceAfterTransferFirstCard = DataGeneration.balanceOfSecondCardAfterTransfer(balanceOfFirstCardBefore, amount);
        int balanceAfterTransferSecondCard = DataGeneration.balanceOfFirstCardAfterTransfer(balanceOfSecondCardBefore, amount);
        int balanceOfFirstCardAfter = DashboardPage.getCurrentBalanceOfFirstCard();
        int balanceOfSecondCardAfter = DashboardPage.getCurrentBalanceOfSecondCard();
        assertEquals(balanceAfterTransferFirstCard, balanceOfFirstCardAfter);
        assertEquals(balanceAfterTransferSecondCard, balanceOfSecondCardAfter);
    }

    @Test
    public void shouldTransferFromFirstToSecond0() {
        int amount = 0;
        val loginPage = open("http://localhost:9999", LoginPage.class);
        val authInfo = DataGeneration.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataGeneration.getVerificationCode(authInfo);
        val dashboardPage = verificationPage.verify(verificationCode);
        int balanceOfFirstCardBefore = DashboardPage.getCurrentBalanceOfFirstCard();
        int balanceOfSecondCardBefore = DashboardPage.getCurrentBalanceOfSecondCard();
        val transferPage = dashboardPage.secondCard();
        val cardInfo = DataGeneration.getFirstCardInfo();
        transferPage.transferCard(cardInfo, amount);
        int balanceAfterTransferFirstCard = DataGeneration.balanceOfSecondCardAfterTransfer(balanceOfSecondCardBefore, amount);
        int balanceAfterTransferSecondCard = DataGeneration.balanceOfFirstCardAfterTransfer(balanceOfFirstCardBefore, amount);
        int balanceOfFirstCardAfter = DashboardPage.getCurrentBalanceOfSecondCard();
        int balanceOfSecondCardAfter = DashboardPage.getCurrentBalanceOfFirstCard();
        assertEquals(balanceAfterTransferFirstCard, balanceOfFirstCardAfter);
        assertEquals(balanceAfterTransferSecondCard, balanceOfSecondCardAfter);
    }
}

