USE [master]
GO
/****** Object:  Database [Codecademy]    Script Date: 15-4-2023 18:39:29 ******/
CREATE DATABASE [Codecademy]
 CONTAINMENT = NONE
 ON  PRIMARY
( NAME = N'Codecademy', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLDEV2019\MSSQL\DATA\Codecademy.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON
( NAME = N'Codecademy_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLDEV2019\MSSQL\DATA\Codecademy_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [Codecademy] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [Codecademy].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [Codecademy] SET ANSI_NULL_DEFAULT OFF
GO
ALTER DATABASE [Codecademy] SET ANSI_NULLS OFF
GO
ALTER DATABASE [Codecademy] SET ANSI_PADDING OFF
GO
ALTER DATABASE [Codecademy] SET ANSI_WARNINGS OFF
GO
ALTER DATABASE [Codecademy] SET ARITHABORT OFF
GO
ALTER DATABASE [Codecademy] SET AUTO_CLOSE OFF
GO
ALTER DATABASE [Codecademy] SET AUTO_SHRINK OFF
GO
ALTER DATABASE [Codecademy] SET AUTO_UPDATE_STATISTICS ON
GO
ALTER DATABASE [Codecademy] SET CURSOR_CLOSE_ON_COMMIT OFF
GO
ALTER DATABASE [Codecademy] SET CURSOR_DEFAULT  GLOBAL
GO
ALTER DATABASE [Codecademy] SET CONCAT_NULL_YIELDS_NULL OFF
GO
ALTER DATABASE [Codecademy] SET NUMERIC_ROUNDABORT OFF
GO
ALTER DATABASE [Codecademy] SET QUOTED_IDENTIFIER OFF
GO
ALTER DATABASE [Codecademy] SET RECURSIVE_TRIGGERS OFF
GO
ALTER DATABASE [Codecademy] SET  DISABLE_BROKER
GO
ALTER DATABASE [Codecademy] SET AUTO_UPDATE_STATISTICS_ASYNC OFF
GO
ALTER DATABASE [Codecademy] SET DATE_CORRELATION_OPTIMIZATION OFF
GO
ALTER DATABASE [Codecademy] SET TRUSTWORTHY OFF
GO
ALTER DATABASE [Codecademy] SET ALLOW_SNAPSHOT_ISOLATION OFF
GO
ALTER DATABASE [Codecademy] SET PARAMETERIZATION SIMPLE
GO
ALTER DATABASE [Codecademy] SET READ_COMMITTED_SNAPSHOT OFF
GO
ALTER DATABASE [Codecademy] SET HONOR_BROKER_PRIORITY OFF
GO
ALTER DATABASE [Codecademy] SET RECOVERY FULL
GO
ALTER DATABASE [Codecademy] SET  MULTI_USER
GO
ALTER DATABASE [Codecademy] SET PAGE_VERIFY CHECKSUM
GO
ALTER DATABASE [Codecademy] SET DB_CHAINING OFF
GO
ALTER DATABASE [Codecademy] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF )
GO
ALTER DATABASE [Codecademy] SET TARGET_RECOVERY_TIME = 60 SECONDS
GO
ALTER DATABASE [Codecademy] SET DELAYED_DURABILITY = DISABLED
GO
ALTER DATABASE [Codecademy] SET ACCELERATED_DATABASE_RECOVERY = OFF
GO
EXEC sys.sp_db_vardecimal_storage_format N'Codecademy', N'ON'
GO
ALTER DATABASE [Codecademy] SET QUERY_STORE = OFF
GO
USE [Codecademy]
GO
/****** Object:  Table [dbo].[ContactPerson]    Script Date: 15-4-2023 18:39:29 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ContactPerson](
    [Name] [nvarchar](50) NOT NULL,
    [Email] [nvarchar](50) NOT NULL,
    CONSTRAINT [PK_ContactPerson] PRIMARY KEY CLUSTERED
(
[Name] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[ContentItem]    Script Date: 15-4-2023 18:39:29 ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[ContentItem](
    [ContentID] [int] NOT NULL,
    [PublicationDate] [date] NOT NULL,
    [Status] [nvarchar](50) NOT NULL,
    [CourseName] [nvarchar](100) NOT NULL,
    [ModuleID] [int] NULL,
    [WebcastID] [int] NULL,
    CONSTRAINT [PK_ContentItem] PRIMARY KEY CLUSTERED
(
[ContentID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[Course]    Script Date: 15-4-2023 18:39:29 ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[Course](
    [CourseName] [nvarchar](100) NOT NULL,
    [Subject] [nvarchar](50) NOT NULL,
    [IntroductionText] [nvarchar](2000) NULL,
    [Difficulty] [nvarchar](50) NOT NULL,
    [Chapters] [int] NOT NULL,
    CONSTRAINT [PK_Course] PRIMARY KEY CLUSTERED
(
[CourseName] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[Module]    Script Date: 15-4-2023 18:39:29 ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[Module](
    [Title] [nvarchar](50) NOT NULL,
    [Version] [int] NOT NULL,
    [ID] [int] NOT NULL,
    [ContactPersonName] [nvarchar](50) NOT NULL,
    [Description] [nvarchar](2000) NULL,
    CONSTRAINT [PK_Module_1] PRIMARY KEY CLUSTERED
(
[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[Registration]    Script Date: 15-4-2023 18:39:29 ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[Registration](
    [CourseName] [nvarchar](100) NOT NULL,
    [StudentEmail] [nvarchar](100) NOT NULL,
    [Date] [date] NOT NULL,
    [RegistrationID] [int] NOT NULL,
    CONSTRAINT [PK_Registration_1] PRIMARY KEY CLUSTERED
(
[RegistrationID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[Speaker]    Script Date: 15-4-2023 18:39:29 ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[Speaker](
    [SpeakerID] [int] NOT NULL,
    [Name] [nvarchar](50) NOT NULL,
    [Organization] [nvarchar](50) NOT NULL,
    CONSTRAINT [PK_Speaker] PRIMARY KEY CLUSTERED
(
[SpeakerID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[Student]    Script Date: 15-4-2023 18:39:29 ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[Student](
    [Email] [nvarchar](100) NOT NULL,
    [Name] [nvarchar](50) NOT NULL,
    [DateOfBirth] [date] NOT NULL,
    [Gender] [nvarchar](50) NOT NULL,
    [Address] [nvarchar](50) NOT NULL,
    [PostalCode] [nvarchar](50) NOT NULL,
    [Country] [nvarchar](50) NOT NULL,
    CONSTRAINT [PK_Student] PRIMARY KEY CLUSTERED
(
[Email] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[ViewedContent]    Script Date: 15-4-2023 18:39:29 ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[ViewedContent](
    [ContentID] [int] NOT NULL,
    [StudentEmail] [nvarchar](100) NOT NULL,
    [PercentageViewed] [int] NOT NULL,
    CONSTRAINT [PK_ViewedContent] PRIMARY KEY CLUSTERED
(
    [ContentID] ASC,
[StudentEmail] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[Webcast]    Script Date: 15-4-2023 18:39:29 ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[Webcast](
    [Title] [nvarchar](50) NOT NULL,
    [ID] [int] NOT NULL,
    [SpeakerId] [int] NOT NULL,
    [URL] [nvarchar](50) NOT NULL,
    [Description] [nvarchar](2000) NULL,
    [TimeInMinutes] [int] NOT NULL,
    [Views] [int] NULL,
    CONSTRAINT [PK_Webcast_1] PRIMARY KEY CLUSTERED
(
[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY]
    GO
ALTER TABLE [dbo].[ContentItem]  WITH CHECK ADD  CONSTRAINT [FK_ContentItem_Course] FOREIGN KEY([CourseName])
    REFERENCES [dbo].[Course] ([CourseName])
    ON UPDATE CASCADE
           GO
ALTER TABLE [dbo].[ContentItem] CHECK CONSTRAINT [FK_ContentItem_Course]
    GO
ALTER TABLE [dbo].[ContentItem]  WITH CHECK ADD  CONSTRAINT [FK_ContentItemID_ModuleID] FOREIGN KEY([ModuleID])
    REFERENCES [dbo].[Module] ([ID])
    ON UPDATE CASCADE
       ON DELETE CASCADE
GO
ALTER TABLE [dbo].[ContentItem] CHECK CONSTRAINT [FK_ContentItemID_ModuleID]
    GO
ALTER TABLE [dbo].[ContentItem]  WITH CHECK ADD  CONSTRAINT [FK_ContentItemID_WebcastID] FOREIGN KEY([WebcastID])
    REFERENCES [dbo].[Webcast] ([ID])
    ON UPDATE CASCADE
       ON DELETE CASCADE
GO
ALTER TABLE [dbo].[ContentItem] CHECK CONSTRAINT [FK_ContentItemID_WebcastID]
    GO
ALTER TABLE [dbo].[Module]  WITH CHECK ADD  CONSTRAINT [FK_Module_ContactPersonName] FOREIGN KEY([ContactPersonName])
    REFERENCES [dbo].[ContactPerson] ([Name])
    ON UPDATE CASCADE
       ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Module] CHECK CONSTRAINT [FK_Module_ContactPersonName]
    GO
ALTER TABLE [dbo].[Registration]  WITH CHECK ADD  CONSTRAINT [FK_Registration_CourseName] FOREIGN KEY([CourseName])
    REFERENCES [dbo].[Course] ([CourseName])
    ON UPDATE CASCADE
           GO
ALTER TABLE [dbo].[Registration] CHECK CONSTRAINT [FK_Registration_CourseName]
    GO
ALTER TABLE [dbo].[Registration]  WITH CHECK ADD  CONSTRAINT [FK_RegistrationEmail_StudentEmail] FOREIGN KEY([StudentEmail])
    REFERENCES [dbo].[Student] ([Email])
    ON UPDATE CASCADE
       ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Registration] CHECK CONSTRAINT [FK_RegistrationEmail_StudentEmail]
    GO
ALTER TABLE [dbo].[ViewedContent]  WITH CHECK ADD  CONSTRAINT [FK_ViewedContent_ContentItemID] FOREIGN KEY([ContentID])
    REFERENCES [dbo].[ContentItem] ([ContentID])
    ON UPDATE CASCADE
       ON DELETE CASCADE
GO
ALTER TABLE [dbo].[ViewedContent] CHECK CONSTRAINT [FK_ViewedContent_ContentItemID]
    GO
ALTER TABLE [dbo].[ViewedContent]  WITH CHECK ADD  CONSTRAINT [FK_ViewedContentEmail_StudentEmail] FOREIGN KEY([StudentEmail])
    REFERENCES [dbo].[Student] ([Email])
    ON UPDATE CASCADE
       ON DELETE CASCADE
GO
ALTER TABLE [dbo].[ViewedContent] CHECK CONSTRAINT [FK_ViewedContentEmail_StudentEmail]
    GO
ALTER TABLE [dbo].[Webcast]  WITH CHECK ADD  CONSTRAINT [FK_Webcast_Speaker] FOREIGN KEY([SpeakerId])
    REFERENCES [dbo].[Speaker] ([SpeakerID])
    ON UPDATE CASCADE
       ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Webcast] CHECK CONSTRAINT [FK_Webcast_Speaker]
    GO
    USE [master]
    GO
ALTER DATABASE [Codecademy] SET  READ_WRITE
GO
