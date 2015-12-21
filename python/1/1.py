#!/usr/bin/env python
from sys import argv
from random import randint


def roll_dice():
    """Function returns random number from 1 to 6"""
    return randint(1, 6)


def game(number_of_matches):
    """Game"""
    player1_won_games = 0
    player2_won_games = 0
    for match in range(number_of_matches):
        print "======"
        print "ROUND {0}".format(match + 1)
        print "======"

        print "Player1 rolls a dice..."
        player1_first_roll = roll_dice()
        print "First roll: {0}, so far: {1}".format(player1_first_roll, player1_first_roll)
        player1_second_roll = roll_dice()
        player1_scores_in_match = player1_first_roll + player1_second_roll
        print "Second roll: {0}, so far: {1}\n".format(player1_second_roll, player1_scores_in_match)

        print "Player2 rolls a dice..."
        player2_first_roll = roll_dice()
        print "First roll: {0}, so far: {1}".format(player2_first_roll, player2_first_roll)
        player2_second_roll = roll_dice()
        player2_scores_in_match = player2_first_roll + player2_second_roll
        print "Second roll: {0}, so far: {1}\n\n".format(player2_second_roll, player2_scores_in_match)

        if player1_scores_in_match > player2_scores_in_match:
            player1_won_games += 1
        elif player1_scores_in_match < player2_scores_in_match:
            player2_won_games += 1

        print "First player: {0} won matches".format(player1_won_games)
        print "Second player: {0} won matches\n\n".format(player2_won_games)

        if (player1_won_games == player2_won_games) and (match == number_of_matches - 1) :
            print "+++++++++++++++++"
            print "+++ EXTRA GAME +++"
            print "+++++++++++++++++"
            extra_time()

def extra_time():
    while True:
        print "Player1 rolls a dice..."
        player1_first_roll = roll_dice()
        print "First roll: {0}, so far: {1}".format(player1_first_roll, player1_first_roll)
        player1_second_roll = roll_dice()
        player1_scores_in_match = player1_first_roll + player1_second_roll
        print "Second roll: {0}, so far: {1}\n".format(player1_second_roll, player1_scores_in_match)

        print "Player2 rolls a dice..."
        player2_first_roll = roll_dice()
        print "First roll: {0}, so far: {1}".format(player2_first_roll, player2_first_roll)
        player2_second_roll = roll_dice()
        player2_scores_in_match = player2_first_roll + player2_second_roll
        print "Second roll: {0}, so far: {1}\n\n".format(player2_second_roll, player2_scores_in_match)

        if player1_scores_in_match > player2_scores_in_match:
            print "FIRST PLAYER WON A GAME!!!"
            break
        elif player1_scores_in_match < player2_scores_in_match:
            print "SECOND PLAYER WON A GAME!!!"
            break

game(int(argv[1]))
