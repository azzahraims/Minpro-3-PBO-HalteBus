# Sistem Manajemen Halte Bus ˚ ༘ 🚍⋆｡˚

Az-Zahra Imsawati Sugianto - 2509116062

---

## Deskripsi Singkat Program

Sistem Manajemen Halte Bus merupakan program berbasis Java yang digunakan oleh admin untuk mengelola data halte bus. Program ini merupakan pengembangan dari Mini Project 2 dengan menerapkan konsep **polymorphism**, **abstraction**, serta struktur **MVC (Model-View-Controller)**.

Program menyediakan fitur CRUD (Create, Read, Update, Delete) yang terdiri dari menambah, melihat, mengubah, dan menghapus data halte. Data halte disimpan menggunakan `ArrayList`.

Pada program terdapat dua jenis halte, yaitu **Halte Reguler** dan **Halte Transit**. Halte Reguler memiliki data khusus berupa titik tujuan, sedangkan Halte Transit memiliki data khusus berupa rute penghubung.

ID halte dibuat secara otomatis oleh sistem dengan urutan H001, H002, H003, dan seterusnya sehingga admin tidak perlu memasukkan ID secara manual.

---

## Struktur Package

Program menerapkan struktur MVC dengan memisahkan class ke dalam beberapa package sesuai dengan fungsinya.

[MASUKKAN SCREENSHOT STRUKTUR PACKAGE]

- **Model** berisi `Halte`, `HalteReguler`, `HalteTransit`, dan `InformasiHalte`. Package ini digunakan untuk membentuk dan menyimpan struktur data halte.
- **View** berisi `HalteView` yang digunakan untuk menampilkan menu serta menerima input dari pengguna.
- **Controller** berisi `HalteController` yang digunakan untuk mengatur proses pengelolaan data halte.
- **Util** berisi `InputValidator` yang digunakan untuk membantu proses validasi input.
- **Main** berisi `Main` yang berdiri sendiri sebagai entry point untuk menjalankan program.

Pemisahan tersebut membuat setiap bagian program memiliki fungsi dan tanggung jawab yang lebih terorganisir.

---

## Alur Program

Saat program dijalankan, `Main` akan menjalankan `HalteView` untuk menampilkan menu utama. Menu utama terdiri dari:

1. **Tambah Halte:** Admin dapat menambahkan data dengan memilih Halte Reguler atau Halte Transit. Sistem akan memeriksa nama dan lokasi halte untuk mencegah data yang sama. ID halte dibuat secara otomatis sebelum data disimpan ke dalam `ArrayList`.
2. **Lihat Data Halte:** Admin dapat melihat seluruh data halte yang tersimpan. Program memiliki dua dummy data awal, yaitu Halte Reguler dan Halte Transit.
3. **Ubah Data Halte:** Admin memasukkan ID halte yang ingin diubah. Sistem akan mencari halte berdasarkan ID tersebut. Jika ditemukan, admin dapat memasukkan data baru.
4. **Hapus Halte:** Admin memasukkan ID halte yang ingin dihapus. Sistem akan mencari data berdasarkan ID dan menghapusnya apabila ditemukan.
5. **Keluar:** Admin dapat memilih menu keluar untuk mengakhiri program.

Setelah proses pada menu selesai dilakukan, program akan kembali menampilkan menu utama sampai admin memilih menu Keluar.

---

## Penerapan Encapsulation

Encapsulation diterapkan pada class `Halte`, `HalteReguler`, dan `HalteTransit`. Atribut pada setiap class menggunakan access modifier `private` sehingga tidak dapat diakses secara langsung dari luar class.

Akses dan perubahan nilai atribut dilakukan melalui method getter dan setter. Setter pada program juga dilengkapi dengan validasi terhadap nilai yang diberikan.

[MASUKKAN SCREENSHOT ENCAPSULATION]

Pada class `Halte`, atribut `idHalte` juga menggunakan keyword `final`.

`final` digunakan agar ID halte tidak dapat diubah setelah objek dibuat. Oleh karena itu, `idHalte` hanya memiliki getter dan tidak memiliki setter.

---

## Penerapan Inheritance

Inheritance diterapkan dengan menjadikan abstract class `Halte` sebagai **superclass**, sedangkan `HalteReguler` dan `HalteTransit` sebagai **subclass**.

Class `HalteReguler` dan `HalteTransit` menggunakan `extends Halte` sehingga dapat mewarisi atribut dan method yang dimiliki oleh superclass.

[MASUKKAN SCREENSHOT INHERITANCE HALTE REGULER]

[MASUKKAN SCREENSHOT INHERITANCE HALTE TRANSIT]

`HalteReguler` memiliki atribut tambahan `titikTujuan`, sedangkan `HalteTransit` memiliki atribut tambahan `rutePenghubung`.

Constructor pada kedua subclass menggunakan `super()` untuk memanggil constructor dari superclass `Halte`.

---

## Penerapan Polymorphism

Polymorphism pada program diterapkan melalui **method overriding** dan **method overloading**.

### Method Overriding

Method overriding diterapkan pada method `tampilkanInfo()` dan `tampilkanJenisHalte()`.

