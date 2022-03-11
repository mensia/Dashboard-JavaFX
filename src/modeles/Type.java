package modeles;

public enum Type {
    Hotel,
    Maison_Dhut,
    Lounge,
    empty,
    Appartement;

    public static Type type(String t) {
        Type x;
        switch (t.toLowerCase()) {
            case "hotel":
                x = Hotel;
                break;
            case "maison d'hut":
                x = Maison_Dhut;
                break;
            case "appartement":
                x = Appartement;
                break;
            case "lounge":
                x = Lounge;
                break;
            default:
                x = empty;
                break;
        }
        return null;
    }
}
