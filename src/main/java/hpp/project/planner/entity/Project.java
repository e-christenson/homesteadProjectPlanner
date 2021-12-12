package hpp.project.planner.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
    private LocalDate date;
    private String mon_fri;
    private String sat_sun;
    private String helper;
    private String store;
    private String in_out;
    private String hot_cold;
    private String windy;
    private int weather_score;

    //@OneToMany(mappedBy = "parent_project", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
   // private List<Store> stores;


    public Project(int id, User user, String project_name, LocalDate date, String mon_fri, String sat_sun, String helper, String store, String in_out, String hot_cold, String windy, int weather_score) {
        this.id = id;
        this.user = user;
        this.project_name = project_name;
        this.date = date;
        this.mon_fri = mon_fri;
        this.sat_sun = sat_sun;
        this.helper = helper;
        this.store = store;
        this.in_out = in_out;
        this.hot_cold = hot_cold;
        this.windy = windy;
        this.weather_score = weather_score;
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getWeather_score() {
        return weather_score;
    }

    public void setWeather_score(int weather_score) {
        this.weather_score = weather_score;
    }

    /*
    public List<Store> getStores() {
        return stores;
    }

    public void setStores(List<Store> stores) {
        this.stores = stores;
    }

    public void addStore(Store store){
        stores.add(store);
        store.setProject(this);
    }

    public void removeStore(Store store){
        stores.add(store);
        store.setProject(null);
    }
*/

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
                ", date=" + date +
                ", mon_fri='" + mon_fri + '\'' +
                ", sat_sun='" + sat_sun + '\'' +
                ", helper='" + helper + '\'' +
                ", store='" + store + '\'' +
                ", in_out='" + in_out + '\'' +
                ", hot_cold='" + hot_cold + '\'' +
                ", windy='" + windy + '\'' +
                ", weather_score=" + weather_score +
                '}';
    }
}
