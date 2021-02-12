package nl.saxion.oop.week1;

public class Video {
    private String title;
    private int views;
    private boolean seen;
    private String id;

    public void setTitle(String title){
        this.title = title;
    }
    public void setViews(int views){
        this.views = views;
    }
    public void setSeen(Boolean seen){
        this.seen = seen;
    }
    public void setId(String id){
        this.id = id;
    }

    public boolean isSeen() {
        return seen;
    }

    public void setSeen(boolean seen) {
        this.seen = seen;
    }



    @Override
    public String toString() {
        return title + " - " + id + " (" + views + ")";
    }
}
