package com.testng.coffeemachine;

import org.testng.annotations.*;

public class SupportInternationalisationTest {
    // Tags: sprint:3
    public Actionwords actionwords;

    @BeforeMethod
    public void setUp() {
        actionwords = new Actionwords();
    }
    public void messagesAreBasedOnLanguage(String language, String readyMessage) {
        // Tags: priority:medium
        // When I start the coffee machine using language "<language>"
        actionwords.iStartTheCoffeeMachineUsingLanguageLang(language);
        // Then message "<ready_message>" should be displayed
        actionwords.messageMessageShouldBeDisplayed(readyMessage);
    }

    @Test
    public void messagesAreBasedOnLanguageEnglish() {
        messagesAreBasedOnLanguage("en", "Ready");
    }

    @Test
    public void messagesAreBasedOnLanguageFrench() {
        messagesAreBasedOnLanguage("fr", "Pret");
    }


    //
    // Tags: priority:medium
    @Test
    public void noMessagesAreDisplayedWhenMachineIsShutDown() {
        // Given the coffee machine is started
        actionwords.theCoffeeMachineIsStarted();
        // When I shutdown the coffee machine
        actionwords.iShutdownTheCoffeeMachine();
        // Then message "" should be displayed
        actionwords.messageMessageShouldBeDisplayed("");
    }
}