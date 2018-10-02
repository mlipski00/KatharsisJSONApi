package org.katharsis.persistence.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.katharsis.resource.annotations.JsonApiId;
import io.katharsis.resource.annotations.JsonApiRelation;
import io.katharsis.resource.annotations.JsonApiResource;
import io.katharsis.resource.annotations.SerializeType;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Document
@JsonApiResource(type = "users")
public class User {

    @Id
    @JsonApiId
    private String id;

    @JsonApiRelation(serialize = SerializeType.EAGER)
    private Set<Role> roles;


    @JsonProperty("username")
    private String username;
    @JsonProperty("lastname")
    private String lastname;
    @JsonProperty("email")
    private String email;
    @JsonProperty("gender")
    private String gender;
    @JsonProperty("ipaddress")
    private String ipaddress;
    @JsonProperty("field1")
    private String field1;
    @JsonProperty("field2")
    private String field2;
    @JsonProperty("field3")
    private String field3;
    @JsonProperty("field4")
    private String field4;
    @JsonProperty("field5")
    private String field5;
    @JsonProperty("field7")
    private String field7;
    @JsonProperty("field8")
    private String field8;
    @JsonProperty("field9")
    private String field9;
    @JsonProperty("field10")
    private String field10;
    @JsonProperty("field11")
    private String field11;
    @JsonProperty("field12")
    private String field12;
    @JsonProperty("field13")
    private String field13;
    @JsonProperty("field14")
    private String field14;


    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("username")
    public String getUsername() {
        return username;
    }

    @JsonProperty("username")
    public void setUsername(String username) {
        this.username = username;
    }

    @JsonProperty("lastname")
    public String getLastname() {
        return lastname;
    }

    @JsonProperty("lastname")
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }

    @JsonProperty("gender")
    public String getGender() {
        return gender;
    }

    @JsonProperty("gender")
    public void setGender(String gender) {
        this.gender = gender;
    }

    @JsonProperty("ipaddress")
    public String getIpaddress() {
        return ipaddress;
    }

    @JsonProperty("ipaddress")
    public void setIpaddress(String ipaddress) {
        this.ipaddress = ipaddress;
    }

    @JsonProperty("field1")
    public String getField1() {
        return field1;
    }

    @JsonProperty("field1")
    public void setField1(String field1) {
        this.field1 = field1;
    }

    @JsonProperty("field2")
    public String getField2() {
        return field2;
    }

    @JsonProperty("field2")
    public void setField2(String field2) {
        this.field2 = field2;
    }

    @JsonProperty("field3")
    public String getField3() {
        return field3;
    }

    @JsonProperty("field3")
    public void setField3(String field3) {
        this.field3 = field3;
    }

    @JsonProperty("field4")
    public String getField4() {
        return field4;
    }

    @JsonProperty("field4")
    public void setField4(String field4) {
        this.field4 = field4;
    }

    @JsonProperty("field5")
    public String getField5() {
        return field5;
    }

    @JsonProperty("field5")
    public void setField5(String field5) {
        this.field5 = field5;
    }

    @JsonProperty("field7")
    public String getField7() {
        return field7;
    }

    @JsonProperty("field7")
    public void setField7(String field7) {
        this.field7 = field7;
    }

    @JsonProperty("field8")
    public String getField8() {
        return field8;
    }

    @JsonProperty("field8")
    public void setField8(String field8) {
        this.field8 = field8;
    }

    @JsonProperty("field9")
    public String getField9() {
        return field9;
    }

    @JsonProperty("field9")
    public void setField9(String field9) {
        this.field9 = field9;
    }

    @JsonProperty("field10")
    public String getField10() {
        return field10;
    }

    @JsonProperty("field10")
    public void setField10(String field10) {
        this.field10 = field10;
    }

    @JsonProperty("field11")
    public String getField11() {
        return field11;
    }

    @JsonProperty("field11")
    public void setField11(String field11) {
        this.field11 = field11;
    }

    @JsonProperty("field12")
    public String getField12() {
        return field12;
    }

    @JsonProperty("field12")
    public void setField12(String field12) {
        this.field12 = field12;
    }

    @JsonProperty("field13")
    public String getField13() {
        return field13;
    }

    @JsonProperty("field13")
    public void setField13(String field13) {
        this.field13 = field13;
    }

    @JsonProperty("field14")
    public String getField14() {
        return field14;
    }

    @JsonProperty("field14")
    public void setField14(String field14) {
        this.field14 = field14;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (email == null ? 0 : email.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User user = (User) obj;
        if (!email.equals(user.email)) {
            return false;
        }
        return true;
    }

    public User() {
    }

    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }
}