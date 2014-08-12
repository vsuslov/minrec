/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.rs.testcase.minrec.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "applicants")
public class Applicant implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Comment")
    private String comment;
}
