/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Logica.Gerente;
import java.io.Serializable;
import jakarta.persistence.Query;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import Logica.Ventas;
import Persistencia.exceptions.NonexistentEntityException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 123456789
 */
public class GerenteJpaController implements Serializable {

    public GerenteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public GerenteJpaController() {
        emf = Persistence.createEntityManagerFactory("Panamericanas_PU");
    }
    
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Gerente gerente) {
        if (gerente.getListaventasGerente() == null) {
            gerente.setListaventasGerente(new ArrayList<Ventas>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Ventas> attachedListaventasGerente = new ArrayList<Ventas>();
            for (Ventas listaventasGerenteVentasToAttach : gerente.getListaventasGerente()) {
                listaventasGerenteVentasToAttach = em.getReference(listaventasGerenteVentasToAttach.getClass(), listaventasGerenteVentasToAttach.getIdVenta());
                attachedListaventasGerente.add(listaventasGerenteVentasToAttach);
            }
            gerente.setListaventasGerente(attachedListaventasGerente);
            em.persist(gerente);
            for (Ventas listaventasGerenteVentas : gerente.getListaventasGerente()) {
                Gerente oldSalesGerenteOfListaventasGerenteVentas = listaventasGerenteVentas.getSalesGerente();
                listaventasGerenteVentas.setSalesGerente(gerente);
                listaventasGerenteVentas = em.merge(listaventasGerenteVentas);
                if (oldSalesGerenteOfListaventasGerenteVentas != null) {
                    oldSalesGerenteOfListaventasGerenteVentas.getListaventasGerente().remove(listaventasGerenteVentas);
                    oldSalesGerenteOfListaventasGerenteVentas = em.merge(oldSalesGerenteOfListaventasGerenteVentas);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Gerente gerente) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Gerente persistentGerente = em.find(Gerente.class, gerente.getId());
            List<Ventas> listaventasGerenteOld = persistentGerente.getListaventasGerente();
            List<Ventas> listaventasGerenteNew = gerente.getListaventasGerente();
            List<Ventas> attachedListaventasGerenteNew = new ArrayList<Ventas>();
            for (Ventas listaventasGerenteNewVentasToAttach : listaventasGerenteNew) {
                listaventasGerenteNewVentasToAttach = em.getReference(listaventasGerenteNewVentasToAttach.getClass(), listaventasGerenteNewVentasToAttach.getIdVenta());
                attachedListaventasGerenteNew.add(listaventasGerenteNewVentasToAttach);
            }
            listaventasGerenteNew = attachedListaventasGerenteNew;
            gerente.setListaventasGerente(listaventasGerenteNew);
            gerente = em.merge(gerente);
            for (Ventas listaventasGerenteOldVentas : listaventasGerenteOld) {
                if (!listaventasGerenteNew.contains(listaventasGerenteOldVentas)) {
                    listaventasGerenteOldVentas.setSalesGerente(null);
                    listaventasGerenteOldVentas = em.merge(listaventasGerenteOldVentas);
                }
            }
            for (Ventas listaventasGerenteNewVentas : listaventasGerenteNew) {
                if (!listaventasGerenteOld.contains(listaventasGerenteNewVentas)) {
                    Gerente oldSalesGerenteOfListaventasGerenteNewVentas = listaventasGerenteNewVentas.getSalesGerente();
                    listaventasGerenteNewVentas.setSalesGerente(gerente);
                    listaventasGerenteNewVentas = em.merge(listaventasGerenteNewVentas);
                    if (oldSalesGerenteOfListaventasGerenteNewVentas != null && !oldSalesGerenteOfListaventasGerenteNewVentas.equals(gerente)) {
                        oldSalesGerenteOfListaventasGerenteNewVentas.getListaventasGerente().remove(listaventasGerenteNewVentas);
                        oldSalesGerenteOfListaventasGerenteNewVentas = em.merge(oldSalesGerenteOfListaventasGerenteNewVentas);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = gerente.getId();
                if (findGerente(id) == null) {
                    throw new NonexistentEntityException("The gerente with id " + id + " no longer exists.");
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
            Gerente gerente;
            try {
                gerente = em.getReference(Gerente.class, id);
                gerente.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The gerente with id " + id + " no longer exists.", enfe);
            }
            List<Ventas> listaventasGerente = gerente.getListaventasGerente();
            for (Ventas listaventasGerenteVentas : listaventasGerente) {
                listaventasGerenteVentas.setSalesGerente(null);
                listaventasGerenteVentas = em.merge(listaventasGerenteVentas);
            }
            em.remove(gerente);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Gerente> findGerenteEntities() {
        return findGerenteEntities(true, -1, -1);
    }

    public List<Gerente> findGerenteEntities(int maxResults, int firstResult) {
        return findGerenteEntities(false, maxResults, firstResult);
    }

    private List<Gerente> findGerenteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Gerente.class));
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

    public Gerente findGerente(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Gerente.class, id);
        } finally {
            em.close();
        }
    }

    public int getGerenteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Gerente> rt = cq.from(Gerente.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
