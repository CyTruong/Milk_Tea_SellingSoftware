 /*
 * =========================================================
 *
 *                       _oo0oo_
 *                      o8888888o
 *                      88" . "88
 *                      (| -_- |)
 *                      0\  =  /0
 *                    ___/`---'\___
 *                  .' \|     |// '.
 *                 / \|||  :  |||// \
 *                / _||||| -:- |||||- \
 *               |   | \\  -  /// |   |
 *               | \_|  ''\---/''  |_/ |
 *               \  .-\__  '-'  ___/-. /
 *             ___'. .'  /--.--\  `. .'___
 *          ."" '<  `.___\_<|>_/___.' >' "".
 *         | | :  `- \`.;`\ _ /`;.`/ - ` : | |
 *         \  \ `_.   \_ __\ /__ _/   .-` /  /
 *     =====`-.____`.___ \_____/___.-`___.-'=====
 *                       `=---='
 *
 *     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *
 *               Buddha Bless:  "No Bugs Pls"
 *
 * ========================================================= */

 /*
 Các bước chỉnh sửa DB
 1) tạo 1 cript ms
 2) thêm từ khóa IDENTITY trc thuộc tính
 3) sửa lại hàm insert

 
 */
 CREATE DATABASE  QUANLITRASUA
 GO
 USE QUANLITRASUA
 go
 /*==============================================================*/
/* DBMS name:      Microsoft SQL Server 2008                    */
/* Created on:     27/04/2019 10:03:59 CH                       */
/*==============================================================*/

if exists (select 1
          from sysobjects
          where  id = object_id('BANG_GIA_DELETEPROCEDURE')
          and type in ('P','PC'))
   drop procedure BANG_GIA_DELETEPROCEDURE
go

if exists (select 1
          from sysobjects
          where  id = object_id('BANG_GIA_INSERTPROCEDURE')
          and type in ('P','PC'))
   drop procedure BANG_GIA_INSERTPROCEDURE
go

if exists (select 1
          from sysobjects
          where  id = object_id('BANG_GIA_SELECTPROCEDURE')
          and type in ('P','PC'))
   drop procedure BANG_GIA_SELECTPROCEDURE
go

if exists (select 1
          from sysobjects
          where  id = object_id('BANG_GIA_UPDATEPROCEDURE')
          and type in ('P','PC'))
   drop procedure BANG_GIA_UPDATEPROCEDURE
go

if exists (select 1
          from sysobjects
          where  id = object_id('CHI_TIET_HOA_DON_DELETEPROCEDURE')
          and type in ('P','PC'))
   drop procedure CHI_TIET_HOA_DON_DELETEPROCEDURE
go

if exists (select 1
          from sysobjects
          where  id = object_id('CHI_TIET_HOA_DON_INSERTPROCEDURE')
          and type in ('P','PC'))
   drop procedure CHI_TIET_HOA_DON_INSERTPROCEDURE
go

if exists (select 1
          from sysobjects
          where  id = object_id('CHI_TIET_HOA_DON_SELECTPROCEDURE')
          and type in ('P','PC'))
   drop procedure CHI_TIET_HOA_DON_SELECTPROCEDURE
go

if exists (select 1
          from sysobjects
          where  id = object_id('CHI_TIET_HOA_DON_UPDATEPROCEDURE')
          and type in ('P','PC'))
   drop procedure CHI_TIET_HOA_DON_UPDATEPROCEDURE
go

if exists (select 1
          from sysobjects
          where  id = object_id('HOA__ON_DELETEPROCEDURE')
          and type in ('P','PC'))
   drop procedure HOA__ON_DELETEPROCEDURE
go

if exists (select 1
          from sysobjects
          where  id = object_id('HOA__ON_INSERTPROCEDURE')
          and type in ('P','PC'))
   drop procedure HOA__ON_INSERTPROCEDURE
go

if exists (select 1
          from sysobjects
          where  id = object_id('HOA__ON_SELECTPROCEDURE')
          and type in ('P','PC'))
   drop procedure HOA__ON_SELECTPROCEDURE
go

