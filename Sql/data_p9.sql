--
-- Structure de la table `patient`
--

DROP TABLE IF EXISTS `patient`;
CREATE TABLE IF NOT EXISTS `patient` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `birthdate` date DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `sex` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UniqueFirstNameAndLastNameAndBirthDate` (`first_name`,`last_name`,`birthdate`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `patient`
--

INSERT INTO `patient` (`id`, `address`, `birthdate`, `first_name`, `last_name`, `phone`, `sex`) VALUES
(1, '10 rue de paris', '2022-07-15', 'dia', 'sekou', '0601383041', 'M'),
(2, '10 rue de paris', '2022-07-15', 'dia', 'aziz', '0601383042', 'M'),
(3, '10 rue de paris', '2022-07-15', 'dia', 'djen', '0601383045', 'F'),
(6, '11 rue de france', '2022-07-02', 'toto', 'titi', '0601383211', 'M');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
