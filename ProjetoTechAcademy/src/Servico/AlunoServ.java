package Servico;

import java.util.ArrayList;

import DAO.AlunoDAO;
import Dominio.Aluno;

public class AlunoServ extends AbsGenericServ<Aluno> {

    @Override
    public ArrayList<Aluno> listar(){
        return this.dao.readAll();
    }

    @Override
    public Aluno buscar(int codigo){
        return this.dao.readOne(codigo);
    }

    @Override
    public Aluno editar(Aluno alterado){
        return this.dao.update(alterado);
    }

    @Override
    public Aluno adicionar(Aluno novo){
        return this.dao.create(novo);
    }

    @Override
    public Aluno excluir(Aluno apagado){
        return this.dao.delete(apagado);
    }

    public AlunoServ(){
        this.dao = new AlunoDAO();
    }
}
