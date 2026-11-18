package DAO;

import Dominio.Professor;
import FakeDB.ProfessorFakeDB;

public class ProfessorDAO extends AbsGenericDAO<Professor>{

    @Override
    public Professor create(Professor novo) {
        int ultimoCodigo = this.repositorio.getLast().getCodigo();
        int proximoCodigo = ultimoCodigo + 1;
        novo.setCodigo(proximoCodigo);
        this.repositorio.add(novo);
        return novo;
    }

    @Override
    public Professor delete(Professor apagado) {
        int codigoProcurado = apagado.getCodigo();
        return this.deletePorID(codigoProcurado);
    }

    @Override
    public Professor readOne(int codigo) {
        for (Professor item : this.repositorio) {
            if (item.getCodigo() == codigo){
                return item;
            }
        }
        return null;
    }

    @Override
    public Professor update(Professor alterado) {
        int codigoProcurado = alterado.getCodigo();
        Professor original = this.readOne(codigoProcurado);
        if (original != null){
            int indice = this.repositorio.indexOf(original);
            this.repositorio.set(indice, alterado);
            return alterado;
        }
        return null;
    }

    public Professor deletePorID(int codigo){
        Professor original = this.readOne(codigo);
        if (original != null){
            this.repositorio.remove(original);
            return original;
        }
        return null;
    }

    public ProfessorDAO(){
        this.repositorio = new ProfessorFakeDB().getDados();
    }
}
