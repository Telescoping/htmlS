package JavaBean;

public class Department {
    private String dno;
    private String dname;

    public String getDno() {
        return dno;
    }

    public Department(String dno, String dname, String dcontrol, String dadress, String dpostcode, Long dphone) {
        this.dno = dno;
        this.dname = dname;
        this.dcontrol = dcontrol;
        this.dadress = dadress;
        this.dpostcode = dpostcode;
        this.dphone = dphone;
    }

    public void setDno(String dno) {
        this.dno = dno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getDcontrol() {
        return dcontrol;
    }

    public void setDcontrol(String dcontrol) {
        this.dcontrol = dcontrol;
    }

    public String getDadress() {
        return dadress;
    }

    public void setDadress(String dadress) {
        this.dadress = dadress;
    }

    public String getDpostcode() {
        return dpostcode;
    }

    public void setDpostcode(String dpostcode) {
        this.dpostcode = dpostcode;
    }

    public Long getDphone() {
        return dphone;
    }

    public void setDphone(Long dphone) {
        this.dphone = dphone;
    }

    private String dcontrol;
    private String dadress;
    private String dpostcode;
    private Long dphone;
}
