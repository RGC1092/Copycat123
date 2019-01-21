package com.evoqis.apps.manibhai;

/**
 * Created by Evoqis on 15/12/2017.
 */

public class MandalPojo {
    int images;
    String name,post;

    public MandalPojo(int images, String name, String post) {
        this.images = images;
        this.name = name;
        this.post = post;
    }

    public int getImages() {
        return images;
    }

    public void setImages(int images) {
        this.images = images;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }
}
