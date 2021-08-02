package edu.ieu.ejemplorest.servicios;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import edu.ieu.ejemplorest.entities.Usuario;

@Service
public class UsuarioServiceImp implements UsuarioService{
	private static final AtomicLong counter = new AtomicLong();
    private static List<Usuario> users;
	
    static{
        users = populateDummyUsers();
    }
    
	private static List<Usuario> populateDummyUsers() {
		List<Usuario> users = new ArrayList<Usuario>();
        users.add(new Usuario( (int)counter.incrementAndGet(),"sam@email.com","sam", "Sam", "Simpson"));
        users.add(new Usuario( (int)counter.incrementAndGet(),"tom@email.com", "tom", "Tom", "Smith"));
        users.add(new Usuario( (int)counter.incrementAndGet(),"jrome@email.com","jor", "Jerome", "Blatzi"));
        users.add(new Usuario( (int)counter.incrementAndGet(),"silvia@email","sil", "Silvia", "Romero"));
        return users;
	}
    
	@Override
	public Usuario findById(long id) {
		for(Usuario user : users){
            if(user.getId() == id){
                return user;
            }
        }
        return null;
	}

	@Override
	public Usuario findByNombre(String name) {
		for(Usuario user : users){
            if(user.getNombre().equalsIgnoreCase(name)){
                return user;
            }
        }
        return null;
	}

	@Override
	public List<Usuario> findAll() {
		return users;
	}

	@Override
	public boolean isUserExist(Usuario user) {		
		return findByNombre(user.getNombre()) != null;
	}

	@Override
	public void saveUser(Usuario user) {
		user.setId((int) counter.incrementAndGet());
        users.add(user);
		
	}

	@Override
	public void updateUser(Usuario user) {
		int index = users.indexOf(user);
        users.set(index, user);
	}

	@Override
	public void deleteUserById(long id) {
		for (Iterator<Usuario> iterator = users.iterator(); iterator.hasNext(); ) {
            Usuario user = iterator.next();
            if (user.getId() == id) {
                iterator.remove();
            }
        }		
	}
	
}
