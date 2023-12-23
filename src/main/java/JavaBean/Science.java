package JavaBean;

public class Science {
    private String sno;

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public Science(String sno, String sname, String ssort, String slevel, String sgrade, String srank, String sdate) {
        this.sno = sno;
        this.sname = sname;
        this.ssort = ssort;
        this.slevel = slevel;
        this.sgrade = sgrade;
        this.srank = srank;
        this.sdate = sdate;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSsort() {
        return ssort;
    }

    public void setSsort(String ssort) {
        this.ssort = ssort;
    }

    public String getSlevel() {
        return slevel;
    }

    public void setSlevel(String slevel) {
        this.slevel = slevel;
    }

    public String getSgrade() {
        return sgrade;
    }

    public void setSgrade(String sgrade) {
        this.sgrade = sgrade;
    }

    public String getSrank() {
        return srank;
    }

    public void setSrank(String srank) {
        this.srank = srank;
    }

    public String getSdate() {
        return sdate;
    }

    public void setSdate(String sdate) {
        this.sdate = sdate;
    }

    private String sname;
    private String ssort;
    private String slevel;
    private String sgrade;
    private String srank;
    private String sdate;
}
