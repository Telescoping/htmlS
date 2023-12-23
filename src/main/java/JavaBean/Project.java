package JavaBean;

public class Project {
    private String pno;

    public String getPno() {
        return pno;
    }

    public Project(String pno, String pname, String pfrom, Long pmoney, String ptime, String prole) {
        this.pno = pno;
        this.pname = pname;
        this.pfrom = pfrom;
        this.prole = prole;
        this.pmoney = pmoney;
        this.ptime = ptime;
    }

    public void setPno(String pno) {
        this.pno = pno;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPfrom() {
        return pfrom;
    }

    public void setPfrom(String pfrom) {
        this.pfrom = pfrom;
    }

    public String getProle() {
        return prole;
    }

    public void setProle(String prole) {
        this.prole = prole;
    }

    public Long getPmoney() {
        return pmoney;
    }

    public void setPmoney(Long pmoney) {
        this.pmoney = pmoney;
    }

    public String getPtime() {
        return ptime;
    }

    public void setPtime(String ptime) {
        this.ptime = ptime;
    }

    private String pname;
    private String pfrom;
    private String prole;
    private Long pmoney;
    private String ptime;
}
