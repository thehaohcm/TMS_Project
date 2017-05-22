package org.fsoft.tms.entity;


import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonManagedReference;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by thehaohcm on 5/21/17.
 */
@Entity
@Table(name="TESTTABLE")
public class TestTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID",nullable = false)
    private Integer id;

    @Column(name="DATE",nullable = true)
    private Date date;

    //@NotFound(action = NotFoundAction.IGNORE)
    @ManyToOne(cascade = CascadeType.ALL)
    //@JsonIgnore
    @JoinColumn(name="MANAGERID", referencedColumnName = "ID")//,insertable = false,updatable =false)
   // @JsonBackReference
    private TestTable main;

    @OneToMany(mappedBy = "main")//,fetch = FetchType.EAGER)
    //@JsonManagedReference
    private Set<TestTable> sub= new HashSet<TestTable>();


    public TestTable(){

    }

    public TestTable(Date date) {
        this.date = date;
    }

    public TestTable getMainCategory() {
        return main;
    }

    public void setMainCategory(TestTable mainCategory) {
        this.main = mainCategory;
    }

    public Set<TestTable> getSubCategory() {
        return sub;
    }

    public void setSubCategory(Set<TestTable> subCategory) {
        this.sub = subCategory;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
