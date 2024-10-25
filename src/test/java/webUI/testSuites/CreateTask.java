package webUI.testSuites;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import webUI.pages.todoist.LoginPage;
import webUI.pages.todoist.MenuSection;
import webUI.pages.todoist.TaskSection;
import webUI.session.Session;

public class CreateTask {
    LoginPage loginPage = new LoginPage();
    MenuSection menuSection = new MenuSection();
    TaskSection taskSection = new TaskSection();

    @BeforeEach
    public void open() {
        Session.getInstance().getBrowser().get("https://todoist.com/app/");
    }

    @AfterEach
    public void close() {
        Session.getInstance().closeSession();
    }

    @Test
    public void addTask()  {

        loginPage.emailTextBox.setText("nataliabilbaocano19@gmail.com");
        loginPage.pwdTextBox.setText("Admin123.");
        loginPage.loginButton.click();

        String task = "tarea segundo parcial";
        menuSection.addTaskButton.click();
        taskSection.taskNameTextBox.click();
        taskSection.taskNameTextBox.setText(task);
        taskSection.sendButton.click();
        menuSection.setTaskName(task);

        menuSection.inboxButton.click();

        Assertions.assertTrue(menuSection.taskName.isControlDisplayed(), "ERROR la tarea no existe!");

    }
}
