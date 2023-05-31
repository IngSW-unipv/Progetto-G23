use stadiumsystem;

insert into utenti
values 
	('test1@example.com', 'john', 'doe', 'pass', 'CLIENTE','2000-01-30'),
	('a', 'a', 'a', 'a', 'CLIENTE','2001-04-26'),
	('b', 'b', 'b', 'b', 'ADMIN','2002-10-02');


insert into partite
values
	('2023-1-1 15:00:00', 'Napoli', 50, 40000),
    ('2023-1-2 16:00:00', 'Lazio', 50, 40000),
    ('2023-1-3 21:30:00', 'Fiorentina', 50, 40000),
    ('2023-1-4 15:00:00', 'Sassuolo', 50, 40000),
    ('2023-1-5 15:00:00', 'Salernitana', 50, 40000),
    ('2023-1-6 15:00:00', 'Roma', 50, 40000);
    
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
	('Coppa', 2022, "Coppa vinta dall'inter che prevede la partecipazione di 20 squadre di Serie A, 20 di Serie B, 29 di Serie C e 29 di Serie D", "coppaitalia"),
    ('Coppa', 2010, "Coppa che prevede innanzitutto la partecipazione di 20 squadre di Serie A, 20 di Serie B, 29 di Serie C e 29 di Serie D, grazie anche a questo trofeo l'inter fece il Triplete", "coppaitalia"),
    ('Coppa', 2022, "La Supercoppa mette annualmente di fronte il club campione d'Italia e quello vincitore della Coppa Italia", "supercoppa"),
    ('Coppa', 2010, "La Supercoppa mette annualmente di fronte il club campione d'Italia e quello vincitore della Coppa Italia,grazie anche a questo trofeo l'inter fece il Triplete", "supercoppa"),
    ('Trofeo', 2021, "La Supercoppa mette annualmente di fronte il club campione d'Italia e quello vincitore della Coppa Italia", "scudetto"),
    ('Trofeo', 2010, "Trofeo che attesta la vittoria del campionato utenti,grazie anche a questo trofeo l'inter fece il Triplete", "scudetto");