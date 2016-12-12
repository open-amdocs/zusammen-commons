package org.amdocs.tsuzammen.utils.facade.api;


import org.amdocs.tsuzammen.utils.facade.impl.AbstractFactoryBase;

/**
 * This class provides generic implementation of an abstract factory. Components exposed as Java
 * interfaces should have their own concrete factories derived from the given class. This assures
 * code alignment and consistency across all Service Management components. <p> The class actually
 * uses singleton pattern to instantiate and reuse just one instance of a factory. Therefore, each
 * factory implementation has to be <i>thread-safe</i>. <p> In a general case, the hierarchy of
 * factory objects for an Java interface <tt>IUknown</tt> may look as follows:
 * <pre>
 *                     AbstractFactory&lt;IUnknown&gt;
 *                                ^
 *                                |
 *   Application code ----> ConcreteFactory
 *                                ^
 *                                |
 *                      +---------+---------+
 *                      |                   |
 *             BaselineFactoryImpl   CustomFactoryImpl
 * </pre>
 * Where the classes responsibility is: <ul> <li>Abstract factory - common logic to retrieve the
 * implementation class name from a central repository.</li> <li>Concrete factory - abstract class
 * that only exposes to application layer the type specific API such as: <ul> <li><tt>public static
 * ConcreteFactory getInstance()</tt></li> </ul> <li>Baseline factory - out of the box
 * implementation of concrete factory (that can be replaced by a custom one depending on customer
 * needs) which actually implements method: <ul> <li><tt>public IUnknown createInterface()</tt></li>
 * </ul> </ul> The normal concrete factory class may look like:
 * <pre>
 * public abstract class ConcreteFactory extends AbstractFactory&lt;IUnknown&gt; {
 *   static {
 *     registerFactory(ConcreteFactory.class, BaselineFactoryImpl.class);
 *   }
 *   public static ConcreteFactory getInstance() {
 *     return AbstractFactory.&lt;IUnknown, ConcreteFactory.class&gt;getInstance(ConcreteFactory.class);
 *   }
 * }
 * </pre>
 *
 * @param <I> Java interface type created by the factory.
 * @since Amdocs OSS SM 8.1
 */
public abstract class AbstractFactory<I> extends AbstractFactoryBase {


  /**
   * Returns the interface implementor instance.
   * <p>
   * <b>Note</b>: It's up to the concrete factory to decide on the actual
   * implementation of the returned interface. Therefore, the call can get the
   * same instance per each call in case of singleton implementation or new
   * instance otherwise. However, the API consumer may not assume anything
   * regarding the underlying logic and has always go through the factory to
   * obtain the reference.
   *
   * @return Implementor of the exposed Java interface.
   */
  //public abstract I createInterface();


} // End of class
