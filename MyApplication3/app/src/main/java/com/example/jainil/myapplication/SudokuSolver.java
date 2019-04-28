package com.example.jainil.myapplication;

import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class SudokuSolver extends AppCompatActivity {


    Button btn;
    EditText t1;
    EditText t2;
    EditText t3;
    EditText t4;
    EditText t5;
    EditText t6;
    EditText t7;
    EditText t8;
    EditText t9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sudoku_solver);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        t1 = (EditText) findViewById(R.id.editText1);
        t2 = (EditText) findViewById(R.id.editText2);
        t3 = (EditText) findViewById(R.id.editText3);
        t4 = (EditText) findViewById(R.id.editText4);
        t5 = (EditText) findViewById(R.id.editText5);
        t6 = (EditText) findViewById(R.id.editText6);
        t7 = (EditText) findViewById(R.id.editText7);
        t8 = (EditText) findViewById(R.id.editText8);
        t9 = (EditText) findViewById(R.id.editText9);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public static boolean UsedInBox(int grid[][], int boxStartRow, int boxStartCol, int num) {
        for (int row = 0; row < 3; row++)
            for (int col = 0; col < 3; col++)
                if (grid[row + boxStartRow][col + boxStartCol] == num)
                    return true;
        return false;
    }/* Returns whether it will be legal to assign num to the given row,col location.
     */

    public static boolean isSafe(int grid[][], int row, int col, int num) {
        return !UsedInRow(grid, row, num) && !UsedInCol(grid, col, num) && !UsedInBox(grid, row - row % 3, col - col % 3, num);
    }


    public static boolean SolveSudoku(int grid[][]) {
        int row = 0, col = 0;

        int flag;
        flag = 0;
        aa:
        for (row = 0; row < 9; row++)
            for (col = 0; col < 9; col++) {
                if (grid[row][col] == 0) {
                    flag = 1;
                    break aa;
                }
            }

        if (row == 9 || col == 9) {
            return true;
        }

        for (int num = 1; num <= 9; num++) {
            if (isSafe(grid, row, col, num)) {
                grid[row][col] = num;
                if (SolveSudoku(grid))
                    return true;
                grid[row][col] = 0;
            }
        }
        return false;
    }
    /* Searches the grid to find an entry that is still unassigned. */

    /* Returns whether any assigned entry n the specified row matches
       the given number. */
    public static boolean UsedInRow(int grid[][], int row, int num) {
        for (int col = 0; col < 9; col++)
            if (grid[row][col] == num)
                return true;
        return false;
    }

    /* Returns whether any assigned entry in the specified column matches
       the given number. */
    public static boolean UsedInCol(int grid[][], int col, int num) {
        for (int row = 0; row < 9; row++)
            if (grid[row][col] == num)
                return true;
        return false;
    }/* Returns whether any assigned entry within the specified 3x3 box matches
       the given number. */

    char grid[][] = new char[9][9];

    public void onrate(View v) {
        RatingBar rr = (RatingBar) findViewById(R.id.ratingBar2);
        Context context=getApplicationContext();
        Toast toast=Toast.makeText(context,"Thanks for rating us "+rr.getRating()+" Stars",Toast.LENGTH_SHORT);
        toast.show();

    }


    public void onbutclick(View v) {


        TextView cc = (TextView) findViewById(R.id.textView);
        String s1 = t1.getText().toString();
        String s2 = t2.getText().toString();
        String s3 = t3.getText().toString();
        String s4 = t4.getText().toString();
        String s5 = t5.getText().toString();
        String s6 = t6.getText().toString();
        String s7 = t7.getText().toString();
        String s8 = t8.getText().toString();
        String s9 = t9.getText().toString();
        grid[0][0] = s1.charAt(0);
        grid[0][1] = s1.charAt(1);
        grid[0][2] = s1.charAt(2);
        grid[0][3] = s1.charAt(3);
        grid[0][4] = s1.charAt(4);
        grid[0][5] = s1.charAt(5);
        grid[0][6] = s1.charAt(6);
        grid[0][7] = s1.charAt(7);
        grid[0][8] = s1.charAt(8);


        grid[1][0] = s2.charAt(0);
        grid[1][1] = s2.charAt(1);
        grid[1][2] = s2.charAt(2);
        grid[1][3] = s2.charAt(3);
        grid[1][4] = s2.charAt(4);
        grid[1][5] = s2.charAt(5);
        grid[1][6] = s2.charAt(6);
        grid[1][7] = s2.charAt(7);
        grid[1][8] = s2.charAt(8);

        grid[2][0] = s3.charAt(0);
        grid[2][1] = s3.charAt(1);
        grid[2][2] = s3.charAt(2);
        grid[2][3] = s3.charAt(3);
        grid[2][4] = s3.charAt(4);
        grid[2][5] = s3.charAt(5);
        grid[2][6] = s3.charAt(6);
        grid[2][7] = s3.charAt(7);
        grid[2][8] = s3.charAt(8);

        grid[3][0] = s4.charAt(0);
        grid[3][1] = s4.charAt(1);
        grid[3][2] = s4.charAt(2);
        grid[3][3] = s4.charAt(3);
        grid[3][4] = s4.charAt(4);
        grid[3][5] = s4.charAt(5);
        grid[3][6] = s4.charAt(6);
        grid[3][7] = s4.charAt(7);
        grid[3][8] = s4.charAt(8);

        grid[4][0] = s5.charAt(0);
        grid[4][1] = s5.charAt(1);
        grid[4][2] = s5.charAt(2);
        grid[4][3] = s5.charAt(3);
        grid[4][4] = s5.charAt(4);
        grid[4][5] = s5.charAt(5);
        grid[4][6] = s5.charAt(6);
        grid[4][7] = s5.charAt(7);
        grid[4][8] = s5.charAt(8);

        grid[5][0] = s6.charAt(0);
        grid[5][1] = s6.charAt(1);
        grid[5][2] = s6.charAt(2);
        grid[5][3] = s6.charAt(3);
        grid[5][4] = s6.charAt(4);
        grid[5][5] = s6.charAt(5);
        grid[5][6] = s6.charAt(6);
        grid[5][7] = s6.charAt(7);
        grid[5][8] = s6.charAt(8);

        grid[6][0] = s7.charAt(0);
        grid[6][1] = s7.charAt(1);
        grid[6][2] = s7.charAt(2);
        grid[6][3] = s7.charAt(3);
        grid[6][4] = s7.charAt(4);
        grid[6][5] = s7.charAt(5);
        grid[6][6] = s7.charAt(6);
        grid[6][7] = s7.charAt(7);
        grid[6][8] = s7.charAt(8);

        grid[7][0] = s8.charAt(0);
        grid[7][1] = s8.charAt(1);
        grid[7][2] = s8.charAt(2);
        grid[7][3] = s8.charAt(3);
        grid[7][4] = s8.charAt(4);
        grid[7][5] = s8.charAt(5);
        grid[7][6] = s8.charAt(6);
        grid[7][7] = s8.charAt(7);
        grid[7][8] = s8.charAt(8);

        grid[8][0] = s9.charAt(0);
        grid[8][1] = s9.charAt(1);
        grid[8][2] = s9.charAt(2);
        grid[8][3] = s9.charAt(3);
        grid[8][4] = s9.charAt(4);
        grid[8][5] = s9.charAt(5);
        grid[8][6] = s9.charAt(6);
        grid[8][7] = s9.charAt(7);
        grid[8][8] = s9.charAt(8);

        cc.setText("");
        int gridd[][] = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                gridd[i][j] = (Integer.valueOf(grid[i][j])) - 48;
            }
        }
        if (SolveSudoku(gridd) == true) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    cc.append(Integer.toString(gridd[i][j]) + "  ");

                }
                cc.append("\n");
            }
        }
        else {
            cc.append("NO SOLUTION FOUND : ENTER CORRECT MATRIX");
        }
        String aaa="";
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                aaa=aaa+(Integer.toString(gridd[i][j]) + "  ");

            }
            aaa=aaa+("\n");
        }
        Bitmap icon1= BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher);
        NotificationCompat.BigTextStyle bigText=new NotificationCompat.BigTextStyle();
        bigText.bigText(aaa);
        bigText.setBigContentTitle("Solved sudoku");
        bigText.setSummaryText("By Jainil Patel");
        NotificationCompat.Builder mbuilder=new NotificationCompat.Builder(this).setSmallIcon(R.mipmap.ic_launcher).setContentTitle("Solved Sudoku").setContentText("aaa").setLargeIcon(icon1).setStyle(bigText);
        NotificationManager mNotificationManager=(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(0,mbuilder.build());

    }

}
