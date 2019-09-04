package cn.hbu.cs.maingrid;

public class ListFruit {
    private String name;
    private int imgId;


    public ListFruit(String name, int imgId) {
        this.name = name;
        this.imgId = imgId;
    }

    public String getName() {
        return name;
    }

    public int getImgId() {
        return imgId;
    }
}
