package Servico;

import java.util.ArrayList;

import DAO.ProfessorDAO;
import Dominio.Professor;

public class ProfessorServ extends AbsGenericServ<Professor> {

    @Override
    public ArrayList<Professor> listar(){
        return this.dao.readAll();
    }

    @Override
    public Professor buscar(int codigo){
        return this.dao.readOne(codigo);
    }

    @Override
    public Professor editar(Professor alterado){
        return this.dao.update(alterado);
    }

    @Override
    public Professor adicionar(Professor novo){
        return this.dao.create(novo);
    }

    @Override
    public Professor excluir(Professor apagado){
        return this.dao.delete(apagado);
    }

    public ProfessorServ(){
        this.dao = new ProfessorDAO();
    }
}
