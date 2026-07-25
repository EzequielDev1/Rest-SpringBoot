
DROP TABLE IF EXISTS `estudante`;

CREATE TABLE `estudante` (
                             `id` binary(16) NOT NULL,
                             `cor` varchar(25) NOT NULL,
                             `idade` int NOT NULL,
                             `nome` varchar(30) NOT NULL,
                             PRIMARY KEY (`id`)
);


CREATE TABLE `person` (d
                          `id` bigint NOT NULL AUTO_INCREMENT,
                          `address` varchar(76) NOT NULL,
                          `first_name` varchar(50) NOT NULL,
                          `gender` varchar(10) NOT NULL,
                          `last_name` varchar(50) NOT NULL,
                          PRIMARY KEY (`id`)
);


CREATE TABLE `programador` (
                               `id` bigint NOT NULL AUTO_INCREMENT,
                               `cor_pele` varchar(200) DEFAULT NULL,
                               `idade` int NOT NULL,
                               `nome` varchar(30) NOT NULL,
                               `sexo` varchar(40) NOT NULL,
                               PRIMARY KEY (`id`)
);

