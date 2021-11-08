package Assignment;

import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Main {    static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
static Scanner sc = new Scanner(System.in);
static NhomHangDAO NHD = new NhomHangDAO();
static SanPhamDAO SPD = new SanPhamDAO();
static DonHangDAO DHD = new DonHangDAO();

public static void main(String[] args) {
	  
    int choose;
	do {
            showMenu();
            choose = sc.nextInt();
            switch (choose) {
            case 1: 
              
                int menu1;
                do {
                    crudNhomHang();
                    menu1 = sc.nextInt();
                    switch (menu1) {
                    case 1:
                        System.out.println("Them nhom hang");
                        NHD.taoNhomHang();
                        break;
                    case 2:
                        System.out.println("Hien thi danh sach nhom hang");
                        NHD.showDsNhomHang();
                        break;
                    case 3:
                        System.out.println("Tim kiem nhom hang:");
                        sc.nextLine();
                        System.out.println("Nhap ma nhom hang can tim: ");
                        String maNH = sc.nextLine();
                        int index = NHD.timNhomHangTuMa(maNH);
                        if (index == -1) {
                            System.out.println("Ma nhom hang sai");
                        } else if (index == -2) {
                            System.out.println("khong tim thay nhom hang");
                        } else {
                            System.out.println(NHD.getDsNhomHang().get(index));
                        }
                        break;
                    case 4:
                        break;
                    default:
                        System.out.println("Lua chon khong hop le");
                        break;
                    }
                } while (menu1 >= 1 && menu1 <= 4);
                break;
            case 2:
                int menu2;
                do {
                    crudSanPham();
                    menu2 = sc.nextInt();
                    int index = -1;
                    String maSP = "";
                    switch (menu2) {
                    case 1: 
                        System.out.println("Them san pham moi");
                        SPD.taoSanPham(NHD);
                        break;
                    case 2:
                        System.out.println("Hien thi danh sach san pham");
                        SPD.showDsSanPham();
                        break;
                    case 3:
                    	System.out.println("Nhap ma san phan");
						sc.nextLine();
                        System.out.println("Nhap ma san pham can tim: ");
                        maSP = sc.nextLine();
                        index = SPD.timSanPhamTuMa(maSP);
                        if (index == -1) {
                            System.out.println("Ma san pham nhap sai.");
                        } else if (index == -2) {
                            System.out.println("Khong tim thay san pham");
                        } else {
                            System.out.println(SPD.getDsSanPham().get(index).toDetail());
                        }
						break;
                
                    case 4:
                    	System.out.println("Tim kiem nhom hang tu ma san pham");
                        sc.nextLine();
                        System.out.println("Nhap ma san pham can tim Nhom Hang: ");
                        maSP = sc.nextLine();
                        index = SPD.timSanPhamTuMa(maSP);
                        if (index == -1) {
                            System.out.println("Ma san pham nhap sai.");
                        } else if (index == -2) {
                            System.out.println("Khong tim thay nhom hang nao tu ma vua nhap.");
                        } else {
                            String maNH = SPD.getDsSanPham().get(index).getNhomHang().getMaNhomHang();
                            index = NHD.timNhomHangTuMa(maNH);
                            System.out.println(NHD.getDsNhomHang().get(index));
                        }
                        break;
                    case 5:
                        System.out.println("----------Update san pham----------");
                        sc.nextLine();
                        System.out.println("Nhap ma san pham can sua thong tin: ");
                        maSP = sc.nextLine();
                        SPD.updateSanPham(maSP, NHD);
                        break;
                    case 6:
                        break;
                    default:
                        System.out.println("Lua chon khong hop le");
                        break;
                    }
                    if (menu2 == 6) {
                        break;
                    }
                } while (menu2 != 6);
                break;
             
            case 3: 
                
            	int menu3;
                do {
                    crudDonHang();
                    System.out.println("Nhap lua chon: ");
                    menu3 = sc.nextInt();
                    switch (menu3) {
                    case 1: 
                        System.out.println("Tao don hang:");
                        DHD.taoDonHang(SPD);
                        break;
                    case 2: 
                        System.out.println("Hien thi danh sach don hang:");
                        DHD.showDsDonHang();
                        break;
                    case 3: 
						System.out.println("Thoat");
						break;
                    default:
                        System.out.println("Lua chon khong hop le");
                        break;
                    }
                  
                } while (menu3 >= 1 && menu3 <= 2);
                break;
            case 4: 
                break;
                
            case 5:
                break;
            default:
                System.out.println("Lua chon khong hop le");
                break;
            }
            
        
    } while( choose >= 1 && choose <= 4);
}

public static void showMenu() {
    System.out.println("---------MAIN MENU---------");
    System.out.println("1. CRUD Nhom Hang.");
    System.out.println("2. CRUD San Pham.");
    System.out.println("3. CRUD Don Hang.");
    System.out.println("4. Bao Cao.");
    System.out.println("5. Thoat.");
 }

 public static void crudNhomHang() {
	System.out.println("CRUD NHOM HANG");
    System.out.println("1. Them Nhom Hang.");
    System.out.println("2. Show DS Nhom Hang.");
    System.out.println("3. Tim Nhom Hang.");
    System.out.println("4. Back to MAIN MENU.");
 }

 public static void crudSanPham() {
    System.out.println("CRUD SAN PHAM");
    System.out.println("1. Them San Pham.");
    System.out.println("2. Show DS San Pham.");
    System.out.println("3. Tim San pham Theo Ma San Pham.");
    System.out.println("4. Tim Nhom Hang Theo Ma San Pham.");
    System.out.println("5. Sua Thong tin San Pham.");
    System.out.println("6. Back to MAIN MENU.");
 }

 public static void crudDonHang() {
    System.out.println("CRUD DON HANG");
    System.out.println("1. Them Don Hang.");
    System.out.println("2. Show All DS Don Hang.");
    System.out.println("3. Show DS Don Hang theo thang.");
    System.out.println("4. Back to MAIN MENU.");
   }

 public static void baoCao() {
    System.out.println("BAO CAO");
    System.out.println("1. Bao Cao doanh so ca nam.");
    System.out.println("2. Bao Cao doanh so theo thang.");
    System.out.println("3. Bao Cao Top 3 san pham ban chay theo thang.");
    System.out.println("4. Back to MAIN MENU.");
 }

}

