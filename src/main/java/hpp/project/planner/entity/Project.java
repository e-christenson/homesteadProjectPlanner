package hpp.project.planner.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * The type Project.
 */
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


    /**
     * Instantiates a new Project.
     */
    public Project() {
    }

    /**
     * Instantiates a new Project.
     *
     * @param id           the id
     * @param user         the user
     * @param project_name the project name
     * @param mon_fri      the mon fri
     * @param sat_sun      the sat sun
     */
    public Project(int id, User user, String project_name, String mon_fri, String sat_sun) {
        this.id = id;
        this.user = user;
        this.project_name = project_name;
        this.mon_fri = mon_fri;
        this.sat_sun = sat_sun;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets user.
     *
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets user.
     *
     * @param user the user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Gets project name.
     *
     * @return the project name
     */
    public String getProject_name() {
        return project_name;
    }

    /**
     * Sets project name.
     *
     * @param project_name the project name
     */
    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    /**
     * Gets mon fri.
     *
     * @return the mon fri
     */
    public String getMon_fri() {
        return mon_fri;
    }

    /**
     * Sets mon fri.
     *
     * @param mon_fri the mon fri
     */
    public void setMon_fri(String mon_fri) {
        this.mon_fri = mon_fri;
    }

    /**
     * Gets sat sun.
     *
     * @return the sat sun
     */
    public String getSat_sun() {
        return sat_sun;
    }

    /**
     * Sets sat sun.
     *
     * @param sat_sun the sat sun
     */
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
