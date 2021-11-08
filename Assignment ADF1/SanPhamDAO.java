package Assignment;

import java.util.ArrayList;
import java.util.Scanner;

public class SanPhamDAO {
    private ArrayList<SanPham> dsSanPham;
    Scanner sc = new Scanner(System.in);

    public SanPhamDAO() {
        this.dsSanPham = new ArrayList<SanPham>();
    }

    public ArrayList<SanPham> getDsSanPham() {
        return this.dsSanPham;
    }

    public void setDsSanPham(ArrayList<SanPham> dsSanPham) {
        this.dsSanPham = dsSanPham;
    }

    public void taoSanPham(NhomHangDAO NHD) {
        System.out.println("Danh sach nhom hang: ");
        NHD.showDsNhomHang();
        System.out.println("Nhap ma nhom hang muon them: ");
        String maNH = sc.nextLine();
        int index = NHD.timNhomHangTuMa(maNH);
        if (index == -1) {
            System.out.println("Ma nhom hang sai");
        } else if (index == -2) {
            System.out.println("Nhom hang khong ton tai");
        } else {
            NhomHang nh = NHD.getDsNhomHang().get(index);
            SanPham sp = new SanPham();
            sp.nhapSanPham(nh);
            this.dsSanPham.add(sp);
        }
    }

    public void taoSanPham(SanPham sp) {
        this.dsSanPham.add(sp);
    }

    public int timSanPhamTuMa(String maSP) {
        if (maSP == null || maSP.length() != 8) {
            return -1;
            
        } else {
            for (int i = 0; i < this.dsSanPham.size(); i++) {
                if (this.dsSanPham.get(i).getMaSanPham().equalsIgnoreCase(maSP)) {
                    return i;
                }
            }
        }
        return -2;
       
    }

    public void showDsSanPham() {
        for (SanPham sanPham : this.dsSanPham) {
            System.out.println(sanPham.toList());
        }
    }

    public void updateSanPham(String maSP, NhomHangDAO nhd) {
        if (maSP == null || maSP.length() != 8) {
            System.out.println("Ma san pham khong dung");
        } else {
            int index = this.timSanPhamTuMa(maSP);
            if (index == -2) {
                System.out.println("Khong tim thay san pham");
            } else {
                System.out.println("Danh sach nhom hang: ");
                nhd.showDsNhomHang();
                System.out.println("Chon nhom hang moi cho san pham: ");
                String maNH = sc.nextLine();
                int indexNH = nhd.timNhomHangTuMa(maNH);
                if (indexNH == -1) {
                    System.out.println("Ma nhom hang nhap sai");
                } else if (indexNH == -2) {
                    System.out.println("Nhom hang khong ton tai");
                } else {
                    NhomHang nh = nhd.getDsNhomHang().get(indexNH);
                    SanPham sp = this.dsSanPham.get(index);
                    sp.capNhatSanPham(nh, sp);
                    this.dsSanPham.set(index, sp);
                    if (this.dsSanPham.set(index, sp) == null) {
                        System.out.println("Cap nhat san pham that bai");
                    } else {
                        System.out.println("Cap nhat san pham thanh cong");
                    }
                }
            }
        }
    }
}

