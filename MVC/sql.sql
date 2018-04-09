drop database if exists bdTest;

create database bdTest;
use bdTest;

create table persona(
idpersona int not null primary key,
nombre nvarchar(60) not null,
paterno nvarchar(60) not null,
materno nvarchar(60) not null,
email nvarchar(500) not null,
psw nvarchar(120) not null,
psw2 nvarchar(120) not null,
fecreg timestamp default current_timestamp
);


drop procedure if exists spGuardaPersona;
delimiter **
create procedure spGuardaPersona(
in nom nvarchar(60),
in pat nvarchar(60),
in mat nvarchar(60),
in correo nvarchar(500),
in pswd nvarchar(120),
in pswd2 nvarchar(120)
)
begin
declare idp int;
declare msj nvarchar(300);
declare existe int;

set existe = (select count(*) from persona where email = correo);
if existe = 0 then
	set idp = (select ifnull(max(idpersona), 0) + 1 from persona);
    insert into persona(idpersona, nombre, paterno, materno, email, psw, psw2)
				values (idp, nom, pat, mat, correo, pswd, pswd2);
	set msj = concat('', ' , persona registrada!!!');
else
	set idp= 0;
	set msj = 'ya existe ese usuario :v';
end if;

select idp as idPersona, msj as MSJ;

end;**
delimiter ;


call spGuardaPersona('Gerardo Emmanuel', 'Ponce', 'Ortega', 'gerardo2002@hotmail.com', 'psw1','psw2');

