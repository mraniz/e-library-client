package com.library.demo.repository;

/**
 * @author ANIZAM
 *
 */

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.library.demo.model.Buku;

@Repository
public interface BukuRepository extends JpaRepository<Buku, Integer>{

	@Query(value = "select * from buku where status=true", nativeQuery = true)
	List<Buku> findAll();

	Buku findById(int id);
	
	Buku findByKdbuku(String kdbuku);

	Buku findByTahun(String tahun);
	
	@Query(value = "select count(id) from buku", nativeQuery = true)
	int getTotalData();
	
	@Query(value = "select max(id) from buku", nativeQuery = true)
	int getSequenceId();
}
