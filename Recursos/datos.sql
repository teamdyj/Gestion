
use facturaciondb;
Insert into rol(idRol,Rol) values
(1, 'Usuario'),
(2, 'Administrador'),
(3, 'root'),
(4,'profesor'),
(5,'familia');

Insert into usuarios(email,nombre,apellido,fecharegistro,Rol_idRol) values
('pp@gmail.com','Daniel','Hernandez','2019-09-15',3),
('pp2@gmail.com','Daniel2','Hernandez2','2019-09-15',1),
('pp3@gmail.com','Daniel3','Hernandez3','2019-09-15',4),
('pp4@gmail.com','Daniel','Hernandez','2019-09-15',5);
