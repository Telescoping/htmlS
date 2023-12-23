package JavaBean;

public class Participator {
    private String rno;
    private String rname;

    public String getRno() {
        return rno;
    }

    public void setRno(String rno) {
        this.rno = rno;
    }

    public Participator(String rno, String rname, String rsex, String rdate, String rnation, String rdegree, String dno, String rjobtime, String rtitle, String rsalary, String rjobsalary, String rhelpsalary) {
        this.rno = rno;
        this.rname = rname;
        this.rsex = rsex;
        this.rdate = rdate;
        this.rnation = rnation;
        this.rdegree = rdegree;
        this.dno = dno;
        this.rjobtime = rjobtime;
        this.rtitle = rtitle;
        this.rsalary = rsalary;
        this.rjobsalary = rjobsalary;
        this.rhelpsalary = rhelpsalary;

    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public String getRsex() {
        return rsex;
    }

    public void setRsex(String rsex) {
        this.rsex = rsex;
    }

    public String getRnation() {
        return rnation;
    }

    public void setRnation(String rnation) {
        this.rnation = rnation;
    }

    public String getRdegree() {
        return rdegree;
    }

    public void setRdegree(String rdegree) {
        this.rdegree = rdegree;
    }

    public String getRtitle() {
        return rtitle;
    }

    public void setRtitle(String rtitle) {
        this.rtitle = rtitle;
    }

    public String getRdate() {
        return rdate;
    }

    public void setRdate(String rdate) {
        this.rdate = rdate;
    }

    public String getRjobtime() {
        return rjobtime;
    }

    public void setRjobtime(String rjobtime) {
        this.rjobtime = rjobtime;
    }

    public String getRsalary() {
        return rsalary;
    }

    public void setRsalary(String rsalary) {
        this.rsalary = rsalary;
    }

    public String getRjobsalary() {
        return rjobsalary;
    }

    public void setRjobsalary(String rjobsalary) {
        this.rjobsalary = rjobsalary;
    }

    public String getRhelpsalary() {
        return rhelpsalary;
    }

    public void setRhelpsalary(String rhelpsalary) {
        this.rhelpsalary = rhelpsalary;
    }

    public String getDno() {
        return dno;
    }

    public void setDno(String dno) {
        this.dno = dno;
    }

    private String rsex;
    private String rnation;
    private String rdegree;
    private String rtitle;
    private String rdate;
    private String rjobtime;
    private String rsalary;
    private String rjobsalary;
    private String rhelpsalary;
    private String dno;
}