Method tersebut diterapkan kembali pada `HalteReguler` dan `HalteTransit` sehingga masing-masing jenis halte dapat menampilkan informasi sesuai dengan karakteristiknya.

[MASUKKAN SCREENSHOT OVERRIDING HALTE REGULER]

Pada `HalteReguler`, method `tampilkanInfo()` menampilkan informasi tambahan berupa titik tujuan.

[MASUKKAN SCREENSHOT OVERRIDING HALTE TRANSIT]

Pada `HalteTransit`, method `tampilkanInfo()` menampilkan informasi tambahan berupa rute penghubung.

Dengan method overriding, pemanggilan method yang sama dapat menghasilkan informasi yang berbeda sesuai dengan jenis objek halte.

### Method Overloading

Method overloading diterapkan pada method `cariHalte()` di dalam `HalteController`.

[MASUKKAN SCREENSHOT DUA METHOD CARI HALTE]

Method `cariHalte()` pertama menerima satu parameter berupa ID halte dan digunakan pada proses ubah serta hapus data.

Method `cariHalte()` kedua menerima dua parameter berupa nama dan lokasi halte. Method ini digunakan pada proses penambahan data untuk memeriksa apakah halte dengan nama dan lokasi yang sama sudah tersedia.

Kedua method memiliki nama yang sama tetapi menggunakan parameter yang berbeda sehingga merupakan penerapan method overloading.

---

## Penerapan Abstraction

Abstraction diterapkan dengan menjadikan class `Halte` sebagai **abstract class**.

[MASUKKAN SCREENSHOT ABSTRACT CLASS HALTE]

Abstract class `Halte` menyimpan atribut dan method umum yang dimiliki oleh Halte Reguler dan Halte Transit. Objek tidak dibuat secara langsung dari class `Halte`, tetapi melalui subclass `HalteReguler` atau `HalteTransit`.

Pada class `Halte` juga terdapat abstract method:

`public abstract void tampilkanJenisHalte();`

Abstract method tersebut belum memiliki implementasi pada class `Halte`. Implementasinya diberikan oleh `HalteReguler` dan `HalteTransit` sesuai dengan jenis haltenya.

---

## ⭐ Penerapan Nilai Tambah

### Interface

Nilai tambah pada program diterapkan menggunakan interface `InformasiHalte`.

[MASUKKAN SCREENSHOT INTERFACE INFORMASI HALTE]

Interface `InformasiHalte` memiliki method `tampilkanInfo()` dan digunakan sebagai kontrak untuk menampilkan informasi halte.

Interface tersebut diterapkan pada abstract class `Halte` menggunakan `implements InformasiHalte`.

[MASUKKAN SCREENSHOT IMPLEMENTS INFORMASI HALTE]

Method `tampilkanInfo()` kemudian dapat digunakan dan di-override kembali oleh `HalteReguler` dan `HalteTransit` untuk menampilkan informasi sesuai dengan jenis haltenya.

---

## Dokumentasi Program

### Menu Utama

[MASUKKAN SCREENSHOT MENU UTAMA]

Menu Utama menampilkan lima pilihan yang dapat digunakan admin untuk mengelola data halte, yaitu tambah, lihat, ubah, hapus data halte, serta keluar dari program.

### Tambah Halte

Pada menu Tambah Halte, admin dapat memilih dua jenis halte, yaitu Halte Reguler dan Halte Transit.

#### Halte Reguler

[MASUKKAN SCREENSHOT TAMBAH HALTE REGULER]

Halte Reguler dipilih dengan memasukkan pilihan 1. Admin mengisi nama halte, lokasi, kapasitas, rute bus, serta titik tujuan. ID halte dibuat secara otomatis oleh sistem setelah data berhasil ditambahkan.

#### Halte Transit

[MASUKKAN SCREENSHOT TAMBAH HALTE TRANSIT]

Halte Transit dipilih dengan memasukkan pilihan 2. Admin mengisi nama halte, lokasi, kapasitas, rute bus, serta rute penghubung. ID halte juga dibuat secara otomatis oleh sistem.

### Lihat Data Halte

[MASUKKAN SCREENSHOT LIHAT DATA]

Menu Lihat Data Halte menampilkan seluruh data halte yang tersimpan di dalam `ArrayList`. Informasi yang ditampilkan menyesuaikan jenis halte, termasuk titik tujuan pada Halte Reguler dan rute penghubung pada Halte Transit.

### Ubah Data Halte

[MASUKKAN SCREENSHOT UBAH DATA]

Menu Ubah Data Halte digunakan untuk memperbarui data berdasarkan ID halte. Setelah data ditemukan, admin dapat memasukkan data baru untuk memperbarui informasi halte.

### Hapus Halte

[MASUKKAN SCREENSHOT HAPUS DATA]

Menu Hapus Halte digunakan untuk menghapus data berdasarkan ID halte. Jika data dengan ID tersebut ditemukan, data akan dihapus dari `ArrayList`.

### Keluar

[MASUKKAN SCREENSHOT KELUAR]

Menu Keluar digunakan untuk mengakhiri program. Setelah menu dipilih, sistem menampilkan pesan penutup dan program berhenti.
