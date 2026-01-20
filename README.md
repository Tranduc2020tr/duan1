# 🏢 DỰ ÁN 1 – HỆ THỐNG QUẢN LÝ NHÂN SỰ

> Dự án xây dựng **hệ thống quản lý nhân sự** giúp doanh nghiệp theo dõi thông tin nhân viên, phòng ban, chấm công và lương một cách **chính xác, bảo mật và hiệu quả**.

---

## 📌 Mục lục

* [Giới thiệu](#-giới-thiệu)
* [Mục tiêu dự án](#-mục-tiêu-dự-án)
* [Công nghệ sử dụng](#-công-nghệ-sử-dụng)
* [Chức năng chính](#-chức-năng-chính)
* [Cài đặt & sử dụng](#-cài-đặt--sử-dụng)
* [Cấu trúc hệ thống](#-cấu-trúc-hệ-thống)
* [Cơ sở dữ liệu](#-cơ-sở-dữ-liệu)
* [Hướng phát triển](#-hướng-phát-triển)
* [Tác giả](#-tác-giả)

---

## 📖 Giới thiệu

**Hệ thống Quản lý Nhân sự** được xây dựng nhằm hỗ trợ doanh nghiệp:

* Quản lý thông tin nhân viên tập trung
* Giảm sai sót trong quản lý chấm công, lương
* Tăng hiệu quả vận hành và tính minh bạch

Đây là **Dự án 1** trong chương trình học tại **FPT Polytechnic**, áp dụng kiến thức lập trình và cơ sở dữ liệu.

---

## 🎯 Mục tiêu dự án

* Áp dụng kiến thức **CSDL & lập trình ứng dụng**
* Thiết kế hệ thống theo đúng **nghiệp vụ thực tế**
* Rèn luyện tư duy **CRUD – logic – bảo mật**
* Chuẩn bị nền tảng cho các dự án lớn hơn sau này

---

## 🛠 Công nghệ sử dụng

### Backend / Logic

* Java / Java Swing (hoặc Web tùy triển khai)
* JDBC kết nối cơ sở dữ liệu

### Database

* SQL Server / MySQL
* Trigger, Stored Procedure, View

### Công cụ

* Git & GitHub
* SQL Server Management Studio
* NetBeans / IntelliJ IDEA

---

## ✨ Chức năng chính

### 👤 Quản lý nhân viên

* Thêm, sửa, xoá, tìm kiếm nhân viên
* Quản lý thông tin cá nhân, chức vụ, phòng ban

### 🏢 Quản lý phòng ban & chức vụ

* Thêm / cập nhật phòng ban
* Phân công nhân viên theo phòng ban

### ⏱ Chấm công

* Ghi nhận ngày công
* Theo dõi đi làm, nghỉ phép

### 💰 Quản lý lương

* Tính lương dựa trên:

  * Ngày công
  * Chức vụ
  * Thưởng / phạt
* Thống kê lương theo tháng

### 🔐 Tài khoản & phân quyền

* Đăng nhập hệ thống
* Phân quyền: Admin / Nhân viên

---

## 🚀 Cài đặt & sử dụng

### 1️⃣ Clone project

```bash
git clone https://github.com/username/quan-ly-nhan-su.git
```

### 2️⃣ Import database

* Mở file `database.sql`
* Chạy script tạo bảng, dữ liệu mẫu

### 3️⃣ Cấu hình kết nối CSDL

```java
String url = "jdbc:sqlserver://localhost:1433;databaseName=QLNS";
String user = "sa";
String password = "123456";
```

### 4️⃣ Chạy ứng dụng

* Run project trong IDE
* Đăng nhập bằng tài khoản admin

---

## 🧩 Cấu trúc hệ thống

```bash
QLNS/
├── src/
│   ├── model/
│   ├── repository/
│   ├── service/
│   └── ui/
├── database/
│   └── qlns.sql
├── README.md
```

---

## 🗄 Cơ sở dữ liệu

Các bảng chính:

* NhanVien
* PhongBan
* ChucVu
* ChamCong
* Luong
* TaiKhoan

Áp dụng:

* Khóa chính, khóa ngoại
* Trigger tự động cập nhật
* Stored Procedure tính lương

---

## 🔮 Hướng phát triển

* Nâng cấp lên Web (Spring Boot / REST API)
* Thêm biểu đồ thống kê
* Xuất file Excel / PDF
* Phân quyền chi tiết hơn
* Deploy hệ thống thực tế

---

## 👨‍💻 Tác giả

* **Trần Anh Đức**
* Sinh viên **FPT Polytechnic**
* GitHub: [https://github.com/your-username](https://github.com/your-username)

---

⭐ Nếu bạn thấy dự án hữu ích, hãy **Star** repository để ủng hộ nhé!