if exists (select 1
          from sysobjects
          where  id = object_id('HOA__ON_UPDATEPROCEDURE')
          and type in ('P','PC'))
   drop procedure HOA__ON_UPDATEPROCEDURE
go

if exists (select 1
          from sysobjects
          where  id = object_id('LOAI_DO_UONG_DELETEPROCEDURE')
          and type in ('P','PC'))
   drop procedure LOAI_DO_UONG_DELETEPROCEDURE
go

if exists (select 1
          from sysobjects
          where  id = object_id('LOAI_DO_UONG_INSERTPROCEDURE')
          and type in ('P','PC'))
   drop procedure LOAI_DO_UONG_INSERTPROCEDURE
go

if exists (select 1
          from sysobjects
          where  id = object_id('LOAI_DO_UONG_SELECTPROCEDURE')
          and type in ('P','PC'))
   drop procedure LOAI_DO_UONG_SELECTPROCEDURE
go

if exists (select 1
          from sysobjects
          where  id = object_id('LOAI_DO_UONG_UPDATEPROCEDURE')
          and type in ('P','PC'))
   drop procedure LOAI_DO_UONG_UPDATEPROCEDURE
go

if exists (select 1
          from sysobjects
          where  id = object_id('NHAN_VIEN_DELETEPROCEDURE')
          and type in ('P','PC'))
   drop procedure NHAN_VIEN_DELETEPROCEDURE
go

if exists (select 1
          from sysobjects
          where  id = object_id('NHAN_VIEN_INSERTPROCEDURE')
          and type in ('P','PC'))
   drop procedure NHAN_VIEN_INSERTPROCEDURE
go

if exists (select 1
          from sysobjects
          where  id = object_id('NHAN_VIEN_SELECTPROCEDURE')
          and type in ('P','PC'))
   drop procedure NHAN_VIEN_SELECTPROCEDURE
go

if exists (select 1
          from sysobjects
          where  id = object_id('NHAN_VIEN_UPDATEPROCEDURE')
          and type in ('P','PC'))
   drop procedure NHAN_VIEN_UPDATEPROCEDURE
go

if exists (select 1
          from sysobjects
          where  id = object_id('TOPPING_DELETEPROCEDURE')
          and type in ('P','PC'))
   drop procedure TOPPING_DELETEPROCEDURE
go

if exists (select 1
          from sysobjects
          where  id = object_id('TOPPING_INSERTPROCEDURE')
          and type in ('P','PC'))
   drop procedure TOPPING_INSERTPROCEDURE
go

if exists (select 1
          from sysobjects
          where  id = object_id('TOPPING_SELECTPROCEDURE')
          and type in ('P','PC'))
   drop procedure TOPPING_SELECTPROCEDURE
go

if exists (select 1
          from sysobjects
          where  id = object_id('TOPPING_UPDATEPROCEDURE')
          and type in ('P','PC'))
   drop procedure TOPPING_UPDATEPROCEDURE
go

if exists (select 1
          from sysobjects
          where  id = object_id('_O_UONG_DELETEPROCEDURE')
          and type in ('P','PC'))
   drop procedure _O_UONG_DELETEPROCEDURE
go

if exists (select 1
          from sysobjects
          where  id = object_id('_O_UONG_INSERTPROCEDURE')
          and type in ('P','PC'))
   drop procedure _O_UONG_INSERTPROCEDURE
go

if exists (select 1
          from sysobjects
          where  id = object_id('_O_UONG_SELECTPROCEDURE')
          and type in ('P','PC'))
   drop procedure _O_UONG_SELECTPROCEDURE
go

