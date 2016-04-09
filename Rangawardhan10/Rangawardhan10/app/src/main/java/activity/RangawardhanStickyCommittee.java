package activity;

/**
 * Created by akashj on 20/11/2015.
 */

        import java.io.Serializable;

public class RangawardhanStickyCommittee implements Serializable {

    private String name, post;
    private int position;

    public RangawardhanStickyCommittee(String name, int position) {
        this(name, "", position);
    }

    public RangawardhanStickyCommittee(String name, String post, int position) {
        this.name = name;
        this.post = post;
        this.position = position;
    }

    public String getName() { return this.name; }
    public String getPost() { return this.post; }
    public int getPosition() { return this.position; }

    public void setName(String name) { this.name = name; }
    public void setPost(String post) { this.post = post; }
    public void setPosition(int position) { this.position = position; }

}
