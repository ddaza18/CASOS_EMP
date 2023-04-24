package com.casos.web.repository;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import com.casos.web.model.Administrador;

@Repository
public class AdminRepositoryImpl implements AdminRepository {
	public static final Logger LOG = LoggerFactory.getLogger(AdminRepositoryImpl.class);

	@PersistenceContext 
	private EntityManager entityManager;
	
	@Override
	public Administrador findByAdminUsAndToken(String admin, String token) {
	   String queryStr = "SELECT a.* FROM administrador a WHERE a.admin = :admin AND a.token = :token";
	   Query query = entityManager.createNativeQuery(queryStr, Administrador.class);
	   query.setParameter("admin", admin);
	   query.setParameter("token", token);
	   
	   try {
		   Administrador resultado = (Administrador) query.getSingleResult();
		return resultado;
	} catch (NoResultException e) {
		LOG.error("El query no arrojo resultados", e.getMessage());
		return null;
	}
}
	
	//Metodos Adicionales para el modo ADMIN dentro del modulo
	
	@Override
	public List<Administrador> findAll() {
		//Metodo generado automaticamente
		return null;
	}

	@Override
	public List<Administrador> findAll(Sort sort) {
		//Metodo generado automaticamente
		return null;
	}

	@Override
	public List<Administrador> findAllById(Iterable<Long> ids) {
		//Metodo generado automaticamente
		return null;
	}

	@Override
	public <S extends Administrador> List<S> saveAll(Iterable<S> entities) {
		//Metodo generado automaticamente
		return null;
	}

	@Override
	public void flush() {
		//Metodo generado automaticamente
		
	}

	@Override
	public <S extends Administrador> S saveAndFlush(S entity) {
		//Metodo generado automaticamente
		return null;
	}

	@Override
	public <S extends Administrador> List<S> saveAllAndFlush(Iterable<S> entities) {
		//Metodo generado automaticamente
		return null;
	}

	@Override
	public void deleteAllInBatch(Iterable<Administrador> entities) {
		//Metodo generado automaticamente
		
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Long> ids) {
		//Metodo generado automaticamente
		
	}

	@Override
	public void deleteAllInBatch() {
		//Metodo generado automaticamente
		
	}

	@Override
	public Administrador getOne(Long id) {
		//Metodo generado automaticamente
		return null;
	}

	@Override
	public Administrador getById(Long id) {
		//Metodo generado automaticamente
		return null;
	}

	@Override
	public <S extends Administrador> List<S> findAll(Example<S> example) {
		//Metodo generado automaticamente
		return null;
	}

	@Override
	public <S extends Administrador> List<S> findAll(Example<S> example, Sort sort) {
		//Metodo generado automaticamente
		return null;
	}

	@Override
	public Page<Administrador> findAll(Pageable pageable) {
		//Metodo generado automaticamente
		return null;
	}

	@Override
	public <S extends Administrador> S save(S entity) {
		//Metodo generado automaticamente
		return null;
	}

	@Override
	public Optional<Administrador> findById(Long id) {
		//Metodo generado automaticamente
		return null;
	}

	@Override
	public boolean existsById(Long id) {
		//Metodo generado automaticamente
		return false;
	}

	@Override
	public long count() {
		//Metodo generado automaticamente
		return 0;
	}

	@Override
	public void deleteById(Long id) {
		//Metodo generado automaticamente
		
	}

	@Override
	public void delete(Administrador entity) {
		//Metodo generado automaticamente
		
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		//Metodo generado automaticamente
		
	}

	@Override
	public void deleteAll(Iterable<? extends Administrador> entities) {
		//Metodo generado automaticamente
		
	}

	@Override
	public void deleteAll() {
		//Metodo generado automaticamente
		
	}

	@Override
	public <S extends Administrador> Optional<S> findOne(Example<S> example) {
		//Metodo generado automaticamente
		return null;
	}

	@Override
	public <S extends Administrador> Page<S> findAll(Example<S> example, Pageable pageable) {
		//Metodo generado automaticamente
		return null;
	}

	@Override
	public <S extends Administrador> long count(Example<S> example) {
		//Metodo generado automaticamente
		return 0;
	}

	@Override
	public <S extends Administrador> boolean exists(Example<S> example) {
		//Metodo generado automaticamente
		return false;
	}

}
