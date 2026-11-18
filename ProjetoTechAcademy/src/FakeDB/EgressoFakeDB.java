package FakeDB;

import java.util.ArrayList;

import Dominio.Egresso;

public class EgressoFakeDB extends AbsGenericFakeDB<Egresso>{

    @Override
    protected void autoPreencher(){
        this.dados.add(new Egresso(201, "Fernanda Souza", "2341", 2021, "Análise e Desenvolvimento de Sistemas", "Desenvolvimento Web"));
        this.dados.add(new Egresso(202, "Gabriel Torres", "2342", 2022, "Engenharia de Software", "Banco de Dados"));
        this.dados.add(new Egresso(203, "Helena Martins", "2343", 2023, "Ciência da Computação", "Inteligência Artificial"));
        this.dados.add(new Egresso(204, "Igor Ramos", "2344", 2024, "Sistemas de Informação", "Suporte de TI"));
        this.dados.add(new Egresso(205, "Juliana Prado", "2345", 2025, "Análise e Desenvolvimento de Sistemas", "Desenvolvimento Mobile"));
    }

    public EgressoFakeDB(){
        this.dados = new ArrayList<>();
        this.autoPreencher();
    }
}
