package com.napier.sem;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class PopRep
{
    private Connection con;

    public PopRep(Connection conget)
    {
        con = conget;
    }
    public ArrayList<Country> getCountriesPop()
    {
        // creating an initial empty arraylist
        ArrayList countriesPop = new ArrayList();

        String getCountires = "SELECT Code, Name, Continent, Population FROM countries ORDER BY population DESC";

        try
        {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(getCountires);

            while (rs.next())
            {
                Country country = new Country();
                country.code = rs.getString("Code");
                country.name = rs.getString("Name");
                country.continent = rs.getString("Continent");
                country.population = rs.getInt("Population");
                countriesPop.add(country);
            }
        }
        catch (Exception e)
        {

        }


        return countriesPop;
    }
    public void printCountires(ArrayList<Country> countries, StringBuilder output)
    {
        for (Country country : countries)
        {
            output.append("Country: " + country.code).append("Population: " + country.population).append("\n");

        }
        System.out.println(output.toString());
    }
}
