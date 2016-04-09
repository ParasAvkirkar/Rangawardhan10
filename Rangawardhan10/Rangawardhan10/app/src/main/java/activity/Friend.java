package activity;

/**
 * Created by Dell on 11/24/2015.
 */
public class Friend {
    private String name, phoneNo, emailId;
    private int imageId;

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public Friend(int id, String name, String emailId, String phoneNo) {
        this.imageId = id;
        this.name = name;
        this.phoneNo = phoneNo;
        this.emailId = emailId;
    }
    Friend(){}



    public String name() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName(){return name;}

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
}
