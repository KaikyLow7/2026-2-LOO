package FakeDB;

import java.util.ArrayList;

import Dominio.Estagiario;

public class EstagiarioFakeDB extends AbsGenericFakeDB<Estagiario>{

    @Override
    protected void autoPreencher(){
        this.dados.add(new Estagiario(501, "Gustavo Pires", "5671", "gustavo@email.com", "(11) 90000-5671", "Rua das Palmeiras, 40", 1200.0, 30, "Desenvolvimento"));
        this.dados.add(new Estagiario(502, "Isabela Cunha", "5672", "isabela@email.com", "(11) 90000-5672", "Rua Santa Catarina, 210", 1000.0, 20, "Suporte de TI"));
        this.dados.add(new Estagiario(503, "Leonardo Vieira", "5673", "leonardo@email.com", "(11) 90000-5673", "Avenida Central, 999", 1100.0, 25, "Banco de Dados"));
        this.dados.add(new Estagiario(504, "Mariana Teixeira", "5674", "mariana@email.com", "(11) 90000-5674", "Rua do Comércio, 77", 1200.0, 30, "Redes"));
        this.dados.add(new Estagiario(505, "Natália Gomes", "5675", "natalia@email.com", "(11) 90000-5675", "Rua Getúlio Vargas, 530", 900.0, 20, "Design"));
    }

    public EstagiarioFakeDB(){
        this.dados = new ArrayList<>();
        this.autoPreencher();
    }
}
