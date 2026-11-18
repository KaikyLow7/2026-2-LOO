package FakeDB;

import java.util.ArrayList;

import Dominio.Professor;
import Dominio.ProfessorEfetivo;

public class ProfessorFakeDB extends AbsGenericFakeDB<Professor>{

    @Override
    protected void autoPreencher(){
        this.dados.add(new Professor(301, "Ricardo Nunes", "3451", 4500.0));
        this.dados.add(new ProfessorEfetivo(302, "Sandra Lopes", "3452", 6200.0, 350.0));
        this.dados.add(new Professor(303, "Tiago Fernandes", "3453", 3800.0));
        this.dados.add(new ProfessorEfetivo(304, "Vanessa Rocha", "3454", 7000.0, 500.0));
        this.dados.add(new Professor(305, "Wagner Dias", "3455", 4100.0));
    }

    public ProfessorFakeDB(){
        this.dados = new ArrayList<>();
        this.autoPreencher();
    }
}
