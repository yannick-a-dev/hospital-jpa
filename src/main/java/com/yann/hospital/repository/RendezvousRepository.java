package com.yann.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yann.hospital.entity.Rendezvous;

public interface RendezvousRepository extends JpaRepository<Rendezvous,String> {

}
