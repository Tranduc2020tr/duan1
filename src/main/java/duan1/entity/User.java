package duan1.entity;

public class User {
    private String tendangnhap;
    private String matkhau;
    private boolean VaiTro;
    private String MaNV;
    private boolean TrangThai;
     private String fullname;
     private int roleid;
     private String rolename;

    public User(){}

    public User(String tendangnhap, String matkhau, boolean VaiTro, String MaNV, boolean TrangThai, String fullname) {
        this.tendangnhap = tendangnhap;
        this.matkhau = matkhau;
        this.VaiTro = VaiTro;
        this.MaNV = MaNV;
        this.TrangThai = TrangThai;
        this.fullname = fullname;
    }

    public String getTendangnhap() {
        return tendangnhap;
    }

    public void setTendangnhap(String tendangnhap) {
        this.tendangnhap = tendangnhap;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public boolean isVaiTro() {
        return VaiTro;
    }

    public void setVaiTro(boolean VaiTro) {
        this.VaiTro = VaiTro;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public boolean isTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(boolean TrangThai) {
        this.TrangThai = TrangThai;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }
}
