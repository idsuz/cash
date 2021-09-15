-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2.1
-- http://www.phpmyadmin.net
--
-- Хост: localhost
-- Время создания: Сен 02 2021 г., 07:53
-- Версия сервера: 5.7.33-0ubuntu0.16.04.1
-- Версия PHP: 7.0.33-0ubuntu0.16.04.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `admin_desk`
--

-- --------------------------------------------------------

--
-- Структура таблицы `cms_product_type`
--

CREATE TABLE `product_type` (
                                    `id` int(11) NOT NULL,
                                    `measure_id` int(11) DEFAULT NULL,
                                    `name` varchar(32) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `cms_product_type`
--

INSERT INTO `product_type` (`id`, `measure_id`, `name`) VALUES
(1, 1, 'штук'),
(2, 4, 'грамм'),
(3, 2, 'пачка'),
(4, 5, 'килограмм'),
(5, 3, 'миллиграмм'),
(6, 7, 'тонна'),
(7, 6, 'центнер'),
(8, 10, 'дециметр'),
(9, 9, 'сантиметр'),
(10, 8, 'миллиметр'),
(11, 11, 'метр'),
(12, 12, 'километр'),
(13, 14, 'кв. сантиметр'),
(14, 16, 'кв. метр'),
(15, 15, 'кв. дециметр'),
(16, 13, 'кв. миллиметр'),
(17, 19, 'куб. дециметр'),
(18, 18, 'кв. километр'),
(19, 20, 'куб. метр'),
(20, 17, '1000 куб. метр'),
(21, 24, 'дал'),
(22, 23, 'литр'),
(23, 21, 'куб. километр'),
(24, 25, 'сум'),
(25, 22, 'миллилитр'),
(26, 26, 'комплект'),
(27, 27, 'сутка'),
(28, 28, 'соат'),
(29, 29, 'пар'),
(30, 30, 'флакон'),
(31, 31, 'размещение'),
(32, 32, 'показы'),
(33, 33, 'коробка'),
(34, 34, 'моточас'),
(35, 35, 'Гкал'),
(36, 36, 'кВтч'),
(37, 37, 'рейс'),
(38, 38, 'упаковка'),
(39, 39, 'минут'),
(40, 40, 'норма/час'),
(41, 41, 'баллон'),
(42, 42, 'день'),
(43, 43, 'месяц'),
(44, 44, 'мегабайт'),
(45, 45, 'серия'),
(46, 0, 'другой'),
(47, 46, 'бутылка'),
(48, 47, 'кега'),
(49, 48, 'публикация'),
(50, 49, 'рулон'),
(51, 50, 'порция'),
(52, 51, 'погонный метр'),
(53, 52, 'га'),
(54, 53, 'кВарч'),
(55, 54, 'человек/час'),
(56, 55, 'кВар'),
(57, 56, 'кВт'),
(58, 57, 'год'),
(59, 58, 'лист'),
(60, 59, 'блок'),
(61, 60, 'машина/час'),
(62, 61, 'тонна/километр'),
(63, 62, 'ящик'),
(64, 63, 'ампула'),
(65, 64, 'базовая тонна'),
(66, 65, 'банка'),
(67, 66, 'баррель'),
(68, 67, 'бобина'),
(69, 68, 'бочка'),
(70, 69, 'вагон'),
(71, 70, 'галлон'),
(72, 71, 'декалитр'),
(73, 72, 'доза'),
(74, 73, 'работа'),
(75, 74, 'канистр'),
(76, 75, 'Ккалл'),
(77, 76, 'Мешок'),
(78, 77, 'млн.т.'),
(79, 78, 'млн.шт.'),
(80, 79, 'набор'),
(81, 80, 'объект'),
(82, 81, 'проба'),
(83, 82, 'пучок'),
(84, 83, 'тыс.т.'),
(85, 84, 'тыс.шт.'),
(86, 85, 'услуга'),
(87, 86, 'шлиф'),
(88, 87, 'банка'),
(89, 88, 'пэт'),
(90, 89, 'WGRP'),
(91, 90, 'копия'),
(92, 91, 'человек'),
(93, 92, 'выход');

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `cms_product_type`
--
ALTER TABLE `product_type`
    ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `cms_product_type`
--
ALTER TABLE `product_type`
    MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=94;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;