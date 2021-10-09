package hpp.project.planner.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity(name = "Project")
@Table(name = "projects")

public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @ManyToOne
    private User user;


    private String project_name;
    private String mon_fri;
    private String sat_sun;


    public Project() {
    }

    public Project(int id, User user, String project_name, String mon_fri, String sat_sun) {
        this.id = id;
        this.user = user;
        this.project_name = project_name;
        this.mon_fri = mon_fri;
        this.sat_sun = sat_sun;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getProject_name() {
        return project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    public String getMon_fri() {
        return mon_fri;
    }

    public void setMon_fri(String mon_fri) {
        this.mon_fri = mon_fri;
    }

    public String getSat_sun() {
        return sat_sun;
    }

    public void setSat_sun(String sat_sun) {
        this.sat_sun = sat_sun;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", user=" + user +
                ", project_name='" + project_name + '\'' +
                ", mon_fri='" + mon_fri + '\'' +
                ", sat_sun='" + sat_sun + '\'' +
                '}';
    }
}
