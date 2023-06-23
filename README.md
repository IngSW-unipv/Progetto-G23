# StadiumSystem
Progetto del gruppo di Informatici_per_obbligo del corso di programmazione ad oggeti e ingegneria del software dell'Università di Pavia.

## Obbiettivo
StadiumSystem si propone come soluzione per la gestione dell'infrastruttura di uno stadio di una squadra di calcio; partendo dalla prenotazione dei posti delle partite fino alla gestione dello store online e delle prenotazioni del museo della squadra.
L'applicazione offre un'esperienza personalizzata per gli admin dandogli la possibilità di gestire ogni sezione dell'app e di visionare i ricavi differenziati per prodotto.

## Tecnologie utilizzate
- [FlatLaf](https://github.com/JFormDesigner/FlatLaf)
- [MySQL Java Connector](https://github.com/mysql/mysql-connector-j)
- [LGoodDatePicker](https://github.com/LGoodDatePicker/LGoodDatePicker)
- [Javax mail](https://javadoc.io/doc/javax.mail/javax.mail-api/latest/index.html)
- [JUnit 5](https://junit.org/junit5)

## Guida per il setup
Per poter compilare l'app StadiumSystem è necessario l'utilizzo di [Eclipse IDE](https://www.eclipse.org).

### Clone del repository

```
git clone https://github.com/IngSW-unipv/Progetto-G23.git StadiumSystem
```
### Creazione del database
Utilizzando un qualsiasi client per MySQL si eseguano in ordine i due script nella cartalla `db_scripts`, essi creeranno tutte le tables necessarie e le riempiranno con dei dati utili ad una demo.
- `SSCREATE.sql`
- `ADDDATA.sql`

### Creazione delle proprietà
StadiumSystem per funzionare si aspetta che esistano dei file nei quali sono specificate proprietà che dovranno essere creati manualmente in una source directory nella root del progetto chiamata `properties`.

#### Database
In un file chiamato `properties` devono essere specificate le seguenti proprietà:
```
DBDRIVER = com.mysql.cj.jdbc.Driver
DBURL = jdbc:mysql://localhost:<port>/stadiumsystem?user=<utente>&password=<password>
```
Dove:
- \<utente\>: nome dell'utente.
- \<password\>: password dell'utente.
- \<port\>: porta verso la quale collegarsi.

#### Email
In un file chiamato `mail_properties` devono essere specificate le seguenti proprietà:
```
MITTENTE = <email mittente>
PASSWORD = <password del provider>
```
Dove:
- \<email mittente\>: email dell'account dal quale si vuole inviare le mail di conferma.
- \<password del provider\>: password del provider del servizio email.

#### Struttura finale cartelle

```
StadiumSystem
|
+- src
|
+- properties
|  |
|  +- properties
|  +- mail_properties
|
[...]
```
