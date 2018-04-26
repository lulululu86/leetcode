package com.luo.leetcode;

import java.util.LinkedList;
import java.util.List;

public class DesignSnakeGame_353 {
    /*Design a Snake game that is played on a device with screen size = width x height.
    Play the game online if you are not familiar with the game.

The snake is initially positioned at the top left corner (0,0) with length = 1 unit.

You are given a list of food's positions in row-column order. When a snake eats the food,
its length and the game's score both increase by 1.

Each food appears one by one on the screen. For example, the second food will not appear
until the first food was eaten by the snake.

When a food does appear on the screen, it is guaranteed that it will not appear on a block occupied by the snake.

Example:
Given width = 3, height = 2, and food = [[1,2],[0,1]].

Snake snake = new Snake(width, height, food);

Initially the snake appears at position (0,0) and the food at (1,2).

|S| | |
| | |F|

snake.move("R"); -> Returns 0

| |S| |
| | |F|

snake.move("D"); -> Returns 0

| | | |
| |S|F|

snake.move("R"); -> Returns 1 (Snake eats the first food and right after that, the second food appears at (0,1) )

| |F| |
| |S|S|

snake.move("U"); -> Returns 1

| |F|S|
| | |S|

snake.move("L"); -> Returns 2 (Snake eats the second food)

| |S|S|
| | |S|

snake.move("U"); -> Returns -1 (Game over because snake collides with border)

Credits:
Special thanks to @elmirap for adding this problem and creating all test cases.*/
    private int[] head;
    private int[][]food;
    private int width;
    private int height;
    private List<int[]> body;
    private int foodIdx;
    private int score;
    public DesignSnakeGame_353(int width,int height,int[][]food){
        head = new int[]{0,0};
        body = new LinkedList<int[]>();
        body.add(new int[]{0,0});
        this.food = food;
        this.width = width;
        this.height = height;
        foodIdx = 0;
        score = 0;
    }
    public int move(String dir){
        if(dir.equals("L"))head[1]--;
        if(dir.equals("R"))head[1]++;
        if(dir.equals("U"))head[0]--;
        if(dir.equals("D"))head[0]++;
        System.out.println("cur position: "+head[0]+","+head[1]);
        if(head[1]<0||head[1]>=width||head[0]<0||head[0]>=height)return -1;
        else if(head[0]==food[foodIdx][0] && head[1]==food[foodIdx][1]){
            body.add(0,head);
            foodIdx++;
            score++;
            return score;
        }else{
            body.remove(body.size()-1);
            body.add(0,head);
            return score;
        }

    }
}
