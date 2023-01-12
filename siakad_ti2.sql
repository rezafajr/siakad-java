-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Waktu pembuatan: 26 Des 2022 pada 07.12
-- Versi server: 5.7.24
-- Versi PHP: 7.2.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `siakad_ti2`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_dosen`
--

CREATE TABLE `tb_dosen` (
  `nidn_dosen` varchar(15) NOT NULL,
  `nama_dosen` varchar(100) DEFAULT NULL,
  `jk_dosen` varchar(1) DEFAULT NULL,
  `alamat_dosen` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tb_dosen`
--

INSERT INTO `tb_dosen` (`nidn_dosen`, `nama_dosen`, `jk_dosen`, `alamat_dosen`) VALUES
('11332', 'Adiwibowo', 'L', 'Cikidang'),
('161666', 'Wahyuni M.Kom', 'L', 'Jati Barang'),
('161667', 'Ronaldo SHuuuuu M.Si', 'L', 'Protugal'),
('16625', 'Sumirna', 'P', 'Belanda'),
('166252', 'Dulkarnain MMMMMM.Mek', 'L', 'Jakarta');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_jurusan`
--

CREATE TABLE `tb_jurusan` (
  `id_jurusan` char(5) NOT NULL,
  `nama_jurusan` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tb_jurusan`
--

INSERT INTO `tb_jurusan` (`id_jurusan`, `nama_jurusan`) VALUES
('145', 'Teknik Informatika'),
('245', 'Sistem Informasi'),
('345', 'Ilmu Pendidikan');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_mahasiswa`
--

CREATE TABLE `tb_mahasiswa` (
  `nim` char(20) NOT NULL,
  `id_jurusan` char(5) NOT NULL,
  `id_prodi` char(5) NOT NULL,
  `id_thn_angkatan` char(5) NOT NULL,
  `nama_mahasiswa` varchar(100) NOT NULL,
  `jk` enum('L','P') NOT NULL,
  `tempat_lahir` varchar(100) NOT NULL,
  `tgl_lahir` date NOT NULL,
  `alamat` varchar(100) NOT NULL,
  `agama` varchar(100) NOT NULL,
  `no_telepon` varchar(100) NOT NULL,
  `nama_ayah` varchar(100) NOT NULL,
  `nama_ibu` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_mhs`
--

CREATE TABLE `tb_mhs` (
  `nim` varchar(20) NOT NULL,
  `nama_mahasiswa` varchar(200) NOT NULL,
  `jk_mhs` varchar(30) NOT NULL,
  `id_jurusan` char(5) NOT NULL,
  `angkatan` varchar(10) NOT NULL,
  `alamat` varchar(400) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tb_mhs`
--

INSERT INTO `tb_mhs` (`nim`, `nama_mahasiswa`, `jk_mhs`, `id_jurusan`, `angkatan`, `alamat`) VALUES
('14519162', 'Reza F', 'Laki-Laki', '145', '2019', 'Rajagaluh'),
('14519166', 'Haznam Rais', 'Laki-Laki', '145', '2020', 'Sumber'),
('14519177', 'Kimi Harada', 'Perempuan', '245', '2021', 'Tegal');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_prodi`
--

CREATE TABLE `tb_prodi` (
  `id_prodi` char(5) NOT NULL,
  `nama_prodi` varchar(100) NOT NULL,
  `id_jurusan` char(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_thn_angkatan`
--

CREATE TABLE `tb_thn_angkatan` (
  `id_thn_angkatan` tinyint(4) NOT NULL,
  `thn_angkatan` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_user`
--

CREATE TABLE `tb_user` (
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tb_user`
--

INSERT INTO `tb_user` (`username`, `password`) VALUES
('reza', 'ganteng');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `tb_dosen`
--
ALTER TABLE `tb_dosen`
  ADD PRIMARY KEY (`nidn_dosen`);

--
-- Indeks untuk tabel `tb_jurusan`
--
ALTER TABLE `tb_jurusan`
  ADD PRIMARY KEY (`id_jurusan`);

--
-- Indeks untuk tabel `tb_mahasiswa`
--
ALTER TABLE `tb_mahasiswa`
  ADD PRIMARY KEY (`nim`,`id_jurusan`,`id_prodi`,`id_thn_angkatan`);

--
-- Indeks untuk tabel `tb_mhs`
--
ALTER TABLE `tb_mhs`
  ADD PRIMARY KEY (`nim`),
  ADD KEY `id_jurusan` (`id_jurusan`);

--
-- Indeks untuk tabel `tb_prodi`
--
ALTER TABLE `tb_prodi`
  ADD PRIMARY KEY (`id_prodi`);

--
-- Indeks untuk tabel `tb_thn_angkatan`
--
ALTER TABLE `tb_thn_angkatan`
  ADD PRIMARY KEY (`id_thn_angkatan`);

--
-- Indeks untuk tabel `tb_user`
--
ALTER TABLE `tb_user`
  ADD PRIMARY KEY (`username`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
