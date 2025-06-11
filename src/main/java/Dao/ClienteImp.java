package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Interfaces.ICliente;
import Modelo.TblCliente;

public class ClienteImp implements ICliente {

	public void RegistrarCliente(TblCliente cliente) {
		//nos conectamos con la U.P.
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("ProyectoJPAWebMiercoles");
		//administrar la transaccion
		EntityManager em=emf.createEntityManager();
		try{
			//iniciamos la transaccion..
			em.getTransaction().begin();
			//invocamos el metodo registrar...
			em.persist(cliente);
			//confirmamos
			em.getTransaction().commit();
		}catch(RuntimeException ex){
			ex.getMessage();
		}finally  {
			//cerramos
			em.close();
		} //fin del finally
		
	}  //fin del metodo registrar...

	public void ActualizarCliente(TblCliente cliente) {
		// nos conectamos con la unidad de persistencia...
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("ProyectoJPAWebMiercoles");
	//administrar las transacciones
	EntityManager em=emf.createEntityManager();
	try{
		//iniciamos la transaccion
		em.getTransaction().begin();
		//invocamos el metodo actualizar
		em.merge(cliente);
		//confirmamos 
		em.getTransaction().commit();
	}catch(RuntimeException e){
		//enviamos un mensaje en caso de error
		System.out.println(e.getMessage());
	}finally{
		//cerramos
		em.close();
	} //fin del finally
		
	} //fin del metodo actualizar...

	public void EliminarCliente(TblCliente cliente) {
		//nos conectamos con la u.p
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("ProyectoJPAWebMiercoles");
		//para administrar las transacciones
		EntityManager em=emf.createEntityManager();
		try{
			//iniciamos la transaccion
			em.getTransaction().begin();
			//recuperamos el codigo a eliminar...
			TblCliente  codelim=em.find(TblCliente.class,cliente.getIdcliente());
			//aplicamos una condicion
			if(codelim!=null){
				//procedemos a eliminar
				em.remove(codelim);
				//confirmamos
				em.getTransaction().commit();
			}//fin de la condicion...
		}catch(RuntimeException e){
		System.out.println(e.getMessage());
		}finally{
			//cerramos
			em.close();
		} //fin del finally
		
	} //fin del metodo eliminar...

	public List<TblCliente> ListarCliente() {
		//nos conectamos con la u.p.
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("ProyectoJPAWebMiercoles");
		//para administrar las transacciones
		EntityManager em=emf.createEntityManager();
		//para el listado
<<<<<<< HEAD
		List<TblCliente> buscarcodigo=null;
=======
		List<TblCliente> listadocliente=null;
>>>>>>> 4650aeb4fcf1e64b2f32af1e893effd9f32fc207
		try{
			//iniciamos la transaccion..
			em.getTransaction().begin();
			//hacemos la consulta JPQL
<<<<<<< HEAD
			buscarcodigo=em.createQuery("select c from TblCliente c",TblCliente.class).getResultList();
=======
			listadocliente=em.createQuery("select c from TblCliente c",TblCliente.class).getResultList();
>>>>>>> 4650aeb4fcf1e64b2f32af1e893effd9f32fc207
		     //confirmamos
			em.getTransaction().commit();
		
		}catch(RuntimeException e){
			System.out.println(e.getMessage());
		}finally{
			//cerramos
			em.close();
		}  //fin del finally
		//retornamos el listado
<<<<<<< HEAD
		return buscarcodigo;
	}  //fin del metodo listar....

	public TblCliente BuscarCliente(TblCliente cliente) {
		//nos conectamos con la u.p.
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("ProyectoJPAWebMiercoles");
		//para administrar las transacciones
		EntityManager em=emf.createEntityManager();
		//para el buscar
		TblCliente buscarcodigo=null;
		try{
			//iniciamos la transaccion..
			em.getTransaction().begin();
			//hacemos la consulta JPQL
			buscarcodigo=em.find(TblCliente.class,cliente.getIdcliente());
		     //confirmamos
			em.getTransaction().commit();
		
		}catch(RuntimeException e){
			System.out.println(e.getMessage());
		}finally{
			//cerramos
			em.close();
		}  //fin del finally
		//retornamos el listado
		return buscarcodigo;
	}  //fin del metodo listar....
=======
		return listadocliente;
	}  //fin del metodo listar....

	public TblCliente BuscarCliente(TblCliente cliente) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProyectoJPAWebMiercoles");
		EntityManager em = emf.createEntityManager();
		TblCliente buscado = null;
		try {
			em.getTransaction().begin();
			buscado = em.find(TblCliente.class, cliente.getIdcliente());
			em.getTransaction().commit();
		}
		catch (RuntimeException ex)
		{
			System.out.println(ex.getMessage());
		}finally {
			em.close();
		}
		return buscado;		
	}
	
	
>>>>>>> 4650aeb4fcf1e64b2f32af1e893effd9f32fc207
} //fin de la clase...