if exists (select 1
          from sysobjects
          where  id = object_id('_O_UONG_UPDATEPROCEDURE')
          and type in ('P','PC'))
   drop procedure _O_UONG_UPDATEPROCEDURE
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('BANG_GIA') and o.name = 'FK_BANG_GIA_TRI_GIA_DO_UONG')
alter table BANG_GIA
   drop constraint FK_BANG_GIA_TRI_GIA_DO_UONG
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('CHI_TIET_HOA_DON') and o.name = 'FK_CHI_TIET_DO_UONG_C_DO_UONG')
alter table CHI_TIET_HOA_DON
   drop constraint FK_CHI_TIET_DO_UONG_C_DO_UONG
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('CHI_TIET_HOA_DON') and o.name = 'FK_CHI_TIET_HOA__ON_HOA_DON')
alter table CHI_TIET_HOA_DON
   drop constraint FK_CHI_TIET_HOA__ON_HOA_DON
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('DO_UONG') and o.name = 'FK_DO_UONG_MA_LOAI_M_LOAI_DO_')
alter table DO_UONG
   drop constraint FK_DO_UONG_MA_LOAI_M_LOAI_DO_
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('HOA_DON') and o.name = 'FK_HOA_DON_CHUA_MA_N_NHAN_VIE')
alter table HOA_DON
   drop constraint FK_HOA_DON_CHUA_MA_N_NHAN_VIE
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('BANG_GIA')
            and   name  = 'TRI_GIA_FK'
            and   indid > 0
            and   indid < 255)
   drop index BANG_GIA.TRI_GIA_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('BANG_GIA')
            and   type = 'U')
   drop table BANG_GIA
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('CHI_TIET_HOA_DON')
            and   name  = 'HOA__ON_FK'
            and   indid > 0
            and   indid < 255)
   drop index CHI_TIET_HOA_DON.HOA__ON_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('CHI_TIET_HOA_DON')
            and   type = 'U')
   drop table CHI_TIET_HOA_DON
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('DO_UONG')
            and   name  = 'CHUA2_FK'
            and   indid > 0
            and   indid < 255)
   drop index DO_UONG.CHUA2_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('DO_UONG')
            and   name  = 'MA_LOAI_MON_FK'
            and   indid > 0
            and   indid < 255)
   drop index DO_UONG.MA_LOAI_MON_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('DO_UONG')
            and   type = 'U')
   drop table DO_UONG
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('HOA_DON')
            and   name  = 'CHUA_MA_NHAN_VIEN_FK'
            and   indid > 0
            and   indid < 255)
   drop index HOA_DON.CHUA_MA_NHAN_VIEN_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('HOA_DON')
            and   type = 'U')
   drop table HOA_DON
go

if exists (select 1
            from  sysobjects
           where  id = object_id('LOAI_DO_UONG')
            and   type = 'U')
   drop table LOAI_DO_UONG
go

if exists (select 1
            from  sysobjects
           where  id = object_id('NHAN_VIEN')
            and   type = 'U')
   drop table NHAN_VIEN
go

if exists (select 1
            from  sysobjects
           where  id = object_id('TOPPING')
            and   type = 'U')
   drop table TOPPING
go

/*==============================================================*/
/* Table: BANG_GIA                                              */
/*==============================================================*/
create table BANG_GIA (
   SIZE                 int                  not null,
   MA_DO_UONG           int                  not null,
   GIA_TIEN             money                not null,
   ISDELETED            bit                  null,
   constraint PK_BANG_GIA primary key nonclustered (SIZE, MA_DO_UONG)
)
go

/*==============================================================*/
/* Index: TRI_GIA_FK                                            */
/*==============================================================*/
create index TRI_GIA_FK on BANG_GIA (
MA_DO_UONG ASC
)
go

/*==============================================================*/
/* Table: CHI_TIET_HOA_DON                                      */
/*==============================================================*/
create table CHI_TIET_HOA_DON (
   MA_CHI_TIET_HOA_DON  int           IDENTITY       not null,
   MA_HOA_DON           int                  not null,
   MA_DO_UONG           int                  not null,
   SIZE					int           not null,
   CAC_LOAI_TOOPING     varchar(256)         null,
   GIA_TIEN				INT						NULL,
   ISDELETED            bit                  null,
   constraint PK_CHI_TIET_HOA_DON primary key nonclustered (MA_CHI_TIET_HOA_DON)
)
go

/*==============================================================*/
/* Index: HOA__ON_FK                                            */
/*==============================================================*/
create index HOA__ON_FK on CHI_TIET_HOA_DON (
MA_HOA_DON ASC
)
go

