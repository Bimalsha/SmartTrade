package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.crypto.Data;

@Entity
@Table(name = "product")
public class Product implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "condition_id")
    private ProductCondition condition_id;

    @ManyToOne
    @JoinColumn(name = "model_id")
    private Model model;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    private String decription;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "qty", nullable = false)
    private int qty;

    @ManyToOne
    @JoinColumn(name = "storage_id")
    private Storage storage;

    @ManyToOne
    @JoinColumn(name = "color_id")
    private Color Color;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "date_time", nullable = false)
    private Date dateTime;

    @ManyToOne
    @JoinColumn(name = "product_status_id")
    private Product_status product_status;

    public Product() {
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the condition_id
     */
    public ProductCondition getCondition_id() {
        return condition_id;
    }

    /**
     * @param condition_id the condition_id to set
     */
    public void setCondition_id(ProductCondition condition_id) {
        this.condition_id = condition_id;
    }

    /**
     * @return the model
     */
    public Model getModel() {
        return model;
    }

    /**
     * @param model the model to set
     */
    public void setModel(Model model) {
        this.model = model;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the description
     */
    public String getDecription() {
        return decription;
    }

    /**
     * @param decription the description to set
     */
    public void setDecription(String decription) {
        this.decription = decription;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @return the qty
     */
    public int getQty() {
        return qty;
    }

    /**
     * @param qty the qty to set
     */
    public void setQty(int qty) {
        this.qty = qty;
    }

    /**
     * @return the storage
     */
    public Storage getStorage() {
        return storage;
    }

    /**
     * @param storage the storage to set
     */
    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    /**
     * @return the Color
     */
    public Color getColor() {
        return Color;
    }

    /**
     * @param Color the Color to set
     */
    public void setColor(Color Color) {
        this.Color = Color;
    }

    /**
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * @return the dateTime
     */
    public Date getDateTime() {
        return dateTime;
    }

    /**
     * @param dateTime the dateTime to set
     */
    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    /**
     * @return the product_status
     */
    public Product_status getProduct_status() {
        return product_status;
    }

    /**
     * @param product_status the product_status to set
     */
    public void setProduct_status(Product_status product_status) {
        this.product_status = product_status;
    }

}
