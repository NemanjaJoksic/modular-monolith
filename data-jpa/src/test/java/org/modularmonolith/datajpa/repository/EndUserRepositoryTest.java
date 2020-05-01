/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.modularmonolith.datajpa.repository;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.modularmonolith.datajpa.TestContext;
import org.modularmonolith.datajpa.entity.EndUser;
import org.modularmonolith.datajpa.entity.EndUserRole;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Nemanja
 */
@Slf4j
public class EndUserRepositoryTest extends TestContext {
    
    @Autowired
    private EndUserRepository endUserRepository;
    
    @Test
    public void test() {
        
        EndUser endUser1 = EndUser.builder()
                .username("testuser1")
                .password("pass")
                .createdAt(new Timestamp(0))
                .roles(Arrays.asList(new EndUserRole("testuser1", "USER_ROLE")))
                .build();
        
        EndUser endUser2 = EndUser.builder()
                .username("testuser2")
                .password("pass")
                .createdAt(new Timestamp(0))
                .roles(Arrays.asList(new EndUserRole("testuser2", "USER_ROLE"), new EndUserRole("testuser2", "ADMIN_ROLE")))
                .build();
        
        int endUserCount = endUserRepository.findAll().size();
        log.info("Number of users before test: {}", endUserCount);
        
        endUserRepository.save(endUser1);
        endUserRepository.save(endUser2);
        
        List<EndUser> endUsers = endUserRepository.findAll();
        log.info("Number of users test after test: {}", endUsers.size());
        Assert.assertEquals(endUserCount + 2, endUsers.size());
        
        log.info("Find and assert testuser1");
        EndUser dbEndUser1 = endUserRepository.findByUsername("testuser1");
        assertEndUsers(endUser1, dbEndUser1);
        
        log.info("Find and assert testuser2");
        EndUser dbEndUser2 = endUserRepository.findByUsername("testuser2");
        assertEndUsers(endUser2, dbEndUser2);
        
        log.info("EndUserRepositoryTest passed");
    }
    
    private void assertEndUsers(EndUser expectedEndUser, EndUser actualEndUser) {
        Assert.assertEquals(expectedEndUser.getUsername(), expectedEndUser.getUsername());
        Assert.assertEquals(expectedEndUser.getPassword(), expectedEndUser.getPassword());
        Assert.assertEquals(expectedEndUser.getCreatedAt(), expectedEndUser.getCreatedAt());
        Assert.assertEquals(expectedEndUser.getRoles().size(), actualEndUser.getRoles().size());
    }
    
}
