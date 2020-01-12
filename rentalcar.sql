-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Хост: 127.0.0.1:3306
-- Время создания: Янв 12 2020 г., 18:45
-- Версия сервера: 5.6.41
-- Версия PHP: 5.5.38

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `rentalcar`
--

-- --------------------------------------------------------

--
-- Структура таблицы `auto`
--

CREATE TABLE `auto` (
  `id` int(11) NOT NULL,
  `number_auto` varchar(64) NOT NULL,
  `mark` varchar(64) NOT NULL,
  `model` varchar(64) NOT NULL,
  `engine` varchar(64) NOT NULL,
  `volume` varchar(32) NOT NULL,
  `transmission_id` int(11) NOT NULL,
  `bodytype_id` int(11) NOT NULL,
  `drivetype_id` int(11) NOT NULL,
  `image` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `auto`
--

INSERT INTO `auto` (`id`, `number_auto`, `mark`, `model`, `engine`, `volume`, `transmission_id`, `bodytype_id`, `drivetype_id`, `image`) VALUES
(1, '3515 IM-7', 'BMW', '3', 'бензин', '3.0', 2, 1, 2, 'https://s.auto.drom.ru/i24226/c/photos/fullsize/bmw/3-series/bmw_3-series_846891.jpg'),
(2, '2658 ET-7', 'VW', 'Passat', 'дизель', '1.6', 1, 2, 1, 'https://mycityauto.com/wp-content/uploads/2019/02/Volkswagen-Passat-universal-2019-1.jpg'),
(3, '4852 NT-7', 'Mercedes', 'S-class', 'дизель', '3.2', 2, 1, 2, 'https://kolesa-uploads.ru/-/cb201eaf-7144-46d9-ac30-91c4977d5e53/mercedes-benz-s-klasse-front1-mini.jpg'),
(4, '6258 LM-5', 'VW', 'Golf', 'бензин', '1.6', 1, 4, 1, 'https://s.auto.drom.ru/i24238/c/photos/fullsize/volkswagen/golf/volkswagen_golf_923808.jpg'),
(5, '5284 YT-5', 'BMW', '5', 'дизель', '3.0', 2, 1, 2, 'https://kolesa-uploads.ru/-/1fa0b412-75de-41fc-8246-031d942f9767/bmw-5er-restyle-front1-mini.jpg'),
(6, '9585 MN-5', 'Audi', 'A6', 'дизель', '2.0', 2, 2, 3, 'https://auto.vercity.ru/gallery/img/automobiles/Audi/2019%20Audi%20A6%2055%20TFSI%20Quattro%20S-Line%20Avant%20(C8)%20(JP)/900x/1552825957.jpg');

-- --------------------------------------------------------

--
-- Структура таблицы `bodytype`
--

CREATE TABLE `bodytype` (
  `id` int(11) NOT NULL,
  `name` varchar(64) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `bodytype`
--

INSERT INTO `bodytype` (`id`, `name`) VALUES
(1, 'седан'),
(2, 'универсал'),
(3, 'кроссовер'),
(4, 'хэтчбек');

-- --------------------------------------------------------

--
-- Структура таблицы `contract`
--

CREATE TABLE `contract` (
  `id` int(11) NOT NULL,
  `contract_number` varchar(64) NOT NULL,
  `manager_id` int(11) NOT NULL,
  `auto_id` int(11) NOT NULL,
  `client_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `contract`
--

INSERT INTO `contract` (`id`, `contract_number`, `manager_id`, `auto_id`, `client_id`) VALUES
(1, '1', 3, 1, 5),
(2, '2', 3, 3, 2);

-- --------------------------------------------------------

--
-- Структура таблицы `contract_history`
--

CREATE TABLE `contract_history` (
  `id` int(11) NOT NULL,
  `action` varchar(11) NOT NULL,
  `contract_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Структура таблицы `drivetype`
--

CREATE TABLE `drivetype` (
  `id` int(11) NOT NULL,
  `name` varchar(64) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `drivetype`
--

INSERT INTO `drivetype` (`id`, `name`) VALUES
(1, 'передний'),
(2, 'задний'),
(3, 'полный');

-- --------------------------------------------------------

--
-- Структура таблицы `status`
--

CREATE TABLE `status` (
  `id` int(11) NOT NULL,
  `name` varchar(64) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `status`
--

INSERT INTO `status` (`id`, `name`) VALUES
(1, 'free'),
(2, 'booked'),
(3, 'in rent');

-- --------------------------------------------------------

--
-- Структура таблицы `transmission`
--

CREATE TABLE `transmission` (
  `id` int(11) NOT NULL,
  `name` varchar(64) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `transmission`
--

INSERT INTO `transmission` (`id`, `name`) VALUES
(1, 'механика'),
(2, 'автомат');

-- --------------------------------------------------------

--
-- Структура таблицы `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `login` varchar(100) NOT NULL,
  `password` varchar(64) NOT NULL,
  `fio` varchar(100) NOT NULL,
  `phone` varchar(64) NOT NULL,
  `address` varchar(64) NOT NULL,
  `passport_id` varchar(32) NOT NULL,
  `identification_number` varchar(64) NOT NULL,
  `role_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `user`
--

INSERT INTO `user` (`id`, `login`, `password`, `fio`, `phone`, `address`, `passport_id`, `identification_number`, `role_id`) VALUES
(1, 'alex', '123', 'alex alekseev', '15461316', 'gaya street', '1564265', '165464613164', 1),
(2, 'bob', '123', 'bob boobson', '51656156', 'wal street', '1665648', '346464613349', 2),
(3, 'sam', '123', 'sam samson', '54666426', 'baker street', '5431354', '346464312313', 3),
(5, 'samson', '123', 'Sam Samson Johnson', '+375296422595', '&#1059;&#1083;. &#1043;&#1072;&#1103; 15-29', 'MP256982', '84re5g4rg4e8', 2);

-- --------------------------------------------------------

--
-- Структура таблицы `user_history`
--

CREATE TABLE `user_history` (
  `id` int(11) NOT NULL,
  `action` varchar(11) NOT NULL,
  `user_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Структура таблицы `user_roles`
--

CREATE TABLE `user_roles` (
  `id` int(11) NOT NULL,
  `role` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `user_roles`
--

INSERT INTO `user_roles` (`id`, `role`) VALUES
(1, 'Admin'),
(2, 'Client'),
(3, 'Manager');

-- --------------------------------------------------------

--
-- Структура таблицы `view_manager`
--

CREATE TABLE `view_manager` (
  `id` int(11) NOT NULL,
  `contract_id` int(11) NOT NULL,
  `start_rent` varchar(100) NOT NULL,
  `finish_rent` varchar(100) NOT NULL,
  `status_rent` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `view_manager`
--

INSERT INTO `view_manager` (`id`, `contract_id`, `start_rent`, `finish_rent`, `status_rent`) VALUES
(1, 1, '2019-12-25T13:00', '2020-01-02T16:00', 1),
(2, 2, '2020-01-02T13:00', '2020-01-06T13:00', 2);

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `auto`
--
ALTER TABLE `auto`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_engine_id` (`engine`),
  ADD KEY `fk_bodyType_id` (`bodytype_id`),
  ADD KEY `fk_driveType_id` (`drivetype_id`),
  ADD KEY `fk_transmission_id` (`transmission_id`);

--
-- Индексы таблицы `bodytype`
--
ALTER TABLE `bodytype`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `contract`
--
ALTER TABLE `contract`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_auto_id` (`auto_id`),
  ADD KEY `fk_client_id` (`client_id`),
  ADD KEY `fk_manager_id` (`manager_id`);

--
-- Индексы таблицы `contract_history`
--
ALTER TABLE `contract_history`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `contract_id` (`contract_id`);

--
-- Индексы таблицы `drivetype`
--
ALTER TABLE `drivetype`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `status`
--
ALTER TABLE `status`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `transmission`
--
ALTER TABLE `transmission`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `login` (`login`) USING BTREE,
  ADD KEY `fk_role_id` (`role_id`);

--
-- Индексы таблицы `user_history`
--
ALTER TABLE `user_history`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `user_id` (`user_id`);

--
-- Индексы таблицы `user_roles`
--
ALTER TABLE `user_roles`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `view_manager`
--
ALTER TABLE `view_manager`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `contract_id` (`contract_id`) USING BTREE,
  ADD KEY `status_rent` (`status_rent`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `auto`
--
ALTER TABLE `auto`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT для таблицы `bodytype`
--
ALTER TABLE `bodytype`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT для таблицы `contract`
--
ALTER TABLE `contract`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT для таблицы `contract_history`
--
ALTER TABLE `contract_history`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT для таблицы `drivetype`
--
ALTER TABLE `drivetype`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT для таблицы `status`
--
ALTER TABLE `status`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT для таблицы `transmission`
--
ALTER TABLE `transmission`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT для таблицы `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT для таблицы `user_history`
--
ALTER TABLE `user_history`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT для таблицы `user_roles`
--
ALTER TABLE `user_roles`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT для таблицы `view_manager`
--
ALTER TABLE `view_manager`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Ограничения внешнего ключа сохраненных таблиц
--

--
-- Ограничения внешнего ключа таблицы `auto`
--
ALTER TABLE `auto`
  ADD CONSTRAINT `fk_bodyType_id` FOREIGN KEY (`bodytype_id`) REFERENCES `bodytype` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_driveType_id` FOREIGN KEY (`drivetype_id`) REFERENCES `drivetype` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_transmission_id` FOREIGN KEY (`transmission_id`) REFERENCES `transmission` (`id`) ON UPDATE CASCADE;

--
-- Ограничения внешнего ключа таблицы `contract`
--
ALTER TABLE `contract`
  ADD CONSTRAINT `fk_auto_id` FOREIGN KEY (`auto_id`) REFERENCES `auto` (`id`),
  ADD CONSTRAINT `fk_client_id` FOREIGN KEY (`client_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `fk_manager_id` FOREIGN KEY (`manager_id`) REFERENCES `user` (`id`);

--
-- Ограничения внешнего ключа таблицы `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `fk_role_id` FOREIGN KEY (`role_id`) REFERENCES `user_roles` (`id`);

--
-- Ограничения внешнего ключа таблицы `view_manager`
--
ALTER TABLE `view_manager`
  ADD CONSTRAINT `fk_contract` FOREIGN KEY (`contract_id`) REFERENCES `contract` (`id`),
  ADD CONSTRAINT `fk_status` FOREIGN KEY (`status_rent`) REFERENCES `status` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
