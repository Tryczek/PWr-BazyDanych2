import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginWindow {
    private JTextField loginTextField;
    private JTextField passwordTextField;
    private JPanel panelMain;
    private JButton loginAcceptButton;
    private JButton cofnijButton;
    private Database database;
    public LoginWindow(Database database) {
        this.database = database;
        JFrame frame = new JFrame("Logowanie");
        frame.setContentPane(panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,450);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        loginAcceptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    String type = database.getLogin(loginTextField.getText(), passwordTextField.getText());
                    if(type != null){
                        if(type.equals("admin")){
                            AdminWindow adminWindow = new AdminWindow(database);
                        }
                        else if (type.equals("pracownik")) {
                            EmployeeWindow employeeWindow = new EmployeeWindow(database);

                        }
                        else if (type.equals("klient")) {
                            ClientWindow clientWindow = new ClientWindow(database);
                        }
                        else{
                            return;
                        }
                        frame.dispose();
                    }

}
        });
        cofnijButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainMenu mainMenu = new MainMenu(database);
                frame.dispose();
            }
        });
    }
}
