package com.example.jainil.myapplication;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.StringTokenizer;

class Term
{

    public float coef;
    public int exp;
    Term sum(Term t2)
    {
        Term t3=new Term();
        t3.coef= coef+t2.coef;
        return t3;
    }
    Term sub(Term t2)
    {
        Term t3=new Term();
        t3.coef= coef-t2.coef;
        return t3;
    }
    Term mul(Term t2)
    {
        Term t3=new Term();
        t3.coef= coef*t2.coef;
        t3.exp= exp+t2.exp;
        return t3;
    }
}
class Polynomial
{

    public int d;
    public Term t[];

    Polynomial(int s)
    {
        d=s;

        t=new Term[d+1];
        for(int i=s;i>=0;i--)
        {
            t[i]=new Term();
            t[i].exp=i;
            t[i].coef=0;
        }
    }
    void getdata(float b[]) {

        for (int i = d; i >= 0; i--) {

            t[i].coef =  b[i];

        }
    }
    String putdata()
    {
        String c="";
        for(int i= d;i>=0;i--)
        {
            c=c+this.t[i].coef+"x^"+ i;

            if(i>0)
            {
                c=c+" + ";
            }
        }
        return c;
    }

    Polynomial sum(Polynomial p2)
    {
        int q;
        if( d>p2.d)
        {
            q= d;
        }
        else
        {
            q=p2.d;
        }
        Polynomial p3=new Polynomial(q);
        if( d>p2.d)
        {
            for(int i=q;i>=q-p2.d-1;i--)
            {
                p3.t[i].coef= t[i].coef;
            }
            for(int i=p2.d;i>=0;i--)
            {
                p3.t[i].coef= t[i].coef+p2.t[i].coef;
            }
        }
        else
        {
            for(int i=q;i>=d;i--)
            {
                p3.t[i].coef=p2.t[i].coef;
            }
            for(int i=d;i>=0;i--)
            {
                p3.t[i].coef= t[i].coef+p2.t[i].coef;
            }
        }
        return p3;
    }

    Polynomial sub(Polynomial p2)
    {
        int q;
        if(d>p2.d)
        {
            q=d;
        }
        else
        {
            q=p2.d;
        }
        Polynomial p3=new Polynomial(q);
        if( d>p2.d)
        {
            for(int i=q;i>=q-p2.d-1;i--)
            {
                p3.t[i].coef= t[i].coef;
            }
            for(int i=p2.d;i>=0;i--)
            {
                p3.t[i].coef= t[i].coef-p2.t[i].coef;
            }
        }
        else
        {
            for(int i=q;i>=d;i--)
            {
                p3.t[i].coef=p2.t[i].coef;
            }
            for(int i=d;i>=0;i--)
            {
                p3.t[i].coef= t[i].coef-p2.t[i].coef;
            }
        }
        return p3;

    }

    Polynomial mul(Polynomial p2)
    {
        int x;
        x= d+p2.d;
        Polynomial p3=new Polynomial(x);
        for(int i= d;i>=0;i--)
        {
            for(int j=p2.d;j>=0;j--)
            {
                p3.t[i+j]=p3.t[i+j].sum( t[i].mul(p2.t[j]));
            }

        }
        return p3;
    }


    Polynomial div(Polynomial p2)
    {
        Polynomial p3=new Polynomial(p2.d-d);
        Polynomial p4=new Polynomial(p2.d-1);
        int i=p2.d;
        for(int j=p2.d-d+1;j>0;j--)
        {
            float f=p2.t[i].coef/t[d].coef;
            p3.t[j-1].coef=f;
            p4.t[j-1].coef=f;
            p2=p2.sub(this.mul(p4));
            p4.t[j-1].coef=0;
            i--;
        }
        return p3;
    }


    Polynomial remainder(Polynomial p2)
    {
        Polynomial p3=new Polynomial(p2.d-d);
        Polynomial p4=new Polynomial(p2.d-1);
        int i=p2.d;
        for(int j=p2.d-d+1;j>0;j--)
        {
            float f=p2.t[i].coef/t[d].coef;
            p3.t[j-1].coef=f;
            p4.t[j-1].coef=f;
            p2=p2.sub(this.mul(p4));
            p4.t[j-1].coef=0;
            i--;
        }
        return p2;
    }
    Polynomial div1(Polynomial p2)
    {
        Polynomial p3=new Polynomial(p2.d-d);
        int i=p2.d;
        for(int j=p2.d-d+1;j>0;j--)
        {
            float f=p2.t[i].coef/t[d].coef;
            p3.t[j-1].coef=f;
            i--;
        }
        return p3;
    }

}

