-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Anamakine: 127.0.0.1
-- Üretim Zamanı: 12 Ağu 2022, 11:30:39
-- Sunucu sürümü: 10.4.24-MariaDB
-- PHP Sürümü: 8.0.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Veritabanı: `kutuphane`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `adminpanel`
--

CREATE TABLE `adminpanel` (
  `username` text CHARACTER SET utf8 COLLATE utf8_turkish_ci DEFAULT NULL,
  `password` text CHARACTER SET utf8 COLLATE utf8_turkish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Tablo döküm verisi `adminpanel`
--

INSERT INTO `adminpanel` (`username`, `password`) VALUES
('admin', 'admin'),
('mali', 'mali'),
('admin2', 'admin2');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `kitapkayit`
--

CREATE TABLE `kitapkayit` (
  `ID` int(11) NOT NULL,
  `kitapAd` text CHARACTER SET utf8 COLLATE utf8_turkish_ci NOT NULL,
  `kitapYazar` text CHARACTER SET utf8 COLLATE utf8_turkish_ci NOT NULL,
  `kisiAdSoyad` text CHARACTER SET utf8 COLLATE utf8_turkish_ci NOT NULL,
  `telNo` text CHARACTER SET utf8 COLLATE utf8_turkish_ci NOT NULL,
  `tarih` text CHARACTER SET utf8 COLLATE utf8_turkish_ci NOT NULL DEFAULT '10.08.2022'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Tablo döküm verisi `kitapkayit`
--

INSERT INTO `kitapkayit` (`ID`, `kitapAd`, `kitapYazar`, `kisiAdSoyad`, `telNo`, `tarih`) VALUES
(1, 'Alparslan', 'Okay Tiryakioğlu', 'Muhammed Ali Gökçe', '05555555555', '10.08.2022'),
(2, 'Kanuni', 'Okay Tiryakioğlu', 'Mehmet Kılıç', '05555555555', '10.08.2022'),
(3, 'Hayvan Mezarlığı', 'Stephen King', 'Berk Öz', '05555555555', '10.08.2022'),
(4, 'Hayvan Çiftliği', 'George Orwell', 'İsmail Yılmaz', '05555555555', '10.08.2022'),
(6, 'Harry Potter ve Sırlar Odası', 'J.K Rowling', 'Merve Çelik', '05555555555', '10.08.2022'),
(7, 'Son Krallık', 'Bernard Cornwell', 'Ali Tuğra', '05555555555', '10.08.2022'),
(8, 'Yüzüklerin Efendisi: Yüzük Kardeşliği', 'J.R.R. Tolkien', 'Dilek Özbağ', '05555555555', '10.08.2022'),
(9, 'Percy Jackson: Şimşek Hırsızı', 'Riordan', 'Sude Arslan', '05555555555', '10.08.2022'),
(17, 'IT', 'Stephen King', 'Deniz Başak', '05555555555', '11.08.2022');

--
-- Dökümü yapılmış tablolar için indeksler
--

--
-- Tablo için indeksler `kitapkayit`
--
ALTER TABLE `kitapkayit`
  ADD PRIMARY KEY (`ID`);

--
-- Dökümü yapılmış tablolar için AUTO_INCREMENT değeri
--

--
-- Tablo için AUTO_INCREMENT değeri `kitapkayit`
--
ALTER TABLE `kitapkayit`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
