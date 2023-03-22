package po;

public class Image {
    private String image_name;
    private int img;

    public Image() {
    }

    public Image(String image_name, int img) {
        this.image_name = image_name;
        this.img = img;
    }

    public String getImage_name() {
        return image_name;
    }

    public void setImage_name(String image_name) {
        this.image_name = image_name;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "Image{" +
                "image_name='" + image_name + '\'' +
                ", img=" + img +
                '}';
    }
}