public class MainActivity extends AppCompatActivity {
    Button btn;
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    EditText e;
    EditText e1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        btn=(Button) findViewById(R.id.button);
        btn1=(Button) findViewById(R.id.button2);
        btn2=(Button) findViewById(R.id.button3);
        btn3=(Button) findViewById(R.id.button4);
        btn4=(Button) findViewById(R.id.button5);
         e = (EditText) findViewById(R.id.editText);
        e1 = (EditText) findViewById(R.id.editText2);


    }
    public void btnclick(View v) {
        Long qqqq=System.currentTimeMillis();
        String a;
        String b;
        TextView t = (TextView) findViewById(R.id.textView);
        TextView t1 = (TextView) findViewById(R.id.textView11);
        TextView t2 = (TextView) findViewById(R.id.textView9);
        TextView t3 = (TextView) findViewById(R.id.textView15);
        TextView t4 = (TextView) findViewById(R.id.textView13);
        TextView t5 = (TextView) findViewById(R.id.textView14);

        a = e.getText().toString();
        b = e1.getText().toString();
        if((a.compareTo("")!=0)&&b.compareTo("")!=0&&a.charAt(0)!='0'&&b.charAt(0)!=0) {
            StringTokenizer tt = new StringTokenizer(a);
            StringTokenizer ttt = new StringTokenizer(b);
            int dd = tt.countTokens();
            int ee = ttt.countTokens();
            float f[] = new float[dd];
            float g[] = new float[ee];
            int i = tt.countTokens() - 1;
            while (tt.hasMoreTokens()) {
                f[i] = Float.parseFloat(tt.nextToken());
                i--;
            }
            i = ttt.countTokens() - 1;
            while (ttt.hasMoreTokens()) {
                g[i] = Float.parseFloat(ttt.nextToken());
                i--;
            }
            Polynomial p1 = new Polynomial(dd - 1);
            Polynomial p2 = new Polynomial(ee - 1);
            p1.getdata(f);
            p2.getdata(g);
            t.setText(p1.mul(p2).putdata());
            t1.setText(p1.sum(p2).putdata());
            t2.setText(p1.sub(p2).putdata());
            if (p1.d == 0) {
                t5.setText("p1/p2 DIVISION IS");
                t3.setText(p1.div1(p2).putdata());
                t4.setText(new Polynomial(p2.d).putdata());
            } else if (p2.d == 0) {
                t5.setText("p2/p1 DIVISION IS");
                t3.setText(p2.div1(p1).putdata());
                t4.setText(new Polynomial(p1.d).putdata());
            } else if (p1.d < p2.d) {
                t5.setText("p1/p2 DIVISION IS");
                t3.setText(p1.div(p2).putdata());
                t4.setText(p1.remainder(p2).putdata());
            } else {
                t5.setText("p2/p1 DIVISION IS");
                t3.setText(p2.div(p1).putdata());
                t4.setText(p2.remainder(p1).putdata());
            }

            Context context = getApplicationContext();
            Toast toast = Toast.makeText(context, "Solved in" + (System.currentTimeMillis() - qqqq) + " milliseconds", Toast.LENGTH_SHORT);
            toast.show();
        }
        else
        {
            Context context = getApplicationContext();
            Toast toast = Toast.makeText(context,"Enter Valid polynomial please", Toast.LENGTH_SHORT);
            toast.show();
        }
    }


    public void addclick(View v) {
        String a;
        String b;
        TextView t1 = (TextView) findViewById(R.id.textView11);
        a = e.getText().toString();
        b = e1.getText().toString();
        if((a.compareTo("")!=0)&&b.compareTo("")!=0&&a.charAt(0)!='0'&&b.charAt(0)!=0) {
        StringTokenizer tt = new StringTokenizer(a);
        StringTokenizer ttt = new StringTokenizer(b);
        int dd = tt.countTokens();
        int ee = ttt.countTokens();
        float f[] = new float[dd];
        float g[] = new float[ee];
        int i = tt.countTokens()-1;
        while (tt.hasMoreTokens()) {
            f[i] = Float.parseFloat(tt.nextToken());
            i--;
        }
        i = ttt.countTokens()-1;
        while (ttt.hasMoreTokens()) {
            g[i] = Float.parseFloat(ttt.nextToken());
            i--;
        }
        Polynomial p1 = new Polynomial(dd - 1);
        Polynomial p2 = new Polynomial(ee - 1);
        p1.getdata(f);
        p2.getdata(g);
        t1.setText(p1.sum(p2).putdata());
        }
        else
        {
            Context context = getApplicationContext();
            Toast toast = Toast.makeText(context,"Enter Valid polynomial please", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    public void subclick(View v) {
        String a;
        String b;

        TextView t2 = (TextView) findViewById(R.id.textView9);

        a = e.getText().toString();
        b = e1.getText().toString();
        if((a.compareTo("")!=0)&&b.compareTo("")!=0&&a.charAt(0)!='0'&&b.charAt(0)!=0) {
        StringTokenizer tt = new StringTokenizer(a);
        StringTokenizer ttt = new StringTokenizer(b);
        int dd = tt.countTokens();
        int ee = ttt.countTokens();
        float f[] = new float[dd];
        float g[] = new float[ee];
        int i = tt.countTokens()-1;
        while (tt.hasMoreTokens()) {
            f[i] = Float.parseFloat(tt.nextToken());
            i--;
        }
        i = ttt.countTokens()-1;
        while (ttt.hasMoreTokens()) {
            g[i] = Float.parseFloat(ttt.nextToken());
            i--;
        }
        Polynomial p1 = new Polynomial(dd - 1);
        Polynomial p2 = new Polynomial(ee - 1);
        p1.getdata(f);
        p2.getdata(g);
        t2.setText(p1.sub(p2).putdata());
        }
        else
        {
            Context context = getApplicationContext();
            Toast toast = Toast.makeText(context,"Enter Valid polynomial please", Toast.LENGTH_SHORT);
            toast.show();
        }

    }
    public void mulclick(View v) {
        String a;
        String b;
        TextView t = (TextView) findViewById(R.id.textView);
        a = e.getText().toString();
        b = e1.getText().toString();
        if((a.compareTo("")!=0)&&b.compareTo("")!=0&&a.charAt(0)!='0'&&b.charAt(0)!=0) {
        StringTokenizer tt = new StringTokenizer(a);
        StringTokenizer ttt = new StringTokenizer(b);
        int dd = tt.countTokens();
        int ee = ttt.countTokens();
        float f[] = new float[dd];
        float g[] = new float[ee];
        int i = tt.countTokens()-1;
        while (tt.hasMoreTokens()) {
            f[i] = Float.parseFloat(tt.nextToken());
            i--;
        }
        i = ttt.countTokens()-1;
        while (ttt.hasMoreTokens()) {
            g[i] = Float.parseFloat(ttt.nextToken());
            i--;
        }
        Polynomial p1 = new Polynomial(dd - 1);
        Polynomial p2 = new Polynomial(ee - 1);
        p1.getdata(f);
        p2.getdata(g);
        t.setText(p1.mul(p2).putdata());
        }
        else
        {
            Context context = getApplicationContext();
            Toast toast = Toast.makeText(context,"Enter Valid polynomial please", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
    public void divclick(View v) {
        String a;
        String b;
        TextView t3 = (TextView) findViewById(R.id.textView15);
        TextView t4 = (TextView) findViewById(R.id.textView13);
        TextView t5 = (TextView) findViewById(R.id.textView14);

        a = e.getText().toString();
        b = e1.getText().toString();
        if((a.compareTo("")!=0)&&b.compareTo("")!=0&&a.charAt(0)!='0'&&b.charAt(0)!=0) {
        StringTokenizer tt = new StringTokenizer(a);
        StringTokenizer ttt = new StringTokenizer(b);
        int dd = tt.countTokens();
        int ee = ttt.countTokens();
        float f[] = new float[dd];
        float g[] = new float[ee];
        int i = tt.countTokens()-1;
        while (tt.hasMoreTokens()) {
            f[i] = Float.parseFloat(tt.nextToken());
            i--;
        }
        i = ttt.countTokens()-1;
        while (ttt.hasMoreTokens()) {
            g[i] = Float.parseFloat(ttt.nextToken());
            i--;
        }
        Polynomial p1 = new Polynomial(dd - 1);
        Polynomial p2 = new Polynomial(ee - 1);
        p1.getdata(f);
        p2.getdata(g);

        if(p1.d==0)
        {
            t5.setText("p2/p1 DIVISION IS");
            t3.setText(p1.div1(p2).putdata());
            t4.setText(new Polynomial(p2.d).putdata());
        }
        else if(p2.d==0)
        {
            t5.setText("p1/p2 DIVISION IS");
            t3.setText(p2.div1(p1).putdata());
            t4.setText(new Polynomial(p1.d).putdata());
        }
        else if(p1.d<p2.d)
        {
            t5.setText("p1/p2 DIVISION IS");
            t3.setText(p1.div(p2).putdata());
            t4.setText(p1.remainder(p2).putdata());
        }
        else
        {
            t5.setText("p2/p1 DIVISION IS");
            t3.setText(p2.div(p1).putdata());
            t4.setText(p2.remainder(p1).putdata());
        }
        }
        else
        {
            Context context = getApplicationContext();
            Toast toast = Toast.makeText(context,"Enter Valid polynomial please", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
    public void help(View v)
    {
        Intent i=new Intent("com.example.jainil.myapplication.help");
        startActivity(i);
    }


}
