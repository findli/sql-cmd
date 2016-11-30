package om;

import java.sql.Timestamp;

public class Contact {

    private int id = -1;
    private String name = null;
    private int type_of_phone = 0;
    private String skype = null;
    private String phone = null;
    private String email = null;
    private Timestamp dataCreate = null;
    private User responsibleUserId = null;
    private Position positionId = null;
    private User createById = null;
    private boolean delete = false;


    public Contact(int id, String name, int type_of_phone, String skype, String phone, String email, Timestamp dataCreate, User responsibleUserId,
                   Position positionId, User createById, boolean delete) {
        this.id = id;
        this.name = name;
        this.type_of_phone = type_of_phone;
        this.skype = skype;
        this.phone = phone;
        this.email = email;
        this.dataCreate = dataCreate;
        this.responsibleUserId = responsibleUserId;
        this.positionId = positionId;
        this.createById = createById;
        this.delete = delete;
    }

    public Contact(String name, int type_of_phone, String skype, String phone, String email, Timestamp dataCreate,User responsibleUserId,
                   Position positionId, User createById, boolean delete) {
        this.name = name;
        this.type_of_phone = type_of_phone;
        this.skype = skype;
        this.phone = phone;
        this.email = email;
        this.dataCreate = dataCreate;
        this.responsibleUserId = responsibleUserId;
        this.positionId = positionId;
        this.createById = createById;
        this.delete = delete;
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

    public User getResponsibleUserId() {
        return responsibleUserId;
    }

    public void setResponsibleUserId(User responsibleUserId) {
        this.responsibleUserId = responsibleUserId;
    }

    public Position getPositionId() {
        return positionId;
    }

    public void setPositionId(Position positionId) {
        this.positionId = positionId;
    }

    public int getType_of_phone() {
        return type_of_phone;
    }

    public void setType_of_phone(int type_of_phone) {
        this.type_of_phone = type_of_phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean getDelete() {
        return delete;
    }

    public void setDelete(boolean delete) {
        this.delete = delete;
    }

    public Timestamp getDataCreate() {
        return dataCreate;
    }

    public void setDataCreate(Timestamp dataCreate) {
        this.dataCreate = dataCreate;
    }

    public User getCreateById() {
        return createById;
    }

    public void setCreateById(User createById) {
        this.createById = createById;
    }
}
