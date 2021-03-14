package ru.example.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import ru.example.utils.EnumTypePostgreSQL;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "users")
@TypeDef(
    name = "enum_pgsql",
    typeClass = EnumTypePostgreSQL.class
)
@SuppressWarnings("unused")
public class User {

    public enum Status {
        Online,
        Away,
        Offline;

        private static final Map<String, Status> mapping = new HashMap<>();

        static {
            mapping.put("Online", Online);
            mapping.put("Away", Away);
            mapping.put("Offline", Offline);
        }

        @JsonCreator
        public static Status fromString(@JsonProperty("Status") String value) {
            return mapping.get(value);
        }
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String username;

    @Column
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    @Column
    @Type(type = "enum_pgsql")
    private Status status;

    @Column(name = "last_activity")
    private Date lastActivity;

    public User() {
        status = Status.Offline;
        lastActivity = Calendar.getInstance().getTime();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getLastActivity() {
        return lastActivity;
    }

    public void setLastActivity(Date lastActivity) {
        this.lastActivity = lastActivity;
    }
}

