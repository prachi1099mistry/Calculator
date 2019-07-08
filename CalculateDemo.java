import java.awt.TextField;
import java.awt.Button;
import java.awt.Panel;
import java.awt.Frame;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Calculate extends Frame implements ActionListener
{
	TextField tf1,tf2;
	Button b1[],b2[],equal;
	Panel p1,p2,p3;
	public String op;
	Calculate()
	{
		setTitle("CALCULATOR");
		b1=new Button[10];
		b2=new Button[5];
		p1=new Panel();
		p2=new Panel();
		p3=new Panel();
		p1.setLayout(new GridLayout(2,1));
		p2.setLayout(new GridLayout(4,4));
		p3.setLayout(new GridLayout(4,1));
		tf1=new TextField(10);
		tf2=new TextField(10);
		p1.add(tf2);
		p1.add(tf1);
		add(p1,BorderLayout.NORTH);
		add(p2,BorderLayout.CENTER);
		add(p3,BorderLayout.EAST);
		String s[]={"/","*","-","+","C"};
		for(int i=9;i>=0;i--)
		{
			b1[i]=new Button(i+"");
			p2.add(b1[i]);
			b1[i].addActionListener(this);
		}
		for(int j=0;j<5;j++)
		{
			b2[j]=new Button(s[j]);
			if(j>=4)
				p2.add(b2[j]);
			else
				p3.add(b2[j]);
			b2[j].addActionListener(this);
		}
		equal=new Button("=");
		p2.add(equal);
		equal.addActionListener(this);
		setVisible(true);
		setSize(300,400);
	}
	public void actionPerformed(ActionEvent ae)
	{
		for(int k=0;k<10;k++)	
		{					
			if(ae.getSource()==b1[k])
				tf1.setText(tf1.getText()+""+k);
		}
		if(ae.getSource()==b2[4])
			clearMe();
		else if(ae.getSource()==b2[0])
		{
			saveOp(b2[0].getLabel());
			tf2.setText(tf1.getText());
			tf1.setText("");
		}
		else if(ae.getSource()==b2[1])
		{
			saveOp(b2[1].getLabel());
			tf2.setText(tf1.getText());
			tf1.setText("");
		}
		else if(ae.getSource()==b2[2])
		{
			saveOp(b2[2].getLabel());
			tf2.setText(tf1.getText());
			tf1.setText("");
		}
		else if(ae.getSource()==b2[3])
		{
			saveOp(b2[3].getLabel());
			tf2.setText(tf1.getText());
			tf1.setText("");
		}
		if(ae.getSource()==equal)
			calculateMe();
	}
	public void clearMe()
	{
			tf1.setText("");
			tf2.setText("");
	}
	public void saveOp(String name)
	{
		op=name;
	}
	public void calculateMe()
	{
		int n1,n2,ans;
		n1=Integer.parseInt(tf1.getText());
		n2=Integer.parseInt(tf2.getText());
		if(op=="+")
		{
			ans=n2+n1;
			tf1.setText(ans+"");
			tf2.setText("");
		}
		else if(op=="-")
		{
			ans=n2-n1;
			tf1.setText(ans+"");
			tf2.setText("");
		}
		else if(op=="*")
		{
			ans=n2*n1;
			tf1.setText(ans+"");
			tf2.setText("");
		}
		else if(op=="/")
		{
			ans=n2/n1;
			tf1.setText(ans+"");
			tf2.setText("");
		}
	}
}

class CalculateDemo
{
	public static void main(String[] args)
	{
		new Calculate();
	}
}