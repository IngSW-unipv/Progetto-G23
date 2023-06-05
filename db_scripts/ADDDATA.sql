use stadiumsystem;

insert into utenti
values 
	('test1@example.com', 'john', 'doe', 'pass', 'CLIENTE','2000-01-30'),
	('a', 'a', 'a', 'a', 'CLIENTE','2001-04-26'),
	('b', 'b', 'b', 'b', 'ADMIN','2002-10-02');


insert into partite
values
	('2023-1-1 15:00:00', 'Napoli', 50, 60000),
    ('2023-1-2 16:00:00', 'Lazio', 50, 60000),
    ('2023-1-3 21:30:00', 'Fiorentina', 50, 60000),
    ('2023-1-4 15:00:00', 'Sassuolo', 50, 60000),
    ('2023-1-5 15:00:00', 'Salernitana', 50, 60000),
    ('2023-1-6 15:00:00', 'Roma', 50, 60000);
    
insert into store_items(nome, prezzo, quantita_rimanente, descrizione)
values
	('T-shirt verde', 24.90, 25, "Maglietta di cotone molto comoda e confortevole."),
    ('T-shirt blu elettrico', 24.90, 31, "Maglietta di cotone molto comoda e confortevole."),
    ('T-shirt verde 2', 24.90, 8, "Maglietta di cotone molto comoda e confortevole."),
    ('T-shirt verde 3', 10.01, 25, "Maglietta di cotone molto comoda e confortevole."),
    ('T-shirt verde 4', 1, 25, "Maglietta di cotone molto comoda e confortevole."),
    ('T-shirt verde 5', 8, 25, "Maglietta di cotone molto comoda e confortevole.");

insert into acquisti_store(item, buyer, quantita)
values
	(1, 'a', 13);
    
insert into museo_items(nome, anno, descrizione, nome_img)
values
	('Fotografia', 1997, "Foto di Ronaldo Luis Nazario da Lima o megli conosciuto come Ronaldo 'il feonomeno' nel 1997, anno in cui vinse il pallone d'oro. In quella stagione (1997-98) il brasiliano era insindacabilmente il calciatore più forte al mondo.", "ronaldoPalloneDOro.jpg"),
	('Maglia', 2010, "Maglia indossata da Diego Milito durante la finale di Champions League in cui andò a segno con una  doppietta che permise di conquistare la coppa dall grandi orecchie, la terza nella storia del club. Sul retro è riportata la firma dello stesso Diego Milito.", "magliettaMilito.png"),
	('Champions_League', 2010, "La coppa dalle grandi orecchie conquistata dalla formazione leggendaria del 2010 contro il Bayern Monaco a Madrid. La terza e per ora piu recente della stora del club.", "champions.png"),
    ('Coppa_Del_Mondo_Per_Club', 2010, "Coppa del mondo per club vinta nell''anno storico del triplete, prima ed unica squadra italiana ad aver conseguito questo successo sportivo.", "coppaclub.png"),
    ('Coppa_Italia', 2022, "Coppa vinta dall'inter che prevede la partecipazione di 20 squadre di Serie A, 20 di Serie B, 29 di Serie C e 29 di Serie D", "coppaitalia.png"),
    ('Coppa_Italia', 2010, "Coppa che prevede innanzitutto la partecipazione di 20 squadre di Serie A, 20 di Serie B, 29 di Serie C e 29 di Serie D, grazie anche a questo trofeo l'inter fece il Triplete", "coppaitalia.png"),
    ('Supercoppa_Italiana', 2022, "La Supercoppa mette annualmente di fronte il club campione d'Italia e quello vincitore della Coppa Italia", "supercoppa.png"),
    ('Supercoppa_Italiana', 2010, "La Supercoppa mette annualmente di fronte il club campione d'Italia e quello vincitore della Coppa Italia,grazie anche a questo trofeo l'inter fece il Triplete", "supercoppa.png"),
    ('SerieA', 2021, "Trofeo che attesta la vittoria del campionato utenti", "scudetto.png"),
    ('SerieA', 2010, "Trofeo che attesta la vittoria del campionato utenti,grazie anche a questo trofeo l'inter fece il Triplete", "scudetto.png");