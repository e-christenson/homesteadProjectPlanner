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
    private String helper;
    private String store;

    private String in_out;

    private String hot_cold;

    private String windy;


    public Project(int id, User user, String project_name, String mon_fri, String sat_sun, String helper, String store, String in_out, String hot_cold, String windy) {
        this.id = id;
        this.user = user;
        this.project_name = project_name;
        this.mon_fri = mon_fri;
        this.sat_sun = sat_sun;
        this.helper = helper;
        this.store = store;
        this.in_out = in_out;
        this.hot_cold = hot_cold;
        this.windy = windy;
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

    public String getHelper() {
        return helper;
    }

    public void setHelper(String helper) {
        this.helper = helper;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public String getIn_out() {
        return in_out;
    }

    public void setIn_out(String in_out) {
        this.in_out = in_out;
    }

    public String getHot_cold() {
        return hot_cold;
    }

    public void setHot_cold(String hot_cold) {
        this.hot_cold = hot_cold;
    }

    public String getWindy() {
        return windy;
    }

    public void setWindy(String windy) {
        this.windy = windy;
    }

    /**
     * Instantiates a new Project.
     */
    public Project() {
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", user=" + user +
                ", project_name='" + project_name + '\'' +
                ", mon_fri='" + mon_fri + '\'' +
                ", sat_sun='" + sat_sun + '\'' +
                ", helper='" + helper + '\'' +
                ", store='" + store + '\'' +
                ", in_out='" + in_out + '\'' +
                ", hot_cold='" + hot_cold + '\'' +
                ", windy='" + windy + '\'' +
                '}';
    }
}
