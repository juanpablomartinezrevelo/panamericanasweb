/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Logica.InventarioProducto;
import java.io.Serializable;
import jakarta.persistence.Query;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import Logica.Producto;
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
public class InventarioProductoJpaController implements Serializable {

    public InventarioProductoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;
    
    public InventarioProductoJpaController() {
        emf = Persistence.createEntityManagerFactory("Panamericanas_PU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(InventarioProducto inventarioProducto) {
        if (inventarioProducto.getListaproducto() == null) {
            inventarioProducto.setListaproducto(new ArrayList<Producto>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Producto> attachedListaproducto = new ArrayList<Producto>();
            for (Producto listaproductoProductoToAttach : inventarioProducto.getListaproducto()) {
                listaproductoProductoToAttach = em.getReference(listaproductoProductoToAttach.getClass(), listaproductoProductoToAttach.getIdProducto());
                attachedListaproducto.add(listaproductoProductoToAttach);
            }
            inventarioProducto.setListaproducto(attachedListaproducto);
            em.persist(inventarioProducto);
            for (Producto listaproductoProducto : inventarioProducto.getListaproducto()) {
                InventarioProducto oldProductOfListaproductoProducto = listaproductoProducto.getProduct();
                listaproductoProducto.setProduct(inventarioProducto);
                listaproductoProducto = em.merge(listaproductoProducto);
                if (oldProductOfListaproductoProducto != null) {
                    oldProductOfListaproductoProducto.getListaproducto().remove(listaproductoProducto);
                    oldProductOfListaproductoProducto = em.merge(oldProductOfListaproductoProducto);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(InventarioProducto inventarioProducto) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            InventarioProducto persistentInventarioProducto = em.find(InventarioProducto.class, inventarioProducto.getIdProducto());
            List<Producto> listaproductoOld = persistentInventarioProducto.getListaproducto();
            List<Producto> listaproductoNew = inventarioProducto.getListaproducto();
            List<Producto> attachedListaproductoNew = new ArrayList<Producto>();
            for (Producto listaproductoNewProductoToAttach : listaproductoNew) {
                listaproductoNewProductoToAttach = em.getReference(listaproductoNewProductoToAttach.getClass(), listaproductoNewProductoToAttach.getIdProducto());
                attachedListaproductoNew.add(listaproductoNewProductoToAttach);
            }
            listaproductoNew = attachedListaproductoNew;
            inventarioProducto.setListaproducto(listaproductoNew);
            inventarioProducto = em.merge(inventarioProducto);
            for (Producto listaproductoOldProducto : listaproductoOld) {
                if (!listaproductoNew.contains(listaproductoOldProducto)) {
                    listaproductoOldProducto.setProduct(null);
                    listaproductoOldProducto = em.merge(listaproductoOldProducto);
                }
            }
            for (Producto listaproductoNewProducto : listaproductoNew) {
                if (!listaproductoOld.contains(listaproductoNewProducto)) {
                    InventarioProducto oldProductOfListaproductoNewProducto = listaproductoNewProducto.getProduct();
                    listaproductoNewProducto.setProduct(inventarioProducto);
                    listaproductoNewProducto = em.merge(listaproductoNewProducto);
                    if (oldProductOfListaproductoNewProducto != null && !oldProductOfListaproductoNewProducto.equals(inventarioProducto)) {
                        oldProductOfListaproductoNewProducto.getListaproducto().remove(listaproductoNewProducto);
                        oldProductOfListaproductoNewProducto = em.merge(oldProductOfListaproductoNewProducto);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = inventarioProducto.getIdProducto();
                if (findInventarioProducto(id) == null) {
                    throw new NonexistentEntityException("The inventarioProducto with id " + id + " no longer exists.");
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
            InventarioProducto inventarioProducto;
            try {
                inventarioProducto = em.getReference(InventarioProducto.class, id);
                inventarioProducto.getIdProducto();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The inventarioProducto with id " + id + " no longer exists.", enfe);
            }
            List<Producto> listaproducto = inventarioProducto.getListaproducto();
            for (Producto listaproductoProducto : listaproducto) {
                listaproductoProducto.setProduct(null);
                listaproductoProducto = em.merge(listaproductoProducto);
            }
            em.remove(inventarioProducto);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<InventarioProducto> findInventarioProductoEntities() {
        return findInventarioProductoEntities(true, -1, -1);
    }

    public List<InventarioProducto> findInventarioProductoEntities(int maxResults, int firstResult) {
        return findInventarioProductoEntities(false, maxResults, firstResult);
    }

    private List<InventarioProducto> findInventarioProductoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(InventarioProducto.class));
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

    public InventarioProducto findInventarioProducto(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(InventarioProducto.class, id);
        } finally {
            em.close();
        }
    }

    public int getInventarioProductoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<InventarioProducto> rt = cq.from(InventarioProducto.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
