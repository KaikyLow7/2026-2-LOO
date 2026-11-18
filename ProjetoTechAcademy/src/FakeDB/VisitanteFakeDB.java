package FakeDB;

import java.util.ArrayList;

import Dominio.Visitante;

public class VisitanteFakeDB extends AbsGenericFakeDB<Visitante>{

    @Override
    protected void autoPreencher(){
        this.dados.add(new Visitante(401, "Bruno Castro", "4561", "bruno@email.com", "(11) 90000-4561", "Rua das Flores, 120", "Reunião com a coordenação", 1, "Coordenação"));
        this.dados.add(new Visitante(402, "Camila Reis", "4562", "camila@email.com", "(11) 90000-4562", "Avenida Brasil, 450", "Entrevista de emprego", 2, "Recursos Humanos"));
        this.dados.add(new Visitante(403, "Daniel Freitas", "4563", "daniel@email.com", "(11) 90000-4563", "Rua XV de Novembro, 88", "Manutenção de equipamentos", 3, "Laboratório de Informática"));
        this.dados.add(new Visitante(404, "Elisa Barros", "4564", "elisa@email.com", "(11) 90000-4564", "Rua São Paulo, 301", "Entrega de material", 4, "Almoxarifado"));
        this.dados.add(new Visitante(405, "Fábio Moreira", "4565", "fabio@email.com", "(11) 90000-4565", "Rua Sete de Setembro, 15", "Palestra", 5, "Auditório"));
    }

    public VisitanteFakeDB(){
        this.dados = new ArrayList<>();
        this.autoPreencher();
    }
}
