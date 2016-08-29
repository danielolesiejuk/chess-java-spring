insert into user (login, name) values ("Romeo", "Wiliam");
insert into user (login, name) values ("Opium", "Hanna");
insert into user (login, name) values ("Odyseusz", "Jan");
insert into user (login, name) values ("Awantura", "Edmund");
insert into user (login, name) values ("Fantomas", "Zbigniew");
insert into user (login, name) values ("Zemsta", "Aleksander");

insert into match_tbl (player_id, opponent_id, on_move_player, game_finished, game_arbitration, date) 			values (1, 2, false, true, 'NONE', CURRENT_TIMESTAMP());
insert into match_tbl (player_id, opponent_id, on_move_player, game_finished, game_arbitration, date) 			values (1, 3, false, true, 'NONE', CURRENT_TIMESTAMP());
insert into match_tbl (player_id, opponent_id, on_move_player, game_finished, game_arbitration, date) 			values (1, 4, true, false, 'NONE', DATE_SUB(curdate(), INTERVAL 1 day));			
insert into match_tbl (player_id, opponent_id, on_move_player, game_finished, game_arbitration, date) 			values (1, 5, false, false, 'NONE', CURRENT_TIMESTAMP());			
insert into match_tbl (player_id, opponent_id, on_move_player, game_finished, game_arbitration, date) 			values (1, 6, false, false, 'NONE', CURRENT_TIMESTAMP());
insert into match_tbl (player_id, opponent_id, on_move_player, game_finished, game_arbitration, date) 			values (2, 3, false, true, 'NONE', DATE_SUB(curdate(), INTERVAL 1 day));
insert into match_tbl (player_id, opponent_id, on_move_player, game_finished, game_arbitration, date) 			values (2, 4, false, true, 'NONE', CURRENT_TIMESTAMP());
insert into match_tbl (player_id, opponent_id, on_move_player, game_finished, game_arbitration, date) 			values (2, 5, true, false, 'NONE', CURRENT_TIMESTAMP());			
insert into match_tbl (player_id, opponent_id, on_move_player, game_finished, game_arbitration, date) 			values (2, 6, false, false, 'NONE', DATE_SUB(curdate(), INTERVAL 1 day));			
insert into match_tbl (player_id, opponent_id, on_move_player, game_finished, game_arbitration, date) 			values (3, 4, false, true, 'NONE', CURRENT_TIMESTAMP());
insert into match_tbl (player_id, opponent_id, on_move_player, game_finished, game_arbitration, date) 			values (3, 5, true, true, 'NONE', CURRENT_TIMESTAMP());
insert into match_tbl (player_id, opponent_id, on_move_player, game_finished, game_arbitration, date) 			values (3, 6, false, false, 'NONE', DATE_SUB(curdate(), INTERVAL 1 day));
insert into match_tbl (player_id, opponent_id, on_move_player, game_finished, game_arbitration, date) 			values (4, 5, false, false, 'NONE', CURRENT_TIMESTAMP());
insert into match_tbl (player_id, opponent_id, on_move_player, game_finished, game_arbitration, date) 			values (4, 6, true, false, 'NONE', CURRENT_TIMESTAMP());			
insert into match_tbl (player_id, opponent_id, on_move_player, game_finished, game_arbitration, date) 			values (5, 6, true, false, 'NONE', DATE_SUB(curdate(), INTERVAL 1 day));			
			
