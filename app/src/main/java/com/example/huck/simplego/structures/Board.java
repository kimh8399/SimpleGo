package com.example.huck.simplego.structures;

import java.util.Vector;

enum Color{Black, White, Empty};
enum StoneType{Friendly, Enemy, Both};

// Coord object
class Coord{
    int x,y;
    /* Constructor for Coord*/
    Coord(int x_v, int y_v){
        x = x_v;
        y = y_v;
    }
    /* Compares two Coordinates */
    public boolean cmp(Coord key){return(x == key.x && y == key.y);}
}

class Stone{
    Color color;                        // Color of the stone
    Coord [] connected;                 // Other stones connected to it
    int liberties;                      // Initial liberties

    Stone(){
        color = Color.Empty;            // Initializes the color of the stone to empty
        liberties = 4;                  // Each stone starts with 4 liberties
        connected = new Coord [4];      // Creates the list of connected stones
    }
}



public class Board {

    private final int BOARD_SIZE = 19;              // Size of the board
    Stone [][] boardState = new Stone[19][19];      // A 19x19 board that contains all the stones

    /*Returns whether a coordinate is in a list*/
    public static boolean find_coord(Vector<Coord> given, Coord key){
        for(int i = 0; i < given.size(); i++) {
            if ((given.get(i) == key))
                return false;
        }
        return true;
    }

    /*Returns the cardinal locations for certain stones (friendly, enemy, or both) */
    public Vector<Coord> get_cardinal(Coord loc, StoneType type){

        Color checkColor;
        Vector<Coord> cardinal = new Vector<>();

        switch (type) {
            case Friendly:
                checkColor = boardState[loc.x][loc.y].color;
                break;
            case Enemy:
                checkColor = (boardState[loc.x][loc.y].color == Color.Black) ? Color.White : Color.Black;
                break;
            case Both:
                checkColor = Color.Empty;
                break;
            default:
                checkColor = Color.Empty;
                break;
        }
        if(loc.x + 1 < BOARD_SIZE && ((boardState[loc.x + 1][loc.y].color == checkColor) || checkColor == Color.Empty)){
            cardinal.add(new Coord(loc.x + 1, loc.y));
        }
        if(loc.x - 1 > 0 && ((boardState[loc.x - 1][loc.y].color == checkColor) || checkColor == Color.Empty)){
            cardinal.add(new Coord(loc.x - 1, loc.y));
        }
        if(loc.y + 1 < BOARD_SIZE && ((boardState[loc.x][loc.y+ 1].color == checkColor) || checkColor == Color.Empty)) {
            cardinal.add(new Coord(loc.x, loc.y + 1));
        }
        if(loc.y - 1 > 0 && ((boardState[loc.x][loc.y - 1].color == checkColor) || checkColor == Color.Empty)) {
            cardinal.add(new Coord(loc.x, loc.y - 1));
        }

        return cardinal;
    }

    public void connect_group(){

    }

    public boolean has_liberties(Coord loc){
        int liberties = 0;


        return true;
    }

    public void remove_stone(Coord loc){

    }

    public boolean place_stone(Coord loc){
        return true;
    }

    public static void start_game(){

    }
}