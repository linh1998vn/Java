package Assignment;

import java.util.ArrayList;
import java.util.Scanner;

public class DonHangDAO {
    private ArrayList<DonHang> dsDonHang;
    Scanner sc = new Scanner(System.in);

    public DonHangDAO() {
        this.dsDonHang = new ArrayList<DonHang>();
    }

    public ArrayList<DonHang> getDsDonHang() {
        return this.dsDonHang;
    }

    public void setDsDonHang(ArrayList<DonHang> dsDonHang) {
        this.dsDonHang = dsDonHang;
    }

    public void taoDonHang(SanPhamDAO SPD) {
        DonHang dh = new DonHang();
        dh.nhapDonHang();
        String confirm = "";
        System.out.println("Danh sach san pham: ");
        SPD.showDsSanPham();
        do {
            System.out.println("Nhap ma san pham de them");
            String maSP = sc.nextLine();
            int index = SPD.timSanPhamTuMa(maSP);
            if (index == -1) {
                System.out.println("Sai ma san pham");
            } else if (index == -2) {
                System.out.println("Khong tim thay san pham");
            } else {
                int sl = 0;
                do {
                    try {
                        System.out.println("So luong: ");
                        sl = sc.nextInt();
                    } catch (Exception e) {
                        sc.nextLine();
                    }
                } while (sl == 0);
                for (int i = 0; i < sl; i++) {
                    dh.getDsSanPham().add(SPD.getDsSanPham().get(index));
                }
            }
            System.out.println("Them san pham khac vao don hang (N = no):");
            confirm = sc.nextLine();
        } while (!"n".equalsIgnoreCase(confirm));
        this.dsDonHang.add(dh);
    }

    public void showDsDonHang() {
        for (DonHang dh : this.dsDonHang) {
            System.out.println(dh.toString());
        }
    }

    public void taoDonHangDemo(DonHang dh) {
        this.dsDonHang.add(dh);
    }
}