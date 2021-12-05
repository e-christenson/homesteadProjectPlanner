package hpp.project.planner.entity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**

 */

@Entity(name = "Store")
@Table(name = "store")
public class Store {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;
    @ManyToOne
    private Project project;

    private String item;

    public Store(int id, Project project, String item) {
        this.id = id;
        this.project = project;
        this.item = item;
    }

    public Store() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "Store{" +
                "id=" + id +
                ", project=" + project +
                ", item='" + item + '\'' +
                '}';
    }
}
