/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import java.io.Serializable;
import jakarta.persistence.Query;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import Logica.Gerente;
import Logica.Almacenista;
import Logica.Ventas;
import Persistencia.exceptions.NonexistentEntityException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;

/**
 *
 * @author 123456789
 */
public class VentasJpaController implements Serializable {

    public VentasJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;
    
    public VentasJpaController() {
        emf = Persistence.createEntityManagerFactory("Panamericanas_PU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Ventas ventas) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Gerente salesGerente = ventas.getSalesGerente();
            if (salesGerente != null) {
                salesGerente = em.getReference(salesGerente.getClass(), salesGerente.getId());
                ventas.setSalesGerente(salesGerente);
            }
            Almacenista salesAlmacenista = ventas.getSalesAlmacenista();
            if (salesAlmacenista != null) {
                salesAlmacenista = em.getReference(salesAlmacenista.getClass(), salesAlmacenista.getId());
                ventas.setSalesAlmacenista(salesAlmacenista);
            }
            em.persist(ventas);
            if (salesGerente != null) {
                salesGerente.getListaventasGerente().add(ventas);
                salesGerente = em.merge(salesGerente);
            }
            if (salesAlmacenista != null) {
                salesAlmacenista.getListaventas().add(ventas);
                salesAlmacenista = em.merge(salesAlmacenista);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Ventas ventas) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Ventas persistentVentas = em.find(Ventas.class, ventas.getIdVenta());
            Gerente salesGerenteOld = persistentVentas.getSalesGerente();
            Gerente salesGerenteNew = ventas.getSalesGerente();
            Almacenista salesAlmacenistaOld = persistentVentas.getSalesAlmacenista();
            Almacenista salesAlmacenistaNew = ventas.getSalesAlmacenista();
            if (salesGerenteNew != null) {
                salesGerenteNew = em.getReference(salesGerenteNew.getClass(), salesGerenteNew.getId());
                ventas.setSalesGerente(salesGerenteNew);
            }
            if (salesAlmacenistaNew != null) {
                salesAlmacenistaNew = em.getReference(salesAlmacenistaNew.getClass(), salesAlmacenistaNew.getId());
                ventas.setSalesAlmacenista(salesAlmacenistaNew);
            }
            ventas = em.merge(ventas);
            if (salesGerenteOld != null && !salesGerenteOld.equals(salesGerenteNew)) {
                salesGerenteOld.getListaventasGerente().remove(ventas);
                salesGerenteOld = em.merge(salesGerenteOld);
            }
            if (salesGerenteNew != null && !salesGerenteNew.equals(salesGerenteOld)) {
                salesGerenteNew.getListaventasGerente().add(ventas);
                salesGerenteNew = em.merge(salesGerenteNew);
            }
            if (salesAlmacenistaOld != null && !salesAlmacenistaOld.equals(salesAlmacenistaNew)) {
                salesAlmacenistaOld.getListaventas().remove(ventas);
                salesAlmacenistaOld = em.merge(salesAlmacenistaOld);
            }
            if (salesAlmacenistaNew != null && !salesAlmacenistaNew.equals(salesAlmacenistaOld)) {
                salesAlmacenistaNew.getListaventas().add(ventas);
                salesAlmacenistaNew = em.merge(salesAlmacenistaNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = ventas.getIdVenta();
                if (findVentas(id) == null) {
                    throw new NonexistentEntityException("The ventas with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Ventas ventas;
            try {
                ventas = em.getReference(Ventas.class, id);
                ventas.getIdVenta();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The ventas with id " + id + " no longer exists.", enfe);
            }
            Gerente salesGerente = ventas.getSalesGerente();
            if (salesGerente != null) {
                salesGerente.getListaventasGerente().remove(ventas);
                salesGerente = em.merge(salesGerente);
            }
            Almacenista salesAlmacenista = ventas.getSalesAlmacenista();
            if (salesAlmacenista != null) {
                salesAlmacenista.getListaventas().remove(ventas);
                salesAlmacenista = em.merge(salesAlmacenista);
            }
            em.remove(ventas);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Ventas> findVentasEntities() {
        return findVentasEntities(true, -1, -1);
    }

    public List<Ventas> findVentasEntities(int maxResults, int firstResult) {
        return findVentasEntities(false, maxResults, firstResult);
    }

    private List<Ventas> findVentasEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Ventas.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Ventas findVentas(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Ventas.class, id);
        } finally {
            em.close();
        }
    }

    public int getVentasCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Ventas> rt = cq.from(Ventas.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