/*==============================================================*/
/* Table: DO_UONG                                               */
/*==============================================================*/
create table DO_UONG (
   MA_DO_UONG           int            IDENTITY      not null,
   TEN_DO_UONG          char(256)            not null,
   MA_LOAI_DO_UONG      int                  not null,
   ISDELETED            bit                  null,
   constraint PK_DO_UONG primary key nonclustered (MA_DO_UONG)
)
go

/*==============================================================*/
/* Index: MA_LOAI_MON_FK                                        */
/*==============================================================*/
create index MA_LOAI_MON_FK on DO_UONG (
MA_LOAI_DO_UONG ASC
)
go

/*==============================================================*/
/* Index: CHUA2_FK                                              */
/*==============================================================*/
create unique index CHUA2_FK on DO_UONG (
MA_LOAI_DO_UONG ASC
)
go

/*==============================================================*/
/* Table: HOA_DON                                               */
/*==============================================================*/
create table HOA_DON (
   MA_HOA_DON           int            IDENTITY      not null,
   TONG_TIEN            money                not null,
   THOI_GIAN            datetime             not null,
   HINH_THUC_MUA        int                  not null,
   MA_THE               int                  null,
   MA_GIAM_GIA          char(256)            null,
   MA_NHAN_VIEN         int                  not null,
   TIENNHAN             int                  null,
   ISDELETED            bit                  null,
   constraint PK_HOA_DON primary key nonclustered (MA_HOA_DON)
)
go

/*==============================================================*/
/* Index: CHUA_MA_NHAN_VIEN_FK                                  */
/*==============================================================*/
create index CHUA_MA_NHAN_VIEN_FK on HOA_DON (
MA_NHAN_VIEN ASC
)
go

/*==============================================================*/
/* Table: LOAI_DO_UONG                                          */
/*==============================================================*/
create table LOAI_DO_UONG (
   MA_LOAI_DO_UONG      int           IDENTITY       not null,
   LOAI_DO_UONG         char(256)            not null,
   ISDELETED            bit                  null,
   constraint PK_LOAI_DO_UONG primary key nonclustered (MA_LOAI_DO_UONG)
)
go

/*==============================================================*/
/* Table: NHAN_VIEN                                             */
/*==============================================================*/
create table NHAN_VIEN (
   MA_NHAN_VIEN         int           IDENTITY       not null,
   HO_TEN               char(256)            not null,
   SDT                  char(256)            not null,
   USENAME              char(256)            not null,
   PASSWORD             char(256)            not null,
   QUYEN_HAN			INT					NOT NULL,
   ISDELETED            bit                  null,
   constraint PK_NHAN_VIEN primary key nonclustered (MA_NHAN_VIEN)
)
go

/*==============================================================*/
/* Table: TOPPING                                               */
/*==============================================================*/
create table TOPPING (
   MA_TOPPING           int           IDENTITY       not null,
   TEN_TOPPING          char(256)            not null,
   GIA_TIEN             money                not null,
   ISDELETED            bit                  null,
   constraint PK_TOPPING primary key nonclustered (MA_TOPPING)
)
go

alter table BANG_GIA
   add constraint FK_BANG_GIA_TRI_GIA_DO_UONG foreign key (MA_DO_UONG)
      references DO_UONG (MA_DO_UONG)
go

alter table CHI_TIET_HOA_DON
   add constraint FK_CHI_TIET_DO_UONG_C_DO_UONG foreign key (MA_DO_UONG)
      references DO_UONG (MA_DO_UONG)
go

alter table CHI_TIET_HOA_DON
   add constraint FK_CHI_TIET_HOA__ON_HOA_DON foreign key (MA_HOA_DON)
      references HOA_DON (MA_HOA_DON)
go

alter table DO_UONG
   add constraint FK_DO_UONG_MA_LOAI_M_LOAI_DO_ foreign key (MA_LOAI_DO_UONG)
      references LOAI_DO_UONG (MA_LOAI_DO_UONG)
go

alter table HOA_DON
   add constraint FK_HOA_DON_CHUA_MA_N_NHAN_VIE foreign key (MA_NHAN_VIEN)
      references NHAN_VIEN (MA_NHAN_VIEN)
