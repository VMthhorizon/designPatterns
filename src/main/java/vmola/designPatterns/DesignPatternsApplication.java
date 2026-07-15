package vmola.designPatterns;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import vmola.designPatterns.entities.DataSource;
import vmola.designPatterns.entities.Info;
import vmola.designPatterns.entities.InfoAdapter;
import vmola.designPatterns.entities.UserData;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

@SpringBootApplication
public class DesignPatternsApplication {

    public static void main(String[] args) {
        Info info = new Info();
        info.setNome("luca");
        info.setCognome("frizzi");

        LocalDate dataNascita = LocalDate.of(2002, 10, 21);

        Date dataDate = Date.from(dataNascita.atStartOfDay(ZoneId.systemDefault())
                .toInstant());
        info.setDataDiNascita(dataDate);

        DataSource adapter = new InfoAdapter(info);
        UserData userData = new UserData();

        userData.getData(adapter);

        System.out.println("Nome Completo: " + adapter.getNomeCompleto());
        System.out.println("Eta': " + adapter.getEta());
    }


}
