package me.slashfix;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 *
 * @author jhoffma5
 */
@ApplicationPath("rest")
public class App extends Application {
  
  @Override
  public Set<Class<?>> getClasses() {
    HashSet s = new HashSet();
    return s;
  }

  /**
   * Do not modify addRestResourceClasses() method.
   * It is automatically re-generated by NetBeans REST support to populate
   * given list with all resources defined in the project.
   */
  private void addRestResourceClasses(Set<Class<?>> resources) {
    resources.add(me.slashfix.service.CustomerFacadeREST.class);
  }
  
}
