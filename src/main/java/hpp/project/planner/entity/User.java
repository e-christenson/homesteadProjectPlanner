package hpp.project.planner.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**

 */

@Entity(name = "User")
@Table(name = "user")
public class User {



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")

    private int id;
    private String name;
    private String email;
    private String lonLat;
    private int zip_code;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)


    private Set<Project> Projects = new HashSet<>();



   public User() {
    }

    public User(int id, String name, String email, String lonLat, int zip_code) {
       this.id = id;
       this.name = name;
        this.email = email;
        this.lonLat = lonLat;
        this.zip_code = zip_code;
    }





    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLonLat() {
        return lonLat;
    }

    public void setLonLat(String password) {
        this.lonLat = password;
    }

    public int getZip_code() {
        return zip_code;
    }

    public void setZip_code(int zip_code) {
        this.zip_code = zip_code;
    }

    public Set<Project> getProjects() {
        return Projects;
    }

    public void setProjects(Set<Project> projects) {
        Projects = projects;
    }

    public void addProject(Project project) {
        Projects.add(project);
        project.setUser(this);
    }

    public void removeProject(Project project) {
        Projects.add(project);
        project.setUser(null);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + lonLat + '\'' +
                ", zip_code=" + zip_code +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && zip_code == user.zip_code && Objects.equals(name, user.name) && Objects.equals(email, user.email) && Objects.equals(lonLat, user.lonLat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, lonLat, zip_code);
    }


}

