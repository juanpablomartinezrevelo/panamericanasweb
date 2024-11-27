/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Logica.Almacenista;
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
public class AlmacenistaJpaController implements Serializable {

    public AlmacenistaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;
    
    public AlmacenistaJpaController() {
        emf = Persistence.createEntityManagerFactory("Panamericanas_PU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Almacenista almacenista) {
        if (almacenista.getListaventas() == null) {
            almacenista.setListaventas(new ArrayList<Ventas>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Ventas> attachedListaventas = new ArrayList<Ventas>();
            for (Ventas listaventasVentasToAttach : almacenista.getListaventas()) {
                listaventasVentasToAttach = em.getReference(listaventasVentasToAttach.getClass(), listaventasVentasToAttach.getIdVenta());
                attachedListaventas.add(listaventasVentasToAttach);
            }
            almacenista.setListaventas(attachedListaventas);
            em.persist(almacenista);
            for (Ventas listaventasVentas : almacenista.getListaventas()) {
                Almacenista oldSalesAlmacenistaOfListaventasVentas = listaventasVentas.getSalesAlmacenista();
                listaventasVentas.setSalesAlmacenista(almacenista);
                listaventasVentas = em.merge(listaventasVentas);
                if (oldSalesAlmacenistaOfListaventasVentas != null) {
                    oldSalesAlmacenistaOfListaventasVentas.getListaventas().remove(listaventasVentas);
                    oldSalesAlmacenistaOfListaventasVentas = em.merge(oldSalesAlmacenistaOfListaventasVentas);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Almacenista almacenista) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Almacenista persistentAlmacenista = em.find(Almacenista.class, almacenista.getId());
            List<Ventas> listaventasOld = persistentAlmacenista.getListaventas();
            List<Ventas> listaventasNew = almacenista.getListaventas();
            List<Ventas> attachedListaventasNew = new ArrayList<Ventas>();
            for (Ventas listaventasNewVentasToAttach : listaventasNew) {
                listaventasNewVentasToAttach = em.getReference(listaventasNewVentasToAttach.getClass(), listaventasNewVentasToAttach.getIdVenta());
                attachedListaventasNew.add(listaventasNewVentasToAttach);
            }
            listaventasNew = attachedListaventasNew;
            almacenista.setListaventas(listaventasNew);
            almacenista = em.merge(almacenista);
            for (Ventas listaventasOldVentas : listaventasOld) {
                if (!listaventasNew.contains(listaventasOldVentas)) {
                    listaventasOldVentas.setSalesAlmacenista(null);
                    listaventasOldVentas = em.merge(listaventasOldVentas);
                }
            }
            for (Ventas listaventasNewVentas : listaventasNew) {
                if (!listaventasOld.contains(listaventasNewVentas)) {
                    Almacenista oldSalesAlmacenistaOfListaventasNewVentas = listaventasNewVentas.getSalesAlmacenista();
                    listaventasNewVentas.setSalesAlmacenista(almacenista);
                    listaventasNewVentas = em.merge(listaventasNewVentas);
                    if (oldSalesAlmacenistaOfListaventasNewVentas != null && !oldSalesAlmacenistaOfListaventasNewVentas.equals(almacenista)) {
                        oldSalesAlmacenistaOfListaventasNewVentas.getListaventas().remove(listaventasNewVentas);
                        oldSalesAlmacenistaOfListaventasNewVentas = em.merge(oldSalesAlmacenistaOfListaventasNewVentas);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = almacenista.getId();
                if (findAlmacenista(id) == null) {
                    throw new NonexistentEntityException("The almacenista with id " + id + " no longer exists.");
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
            Almacenista almacenista;
            try {
                almacenista = em.getReference(Almacenista.class, id);
                almacenista.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The almacenista with id " + id + " no longer exists.", enfe);
            }
            List<Ventas> listaventas = almacenista.getListaventas();
            for (Ventas listaventasVentas : listaventas) {
                listaventasVentas.setSalesAlmacenista(null);
                listaventasVentas = em.merge(listaventasVentas);
            }
            em.remove(almacenista);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Almacenista> findAlmacenistaEntities() {
        return findAlmacenistaEntities(true, -1, -1);
    }

    public List<Almacenista> findAlmacenistaEntities(int maxResults, int firstResult) {
        return findAlmacenistaEntities(false, maxResults, firstResult);
    }

    private List<Almacenista> findAlmacenistaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Almacenista.class));
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

    public Almacenista findAlmacenista(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Almacenista.class, id);
        } finally {
            em.close();
        }
    }

    public int getAlmacenistaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Almacenista> rt = cq.from(Almacenista.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
