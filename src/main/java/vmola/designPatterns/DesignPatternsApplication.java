package vmola.designPatterns;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import vmola.designPatterns.entities.DataSource;
import vmola.designPatterns.entities.Info;
import vmola.designPatterns.entities.InfoAdapter;
import vmola.designPatterns.entities.UserData;

import java.util.Calendar;

@SpringBootApplication
public class DesignPatternsApplication {

    public static void main(String[] args) {
        Info info = new Info();
        info.setNome("Mario");
        info.setCognome("Rossi");

        Calendar cal = Calendar.getInstance();
        cal.set(1996, Calendar.JULY, 15);
        info.setDataDiNascita(cal.getTime());

        DataSource adapter = new InfoAdapter(info);
        UserData userData = new UserData();

        userData.getData(adapter);

        System.out.println("Nome Completo: " + adapter.getNomeCompleto());
        System.out.println("Eta': " + adapter.getEta());
    }


}
