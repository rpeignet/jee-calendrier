package fr.esgi.calendrier_ybr_rpt.exception.gif;

public class GifDownloadException extends RuntimeException{
    public GifDownloadException(){
        super("Le Gif distant doit pointer vers une URL au bon format qui se termine par .gif, .Gif ou .GIF");
    }
}
