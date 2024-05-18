package fr.esgi.calendrier_ybr_rpt.exception.gif;

public class GifDownloadException extends RuntimeException{
    public GifDownloadException(){
        super("Erreur lors du téléchargement du fichier GIF.");
    }
}
