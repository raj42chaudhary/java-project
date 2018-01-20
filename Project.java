
import java.sql.*;
import java.io.*;
import java.util.*;
class AddNew
{
	public String name,haddress,city,hstate,eaddress,phoneno,stid,pname;
	int id,famount;
	void StudentAdd()
	{
		Scanner ob=new Scanner(System.in);
		System.out.print("Enter Name:    ");
		name=ob.nextLine();
		System.out.print("Enter Student ID:    ");
		stid=ob.nextLine();
		System.out.print("Enter Email Address:    ");
		eaddress=ob.nextLine();
		System.out.print("Enter Address:    ");
		haddress=ob.nextLine();
		System.out.print("Enter City:    ");
		city=ob.nextLine();
		System.out.print("Enter State:    ");
		hstate=ob.nextLine();
		System.out.print("Enter Phone No.:    ");
		phoneno=ob.nextLine();
		System.out.print("Enter Program Name:    ");
		pname=ob.nextLine();
		System.out.print("Enter Fee Amount:    ");
		famount=ob.nextInt();
		System.out.print("Enter Id in database:    ");
		id=ob.nextInt();
	}
}
class NewUp extends AddNew
{
	public 	String temp="",tempd;
		String keyword(String r)
		{
			String t="stop";
			switch(r)
			{
				case "name":
				t="name";
				break;
				case "email":
				t="eaddress";
				break;
				case "address":
				t="haddress";
				break;
				case "city":
				t="city";
				break;
				case "state":
				t="hstate";
				break;
				case "phone no.":
				t="phoneno";
				break;
				case "program name":
				t="pname";
				break;
				case "fee amount":
				t="famount";
				break;
				default:
				t="stop";
				break;
			}
			return t;
		}
	void up(String nametb,Statement st)
	{
		Scanner obj=new Scanner(System.in);
		System.out.println("Enter Student id");
		stid=obj.nextLine();
		System.out.println("Enter everything in lowercase");
		System.out.println("If you want to stop updating enter keyword 'stop' in field");
		try
		{
		while(temp!="stop")
		{
		System.out.println("Enter the name of the field");
		temp=obj.nextLine();
		System.out.println("Enter the data you have to update");
		tempd=obj.nextLine();
		if(temp!="stop")
		{
			if(temp!="fee amount")
			{
				st.executeUpdate("UPDATE "+nametb+" SET "+keyword(temp)+"='"+tempd+"' WHERE stid='"+stid+"'");
			}
			else
			{
				int x=Integer.valueOf(tempd);
				st.executeUpdate("UPDATE "+nametb+" SET "+keyword(temp)+"="+x+" WHERE stid='"+stid+"'");
			}
		}
		}
		}
		catch(Exception e){System.out.println(e);}
	}
}
class Project
{
	public static void main(String args[])
	{
		try
		{
		Scanner obj=new Scanner(System.in);
		Scanner obj1=new Scanner(System.in);
		Connection con;
		Statement st;
		ResultSet rs;
		String stid1;
		System.out.println("Welcome to Database Managment System");
		System.out.println("Enter the database Server name");
		String namedb;
		namedb=obj.nextLine();
		System.out.println("Enter the name of table");
		String nametb;
		nametb=obj.nextLine();
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		con=DriverManager.getConnection("jdbc:odbc:"+namedb);
		st=con.createStatement();
		int loop=0,choice=0;
		while(loop==0)
		{
			System.out.println("1.ADD New\n2.UPDATE Data\n3.VIEW ALL Record\n4.DELETE Record\n5.VIEW SINGLE Record\n6.EXIT");
			choice=obj.nextInt();
			switch(choice)
			{
				case 1:
				AddNew t=new AddNew();
				t.StudentAdd();
				st.executeUpdate("INSERT INTO "+nametb+"(name,stid,eaddress,haddress,city,hstate,phoneno,pname,famount,id)"+"values ('"+t.name+"','"+t.stid+"','"+t.eaddress+"','"+t.haddress+"','"+t.city+"','"+t.hstate+"','"+t.phoneno+"','"+t.pname+"',"+t.famount+","+t.id+")");
				break;
				case 2:
				NewUp g=new NewUp();
				g.up(nametb,st);
				break;
				case 3:
				rs=st.executeQuery("SELECT * FROM "+nametb);
				while(rs.next())
				{
				System.out.print("Name of Student:  "+rs.getString("name")+"\t\n"+"Student ID:       "+rs.getString("stid")+"\t\n"+"Email Address:    "+rs.getString("eaddress")+"\t\n"+"Address:          "+rs.getString("haddress")+"\t\n"+"City:             "+rs.getString("city")+"\t\n"+"State:            "+rs.getString("hstate")+"\t\n"+"Phone No:         "+rs.getString("phoneno")+"\t\n"+"Program Name:     "+rs.getString("pname")+"\t\n"+"Fee Amount:       "+rs.getInt("famount")+"\t\n"+"Database ID:      "+rs.getInt("id")+"\t\n");
				}
				break;
				case 4:
				System.out.println("Enter the Student Id:");
				stid1=obj1.nextLine();
				int check=0;
				System.out.println("Do you really want to delete the selected record?\n1 for Yes\n2 for No");
				check=obj1.nextInt();
				if(check==1)
				{
				st.executeUpdate("DELETE FROM "+nametb+" WHERE stid='"+stid1+"'");
				}
				break;
				case 5:
				System.out.println("Enter the Student Id:");
				stid1=obj1.nextLine();
				rs=st.executeQuery("SELECT * FROM "+nametb+" WHERE stid='"+stid1+"'");
				while(rs.next())
				{
				System.out.print("Name of Student:  "+rs.getString("name")+"\t\n"+"Student ID:       "+rs.getString("stid")+"\t\n"+"Email Address:    "+rs.getString("eaddress")+"\t\n"+"Address:          "+rs.getString("haddress")+"\t\n"+"City:             "+rs.getString("city")+"\t\n"+"State:            "+rs.getString("hstate")+"\t\n"+"Phone No:         "+rs.getString("phoneno")+"\t\n"+"Program Name:     "+rs.getString("pname")+"\t\n"+"Fee Amount:       "+rs.getInt("famount")+"\t\n"+"Database ID:      "+rs.getInt("id")+"\t\n");
				}
				break;
				case 6:
				loop=1;
				break;
				default:
				loop=1;
				break;
			}
		}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}