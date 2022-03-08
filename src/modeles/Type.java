package modeles;

public enum Type {
    Hotel,
    Maison_t_hote,
    Lounge,
    Appartement;

    public Type type(String t){
        if(t.equals("Hotel")){
            return Type.Hotel;
        }
        return null;
    }
}
