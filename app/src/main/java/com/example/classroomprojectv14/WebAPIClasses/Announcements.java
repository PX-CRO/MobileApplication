package com.example.classroomprojectv14.WebAPIClasses;

public class Announcements {
    public String Id,Date, Title, EntireContent;

    public Announcements(String Id, String Date, String Title, String EntireContent )
    {
        this.Date = Date;
        this.Title = Title;
        this.EntireContent = EntireContent;
        this.Id =Id;
    }
}
