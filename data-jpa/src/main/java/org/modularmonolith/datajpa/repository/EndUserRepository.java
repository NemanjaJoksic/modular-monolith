/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.modularmonolith.datajpa.repository;

import org.modularmonolith.datajpa.entity.EndUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Nemanja
 */
@Repository
public interface EndUserRepository extends JpaRepository<EndUser, String> {
    
    public EndUser findByUsername(String username);
    
}
