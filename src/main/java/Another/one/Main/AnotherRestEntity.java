package Another.one.Main;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class AnotherRestEntity {
    @Id
    @GeneratedValue
    private Long Id;
    private String name;
    private String address;

    public AnotherRestEntity(String name, String address) {
        this.name = name;
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnotherRestEntity that = (AnotherRestEntity) o;
        return Objects.equals(Id, that.Id) && Objects.equals(name, that.name) && Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, name, address);
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "AnotherRestEntity{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public AnotherRestEntity() {}
}
