package DAO;

import Dominio.Aluno;
import FakeDB.AlunoFakeDB;

public class AlunoDAO extends AbsGenericDAO<Aluno>{

    @Override
    public Aluno create(Aluno novo) {
        int ultimoCodigo = this.repositorio.getLast().getCodigo();
        int proximoCodigo = ultimoCodigo + 1;
        novo.setCodigo(proximoCodigo);
        this.repositorio.add(novo);
        return novo;
    }

    @Override
    public Aluno delete(Aluno apagado) {
        int codigoProcurado = apagado.getCodigo();
        return this.deletePorID(codigoProcurado);
    }

    @Override
    public Aluno readOne(int codigo) {
        for (Aluno item : this.repositorio) {
            if (item.getCodigo() == codigo){
                return item;
            }
        }
        return null;
    }

    @Override
    public Aluno update(Aluno alterado) {
        int codigoProcurado = alterado.getCodigo();
        Aluno original = this.readOne(codigoProcurado);
        if (original != null){
            int indice = this.repositorio.indexOf(original);
            this.repositorio.set(indice, alterado);
            return alterado;
        }
        return null;
    }

    public Aluno deletePorID(int codigo){
        Aluno original = this.readOne(codigo);
        if (original != null){
            this.repositorio.remove(original);
            return original;
        }
        return null;
    }

    public AlunoDAO(){
        this.repositorio = new AlunoFakeDB().getDados();
    }
}
