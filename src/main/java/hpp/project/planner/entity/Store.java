package hpp.project.planner.entity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**

 */

@Entity(name = "Store")
@Table(name = "store")
public class Store {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    //@ManyToOne
   // private Project parent_project;
    private int project_id;
    private int user_id;

    private String item;

    public Store(int id, int project, int user_id, String item) {
        this.id = id;
        this.project_id = project;
        this.user_id = user_id;
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

    public int getProject() {
        return project_id;
    }

    public void setProject(int project) {
        this.project_id = project;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return " "+item;
    }
}
