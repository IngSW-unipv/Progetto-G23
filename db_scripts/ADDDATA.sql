use stadiumsystem;

insert into utenti
values 
	('gabriele.invernizzi02@universitadipavia.it', 'Gabriele', 'Invernizzi', 'gabriele01', 'CLIENTE', '2001-11-21'),
	('federico.romano01@universitadipavia.it', 'Federico', 'Romano', 'federico01', 'CLIENTE', '2002-07-15'),
    ('lorenzo.reale01@universitadipavia.it', 'Lorenzo', 'Reale', 'lorenzo01', 'CLIENTE', '2001-08-18'),
    ('jacopo.piccoli01@universitadipavia.it', 'Jacopo', 'Piccoli', 'jacopo01', 'CLIENTE', '2001-04-26'),
    ('federoma78@gmail.com', 'Federico', 'Romano', 'admin', 'ADMIN', '2001-07-15');
    
insert into carta_pagamento
values
	('lorenzo.reale01@universitadipavia.it', 'Lorenzo', 'Reale', 1234567890123456, 12, 2034);

insert into biglietti_museo(email, email_conferma, numero_persone, dat, ora)
values
	('lorenzo.reale01@universitadipavia.it', 'lorenzo.reale01@universitadipavia.it', 2, '2023-07-10', '16:00'),
	('federico.romano01@universitadipavia.it', 'federico.romano01@universitadipavia.it', 1, '2023-08-20', '15:00'),
    ('jacopo.piccoli01@universitadipavia.it', 'jacopo.piccoli01@universitadipavia.it', 2, '2023-07-23', '15:30'),
    ('gabriele.invernizzi02@universitadipavia.it', 'gabriele.invernizzi02@universitadipavia.it', 2, '2023-08-01', '17:00');

insert into abbonamenti
values
	('lorenzo.reale01@universitadipavia.it', 'LIV2'),
    ('federico.romano01@universitadipavia.it', 'LIV0'),
    ('gabriele.invernizzi02@universitadipavia.it', 'LIV1'),
    ('jacopo.piccoli01@universitadipavia.it', 'LIV3');

insert into partite
values
	('2023-6-1 15:00:00', 'Napoli', 50, 60000),
    ('2023-6-8 16:00:00', 'Lazio', 50, 60000),
    ('2023-6-15 21:30:00', 'Juventus', 50, 60000),
    ('2023-9-22 15:00:00', 'Sassuolo', 50, 60000),
    ('2023-9-29 21:00:00', 'Salernitana', 50, 60000),
    ('2023-10-5 18:00:00', 'Roma', 50, 60000),
    ('2023-10-12 21:00:00', 'Milan', 50, 60000),
    ('2023-10-19 15:00:00', 'Atalanta', 50, 60000),
    ('2023-10-26 18:30:00', 'Spezia', 50, 60000),
    ('2023-10-31 21:00:00', 'Verona', 50, 60000);
    
insert into posti
values
	('2023-9-22 15:00:00', 1, 1, 1, 1, 'lorenzo.reale01@universitadipavia.it'),
    ('2023-9-29 21:00:00', 1, 2, 3, 10, 'jacopo.piccoli01@universitadipavia.it'),
    ('2023-10-31 21:00:00', 1, 2, 3, 2, 'federico.romano01@universitadipavia.it'),
    ('2023-10-26 18:30:00', 2, 2, 1, 1, 'gabriele.invernizzi02@universitadipavia.it');
    
insert into store_items(nome, prezzo, quantita_rimanente, descrizione)
values
	('T-shirt campioni SuperCoppa Italiana', 20.00, 25, "Maglietta di cotone con scritta ""CAMPION7"""),
    ('T-shirt campioni Coppa Italiana', 20.00, 25, "Maglietta di cotone con scritta ""C9MPIONI"""),
    ('Polo Inter', 25.00, 31, "Polo comoda e confortevole."),
    ('Cappellino Inter', 14.99, 31, "Cappellino nero e azzurro."),
    ('Home kit 2023', 100.00, 8, "Maglietta e pantalonicni del kit di casa, stagione 2022/23."),
    ('Outdoor Kit 2023', 110.00, 25, "Maglietta e pantalonicni del kit fuori casa, stagione 2022/23."),
    ('Sciarpa Inter', 1, 25, "Sciarpa ""IM INTER"" blu e nera."),
    ('Third Kit 2023', 8, 25, "Maglietta e pantalonicni del terzo kit, stagione 2022/23.");

insert into acquisti_store(item, buyer, quantita)
values
	(1, 'federico.romano01@universitadipavia.it', 1),
    (5, 'gabriele.invernizzi02@universitadipavia.it', 2),
    (3, 'lorenzo.reale01@universitadipavia.it', 1),
    (2, 'jacopo.piccoli01@universitadipavia.it', 1),
    (8, 'lorenzo.reale01@universitadipavia.it', 1),
    (6, 'federico.romano01@universitadipavia.it', 1);
    