go

create procedure BANG_GIA_DELETEPROCEDURE  @SIZE int,@MA_DO_UONG int as
begin
delete from BANG_GIA
where BANG_GIA.SIZE = @SIZE and BANG_GIA.MA_DO_UONG = @MA_DO_UONG
end
go

create procedure BANG_GIA_INSERTPROCEDURE  @SIZE int,@MA_DO_UONG int,@GIA_TIEN money,@ISDELETED bit as
begin
insert into BANG_GIA (BANG_GIA.SIZE,BANG_GIA.MA_DO_UONG,BANG_GIA.GIA_TIEN,BANG_GIA.ISDELETED)
values(@SIZE,@MA_DO_UONG,@GIA_TIEN,@ISDELETED)
end
go

create procedure BANG_GIA_SELECTPROCEDURE  @SIZE int,@MA_DO_UONG int as
begin
select * from BANG_GIA
where BANG_GIA.SIZE = @SIZE and BANG_GIA.MA_DO_UONG = @MA_DO_UONG
end
go

create procedure BANG_GIA_UPDATEPROCEDURE  @SIZE int,@MA_DO_UONG int,@GIA_TIEN money,@ISDELETED bit as
begin
update BANG_GIA
set BANG_GIA.GIA_TIEN = @GIA_TIEN, BANG_GIA.ISDELETED = @ISDELETED
where (BANG_GIA.SIZE = @SIZE and BANG_GIA.MA_DO_UONG = @MA_DO_UONG)
end
go

create procedure CHI_TIET_HOA_DON_DELETEPROCEDURE  @MA_CHI_TIET_HOA_DON int as
begin
delete from CHI_TIET_HOA_DON
where CHI_TIET_HOA_DON.MA_CHI_TIET_HOA_DON = @MA_CHI_TIET_HOA_DON
end
go

create procedure CHI_TIET_HOA_DON_INSERTPROCEDURE  @MA_HOA_DON int,@MA_DO_UONG int,@SIZE int,@CAC_LOAI_TOOPING varchar(256),@Giatien int ,@ISDELETED bit as
begin
insert into CHI_TIET_HOA_DON (CHI_TIET_HOA_DON.MA_HOA_DON,CHI_TIET_HOA_DON.MA_DO_UONG,CHI_TIET_HOA_DON.SIZE,CHI_TIET_HOA_DON.CAC_LOAI_TOOPING,dbo.CHI_TIET_HOA_DON.GIA_TIEN,CHI_TIET_HOA_DON.ISDELETED)
values(@MA_HOA_DON,@MA_DO_UONG,@SIZE,@CAC_LOAI_TOOPING,@Giatien,@ISDELETED)
end
go

create procedure CHI_TIET_HOA_DON_SELECTPROCEDURE  @MA_CHI_TIET_HOA_DON int as
begin
select * from CHI_TIET_HOA_DON
where CHI_TIET_HOA_DON.MA_CHI_TIET_HOA_DON = @MA_CHI_TIET_HOA_DON
end
go

create procedure CHI_TIET_HOA_DON_UPDATEPROCEDURE  @MA_CHI_TIET_HOA_DON int,@MA_HOA_DON int,@MA_DO_UONG int,@SIZE int,@CAC_LOAI_TOOPING varchar(256),@Giatien int ,@ISDELETED bit as
begin
update CHI_TIET_HOA_DON
set CHI_TIET_HOA_DON.MA_HOA_DON = @MA_HOA_DON, CHI_TIET_HOA_DON.MA_DO_UONG = @MA_DO_UONG, CHI_TIET_HOA_DON.SIZE = @SIZE, CHI_TIET_HOA_DON.CAC_LOAI_TOOPING = @CAC_LOAI_TOOPING, dbo.CHI_TIET_HOA_DON.GIA_TIEN = @Giatien,CHI_TIET_HOA_DON.ISDELETED = @ISDELETED
where (CHI_TIET_HOA_DON.MA_CHI_TIET_HOA_DON = @MA_CHI_TIET_HOA_DON)
end
go

