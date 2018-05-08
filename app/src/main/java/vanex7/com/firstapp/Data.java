package vanex7.com.firstapp;

public class Data {
    private int imgID;
    private String content;

    public Data() {
    }

    public Data(int imgID, String content) {
        this.imgID = imgID;
        this.content = content;
    }

    public int getImgID() {
        return imgID;
    }

    public void setImgID(int imgID) {
        this.imgID = imgID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