insert into museo_items(nome, anno, descrizione, nome_img)
values
	('Fotografia', 2014, "L'Inter batte 4 a 1 conto la Lazio, nel match della 37^ giornata di Serie A e raggiunge l'Europa League. Non solo campo, perché a San Siro, è festa grande per Javier Zanetti nella sua ultima partita casalinga e per Diego Milito che lascerà i nerazzurri (nel finale, il commosso addio).", "10Maggio.jpg"),
	('Fotografia', 2010, "Foto che ritrae i tre protagonisti argentini che festeggiano la vittoria della Champions League.", "ArgentiniChampions.jpg"),
    ('Fotografia', 1997, "Foto di Ronaldo Luis Nazario da Lima o megli conosciuto come Ronaldo 'il feonomeno' nel 1997, anno in cui vinse il pallone d'oro. In quella stagione (1997-98) il brasiliano era insindacabilmente il calciatore più forte al mondo.", "ronaldoPalloneDOro.jpg"),
	('Maglia', 2010, "Maglia indossata da Diego Milito durante la finale di Champions League in cui andò a segno con una  doppietta che permise di conquistare la coppa dall grandi orecchie, la terza nella storia del club. Sul retro è riportata la firma dello stesso Diego Milito.", "magliettaMilito.png"),
	('Champions_League', 2010, "La coppa dalle grandi orecchie conquistata dalla formazione leggendaria del 2010 contro il Bayern Monaco a Madrid. La terza e per ora piu recente della stora del club.", "champions.png"),
    ('Coppa_Del_Mondo_Per_Club', 2010, "Coppa del mondo per club vinta nell''anno storico del triplete, prima ed unica squadra italiana ad aver conseguito questo successo sportivo.", "coppaclub.png"),
    ('Coppa_Italia', 2022, "Coppa vinta dall'inter che prevede la partecipazione di 20 squadre di Serie A, 20 di Serie B, 29 di Serie C e 29 di Serie D.", "coppaitalia.png"),
    ('Coppa_Italia', 2010, "Coppa che prevede innanzitutto la partecipazione di 20 squadre di Serie A, 20 di Serie B, 29 di Serie C e 29 di Serie D, grazie anche a questo trofeo l'inter fece il Triplete.", "coppaitalia.png"),
    ('Supercoppa_Italiana', 2022, "La Supercoppa mette annualmente di fronte il club campione d'Italia e quello vincitore della Coppa Italia.", "supercoppa.png"),
    ('Supercoppa_Italiana', 2010, "La Supercoppa mette annualmente di fronte il club campione d'Italia e quello vincitore della Coppa Italia, grazie anche a questo trofeo l'inter fece il Triplete.", "supercoppa.png"),
    ('SerieA', 2021, "Trofeo che attesta la vittoria del campionato utenti.", "scudetto.png"),
    ('Fotografia', 2010, "Foto che ritrae Eto'o che festeggia la vittoria della Champions League indossando la bandiera del Camerun.", "etoChampions.jpg"),
    ('Fotografia', 2010, "Foto che ritrae Julio Cesar che esulta al gol di Milito nel secondo tempo al minuto 70.", "JulioCesarFoto.jpg"),
    ('Fotografia', 2021, "Foto che ritrae la coppia europea più prolifica della stagione 20/21 Lukaku-Lautaro, definita Lu-La, che festeggia la vittoria del campionato.", "LuLa.jpg"),
    ('Fotografia', 1971, "Medaglia che celebra i campionati vinti fino al 1971", "MedagliaInter1971.png"),
    ('Maglia', 2021, "Maglia ufficiale 2020-21 Inter Milan Third firmata da Javier Zanetti.", "magliaZanettiTerza.jpg"),
    ('Fotografia', 2010, "Foto del presidente Moratti e dell'allora allenatore Mourinho durante la festa per la vittoria della Champions League.", "MorattiMou.jpg"),
    ('Pallone', 2023, "Pallone realizzato in occasione della celebrazione dei 115 anni di storia del club dalla sua creazione nel 1908.", "pallone115anni.jpg"),
    ('Pallone', 2010, "Pallone utilizzato durante la finale di Champions del 2010 che vide il trionfo dei nerazzurri segando così un evento leggendario del club.", "palloneChampions.jpg"),
    ('Scarpe', 2009, "Scarpe iconiche della stagione 2009/2010 dell'argentino Diego Milito con cui disputò la sua migliore stagione.", "ScarpeMilito200910.jpg"),
    ('Scarpe', 2010, "Scarpe iconiche della stagione 2009/2010 del capitano argentino Javier Zanetti con cui disputò la finale di Champions League a Madrid.", "ScarpeZanetti22052010.jpg"),
    ('Fotografia', 2009, "Foto che ritrae due dei più discussi e talentuosi attaccanti di quel periodo.", "BaloZlatan.jpg"),
    ('Fotografia', 2021, "Foto che ritrae il festeggiamento della vittoria dello scudetto dell'anno 2021 con Lautaro e Correa.", "SuperCoppa2021.jpg"),
    ('Europa_League', 1998, "La Coppa UEFA 1997-1998 fu la 27ª edizione della terza competizione UEFA all'epoca per rango. Fu la prima edizione la cui finale si disputò in gara unica e la sede designata fu il Parco dei Principi di Parigi. Fu vinta dall'Inter, vittoriosa 3-0 sulla Lazio.", "coppauefa.jpg"),
    ('Coppa_Intercontinentale', 1964, "La Coppa Intercontinentale 1964 è stata la quinta edizione del trofeo riservato alle squadre vincitrici della Coppa dei Campioni e della Coppa Libertadores.", "coppaintercontinentale.jpg"),
    ('SerieA', 2010, "Trofeo che attesta la vittoria del campionato, grazie anche a questo trofeo l'inter fece il Triplete.", "scudetto.png");