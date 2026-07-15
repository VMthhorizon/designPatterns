package vmola.designPatterns.entities;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;

public class InfoAdapter implements DataSource {
    private final Info info;

    public InfoAdapter(Info info) {
        this.info = info;
    }

    @Override
    public String getNomeCompleto() {
        if (info == null) return "";
        return info.getNome() + " " + info.getCognome();
    }

    @Override
    public int getEta() {
        if (info == null || info.getDataDiNascita() == null) {
            return 0;
        }

        LocalDate dataNascita = info.getDataDiNascita()
                .toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();

        LocalDate oggi = LocalDate.now();

        return Period.between(dataNascita, oggi)
                .getYears();
    }
}

