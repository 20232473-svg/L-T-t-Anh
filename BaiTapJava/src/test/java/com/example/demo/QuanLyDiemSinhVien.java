package com.example.demo;

import java.util.Scanner;

public class QuanLyDiemSinhVien {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 1. Nhập dữ liệu
		System.out.print("Nhập mã sinh viên: ");
		String maSV = sc.nextLine();

		System.out.print("Nhập họ tên: ");
		String hoTen = sc.nextLine();

		double diemChuyenCan = nhapDiem(sc, "điểm chuyên cần");
		double diemGiuaKy = nhapDiem(sc, "điểm giữa kỳ");
		double diemCuoiKy = nhapDiem(sc, "điểm cuối kỳ");

		// 2. Tính điểm tổng kết
		double diemTongKet = diemChuyenCan * 0.1 + diemGiuaKy * 0.3 + diemCuoiKy * 0.6;

		// 3. Xếp loại
		String xepLoai = xepLoai(diemTongKet);

		// 4. Hiển thị kết quả
		System.out.println("\n===== KẾT QUẢ =====");
		System.out.printf("%s - %s - %.1f - %s%n", maSV, hoTen, diemTongKet, xepLoai);

		sc.close();
	}

	// Hàm nhập điểm + kiểm tra dữ liệu (0-10)
	private static double nhapDiem(Scanner sc, String tenDiem) {
		double diem;
		while (true) {
			System.out.print("Nhập " + tenDiem + " (0-10): ");
			try {
				diem = sc.nextDouble();
				sc.nextLine(); // xóa bộ đệm
				if (diem >= 0 && diem <= 10) {
					return diem;
				}
				System.out.println("→ Điểm không hợp lệ! Vui lòng nhập lại (0-10).");
			} catch (Exception e) {
				System.out.println("→ Bạn phải nhập số! Vui lòng nhập lại.");
				sc.nextLine(); // xóa dữ liệu sai
			}
		}
	}

	// Hàm xếp loại
	private static String xepLoai(double diem) {
		if (diem >= 8.5)
			return "A";
		if (diem >= 7.0)
			return "B";
		if (diem >= 5.5)
			return "C";
		if (diem >= 4.0)
			return "D";
		return "F";
	}
}