
-- Lookup tables (Enums)
CREATE TABLE LawType (
                         id INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
                         lawyerType varchar(60) not null,

                         PRIMARY KEY (id)
);

CREATE TABLE Complexity (
                            id INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
                            cLevel varchar(60) not null,

                            PRIMARY KEY (id)
);

CREATE TABLE CaseCategory (
                              id INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
                              caseType varchar(60) not null,

                              PRIMARY KEY (id)
);

CREATE TABLE CaseState (
                           id INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
                           caseType varchar(60) not null,

                           PRIMARY KEY (id)
);

-- Schema tables
CREATE TABLE SYS_USER (
                          id INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
                          firstName VARCHAR(50),
                          lastName VARCHAR(50),
                          email VARCHAR(60) NOT NULL,
                          pass VARCHAR(60) NOT NULL,
                          isActive BOOLEAN,
                          createdAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

                          constraint user_pk PRIMARY KEY (id)
);
CREATE TABLE LAWYER (
                        id INT NOT NULL ,
                        experienceYear INT,
                        lawType INT,
                        isSenior BOOLEAN,
                        isAvailable BOOLEAN,

                        CONSTRAINT lawyer_pk PRIMARY KEY (id),
                        CONSTRAINT lawyer_fk FOREIGN KEY (id) REFERENCES SYS_USER(id) ,
                        CONSTRAINT lawType_fk FOREIGN KEY (lawType) REFERENCES LawType(id)
);


CREATE TABLE Admin(
                      id int NOT NULL,
                      isGlobal BOOLEAN,

                      constraint admin_pk PRIMARY KEY (id),
                      constraint admin_fk foreign key (id) references SYS_USER(id)
);

CREATE TABLE LAWYERASSIST(
                             id int NOT NULL,
                             isSupervisor BOOLEAN,

                             constraint lawyerAssist_pk PRIMARY KEY (id),
                             constraint lawyerAssit_fk foreign key (id) references SYS_USER(id)
);

CREATE TABLE Client (
                        id INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
                        firstName VARCHAR(50),
                        lastName VARCHAR(50),
                        phoneNo VARCHAR(20),

                        constraint client_user_pk PRIMARY KEY (id)
);

CREATE TABLE LEGAL_CASE(
                           id INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
                           name VARCHAR(50),
                           description VARCHAR(50),
                           createdAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                           caseCategory int,
                           caseState int,
                           clientID int,

                           constraint case_pk PRIMARY KEY (id),
                           constraint clientCase_fk foreign key (clientID) references Client (id),
                           constraint caseState_fk foreign key (caseState) references CaseState (id),
                           constraint category_fk foreign key (caseCategory) references CaseCategory (id)
);

-- BILL Table present a single bill for each case (1:1)
-- So that caseID is unique
CREATE TABLE BILL(
                     id INT NOT NULL,
                     caseID INT NOT NULL unique,
                     takenDays int not null,
                     travelFee double not null default 0.0,
                     complexity int default 1,
                     expertFee double not null default 0.0,
                     adminCost double not null default 0.0,

                     constraint bill_pk primary key (id),
                     CONSTRAINT complex_fk FOREIGN KEY (complexity) references LAWYER(id),
                     CONSTRAINT billCase_fk FOREIGN KEY (caseID) references LEGAL_CASE(id)
);


CREATE TABLE CASE_ASSIGN(
                            lawyerID INT NOT NULL,
                            caseID INT NOT NULL,
                            assignDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

                            constraint caseAssign_pk primary key (lawyerID, caseID),
                            CONSTRAINT assignLawyer_fk FOREIGN KEY (lawyerID) references LAWYER(id),
                            CONSTRAINT assignedCase_fk FOREIGN KEY (caseID) references LEGAL_CASE(id)
);


CREATE TABLE Document(
                         id INT NOT NULL,
                         caseID INT NOT NULL,
                         name varchar(60) NOT NULL,
                         uploadTime TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                         uploadBy int NOT NULL,

                         constraint doc_pk primary key (id),
                         CONSTRAINT uploadBy_fk FOREIGN KEY (uploadBy) references LAWYER(id),
                         CONSTRAINT docCase_fk FOREIGN KEY (caseID) references LEGAL_CASE(id)
);


CREATE TABLE Appointment(
                            id INT NOT NULL,
                            caseID INT NOT NULL,
                            title varchar(60) NOT NULL,
                            description varchar(650),
                            date TIMESTAMP NOT NULL,

                            constraint appoint_pk primary key (id),
                            CONSTRAINT appCase_fk FOREIGN KEY (caseID) references LEGAL_CASE(id)
);


CREATE TABLE Reminder(
                         id INT NOT NULL,
                         appID INT NOT NULL,
                         title varchar(60) NOT NULL,
                         time TIMESTAMP NOT NULL,

                         constraint R_appoint_pk primary key (id),
                         CONSTRAINT R_appoint_fk FOREIGN KEY (appID) references Appointment(id)
);