package com.casos.web.repository;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

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
	public Administrador findByAdminUsAndToken(String adminUs, String token) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Administrador> cq = cb.createQuery(Administrador.class);
		Root<Administrador> root = cq.from(Administrador.class);
		
		cq.select(root).where(cb.and(cb.equal(root.get("admin_us"), adminUs), 
				cb.equal(root.get("token"), token)));
		
		TypedQuery<Administrador> query = entityManager.createQuery(cq);
		
		List<Administrador> datos = query.getResultList();
		 LOG.info("Consulta generada del query findByAdminUsAndToken : " + query.unwrap(org.hibernate.query.Query.class).getQueryString());
		if(datos.size() > 0) {
			return datos.get(0);
		}else {
			LOG.error("Se presento un error en el query findByAdminUsAndToken");
			return null;
		}
	}

	//Metodos adicionales en caso de otro tipo de consultas
	
	@Override
	public List<Administrador> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Administrador> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Administrador> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Administrador> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends Administrador> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Administrador> List<S> saveAllAndFlush(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAllInBatch(Iterable<Administrador> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Administrador getOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Administrador getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Administrador> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Administrador> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Administrador> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Administrador> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Administrador> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Administrador entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends Administrador> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends Administrador> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Administrador> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Administrador> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends Administrador> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
