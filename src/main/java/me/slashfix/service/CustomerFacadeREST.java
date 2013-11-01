package me.slashfix.service;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import me.slashfix.Customer;

/**
 *
 * @author burni_000
 */
@Stateless
@Path("/customer")
public class CustomerFacadeREST extends AbstractFacade<Customer> {

  @PersistenceContext(unitName = "playPersistenceUnit")
  private EntityManager em;

  public CustomerFacadeREST() {
    super(Customer.class);
  }

  @POST
  @Consumes({"application/xml", "application/json"})
  @Produces("application/json")
  public Customer createNew(Customer entity) {
    super.create(entity);
    em.flush();
    return entity;
  }

  @PUT
  @Override
  @Consumes({"application/xml", "application/json"})
  public void edit(Customer entity) {
    super.edit(entity);
  }

  @DELETE
  @Path("{id}")
  @Consumes({"application/xml", "application/json"})
  public void remove(@PathParam("id") Integer id) {
    super.remove(super.find(id));
  }

  @GET
  @Path("{id}")
  @Produces({"application/json"})
  public Customer find(@PathParam("id") Integer id) {
    return super.find(id);
  }

  @GET
  @Path("/n/{name}")
  @Produces({"application/json"})
  public List<Customer> find(@PathParam("name") String name) {
    Query q = em.createNamedQuery("Person.findByName");
    StringBuilder sb = new StringBuilder();
    sb.append("%");
    sb.append(name);
    sb.append("%");
    q.setParameter("name", sb.toString());
    return q.getResultList();
  }

  @GET
  @Override
  @Produces({"application/json"})
  public List<Customer> findAll() {
    return super.findAll();
  }

  @GET
  @Path("{from}/{to}")
  @Produces({"application/xml", "application/json"})
  public List<Customer> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
    return super.findRange(new int[]{from, to});
  }

  @GET
  @Path("count")
  @Produces("text/plain")
  public String countREST() {
    return String.valueOf(super.count());
  }

  @Override
  protected EntityManager getEntityManager() {
    return em;
  }
}
