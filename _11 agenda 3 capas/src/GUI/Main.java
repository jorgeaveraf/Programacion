package GUI;

import Domain.AgendaOld;
import Logic.LogicAgenda;
import Logic.LogicContacto;

import javax.swing.*;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        LogicAgenda logicAgenda = LogicAgenda.getInstance();
        Login login = new Login();
        login.setVisible(true);
    }
}