create procedure HOA__ON_DELETEPROCEDURE  @MA_HOA_DON int as
begin
delete from HOA_DON
where HOA_DON.MA_HOA_DON = @MA_HOA_DON
end
go

create procedure HOA__ON_INSERTPROCEDURE  @TONG_TIEN money,@THOI_GIAN datetime,@HINH_THUC_MUA int,@MA_THE int,@MA_GIAM_GIA char(256),@MA_NHAN_VIEN int,@TIENNHAN int,@ISDELETED bit as
begin
insert into HOA_DON (HOA_DON.TONG_TIEN,HOA_DON.THOI_GIAN,HOA_DON.HINH_THUC_MUA,HOA_DON.MA_THE,HOA_DON.MA_GIAM_GIA,HOA_DON.MA_NHAN_VIEN,HOA_DON.TIENNHAN,HOA_DON.ISDELETED)
values( @TONG_TIEN,@THOI_GIAN,@HINH_THUC_MUA,@MA_THE,@MA_GIAM_GIA,@MA_NHAN_VIEN,@TIENNHAN,@ISDELETED)
end
go

create procedure HOA__ON_SELECTPROCEDURE  @MA_HOA_DON int as
begin
select * from HOA_DON
where HOA_DON.MA_HOA_DON = @MA_HOA_DON
end
go

create procedure HOA__ON_UPDATEPROCEDURE  @MA_HOA_DON int,@TONG_TIEN money,@THOI_GIAN datetime,@HINH_THUC_MUA int,@MA_THE int,@MA_GIAM_GIA char(256),@MA_NHAN_VIEN int,@TIENNHAN int,@ISDELETED bit as
begin
update HOA_DON
set HOA_DON.TONG_TIEN = @TONG_TIEN, HOA_DON.THOI_GIAN = @THOI_GIAN, HOA_DON.HINH_THUC_MUA = @HINH_THUC_MUA, HOA_DON.MA_THE = @MA_THE, HOA_DON.MA_GIAM_GIA = @MA_GIAM_GIA, HOA_DON.MA_NHAN_VIEN = @MA_NHAN_VIEN, HOA_DON.TIENNHAN = @TIENNHAN, HOA_DON.ISDELETED = @ISDELETED
where (HOA_DON.MA_HOA_DON = @MA_HOA_DON)
end
go

create procedure LOAI_DO_UONG_DELETEPROCEDURE  @MA_LOAI_DO_UONG int as
begin
delete from LOAI_DO_UONG
where LOAI_DO_UONG.MA_LOAI_DO_UONG = @MA_LOAI_DO_UONG
end
go

create procedure LOAI_DO_UONG_INSERTPROCEDURE   @LOAI_DO_UONG char(256),@ISDELETED bit as
begin
insert into LOAI_DO_UONG (   LOAI_DO_UONG.LOAI_DO_UONG,LOAI_DO_UONG.ISDELETED)
values(  @LOAI_DO_UONG,@ISDELETED)
end
go

create procedure LOAI_DO_UONG_SELECTPROCEDURE  @MA_LOAI_DO_UONG int as
begin
select * from LOAI_DO_UONG
where LOAI_DO_UONG.MA_LOAI_DO_UONG = @MA_LOAI_DO_UONG
end
go

create procedure LOAI_DO_UONG_UPDATEPROCEDURE  @MA_LOAI_DO_UONG int,@LOAI_DO_UONG char(256),@ISDELETED bit as
begin
update LOAI_DO_UONG
set LOAI_DO_UONG.LOAI_DO_UONG = @LOAI_DO_UONG, LOAI_DO_UONG.ISDELETED = @ISDELETED
where (LOAI_DO_UONG.MA_LOAI_DO_UONG = @MA_LOAI_DO_UONG)
end
go

create procedure NHAN_VIEN_DELETEPROCEDURE  @MA_NHAN_VIEN int as
begin
delete from NHAN_VIEN
where NHAN_VIEN.MA_NHAN_VIEN = @MA_NHAN_VIEN
end
go

