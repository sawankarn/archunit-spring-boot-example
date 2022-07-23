package youtube.java.puzzle.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "client")
@Data
public class Client {
    @Id
    @Column(nullable = false, length = 100)
    private int id;

    @Column(nullable = false, length = 100)
    private String firstname;

    @Column(nullable = false, length = 100)
    private String lastname;

    @Column(nullable = true, length = 100)
    private String documentType;

    @Column(nullable = true, length = 100)
    private String documentNumber;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client)) return false;
        Client client = (Client) o;
        return Objects.equals( firstname, client.firstname ) && Objects.equals( lastname, client.lastname ) && Objects.equals( documentType, client.documentType ) && Objects.equals( documentNumber, client.documentNumber );
    }

    @Override
    public int hashCode() {
        return Objects.hash( firstname, lastname, documentType, documentNumber );
    }
}
