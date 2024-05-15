package br.com.alura.comex.DAO;

import br.com.alura.comex.modelos.Categoria;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class CategoriaDao {
    private final EntityManager em;

    public CategoriaDao(EntityManager em) {
        this.em = em;
    }

    public Categoria buscarPorId(Long id) {
        Categoria categoria = em.find(Categoria.class, id);
        System.out.println("Buscar por ID - Categoria encontrada: " + categoria);
        return categoria;
    }

    public void cadastra(Categoria categoria) {
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.persist(categoria);
            et.commit();
            System.out.println("Cadastrando Categoria: " + categoria);
        } catch (Exception e) {
            et.rollback();
            System.out.println("Erro ao cadastrar categoria: " + e.getMessage());
        }
    }

    public List<Categoria> listaTodas() {
        List<Categoria> categorias = em.createQuery("SELECT c FROM Categoria c", Categoria.class).getResultList();
        System.out.println("Listando todas as Categorias: " + categorias);
        return categorias;
    }
}
