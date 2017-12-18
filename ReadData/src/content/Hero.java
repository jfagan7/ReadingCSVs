package content;

public class Hero {
private  String name;
private  String secretID;

public Hero(String name, String secretID)
{
	this.name=name;
	this.secretID=secretID;
}
public String getName()
{
	return name;
}
public String getSecretID()
{
	return secretID;
}
public void setName(String name) 
{ 
	this.name = name; 
}
public String toString()
{
	return name+" "+secretID;
}
}