create procedure NHAN_VIEN_INSERTPROCEDURE  @HO_TEN char(256),@SDT char(256),@USENAME char(256),@PASSWORD char(256),@QUYENHAN INT,@ISDELETED bit as
begin
insert into NHAN_VIEN (NHAN_VIEN.HO_TEN,NHAN_VIEN.SDT,NHAN_VIEN.USENAME,NHAN_VIEN.PASSWORD,dbo.NHAN_VIEN.QUYEN_HAN,NHAN_VIEN.ISDELETED)
values(@HO_TEN,@SDT,@USENAME,@PASSWORD,@QUYENHAN,@ISDELETED)
end
go

create procedure NHAN_VIEN_SELECTPROCEDURE  @MA_NHAN_VIEN int as
begin
select * from NHAN_VIEN
where NHAN_VIEN.MA_NHAN_VIEN = @MA_NHAN_VIEN
end
go

create procedure NHAN_VIEN_UPDATEPROCEDURE  @MA_NHAN_VIEN int,@HO_TEN char(256),@SDT char(256),@USENAME char(256),@PASSWORD char(256),@QUYENHAN INT,@ISDELETED bit as
begin
update NHAN_VIEN
set NHAN_VIEN.HO_TEN = @HO_TEN, NHAN_VIEN.SDT = @SDT, NHAN_VIEN.USENAME = @USENAME, NHAN_VIEN.PASSWORD = @PASSWORD, dbo.NHAN_VIEN.QUYEN_HAN= @QUYENHAN ,NHAN_VIEN.ISDELETED = @ISDELETED
where (NHAN_VIEN.MA_NHAN_VIEN = @MA_NHAN_VIEN)
end
go

create procedure TOPPING_DELETEPROCEDURE  @MA_TOPPING int as
begin
delete from TOPPING
where TOPPING.MA_TOPPING = @MA_TOPPING
end
go

create procedure TOPPING_INSERTPROCEDURE  @TEN_TOPPING char(256),@GIA_TIEN money,@ISDELETED bit as
begin
insert into TOPPING (TOPPING.TEN_TOPPING,TOPPING.GIA_TIEN,TOPPING.ISDELETED)
values(@TEN_TOPPING,@GIA_TIEN,@ISDELETED)
end
go

create procedure TOPPING_SELECTPROCEDURE  @MA_TOPPING int as
begin
select * from TOPPING
where TOPPING.MA_TOPPING = @MA_TOPPING
end
go

create procedure TOPPING_UPDATEPROCEDURE  @MA_TOPPING int,@TEN_TOPPING char(256),@GIA_TIEN money,@ISDELETED bit as
begin
update TOPPING
set TOPPING.TEN_TOPPING = @TEN_TOPPING, TOPPING.GIA_TIEN = @GIA_TIEN, TOPPING.ISDELETED = @ISDELETED
where (TOPPING.MA_TOPPING = @MA_TOPPING)
end
go

create procedure _O_UONG_DELETEPROCEDURE  @MA_DO_UONG int as
begin
delete from DO_UONG
where DO_UONG.MA_DO_UONG = @MA_DO_UONG
end
go

create procedure _O_UONG_INSERTPROCEDURE @TEN_DO_UONG char(256),@MA_LOAI_DO_UONG int,@ISDELETED bit as
begin
insert into DO_UONG (DO_UONG.TEN_DO_UONG,DO_UONG.MA_LOAI_DO_UONG,DO_UONG.ISDELETED)
values(@TEN_DO_UONG,@MA_LOAI_DO_UONG,@ISDELETED)
end
go

CREATE PROCEDURE _O_UONG_SELECTPROCEDURE  @MA_DO_UONG INT AS
BEGIN
SELECT * FROM DO_UONG
WHERE DO_UONG.MA_DO_UONG = @MA_DO_UONG
END
GO

CREATE PROCEDURE _O_UONG_UPDATEPROCEDURE  @MA_DO_UONG INT,@TEN_DO_UONG CHAR(256),@MA_LOAI_DO_UONG INT,@ISDELETED BIT AS
BEGIN
UPDATE DO_UONG
SET DO_UONG.TEN_DO_UONG = @TEN_DO_UONG, DO_UONG.MA_LOAI_DO_UONG = @MA_LOAI_DO_UONG, DO_UONG.ISDELETED = @ISDELETED
WHERE (DO_UONG.MA_DO_UONG = @MA_DO_UONG)
END
GO


