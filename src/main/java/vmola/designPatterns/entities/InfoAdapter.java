package vmola.designPatterns.entities;

import java.util.Calendar;

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
        Calendar oggi = Calendar.getInstance();
        Calendar nascita = Calendar.getInstance();
        nascita.setTime(info.getDataDiNascita());

        int eta = oggi.get(Calendar.YEAR) - nascita.get(Calendar.YEAR);

        if (oggi.get(Calendar.DAY_OF_YEAR) < nascita.get(Calendar.DAY_OF_YEAR)) {
            eta--;
        }
        return eta;
    }
}

