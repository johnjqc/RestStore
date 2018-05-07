package com.jsoft.reststore.model;

import lombok.EqualsAndHashCode;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * This class represents a Client.
 *
 * @author <a href="johnquirogac@gmail.com">John Quiroga</a>
 * @since 0.0.1
 */
@Entity
@EqualsAndHashCode
@GenericGenerator(name = "client_seq", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
        parameters = { @Parameter(name = "sequence_name", value = "client_seq"),
                @Parameter(name = "increment_size", value = "1") })
public class Client implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="client_seq")
    @Column(name="client_id")
    private Long clientId;

    private Integer age;

    @Column(name="client_name")
    private String clientName;

    @Column(name="client_user")
    private String clientUser;

    private BigDecimal document;

    private String email;

    private String password;

    public Client() {
    }

    public Long getClientId() {
        return this.clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Integer getAge() {
        return this.age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getClientName() {
        return this.clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientUser() {
        return this.clientUser;
    }

    public void setClientUser(String clientUser) {
        this.clientUser = clientUser;
    }

    public BigDecimal getDocument() {
        return this.document;
    }

    public void setDocument(BigDecimal document) {
        this.document = document;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