/*
USE master
DROP DATABASE QUANLITRASUA

USE QUANLITRASUA
go

*/

/*
INSERT dbo.LOAI_DO_UONG
(
    LOAI_DO_UONG
)
VALUES
(   'Kem' -- LOAI_DO_UONG - char(256)
    )
	*/

	INSERT dbo.NHAN_VIEN
	(
	    HO_TEN,
	    SDT,
	    USENAME,
	    PASSWORD,
	    QUYEN_HAN,
	    ISDELETED
	)
	VALUES
	(   'Pham Nhat Truong',  -- HO_TEN - char(256)
	    '0563683819',  -- SDT - char(256)
	    'cy',  -- USENAME - char(256)
	    '1',  -- PASSWORD - char(256)
	    10000,   -- QUYEN_HAN - int
	    NULL -- ISDELETED - bit
	    )

		INSERT dbo.HOA_DON
		(
		    TONG_TIEN,
		    THOI_GIAN,
		    HINH_THUC_MUA,
		    MA_THE,
		    MA_GIAM_GIA,
		    MA_NHAN_VIEN,
		    TIENNHAN,
		    ISDELETED
		)
		VALUES
		(   200000,      -- TONG_TIEN - money
		    GETDATE(), -- THOI_GIAN - datetime
		    0,         -- HINH_THUC_MUA - int
		    0,         -- MA_THE - int
		    'eo co',        -- MA_GIAM_GIA - char(256)
		    2,         -- MA_NHAN_VIEN - int
		    200000,         -- TIENNHAN - int
		    0       -- ISDELETED - bit
		    )

	INSERT dbo.HOA_DON
		(
		    TONG_TIEN,
		    THOI_GIAN,
		    HINH_THUC_MUA,
		    MA_THE,
		    MA_GIAM_GIA,
		    MA_NHAN_VIEN,
		    TIENNHAN,
		    ISDELETED
		)
		VALUES
		(   200000,      -- TONG_TIEN - money
		    GETDATE(), -- THOI_GIAN - datetime
		    0,         -- HINH_THUC_MUA - int
		    1,         -- MA_THE - int
		    'eo co',        -- MA_GIAM_GIA - char(256)
		    2,         -- MA_NHAN_VIEN - int
		    200000,         -- TIENNHAN - int
		    0       -- ISDELETED - bit
		    )

	INSERT dbo.HOA_DON
		(
		    TONG_TIEN,
		    THOI_GIAN,
		    HINH_THUC_MUA,
		    MA_THE,
		    MA_GIAM_GIA,
		    MA_NHAN_VIEN,
		    TIENNHAN,
		    ISDELETED
		)
		VALUES
		(   0,      -- TONG_TIEN - money
		    GETDATE(), -- THOI_GIAN - datetime
		    1,         -- HINH_THUC_MUA - int
		    1,         -- MA_THE - int
		    'eo co',        -- MA_GIAM_GIA - char(256)
		    2,         -- MA_NHAN_VIEN - int
		    0,         -- TIENNHAN - int
		    0       -- ISDELETED - bit
		    )

	INSERT dbo.HOA_DON
		(
		    TONG_TIEN,
		    THOI_GIAN,
		    HINH_THUC_MUA,
		    MA_THE,
		    MA_GIAM_GIA,
		    MA_NHAN_VIEN,
		    TIENNHAN,
		    ISDELETED
		)
		VALUES
		(   0,      -- TONG_TIEN - money
		    GETDATE(), -- THOI_GIAN - datetime
		    1,         -- HINH_THUC_MUA - int
		    5,         -- MA_THE - int
		    'eo co',        -- MA_GIAM_GIA - char(256)
		    2,         -- MA_NHAN_VIEN - int
		    0,         -- TIENNHAN - int
		    0       -- ISDELETED - bit
		    )

		