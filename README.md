# AMRIT - Common Service 
[![License: GPL v3](https://img.shields.io/badge/License-GPLv3-blue.svg)](https://www.gnu.org/licenses/gpl-3.0)  ![branch parameter](https://github.com/PSMRI/Common-API/actions/workflows/sast-and-package.yml/badge.svg) 


Common API is a microservice whch acts as a gateway for AMRIT. There are many APIs that are exposed by Common-API. It contains APIs of common integrators like c-Zentrix, Everwell, Openkm and some master APIs like location master, alerts,  notification,language and location messages.
### Primary Features
* Beneficiary Registration
* User authorisation and authentication
* Call handling (107,1097 & mcts)
* Covid Vaccine status
* Email Service
* SMS Service
* OTP Service
* Feedback service
* Beneficiary Medical History maintenance 
* Finding Institutions
* KM file management
* Fetching data from POCT devices
* Report APIs
* Language API
* Notification service
* CRM Reports
* Appointment Scheduling

## Building From Source
This microservice is built on Java, Spring boot framework and MySQL DB.

### Prerequisites 
* JDK 1.8
* Maven 

$ ./mvn clean install

## Installation
This service has been tested on Wildfly as the application server.

### Prerequisites 
* Wildfly (or any compatible app server)
* Redis
* MySQL Database

## Environment and setup

1. Install dependencies `mvn clean install`
2. You can copy `common_example.properties` to `common_local.properties` and edit the file accordingly. The file is under `src/main/environment` folder.
3. Run the spring server with local configuration `mvn spring-boot:run -DENV_VAR=local`

## Integrations
* C_Zentrix
* Everwell
* Openkm
* Door to door App
* Swaasa
* LOINCs
* SnomedCT

## Usage
All features have been exposed as REST endpoints. Refer to the SWAGGER API specification for details.

