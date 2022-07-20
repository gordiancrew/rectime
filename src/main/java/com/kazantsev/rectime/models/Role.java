package com.kazantsev.rectime.models;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;
import java.util.Set;

@Entity
public class Role implements GrantedAuthority {
    @Id
    private Integer id;
    private String name;
   @Transient
    @ManyToMany(mappedBy="roles")
    private Set<Clients> clients;

    public Role(){}
    public Role(Integer id){
        this.id=id;
    }
    public Role(Integer id, String name){
        this.id=id;
        this.name=name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Clients> getClients() {
        return clients;
    }

    public void setClients(Set<Clients> clients) {
        this.clients = clients;
    }

    @Override
    public String getAuthority() {
        return getName();
    }
}
